package app.service;

import app.converter.CustomConversionService;
import app.dto.CellDto;
import app.dto.StorageDto;
import app.entity.Cell;
import app.entity.Storage;
import app.repository.CellRepository;
import app.repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class StorageServiceImpl implements StorageService {
    private final StorageRepository storageRepository;
    private final CellRepository cellRepository;
    private final CustomConversionService conversionService;

    @Autowired
    public StorageServiceImpl(StorageRepository storageRepository, CellRepository cellRepository, CustomConversionService conversionService) {
        this.storageRepository = storageRepository;
        this.cellRepository = cellRepository;
        this.conversionService = conversionService;
    }

    @Override
    public StorageDto getStorageFacilityById(Long id) {
        Storage storage = storageRepository.findById(id).orElseThrow(()->new RuntimeException("Storage facility is not found"));
        return conversionService.convert(storage, StorageDto.class);
    }

    @Override
    public List<StorageDto> getAll() {
        List<Storage> storageFacilities = storageRepository.findAll();
        return storageFacilities.stream().map(storageFacility -> conversionService.convert(storageFacility, StorageDto.class)).collect(Collectors.toList());
    }

    @Override
    public StorageDto createStorageFacility(StorageDto storageDto) {
        Storage storage = conversionService.convert(storageDto, Storage.class);
        Storage storageRepositoryByFirstName = storageRepository.findFirstByTitle(storage.getTitle());
        /*
        if(Objects.isNull(storageRepositoryByFirstName)){
            return conversionService.convert(storageRepository.save(storage), StorageDto.class);
        } else {
            storageDto.setId(storageRepositoryByFirstName.getId());
            updateStorageFacility(storageDto);
            return conversionService.convert(storageRepositoryByFirstName, StorageDto.class);
        }
         */
        return Objects.isNull(storageRepositoryByFirstName) ?
                conversionService.convert(storageRepository.save(storage), StorageDto.class) :
                conversionService.convert(storageRepositoryByFirstName, StorageDto.class);

    }

    @Override
    public StorageDto updateStorageFacility(StorageDto storageDto) {
        Storage storage = storageRepository.findById(storageDto.getId()).orElseThrow(()->new RuntimeException("Storage is not found"));
        storage.setTitle(storageDto.getTitle());
        Set<CellDto> storageCellsDtoSet = storageDto.getStorageCells();
        Set<Cell> cells = storageCellsDtoSet
                .stream()
                .map(storageCellDto -> conversionService.convert(storageCellDto, Cell.class))
                .collect(Collectors.toSet());
        storage.setCells(cells);
        return conversionService.convert(storageRepository.save(storage), StorageDto.class);
    }

    @Override
    public void deleteStorageFacility(Long id) {
        Storage storage = storageRepository.findById(id).orElseThrow(()->new RuntimeException());
        storageRepository.delete(storage);
    }
}

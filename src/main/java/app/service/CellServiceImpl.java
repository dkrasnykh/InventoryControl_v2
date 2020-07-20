package app.service;

import app.converter.CustomConversionService;
import app.dto.CellDto;
import app.entity.Cell;
import app.repository.CellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CellServiceImpl implements CellService {
    private final CellRepository cellRepository;
    private final CustomConversionService conversionService;

    @Autowired
    public CellServiceImpl(CellRepository cellRepository, CustomConversionService conversionService) {
        this.cellRepository = cellRepository;
        this.conversionService = conversionService;
    }

    @Override
    public CellDto getStorageCellById(Long id) {
        Cell cell = cellRepository.findById(id).orElseThrow(()->new RuntimeException("Stprage cell not found"));
        return conversionService.convert(cell, CellDto.class);
    }

    @Override
    public List<CellDto> getAll() {
        List<Cell> cells = cellRepository.findAll();
        return cells.stream().map(storageCell -> conversionService.convert(storageCell, CellDto.class)).collect(Collectors.toList());
    }

    @Override
    public CellDto createStorageCell(CellDto cellDto) {
        Cell cell = conversionService.convert(cellDto, Cell.class);
        return conversionService.convert(cellRepository.save(cell), CellDto.class);
    }

    @Override
    public CellDto updateStorageCell(CellDto cellDto) {
        Cell cell = cellRepository.findById(cellDto.getId()).orElseThrow(()->new RuntimeException("Storage cell is not found"));
        cell.setLine(cellDto.getLine());
        cell.setPosition(cellDto.getPosition());
        cell.setRack(cellDto.getRack());
        cell.setSection(cellDto.getSection());
        cell.setTier(cellDto.getTier());
        cell.setTitle(cellDto.getTitle());
        return conversionService.convert(cellRepository.save(cell), CellDto.class);
    }

    @Override
    public void deleteStorageCell(Long id) {
        Cell cell = cellRepository.findById(id).orElseThrow(()->new RuntimeException("Person is not found"));
        cellRepository.delete(cell);
    }
}

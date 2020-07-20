package app.converter;

import app.dto.CellDto;
import app.dto.StorageDto;
import app.entity.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class StorageToStorageDtoConverter implements Converter<Storage, StorageDto> {
    private final CustomConversionService conversionService;

    @Autowired
    public StorageToStorageDtoConverter(CustomConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public StorageDto convert(Storage storage) {
        StorageDto target = new StorageDto();
        target.setTitle(storage.getTitle());
        target.setId(storage.getId());
        if(storage.getCells() != null){
            target.setStorageCells(conversionService.convert(storage.getCells(), CellDto.class));
            //Set<CellDto> cellDtoSet = storage.getCells().stream().map(storageCell -> conversionService.convert(storageCell, CellDto.class)).collect(Collectors.toSet());
            //target.setStorageCells(cellDtoSet);
        }
        return target;
    }
}

package app.converter;

import app.dto.CellDto;
import app.dto.StorageDto;
import app.entity.Cell;
import app.entity.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;

import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Component
public class StorageDtoToStorageConverter implements Converter<StorageDto, Storage> {
    private final CustomConversionService conversionService;

    @Autowired
    public StorageDtoToStorageConverter(CustomConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public Storage convert(StorageDto storageDto) {
        Storage target = new Storage();
        target.setTitle(storageDto.getTitle());
        target.setId(storageDto.getId());
        if(storageDto.getStorageCells() != null){
            target.setCells(conversionService.convert(storageDto.getStorageCells(), Cell.class));
            //Set<Cell> cells = storageDto.getStorageCells().stream().map(storageCellDto -> conversionService.convert(storageCellDto, Cell.class)).collect(Collectors.toSet());
            //target.setCells(cells);
        }
        return target;
    }
}

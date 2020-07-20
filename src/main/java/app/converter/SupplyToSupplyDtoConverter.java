package app.converter;

import app.dto.ItemDto;
import app.dto.StorageDto;
import app.dto.SupplyDto;
import app.entity.Supply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SupplyToSupplyDtoConverter implements Converter<Supply, SupplyDto> {
    private final CustomConversionService conversionService;

    @Autowired
    public SupplyToSupplyDtoConverter(CustomConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public SupplyDto convert(Supply supply) {
        SupplyDto target = new SupplyDto();
        target.setInvoiceDate(supply.getInvoiceDate());
        target.setInvoiceNumber(supply.getInvoiceNumber());
        target.setStorage(conversionService.convert(supply.getStorage(), StorageDto.class));
        target.setItems(conversionService.convert(supply.getItems(), ItemDto.class));
        return target;
    }
}

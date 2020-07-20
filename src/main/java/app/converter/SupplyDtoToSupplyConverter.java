package app.converter;

import app.dto.SupplyDto;
import app.entity.Item;
import app.entity.Storage;
import app.entity.Supply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SupplyDtoToSupplyConverter implements Converter<SupplyDto, Supply> {
    private final CustomConversionService conversionService;

    @Autowired
    public SupplyDtoToSupplyConverter(CustomConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public Supply convert(SupplyDto supplyDto) {
        Supply target = new Supply();
        target.setInvoiceDate(supplyDto.getInvoiceDate());
        target.setInvoiceNumber(supplyDto.getInvoiceNumber());
        target.setStorage(conversionService.convert(supplyDto.getStorage(), Storage.class));
        target.setItems(conversionService.convert(supplyDto.getItems(), Item.class));
        return target;
    }
}

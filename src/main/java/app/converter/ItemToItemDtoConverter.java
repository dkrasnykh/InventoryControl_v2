package app.converter;

import app.dto.ItemDto;
import app.dto.ProductDto;
import app.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ItemToItemDtoConverter implements Converter<Item, ItemDto> {
    private final CustomConversionService conversionService;

    @Autowired
    public ItemToItemDtoConverter(CustomConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public ItemDto convert(Item item) {
        ItemDto target = new ItemDto();
        ProductDto productDto = conversionService.convert(item.getProduct(), ProductDto.class);
        target.setProductDto(productDto);
        target.setQuantity(item.getQuantity());
        target.setId(item.getId());
        return target;
    }

}

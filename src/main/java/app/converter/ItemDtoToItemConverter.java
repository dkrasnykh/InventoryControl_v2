package app.converter;

import app.dto.ItemDto;
import app.entity.Item;
import app.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ItemDtoToItemConverter implements Converter<ItemDto, Item> {
    private final CustomConversionService conversionService;

    @Autowired
    public ItemDtoToItemConverter(CustomConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public Item convert(ItemDto itemDto) {
        Item target = new Item();
        Product product = conversionService.convert(itemDto.getProductDto(), Product.class);
        target.setProduct(product);
        target.setQuantity(itemDto.getQuantity());
        target.setId(target.getId());
        return target;
    }
}

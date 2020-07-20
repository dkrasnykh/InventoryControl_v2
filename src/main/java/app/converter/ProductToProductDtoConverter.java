package app.converter;

import app.dto.ProductDto;
import app.entity.Product;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductToProductDtoConverter implements Converter<Product, ProductDto> {
    @Override
    public ProductDto convert(Product product) {
        ProductDto target = new ProductDto();
        target.setId(product.getId());
        target.setTitle(product.getTitle());
        target.setArticle(product.getArticle());
        target.setUnit(product.getUnit());
        return target;
    }
}

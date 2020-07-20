package app.converter;

import app.dto.ProductDto;
import app.entity.Product;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductDtoToProductConverter implements Converter<ProductDto, Product> {
    @Override
    public Product convert(ProductDto productDto) {
        Product target = new Product();
        target.setTitle(productDto.getTitle());
        target.setArticle(productDto.getArticle());
        target.setUnit(productDto.getUnit());
        return target;
    }
}

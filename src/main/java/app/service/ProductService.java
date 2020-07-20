package app.service;

import app.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto getProductById(Long id);
    List<ProductDto> getAll();
    ProductDto createProduct(ProductDto productDto);
    ProductDto updateProduct(ProductDto productDto);
    void deleteProduct(Long id);
}

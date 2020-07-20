package app.service;

import app.converter.CustomConversionService;
import app.dto.ProductDto;
import app.entity.Product;
import app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CustomConversionService conversionService;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, CustomConversionService conversionService) {
        this.productRepository = productRepository;
        this.conversionService = conversionService;
    }

    @Override
    public ProductDto getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        return conversionService.convert(product, ProductDto.class);
    }

    @Override
    public List<ProductDto> getAll() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(product -> conversionService.convert(product, ProductDto.class)).collect(Collectors.toList());
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = conversionService.convert(productDto, Product.class);
        return conversionService.convert(productRepository.save(product), ProductDto.class);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        Product product = productRepository.findById(productDto.getId()).orElseThrow(()->new RuntimeException("Product is not found"));
        product.setArticle(productDto.getArticle());
        product.setTitle(productDto.getTitle());
        product.setUnit(productDto.getUnit());
        return conversionService.convert(productRepository.save(product), ProductDto.class);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(()->new RuntimeException("Product is not found"));
        productRepository.delete(product);
    }
}

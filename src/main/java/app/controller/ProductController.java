package app.controller;

import app.dto.ProductDto;
import app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/{id}")
    public ProductDto getProductById(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }

    @GetMapping
    public List<ProductDto> getAll(){
        return productService.getAll();
    }

    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto productDto){
        return productService.createProduct(productDto);
    }

    @PutMapping
    public ProductDto updateProduct(@RequestBody ProductDto productDto){
        return productService.updateProduct(productDto);
    }

    @DeleteMapping
    public void deleteProduct(@PathParam("id") Long id){
        productService.deleteProduct(id);
    }

}

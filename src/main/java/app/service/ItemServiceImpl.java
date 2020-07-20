package app.service;

import app.converter.CustomConversionService;
import app.dto.ItemDto;
import app.entity.Item;
import app.entity.Product;
import app.repository.ItemReposotory;
import app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    private final ItemReposotory itemReposotory;
    private final ProductRepository productRepository;
    private final CustomConversionService conversionService;

    @Autowired
    public ItemServiceImpl(ItemReposotory itemReposotory, ProductRepository productRepository, CustomConversionService conversionService) {
        this.itemReposotory = itemReposotory;
        this.productRepository = productRepository;
        this.conversionService = conversionService;
    }

    @Override
    public ItemDto getItemById(Long id) {
        return null;
    }

    @Override
    public List<ItemDto> getAll() {
        return null;
    }

    @Override
    public ItemDto createItem(ItemDto itemDto) {
        Item item = conversionService.convert(itemDto, Item.class);
        List<Product> products = productRepository.findByArticleAndUnit(item.getProduct().getArticle(), item.getProduct().getUnit());

        if(products.isEmpty()){
            Product product = productRepository.save(item.getProduct());
            item.setProduct(product);
        } else {
            item.setProduct(products.get(0));
        }
        return conversionService.convert(itemReposotory.save(item), ItemDto.class);
    }

    @Override
    public ItemDto updateItem(ItemDto itemDto) {
        Item item = itemReposotory.findById(itemDto.getId()).orElseThrow(()->new RuntimeException("Item not found"));
        Product product = productRepository.findById(itemDto.getProductDto().getId()).orElseThrow(()->new RuntimeException("Product not found"));
        item.setProduct(product);
        item.setQuantity(itemDto.getQuantity());
        return conversionService.convert(itemReposotory.save(item), ItemDto.class);
    }

    @Override
    public void deleteItem(Long id) {
        Item item = itemReposotory.findById(id).orElseThrow(()->new RuntimeException("Item is not found"));
        itemReposotory.delete(item);
    }
}

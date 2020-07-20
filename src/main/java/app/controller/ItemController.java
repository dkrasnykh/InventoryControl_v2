package app.controller;

import app.dto.ItemDto;
import app.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    /*
    @PostMapping
    public CellDto createStorageCell(@RequestBody CellDto cellDto){
        return cellService.createStorageCell(cellDto);
    }
    */


    @PostMapping
    public ItemDto createItem(@RequestBody ItemDto itemDto){
        return itemService.createItem(itemDto);
    }
}

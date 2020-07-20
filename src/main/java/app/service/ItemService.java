package app.service;

import app.dto.ItemDto;

import java.util.List;

public interface ItemService {
    ItemDto getItemById(Long id);
    List<ItemDto> getAll();
    ItemDto createItem(ItemDto itemDto);
    ItemDto updateItem(ItemDto itemDto);
    void deleteItem(Long id);
}

package app.service;

import app.converter.CustomConversionService;
import app.dto.ItemDto;
import app.dto.StorageDto;
import app.dto.SupplyDto;
import app.entity.Item;
import app.entity.Storage;
import app.entity.Supply;
import app.enums.OperationType;
import app.repository.ItemReposotory;
import app.repository.SupplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class SupplyServiceImpl implements SupplyService {
    private final SupplyRepository supplyRepository;
    private final ItemReposotory itemReposotory;
    private final StorageService storageService;
    private final CustomConversionService conversionService;
    private final ItemService itemService;

    @Autowired
    public SupplyServiceImpl(SupplyRepository supplyRepository, ItemReposotory itemReposotory, StorageService storageService, CustomConversionService conversionService, ItemService itemService) {
        this.supplyRepository = supplyRepository;
        this.itemReposotory = itemReposotory;
        this.storageService = storageService;
        this.conversionService = conversionService;
        this.itemService = itemService;
    }

    @Override
    public SupplyDto getSupplyById(Long id) {
        Supply supply = supplyRepository.findById(id).orElseThrow(()->new RuntimeException("Supply not found"));
        return conversionService.convert(supply, SupplyDto.class);
    }

    @Override
    public List<SupplyDto> getAll() {
        List<Supply> supplies = supplyRepository.findAll();
        return supplies.stream().map(supply -> conversionService.convert(supply, SupplyDto.class)).collect(Collectors.toList());
    }

    @Override
    public SupplyDto createSupply(SupplyDto supplyDto) {
        Supply supply = conversionService.convert(supplyDto, Supply.class);
        supply.setOperation(OperationType.SUPPLY);
        //supplyRepository.findFirstByInvoiceDateAndInvoiceNumber(supply.getInvoiceDate(), supply.getInvoiceNumber());
        StorageDto storageDto = storageService.createStorageFacility(supplyDto.getStorage());
        Storage storage = conversionService.convert(storageDto, Storage.class);
        supply.setStorage(storage);
        Set<ItemDto> itemsDto = supplyDto.getItems()
                .stream()
                .map(itemDto -> itemService.createItem(itemDto))
                .collect(Collectors.toSet());

        Set<Item> items = itemsDto.stream()
                .map(itemDto -> itemReposotory.findById(itemDto.getId()).get())
                .collect(Collectors.toSet());

        supply.setItems(items);
        return conversionService.convert(supplyRepository.save(supply), SupplyDto.class);
    }

    @Override
    public SupplyDto updateSupply(SupplyDto supplyDto) {
        Supply supply = supplyRepository.findById(supplyDto.getId()).orElseThrow(()->new RuntimeException("Supply is not found"));
        supply.setInvoiceDate(supplyDto.getInvoiceDate());
        supply.setInvoiceNumber(supplyDto.getInvoiceNumber());
        StorageDto storageDto = storageService.createStorageFacility(supplyDto.getStorage());
        Storage storage = conversionService.convert(storageDto, Storage.class);
        supply.setStorage(storage);
        supply.getItems().forEach(item -> itemService.deleteItem(item.getId()));

        Set<ItemDto> itemsDto = supplyDto.getItems()
                .stream()
                .map(itemDto -> itemService.createItem(itemDto))
                .collect(Collectors.toSet());

        Set<Item> items = itemsDto
                .stream()
                .map(itemDto -> itemReposotory.findById(itemDto.getId()).get())
                .collect(Collectors.toSet());

        supply.setItems(items);
        return conversionService.convert(supplyRepository.save(supply), SupplyDto.class);
    }

    @Override
    public void deleteSupply(Long id) {
        Supply supply = supplyRepository.findById(id).orElseThrow(()->new RuntimeException());
        supplyRepository.delete(supply);
    }
}

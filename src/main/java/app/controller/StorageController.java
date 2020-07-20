package app.controller;

import app.dto.StorageDto;
import app.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/storages")
public class StorageController {
    private final StorageService storageService;

    @Autowired
    public StorageController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping(value = "/{id}")
    public StorageDto getStorageFacilityById(@PathVariable("id") Long id){
        return storageService.getStorageFacilityById(id);
    }

    @GetMapping
    public List<StorageDto> getAll(){
        return storageService.getAll();
    }

    @PostMapping
    public StorageDto createStorageFacility(@RequestBody StorageDto storageDto){
        return storageService.createStorageFacility(storageDto);
    }

    @PutMapping
    public StorageDto updateStorageFacility(@RequestBody StorageDto storageDto){
        return storageService.updateStorageFacility(storageDto);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteStorageFacility(@PathVariable("id") Long id){
        storageService.deleteStorageFacility(id);
    }

}

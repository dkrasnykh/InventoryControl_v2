package app.controller;

import app.dto.CellDto;
import app.service.CellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/cells")
public class CellController {
    private final CellService cellService;

    @Autowired
    public CellController(CellService cellService) {
        this.cellService = cellService;
    }

    @GetMapping(value = "/{id}")
    public CellDto getStorageCellById(@PathVariable("id") Long id) {
        return cellService.getStorageCellById(id);
    }

    @GetMapping
    public List<CellDto> getAll(){
        return cellService.getAll();
    }

    @PostMapping
    public CellDto createStorageCell(@RequestBody CellDto cellDto){
        return cellService.createStorageCell(cellDto);
    }

    @PutMapping
    public CellDto updateStorageCell(@RequestBody CellDto cellDto){
        return cellService.updateStorageCell(cellDto);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteStorageCell(@PathVariable("id") Long id){
        cellService.deleteStorageCell(id);
    }

}

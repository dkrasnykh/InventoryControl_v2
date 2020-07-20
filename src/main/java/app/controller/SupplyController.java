package app.controller;

import app.dto.SupplyDto;
import app.service.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/supplies")
public class SupplyController {
    private final SupplyService supplyService;

    @Autowired
    public SupplyController(SupplyService supplyService) {
        this.supplyService = supplyService;
    }

    @GetMapping(value = "{id}")
    public SupplyDto getSupplyById(@PathVariable("id") Long id){
        return supplyService.getSupplyById(id);
    }

    @GetMapping
    public List<SupplyDto> getAll(){
        return supplyService.getAll();
    }

    @PostMapping
    public SupplyDto createSupply(@RequestBody SupplyDto supplyDto){
        return supplyService.createSupply(supplyDto);
    }

    @PutMapping
    public SupplyDto updateSupply(@RequestBody SupplyDto supplyDto){
        return supplyService.updateSupply(supplyDto);
    }

    @DeleteMapping(value = "{id}")
    public void deleteSupply(@PathVariable("id") Long id){
        supplyService.deleteSupply(id);
    }

}

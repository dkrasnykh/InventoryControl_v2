package app.service;

import app.dto.SupplyDto;

import java.util.List;

public interface SupplyService {
    SupplyDto getSupplyById(Long id);
    List<SupplyDto> getAll();
    SupplyDto createSupply(SupplyDto supplyDto);
    SupplyDto updateSupply(SupplyDto supplyDto);
    void deleteSupply(Long id);
}

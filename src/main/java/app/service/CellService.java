package app.service;
import app.dto.CellDto;
import java.util.List;

public interface CellService {
    CellDto getStorageCellById(Long id);
    List<CellDto> getAll();
    CellDto createStorageCell(CellDto cellDto);
    CellDto updateStorageCell(CellDto cellDto);
    void deleteStorageCell(Long id);
}

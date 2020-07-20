package app.service;
import app.dto.StorageDto;
import java.util.List;

public interface StorageService {
    StorageDto getStorageFacilityById(Long id);
    List<StorageDto> getAll();
    StorageDto createStorageFacility(StorageDto storageDto);
    StorageDto updateStorageFacility(StorageDto storageDto);
    void deleteStorageFacility(Long id);
}

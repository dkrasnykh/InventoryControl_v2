package app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Set;

public class StorageDto implements Serializable {
    @JsonProperty("id")
    private Long id;
    @JsonProperty(value = "title")
    private String title;
    @JsonProperty(value = "storage_cells")
    private Set<CellDto> storageCells;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<CellDto> getStorageCells() {
        return storageCells;
    }

    public void setStorageCells(Set<CellDto> storageCells) {
        this.storageCells = storageCells;
    }
}

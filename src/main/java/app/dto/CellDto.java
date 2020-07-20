package app.dto;
import app.enums.CellType;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class CellDto implements Serializable {
    @JsonProperty("id")
    private Long id;
    @JsonProperty(value = "title")
    private String title;
    @JsonProperty(value = "section")
    private String section;
    @JsonProperty(value = "line")
    private String line;
    @JsonProperty(value = "rack")
    private String rack;
    @JsonProperty(value = "tier")
    private String tier;
    @JsonProperty(value = "position")
    private String position;
    @JsonProperty(value = "cell_type")
    private CellType cellType;

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

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getRack() {
        return rack;
    }

    public void setRack(String rack) {
        this.rack = rack;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public CellType getCellType() {
        return cellType;
    }

    public void setCellType(CellType cellType) {
        this.cellType = cellType;
    }
}

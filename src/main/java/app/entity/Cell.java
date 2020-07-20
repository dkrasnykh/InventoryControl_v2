package app.entity;

import app.enums.CellType;

import javax.persistence.*;

@Entity
public class Cell extends EntityBase{
    @Column(name = "title")
    private String title;
    @Column(name = "section")
    private String section;
    @Column(name = "line")
    private String line;
    @Column(name = "rack")
    private String rack;
    @Column(name = "tier")
    private String tier;
    @Column(name = "position")
    private String position;
    @Enumerated(value = EnumType.STRING)
    private CellType cellType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storage_id")
    private Storage storage;

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

package app.entity;
import javax.persistence.*;
import java.util.Set;


//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
public class Storage extends EntityBase {

    @Column(name = "title")
    private String title;

    //@OneToMany(mappedBy = "storage", cascade = CascadeType.PERSIST)
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "storage_id")
    private Set<Cell> cells;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Cell> getCells() {
        return cells;
    }

    public void setCells(Set<Cell> cells) {
        this.cells = cells;
    }

    public void addStorageCell(Cell cell){
        cells.add(cell);
    }

    public void removeStorageCell(Cell cell){
        cells.remove(cell);
    }
}

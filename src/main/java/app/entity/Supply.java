package app.entity;
import app.enums.OperationType;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "operation")
public class Supply extends EntityBase {
    @Column(name = "invoice_number")
    private String invoiceNumber;
    @Column(name = "invoice_date")
    private LocalDate invoiceDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storage_id", nullable = false)
    private Storage storage;

    @Enumerated(value = EnumType.STRING)
    private OperationType operation;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "operation_id")
    private Set<Item> items;

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public OperationType getOperation() {
        return operation;
    }

    public void setOperation(OperationType operation) {
        this.operation = operation;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
}

package app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class SupplyDto implements Serializable {
    @JsonProperty("id")
    private Long id;
    @JsonProperty(value = "invoice_number")
    private String invoiceNumber;
    @JsonProperty(value = "invoice_date")
    private LocalDate invoiceDate;
    @JsonProperty(value = "storage")
    private StorageDto storage;
    @JsonProperty(value = "items")
    private Set<ItemDto> items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public StorageDto getStorage() {
        return storage;
    }

    public void setStorage(StorageDto storage) {
        this.storage = storage;
    }

    public Set<ItemDto> getItems() {
        return items;
    }

    public void setItems(Set<ItemDto> items) {
        this.items = items;
    }
}

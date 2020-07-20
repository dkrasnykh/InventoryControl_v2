package app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class TransferDto implements Serializable {
    @JsonProperty(value = "transfer_number")
    private String transferNumber;
    @JsonProperty(value = "transfer_date")
    private LocalDate transferDate;
    @JsonProperty(value = "storage_sender")
    private StorageDto storageSender;
    @JsonProperty(value = "storage_recipient")
    private StorageDto storageRecipient;
    @JsonProperty(value = "nomenclature_list")
    private List<ProductDto> nomenclatureList;
    @JsonProperty(value = "quantity_list")
    private List<Integer> quantityList;
    @JsonProperty(value = "consignment_list")
    private List<SupplyDto> consignmentList;

    public String getTransferNumber() {
        return transferNumber;
    }

    public void setTransferNumber(String transferNumber) {
        this.transferNumber = transferNumber;
    }

    public LocalDate getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(LocalDate transferDate) {
        this.transferDate = transferDate;
    }

    public StorageDto getStorageSender() {
        return storageSender;
    }

    public void setStorageSender(StorageDto storageSender) {
        this.storageSender = storageSender;
    }

    public StorageDto getStorageRecipient() {
        return storageRecipient;
    }

    public void setStorageRecipient(StorageDto storageRecipient) {
        this.storageRecipient = storageRecipient;
    }

    public List<ProductDto> getNomenclatureList() {
        return nomenclatureList;
    }

    public void setNomenclatureList(List<ProductDto> nomenclatureList) {
        this.nomenclatureList = nomenclatureList;
    }

    public List<Integer> getQuantityList() {
        return quantityList;
    }

    public void setQuantityList(List<Integer> quantityList) {
        this.quantityList = quantityList;
    }

    public List<SupplyDto> getConsignmentList() {
        return consignmentList;
    }

    public void setConsignmentList(List<SupplyDto> consignmentList) {
        this.consignmentList = consignmentList;
    }


}

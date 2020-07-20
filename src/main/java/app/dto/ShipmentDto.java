package app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class ShipmentDto implements Serializable {
    @JsonProperty(value = "sales_number")
    private String salesNumber;
    @JsonProperty(value = "sales_date")
    private LocalDate salesDate;
    @JsonProperty(value = "storage_facility")
    private StorageDto storageDto;
    @JsonProperty(value = "nomenclature_list")
    private List<ProductDto> nomenclatureList;
    @JsonProperty(value = "quantity_list")
    private List<Integer> quantityList;
    @JsonProperty(value = "consignment_list")
    private List<SupplyDto> consignmentList;

    public String getSalesNumber() {
        return salesNumber;
    }

    public void setSalesNumber(String salesNumber) {
        this.salesNumber = salesNumber;
    }

    public LocalDate getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(LocalDate salesDate) {
        this.salesDate = salesDate;
    }

    public StorageDto getStorageDto() {
        return storageDto;
    }

    public void setStorageDto(StorageDto storageDto) {
        this.storageDto = storageDto;
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

package app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class ItemDto implements Serializable {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("product")
    private ProductDto productDto;
    @JsonProperty("qty")
    private Integer quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductDto getProductDto() {
        return productDto;
    }

    public void setProductDto(ProductDto productDto) {
        this.productDto = productDto;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

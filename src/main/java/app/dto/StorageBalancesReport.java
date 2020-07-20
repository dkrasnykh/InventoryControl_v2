package app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StorageBalancesReport {
    private String storage;
    private String article;
    private String title;
    private String unit;
    private Integer quantity;
}

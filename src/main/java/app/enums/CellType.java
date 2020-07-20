package app.enums;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public enum CellType implements Serializable{
    ACCEPTANSE,
    SHIPMENT,
    KEEPING,
    ARCHIVE
}

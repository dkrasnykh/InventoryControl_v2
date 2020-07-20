package app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class ProductDto implements Serializable {
    @JsonProperty("id")
    private Long id;
    @JsonProperty(value = "title")
    private String title;
    @JsonProperty(value = "article")
    private String article;
    @JsonProperty(value = "unit")
    private String unit;

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

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}

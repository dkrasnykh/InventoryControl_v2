package app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Product extends EntityBase {
    @Column(name = "title")
    private String title;
    @Column(name = "article")
    private String article;
    @Column(name = "unit")
    private String unit;

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

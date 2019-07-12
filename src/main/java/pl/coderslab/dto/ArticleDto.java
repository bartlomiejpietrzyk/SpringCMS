package pl.coderslab.dto;

import pl.coderslab.model.Article;
import pl.coderslab.model.Category;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class ArticleDto {


    private Long id;
    @Size(max=200)
    @NotNull
    private String title;
    private Long author;
    @Size(min = 500)
    @NotNull
    private String content;
    private Long[] categories;
    private String createdDateTime;
    private String updateDateTime;

    public ArticleDto() {
    }

    public ArticleDto(Article that) {
        this.id = that.getId();
        this.title = that.getTitle();
        this.author = that.getAuthor().getId();
        this.categories = that
                .getCategories()
                .stream()
                .map(Category::getId)
                .toArray(Long[]::new);
        this.content = that.getContent();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.createdDateTime = that.getCreated().format(formatter);
        this.createdDateTime = that.getUpdated().format(formatter);
    }

    public void shortenContent(int maxLenght) {
        this.content = this.content.substring(0, Math.min(this.content.length(), maxLenght));
    }

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

    public Long getAuthor() {
        return author;
    }

    public void setAuthor(Long author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long[] getCategories() {
        return categories;
    }

    public void setCategories(Long[] categories) {
        this.categories = categories;
    }

    public String getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(String createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public String getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(String updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    @Override
    public String toString() {
        return "ArticleDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", categories=" + Arrays.toString(categories) +
                ", createdDateTime='" + createdDateTime + '\'' +
                ", updateDateTime='" + updateDateTime + '\'' +
                '}';
    }
}

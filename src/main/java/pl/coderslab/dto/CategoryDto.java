package pl.coderslab.dto;

import pl.coderslab.model.Article;
import pl.coderslab.model.Category;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CategoryDto {
    private Long id;
    @NotNull
    @Size(min=5)
    private String name;
    private String description;
    private String articles;

    public CategoryDto() {
    }

    public CategoryDto(Category that) {
        this.id = that.getId();
        this.name = that.getName();
        this.description = that.getDescription();
        this.articles = that.getArticles()
                .stream()
                .map(Article::getTitle)
                .collect(Collectors.joining());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getArticles() {
        return articles;
    }

    public void setArticles(String articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "CategoryDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", articles='" + articles + '\'' +
                '}';
    }
}


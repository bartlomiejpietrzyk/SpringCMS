package pl.coderslab.dto;

import org.springframework.beans.factory.annotation.Required;
import pl.coderslab.model.Article;
import pl.coderslab.model.Author;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

public class AuthorDto {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private List<String> articles;

    public AuthorDto() {
    }

    public AuthorDto(Author that) {
        this.firstName = that.getFirstName();
        this.lastName = that.getLastName();
        this.articles = that.getArticles()
                .stream()
                .map(Article::getTitle)
                .collect(Collectors.toList());
    }

    public String getFirstName() {
        return firstName;
    }

    @Required
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Required
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<String> getArticles() {
        return articles;
    }

    public void setArticles(List<String> articles) {
        this.articles = articles;
    }
}

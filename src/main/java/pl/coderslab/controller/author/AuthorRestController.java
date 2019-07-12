package pl.coderslab.controller.author;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.dto.AuthorDto;
import pl.coderslab.model.Author;
import pl.coderslab.repository.AuthorDao;
import pl.coderslab.service.AuthorService;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/authors")
public class AuthorRestController {

    private AuthorService authorService;

    public AuthorRestController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping("/showAll")
    @ResponseBody
    public List showAuthors() {
        return authorService.findAll();
    }
}
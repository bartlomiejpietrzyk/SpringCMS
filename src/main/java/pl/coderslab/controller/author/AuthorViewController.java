package pl.coderslab.controller.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.model.Author;
import pl.coderslab.repository.AuthorDao;

import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorViewController {
    private AuthorDao authorDao;

    @Autowired
    public AuthorViewController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @GetMapping("")
    public String showAuthors(Model model) {
        List list = authorDao.showAuthors();
        model.addAttribute("author", list);
        return "display_authors";
    }

    @GetMapping("/add")
    public String createAuthorView(Model model) {
        model.addAttribute("author", new Author());
        return "create_author";
    }
//
//    @GetMapping("/add")
//    public String createAuthorView(Model model) {
//        model.addAttribute("author", new Author());
//        return "create_author";
//    }

    @PostMapping("/added")
    public String createAuthor (Author author, Model model){
        authorDao.save(author);
        List list = authorDao.showAuthors();
        model.addAttribute("author", list);
        return "display_authors";
    }

    @GetMapping("/delete")
    public String deleteAuthor (Model model,
                                @RequestParam Long id){
        authorDao.delete(authorDao.findOneById(id));
        List list = authorDao.showAuthors();
        model.addAttribute("author", list);
        return "display_authors";
    }

    @GetMapping("/edit")
    public String editAuthorView(Model model,
                                 @RequestParam Long id){
        model.addAttribute("author", authorDao.findOneById(id));
        return "edit_author";
    }

    @PostMapping ("/edited")
    public String editAuthor(Author author, Model model){
        Author oneById = authorDao.findOneById(author.getId());
        oneById.setFirstName(author.getFirstName());
        oneById.setLastName(author.getLastName());
        authorDao.update(oneById);
        List list = authorDao.showAuthors();
        model.addAttribute("author", list);
        return "display_authors";
    }


}
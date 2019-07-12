package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import pl.coderslab.model.Author;
import pl.coderslab.repository.AuthorDao;

import org.springframework.core.convert.converter.Converter;

public class AuthorConverter implements Converter<String, Author> {

    private AuthorDao authorDao;

    @Autowired
    public AuthorConverter(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Override
    public Author convert(String s) {
        return authorDao.findOneById(Long.parseLong(s));
    }
}

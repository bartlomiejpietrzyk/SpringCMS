package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.dto.AuthorDto;
import pl.coderslab.model.Author;
import pl.coderslab.repository.AuthorRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<AuthorDto> findAll(){
        List<Author> authorList = authorRepository.findAll();

        return authorList
                .stream()
                .map(AuthorDto::new)
                .collect(Collectors.toList());
    }

    public void save(Author author){
        authorRepository.save(author);
    }

    public void delete(Author author){
        authorRepository.delete(author);
    }
    public Author findOne(Long id){
        return authorRepository.findOne(id);
    }

}
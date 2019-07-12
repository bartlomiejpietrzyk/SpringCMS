package pl.coderslab.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAdder {

@RequestMapping("/article/")
    public String addArticle(){



    return "alalala";
}


}

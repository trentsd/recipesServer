package com.trentsd.recipesServer;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class CommentController {
    private CommentRepository repository;

    public CommentController(CommentRepository repository) {
        this.repository = repository;
    }

    // @GetMapping(path = "page/{pageId}")
    // @CrossOrigin(origins = "http://localhost:4200")
    // public Collection<Comment> pageComments(@PathVariable String pageId) {
    //     return repository.findAll().stream()
    //         .filter(c -> c.getPageid().toString().equals(pageId))
    //         .collect(Collectors.toList());
    // }

    @GetMapping("/comments")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Comment> comments() {
        return repository.findAll().stream().collect(Collectors.toList());
    }

    // private boolean isPageSeventeen(Comment comment) {
    //     return comment.getPageid().toString().equals("7");
    // }
    
}
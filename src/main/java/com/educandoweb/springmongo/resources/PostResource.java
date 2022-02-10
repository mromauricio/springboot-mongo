package com.educandoweb.springmongo.resources;

import com.educandoweb.springmongo.domain.Post;
import com.educandoweb.springmongo.domain.User;
import com.educandoweb.springmongo.dto.UserDTO;
import com.educandoweb.springmongo.resources.util.URL;
import com.educandoweb.springmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @GetMapping
    public ResponseEntity<List<Post>> findAll(){
        List<Post> posts = service.findAll();
        return ResponseEntity.ok().body(posts);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post post = service.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){
        List<Post> posts = service.findByTitle(URL.decodeParam(text));
        return ResponseEntity.ok().body(posts);
    }


}

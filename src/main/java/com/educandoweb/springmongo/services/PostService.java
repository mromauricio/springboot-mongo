package com.educandoweb.springmongo.services;

import com.educandoweb.springmongo.domain.Post;
import com.educandoweb.springmongo.domain.User;
import com.educandoweb.springmongo.dto.UserDTO;
import com.educandoweb.springmongo.respositories.PostRepository;
import com.educandoweb.springmongo.respositories.UserRepository;
import com.educandoweb.springmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public List<Post> findAll(){
        return repository.findAll();
    }

    public Post findById(String id) {
        Optional<Post> user = repository.findById((id));
        return user.orElseThrow(() -> new ObjectNotFoundException("Post Id not found"));
    }

    public Post insert(Post obj){
        return repository.insert(obj);
    }

    public void delete(String id){
        findById(id);
        repository.deleteById(id);
    }

    public void updateData(Post obj, Post existObj){
        existObj.setTitle(obj.getTitle());
        existObj.setBody(obj.getBody());
    }

    public Post update(Post obj){
        Post existObj = findById(obj.getId());
        updateData(obj, existObj);
        return repository.save(existObj);
    }

    public List<Post> findByTitle(String text){
        return repository.findByTitleContainingIgnoreCase(text);
    }

}

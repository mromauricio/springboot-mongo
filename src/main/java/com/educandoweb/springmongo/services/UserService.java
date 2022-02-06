package com.educandoweb.springmongo.services;

import com.educandoweb.springmongo.domain.User;
import com.educandoweb.springmongo.respositories.UserRepository;
import com.educandoweb.springmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = repository.findById((id));
        return user.orElseThrow(() -> new ObjectNotFoundException("User Id not found"));
    }
}

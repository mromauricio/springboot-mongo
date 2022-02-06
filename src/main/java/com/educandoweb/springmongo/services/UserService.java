package com.educandoweb.springmongo.services;

import com.educandoweb.springmongo.domain.User;
import com.educandoweb.springmongo.respositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }
}

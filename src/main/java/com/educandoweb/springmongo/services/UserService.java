package com.educandoweb.springmongo.services;

import com.educandoweb.springmongo.domain.Post;
import com.educandoweb.springmongo.domain.User;
import com.educandoweb.springmongo.dto.UserDTO;
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

    public User insert(User obj){
        return repository.insert(obj);
    }

    public void delete(String id){
        findById(id);
        repository.deleteById(id);
    }

    public void updateData(User obj, User existObj){
        existObj.setName(obj.getName());
        existObj.setEmail(obj.getEmail());
    }

    public User update(User obj){
        User existObj = findById(obj.getId());
        updateData(obj, existObj);
        return repository.save(existObj);
    }

    public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }

}

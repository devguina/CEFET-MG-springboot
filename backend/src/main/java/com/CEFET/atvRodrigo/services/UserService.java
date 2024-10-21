package com.CEFET.atvRodrigo.services;

import com.CEFET.atvRodrigo.RecordsDTO.UserRecordDTO;
import com.CEFET.atvRodrigo.models.User;
import com.CEFET.atvRodrigo.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    //POST
    public User addUser(UserRecordDTO dto){
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        user.setActive(true);
        return repository.save(user);
    }

    public List<User> allUsers(){
        return repository.findAll();
    }

    public Optional<User> getUser(UUID id){
        return repository.findById(id);
    }

    public void deleteUser(UUID id){
        repository.deleteById(id);
    }

    public User updateUser(UUID id, UserRecordDTO dto){
        Optional<User> userOptional = repository.findById(id);
        if (userOptional.isPresent()){
            User user = new User();
            user.setName(user.getName());
            user.setLogin(user.getLogin());
            user.setPassword(user.getPassword());
            return repository.save(user);
        }
        else {
            throw new RuntimeException("Client not found id: "+id);
        }
    }
}

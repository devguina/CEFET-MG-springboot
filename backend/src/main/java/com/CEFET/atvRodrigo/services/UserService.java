package com.CEFET.atvRodrigo.services;

import com.CEFET.atvRodrigo.RecordsDTO.UserRecordDTO;
import com.CEFET.atvRodrigo.models.User;
import com.CEFET.atvRodrigo.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    //add user
    @Transactional
    public User addUser(UserRecordDTO dto) {
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        user.setActive(true);
        return repository.save(user);
    }

    // return all users
    @Transactional
    public List<User> findAllUsers() {
        return repository.findAll();
    }

    // return N users by name
    @Transactional
    public List<User> findUserByName(String name){
        return repository.findByName(name);
    }

    // return user by id
    public Optional<User> findUserById(UUID id) {
        Optional<User> userOptional = repository.findById(id);
        return repository.findById(id);
    }

    // delete user by id
    public void deleteUserById(UUID id) {
        repository.deleteById(id);
    }

    // update user by id
    public User updateUserById(UUID id, UserRecordDTO dto) {
        Optional<User> userOptional = repository.findById(id);
        if (userOptional.isPresent()){
            User user1 = new User();
            BeanUtils.copyProperties(dto, user1);
            user1.setName(user1.getName());
            user1.setLogin(user1.getLogin());
            user1.setPassword(user1.getPassword());
            return repository.save(user1);
        }
        else  {
             throw new RuntimeException("User not found by id: "+id);
        }
    }
}

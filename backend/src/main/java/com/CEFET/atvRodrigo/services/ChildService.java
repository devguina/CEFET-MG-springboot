package com.CEFET.atvRodrigo.services;

import com.CEFET.atvRodrigo.RecordsDTO.ChildRecordDTO;
import com.CEFET.atvRodrigo.models.Child;
import com.CEFET.atvRodrigo.repositories.ChildRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChildService {

    @Autowired
    private ChildRepository repository;

    @Transactional
    public Child addChild(ChildRecordDTO dto){
        Child child = new Child();
        BeanUtils.copyProperties(dto, child);
        return repository.save(child);
    }

    @Transactional
    public Optional<Child> findChildById(UUID id){
        return repository.findById(id);
    }

    @Transactional
    public List<Child> findAllChildies(){
        return repository.findAll();
    }

    @Transactional
    public List<Child>findByName(String name){
        return repository.findByName(name);
    }

    @Transactional
    public void deleteChildById(UUID id){
        repository.deleteById(id);
    }

    @Transactional
    public Child updateChildById(UUID id, ChildRecordDTO dto){
        Optional <Child> childOptional = repository.findById(id);
        if (childOptional.isPresent()){
            Child child = new Child();
            BeanUtils.copyProperties(dto, child);
            child.setName(child.getName());
            child.setBirthday(child.getBirthday());
            child.setClient(child.getClient());
            return repository.save(child);
        }
        throw new RuntimeException();
    }
}

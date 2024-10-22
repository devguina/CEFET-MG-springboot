package com.CEFET.atvRodrigo.services;

import com.CEFET.atvRodrigo.RecordsDTO.StateRecordDTO;
import com.CEFET.atvRodrigo.models.State;
import com.CEFET.atvRodrigo.repositories.StateRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StateService {

    @Autowired
    private StateRepository repository;

    //POST
    @Transactional
    public State addState(StateRecordDTO dto){
        State state = new State();
        BeanUtils.copyProperties(dto, state);
        return repository.save(state);
    }

    //GET ALL
    @Transactional
    public List<State> getAllStates(){
        return repository.findAll();
    }

    //GET ONE STATE by id
    @Transactional
    public Optional<State> getState(UUID id){
        return repository.findById(id);
    }

    //DELETE STATE by id
    @Transactional
    public void deleteState(UUID id){
        repository.deleteById(id);
    }

    //PUT STATE by Id
    @Transactional
    public State updatestate(UUID id, StateRecordDTO dto){
        Optional<State> stateOptional = repository.findById(id);
        if(stateOptional.isPresent()){
            State state = new State();
            BeanUtils.copyProperties(dto, state);
            state.setName(state.getName());
            state.setAbbreviation(state.getAbbreviation());
            return repository.save(state);
        }
        else {
            throw new RuntimeException("State not found, id: "+id);
        }
    }

    @Transactional
    public List<State> findByName(String name){
        return  repository.findByName(name);
    }

}

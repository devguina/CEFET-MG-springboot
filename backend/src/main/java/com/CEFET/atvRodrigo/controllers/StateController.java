package com.CEFET.atvRodrigo.controllers;

import com.CEFET.atvRodrigo.RecordsDTO.StateRecordDTO;
import com.CEFET.atvRodrigo.models.State;
import com.CEFET.atvRodrigo.repositories.StateRepository;
import com.CEFET.atvRodrigo.services.StateService;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.beans.Beans;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/state")
public class StateController {

    @Autowired
    private StateService service;

    //GET ALL
    @GetMapping(value = "/")
    public ResponseEntity <List<State>> allStates(){
        List<State> states = service.getAllStates();
        return new ResponseEntity<>(states, HttpStatus.OK);
    }

    //GET BY ID
    @GetMapping(value = "/{îd}")
    public ResponseEntity<?> getState(@PathVariable UUID id){
        Optional<State> stateOptional = service.getState(id);
        if(stateOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(stateOptional);
        }
        else {
            return ResponseEntity.status((HttpStatus.NOT_FOUND)).body("State not found by id: "+id);
        }
    }

    //POST
    @PostMapping(value = "/")
    public ResponseEntity<?> postState(@RequestBody StateRecordDTO dto){
       State state = service.addState(dto);
        return ResponseEntity.status(HttpStatus.OK).body(state);
    }

    //DELETE BY ID
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteState(@PathVariable UUID id){
        Optional<State> stateOptional= service.getState(id);
        if(stateOptional.isPresent()){
            service.deleteState(id);
            return ResponseEntity.status(HttpStatus.OK).body("User has been deleted");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User has not found, id: "+id);
        }
    }

    //PUT BY ID
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> putState(@PathVariable UUID id,
                                      @RequestBody StateRecordDTO dto){
        Optional<State> stateOptional = service.getState(id);
        if (stateOptional.isPresent()){
            State state = service.updatestate(id, dto);
            return ResponseEntity.status(HttpStatus.OK).body(state);
        }
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("State not found by id: "+id);
    }

}
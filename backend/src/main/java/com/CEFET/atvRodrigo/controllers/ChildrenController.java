package com.CEFET.atvRodrigo.controllers;

import com.CEFET.atvRodrigo.RecordsDTO.ChildRecordDTO;
import com.CEFET.atvRodrigo.models.Child;
import com.CEFET.atvRodrigo.services.ChildService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/child")
public class ChildrenController {

    @Autowired
    ChildService service;

    @GetMapping(value = "/")
    public List<Child> getAllChild(){
        return service.findAllChildies();
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<?> getChild(@PathVariable UUID id){
        Optional<Child> childOptional = service.findChildById(id);
        if(childOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(childOptional);
        }
        else {
            return null;
        }
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<?> getNameChild(@PathVariable String name){
        List<Child> childList= service.findByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(childList);
    }

    @PostMapping(value = "/")
    public ResponseEntity<?> postChild(@RequestBody ChildRecordDTO dto){
        Child child = service.addChild(dto);
        return ResponseEntity.status(HttpStatus.OK).body(child);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> putChild(@RequestParam UUID id,
                                      @RequestBody @Valid ChildRecordDTO dto){
        Optional<Child> childOptional = service.findChildById(id);
        if(childOptional.isPresent()){
            Child child = service.updateChildById(id, dto);
            return ResponseEntity.status(HttpStatus.OK).body(child);
        }
        else {
            return null;
        }
    }

}

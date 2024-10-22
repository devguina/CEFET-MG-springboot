package com.CEFET.atvRodrigo.controllers;

import com.CEFET.atvRodrigo.RecordsDTO.ClientRecordDTO;
import com.CEFET.atvRodrigo.models.Client;
import com.CEFET.atvRodrigo.services.ClientService;
import jakarta.validation.Valid;
import org.hibernate.sql.model.PreparableMutationOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/client")
public class ClienteController {

    @Autowired
    private ClientService service;

    //GET ALL
    @GetMapping(value = "/")
    public ResponseEntity<List<Client>> getAll(){
         List<Client> clients= service.findAll();
         return ResponseEntity.status(HttpStatus.OK).body(clients);
    }

    //GET ID
    @GetMapping(value = "/id/{id}")
    public ResponseEntity<Optional<Client>> getById(@RequestParam UUID id){
        Optional<Client> clientOptional = service.findById(id);
        if(clientOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(clientOptional);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/")
    public ResponseEntity<Client>postClient(@RequestBody @Valid ClientRecordDTO dto){
       Client client = service.addClient(dto);
        return ResponseEntity.status(HttpStatus.OK).body(client);
    }
}

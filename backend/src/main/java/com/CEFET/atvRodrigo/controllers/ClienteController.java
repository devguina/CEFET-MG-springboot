package com.CEFET.atvRodrigo.controllers;

import com.CEFET.atvRodrigo.RecordsDTO.ClientRecordDTO;
import com.CEFET.atvRodrigo.models.Client;
import com.CEFET.atvRodrigo.services.ClientService;
import jakarta.validation.Valid;
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
    public ResponseEntity<List<Client>> getAll() {
        List<Client> clients = service.findAllClients();
        return ResponseEntity.status(HttpStatus.OK).body(clients);
    }

    //GET BY NAME
    @GetMapping(value = "/name/{name}")
    public ResponseEntity<?> getByName(@PathVariable String name){
        List<Client> clientes = service.findByClientByName(name);
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    //GET ID
    @GetMapping(value = "/id/{id}")
    public ResponseEntity<?> getById(@PathVariable UUID id) {
        Optional<Client> clientOptional = service.findClientById(id);
        if (clientOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(clientOptional);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //POST
    @PostMapping(value = "/")
    public ResponseEntity<Client> postClient(@RequestBody @Valid ClientRecordDTO dto) {
        Client client = service.addClient(dto);
        return ResponseEntity.status(HttpStatus.OK).body(client);
    }

    //DELETE BY ID
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable UUID id){
        Optional<Client> clientOptional = service.findClientById(id);
        if(clientOptional.isPresent()){
            service.deleteClientById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Client has been deleted");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client Not Found");
        }
    }

    //PUT BY ID
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> putClient(@RequestParam  UUID id,
                                            @RequestBody @Valid ClientRecordDTO dto ){
        Optional<Client>clientOptional = service.findClientById(id);
        if (clientOptional.isPresent()){
            Client client = service.updateClient(id, dto);
            return ResponseEntity.status(HttpStatus.OK).body(client);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
        }
    }
}

package com.CEFET.atvRodrigo.services;

import com.CEFET.atvRodrigo.RecordsDTO.ClientRecordDTO;
import com.CEFET.atvRodrigo.models.City;
import com.CEFET.atvRodrigo.models.Client;
import com.CEFET.atvRodrigo.repositories.ClientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    //find all clients
    @Transactional
    public List<Client> findAll(){
        return repository.findAll();
    }

    //find Client by id
    @Transactional
    public Optional<Client> findById(UUID id){
        return repository.findById(id);
    }

    // find Client by name
    @Transactional
    public List<Client>findByName(String name){
        return repository.findByName(name);

    }

    //add Client
    @Transactional
    public Client addClient(ClientRecordDTO dto){
        Client client = new Client();
        BeanUtils.copyProperties(dto, client);
        return repository.save(client);
    }

    //delete by id
    @Transactional
    public void deleteClientById(UUID id){
        repository.deleteById(id);
        }

    //put by id
    @Transactional
    public Client updateClient(UUID id, ClientRecordDTO dto){
        Optional<Client>clientOptional = repository.findById(id);
        if (clientOptional.isPresent()){
           Client client = new Client();
           BeanUtils.copyProperties(dto, client);
           client.setName(client.getName());
           client.setCity(client.getCity());
           client.setAddress(client.getAddress());
           client.setChildren(client.getChildren());
           client.setBirthday(client.getBirthday());
           client.setActive(client.isActive());
            return repository.save(client);
        }
        else {
            throw new RuntimeException();
        }

    }
}






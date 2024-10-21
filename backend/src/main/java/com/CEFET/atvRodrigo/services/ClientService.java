package com.CEFET.atvRodrigo.services;

import com.CEFET.atvRodrigo.RecordsDTO.CityRecordDTO;
import com.CEFET.atvRodrigo.RecordsDTO.ClientRecordDTO;
import com.CEFET.atvRodrigo.models.City;
import com.CEFET.atvRodrigo.models.Client;
import com.CEFET.atvRodrigo.repositories.ClientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

//    public Client addClient(ClientRecordDTO clientDTO, CityRecordDTO cityDTO){
//        Client client = new Client();
//        City city = new City();
//        BeanUtils.copyProperties(cityDTO, city);
//        BeanUtils.copyProperties(clientDTO, client);
//        client.setCity(city);
//
//    }
}

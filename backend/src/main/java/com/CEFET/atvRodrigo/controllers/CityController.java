package com.CEFET.atvRodrigo.controllers;

import com.CEFET.atvRodrigo.dto.CityDTO;
import com.CEFET.atvRodrigo.models.City;
import com.CEFET.atvRodrigo.services.CityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "city")
public class CityController {

    @Autowired
    private CityService service;

    @GetMapping(value = "/")
    public List<City> getAllCity(){
        return service.findAllCyties();
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<?> getCity(@PathVariable UUID id){
        Optional<City> cityOptional = service.findCityById(id);
        if(cityOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(cityOptional);
        }
        else {
            return null;
        }
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<?> getNameCity(@PathVariable String name){
        List<City> CityList= service.findCityByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(CityList);
    }

    @PostMapping(value = "/")
    public ResponseEntity<City> postCity(@RequestBody CityDTO dto){
        City city = service.addCity(dto);
        return ResponseEntity.status(HttpStatus.OK).body(city);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> putCity(@RequestParam UUID id,
                                      @RequestBody @Valid CityDTO dto){
        Optional<City> cityOptional = service.findCityById(id);
        if(cityOptional.isPresent()){
            City city = service.updateCityById(id, dto);
            return ResponseEntity.status(HttpStatus.OK).body(city);
        }
        else {
            return null;
        }
    }
}

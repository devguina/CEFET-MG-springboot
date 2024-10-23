package com.CEFET.atvRodrigo.services;

import com.CEFET.atvRodrigo.RecordsDTO.CityRecordDTO;
import com.CEFET.atvRodrigo.models.City;
import com.CEFET.atvRodrigo.repositories.CityRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CityService {
    @Autowired
    private CityRepository repository;

    @Transactional
    public City addCity(CityRecordDTO dto){
        City city = new City();
        BeanUtils.copyProperties(dto, city);
        return repository.save(city);
    }

    @Transactional
    public Optional<City> findCityById(UUID id){
        return repository.findById(id);
    }

    @Transactional
    public List<City>findAllCyties(){
        return repository.findAll();
    }

    @Transactional
    public List<City>findByName(String name){
        return repository.findByName(name);
    }

    @Transactional
    public void deleteCity(UUID id){
        repository.deleteById(id);
    }

    @Transactional
    public City updateCity(UUID id, CityRecordDTO dto){
        Optional <City> cityOptional = repository.findById(id);
        if (cityOptional.isPresent()){
            City city = new City();
            BeanUtils.copyProperties(dto, city);
            city.setName(city.getName());
            city.setState(city.getState());
            return repository.save(city);
        }
        throw new RuntimeException();
    }
}

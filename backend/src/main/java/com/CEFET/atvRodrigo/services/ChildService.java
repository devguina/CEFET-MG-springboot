package com.CEFET.atvRodrigo.services;

import com.CEFET.atvRodrigo.repositories.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChildService {

    @Autowired
    private ChildRepository repository;
}

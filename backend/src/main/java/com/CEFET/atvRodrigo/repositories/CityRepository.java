package com.CEFET.atvRodrigo.repositories;

import com.CEFET.atvRodrigo.models.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CityRepository extends JpaRepository<City, UUID> {
}

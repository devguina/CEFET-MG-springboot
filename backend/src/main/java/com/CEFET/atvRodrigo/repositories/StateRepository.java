package com.CEFET.atvRodrigo.repositories;

import com.CEFET.atvRodrigo.models.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StateRepository extends JpaRepository<State, UUID> {

    List<State> findByName(String name);

}

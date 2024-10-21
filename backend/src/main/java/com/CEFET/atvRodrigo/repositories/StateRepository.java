package com.CEFET.atvRodrigo.repositories;

import com.CEFET.atvRodrigo.models.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StateRepository extends JpaRepository<State, UUID> {
}

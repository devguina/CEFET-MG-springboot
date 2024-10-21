package com.CEFET.atvRodrigo.repositories;

import com.CEFET.atvRodrigo.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
}

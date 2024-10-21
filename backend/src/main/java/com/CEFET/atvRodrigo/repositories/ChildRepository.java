package com.CEFET.atvRodrigo.repositories;

import com.CEFET.atvRodrigo.models.Child;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChildRepository extends JpaRepository<Child, UUID> {
}

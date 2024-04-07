package com.miura.twittersimplified.repository;

import com.miura.twittersimplified.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepository extends JpaRepository <Role, Long> {
    Object findByName(String name);
}

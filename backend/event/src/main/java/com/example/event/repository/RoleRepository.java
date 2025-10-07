package com.example.event.repository;

import com.example.event.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name); // e.g., ROLE_USER, ROLE_ADMIN
}

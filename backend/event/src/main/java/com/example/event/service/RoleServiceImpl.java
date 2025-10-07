package com.example.event.service;

import com.example.event.model.Role;
import com.example.event.repository.RoleRepository;
import com.example.event.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<String> getAllRoles() {
        return roleRepository.findAll()
                .stream()
                .map(Role::getName)
                .collect(Collectors.toList());
    }

    @Override
    public String addRole(String roleName) {
        // Check if role already exists
        if (roleRepository.findByName(roleName).isPresent()) {
            return "Role already exists!";
        }

        Role role = new Role();
        role.setName(roleName);
        roleRepository.save(role);
        return "Role added successfully!";
    }
}

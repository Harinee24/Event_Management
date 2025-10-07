package com.example.event.controller;

import com.example.event.dto.UserDTO;
import com.example.event.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@CrossOrigin(origins = "http://localhost:3000")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<String> getAllRoles() {
        return roleService.getAllRoles();
    }

    @PostMapping
    public String addRole(@RequestParam String roleName) {
        return roleService.addRole(roleName);
    }
}

package com.example.event.service;

import java.util.List;

public interface RoleService {
    List<String> getAllRoles();
    String addRole(String roleName);
}

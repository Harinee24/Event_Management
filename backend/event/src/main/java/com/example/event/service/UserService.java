package com.example.event.service;

import com.example.event.dto.UserDTO;
import com.example.event.model.User;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
    UserDTO createUser(UserDTO userDTO);
    UserDTO updateUser(Long id, UserDTO userDTO);
    void deleteUser(Long id);
    UserDTO convertToDTO(User user);
    User getUserByEmail(String email);
}

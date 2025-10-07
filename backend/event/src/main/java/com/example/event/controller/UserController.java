package com.example.event.controller;
import com.example.event.dto.UserDTO;
import com.example.event.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @PutMapping("/{id}")
    public UserDTO updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        return userService.updateUser(id, userDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    // --- Login endpoint ---
    @PostMapping("/login")
    public UserDTO loginUser(@RequestBody UserDTO userDTO) {
        String email = userDTO.getEmail();
        String password = userDTO.getPassword();
        System.out.println("Received username: " + userDTO.getUsername());
        var userEntity = userService.getUserByEmail(email);
        if (userEntity == null) {
            throw new RuntimeException("User not found");
        }

        if (!userEntity.getPassword().equals(password)) {
            throw new RuntimeException("Invalid credentials");
        }

        return userService.convertToDTO(userEntity);
    }
}

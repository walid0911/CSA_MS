package me.code.backend;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
public record UserController(UserService userService) {

    @CrossOrigin(origins = "*")
    @GetMapping
    public List<User> GetAllUsers() {
        List<User> users = userService.getAllUsers();
        log.info("Count of users fetched: {}", users.size());
        return userService.getAllUsers();
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/add")
    public void AddUser(@RequestBody UserRequest request) {
        log.info("New user added: {}",request);
        userService.addUser(request);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete/{id}")
    public void DeleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        log.info("User deleted: {}", id);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/update/{id}")
    public void UpdateUser(@PathVariable("id") Integer id, @RequestBody UserRequest request) {
        userService.updateUser(id,request);
        log.info("User updated: {}, {}", id, request);
    }
}

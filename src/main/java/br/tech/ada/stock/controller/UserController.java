package br.tech.ada.stock.controller;

import br.tech.ada.stock.dto.UserDTO;
import br.tech.ada.stock.model.User;
import br.tech.ada.stock.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserDTO> addUser(@RequestBody User user) {
        User u = userService.saveOrUpdate(user);
        UserDTO DTO = new UserDTO(u);
        return ResponseEntity.ok(DTO);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<UserDTO> removeUser(@PathVariable Long id) {
        Optional<User> userOptional = userService.findById(id);
        if(userOptional.isPresent()){
            userService.delete(userOptional.get());
            UserDTO DTO = new UserDTO(userOptional.get());
            return ResponseEntity.ok(DTO);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<UserDTO> updateUser(@RequestBody User user, @PathVariable Long id) {
        Optional<User> userToBeUpdated = userService.findById(id);
        if(userToBeUpdated.isPresent()){
            userToBeUpdated.get().setEmail(user.getEmail());
            userToBeUpdated.get().setPassword(user.getPassword());
            userService.saveOrUpdate(userToBeUpdated.get());
            UserDTO DTO = new UserDTO(userToBeUpdated.get());
            return ResponseEntity.ok(DTO);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}

package br.tech.ada.stock.controller;

import br.tech.ada.stock.model.User;
import br.tech.ada.stock.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/create")
    public String addUser(User user) {
        userRepository.save(user);
        return "Success";
    }

}

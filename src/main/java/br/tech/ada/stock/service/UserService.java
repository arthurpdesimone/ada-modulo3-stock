package br.tech.ada.stock.service;

import br.tech.ada.stock.model.User;
import br.tech.ada.stock.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveOrUpdate(User user){
        return userRepository.save(user);
    }

    public void delete(User user){
        userRepository.delete(user);
    }
    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    public User findByEmailAndPassword(String email, String password){
        return userRepository.findUserByEmailAndPassword(email, password);
    }

}

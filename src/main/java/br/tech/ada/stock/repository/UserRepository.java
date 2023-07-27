package br.tech.ada.stock.repository;

import br.tech.ada.stock.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByEmailAndPassword(String email, String password);
}

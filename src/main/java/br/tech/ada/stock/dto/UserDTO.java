package br.tech.ada.stock.dto;

import br.tech.ada.stock.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Long id;
    public UserDTO(User user){
        this.id = user.getId();
    }
}

package br.com.ramonsilva.springsecurityjwt.repository;

import br.com.ramonsilva.springsecurityjwt.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRespository extends CrudRepository<User, String>{

    Optional<User> findByUsername(String username);
}

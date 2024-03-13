package br.com.ramonsilva.springsecurityjwt.repository;

import br.com.ramonsilva.springsecurityjwt.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRespository extends CrudRepository<User, String>{

    Optional<User> findByUsername(String username);
}

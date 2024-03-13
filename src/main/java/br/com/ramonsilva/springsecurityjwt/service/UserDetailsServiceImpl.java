package br.com.ramonsilva.springsecurityjwt.service;

import br.com.ramonsilva.springsecurityjwt.entity.UserAuthenticated;
import br.com.ramonsilva.springsecurityjwt.repository.UserRespository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRespository userRespository;

    public UserDetailsServiceImpl(UserRespository userRespository) {
        this.userRespository = userRespository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRespository.findByUsername(username)
                .map(user -> new UserAuthenticated(user))
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}

package com.example.db_cw_backend.security;

import com.example.db_cw_backend.model.User;
import com.example.db_cw_backend.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    public JwtUserDetailService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if(user == null) throw new UsernameNotFoundException("User with username "+username+" does not exists");

        return JwtUserFactory.createJwtUser(user);
    }

}

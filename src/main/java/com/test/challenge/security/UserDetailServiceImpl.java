package com.test.challenge.security;

import com.test.challenge.model.User;
import com.test.challenge.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserService userService;

    public UserDetailServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.findOneByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario con el email" + email + " no se encuentra."));

        return new UserDetailsImpl(user);
    }
}

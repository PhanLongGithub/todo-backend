package com.personal.todo_management.security;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.personal.todo_management.entity.User;
import com.personal.todo_management.repository.UserRepository;

import lombok.AllArgsConstructor;;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService{

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        User user = userRepository.findbyUsernameOrEmail(usernameOrEmail).orElseThrow(() -> {
            return new UsernameNotFoundException("User not exists by Username or Email");
        });

        Set<GrantedAuthority> grantedAuthorities = user.getRoles().stream().map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(
            usernameOrEmail,
            user.getPassword(),
            grantedAuthorities
        );
    }

}

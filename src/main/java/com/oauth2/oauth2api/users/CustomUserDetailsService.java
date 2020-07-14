package com.oauth2.oauth2api.users;

import com.oauth2.oauth2api.domains.Users;
import com.oauth2.oauth2api.repositories.UsersRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

/**
 * Created by nkakati on 8/23/2019.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepositoryCustom usersRepositoryCustom;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersRepositoryCustom.findByUsername(username);
        if (Objects.isNull(users)) {
            throw new UsernameNotFoundException(String.format("User %s does not exist!", username));
        }
        return new User(users.getUsername(), users.getPassword(), loadAuthorities(users));
    }

    private Collection<GrantedAuthority> loadAuthorities(Users users) {
        // get seurity roles from users
        return Collections.emptyList();
    }
}


package com.oauth2.oauth2api.repositories;

import com.oauth2.oauth2api.domains.Users;

public interface UsersRepositoryCustom {
    Users findByUsername(String username) throws RuntimeException;
}

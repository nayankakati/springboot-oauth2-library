package com.oauth2.oauth2api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nkakati on 8/12/2019.
 */
@RestController
public class OAuth2Controller {

    @PostMapping
    public ResponseEntity<Object> signUpForOauth2() {
        return null;
    }
}


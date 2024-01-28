package com.sy.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public class ProfileController {

    @GetMapping(value = "/user/profile", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Mono<String> getProfile(@RequestHeader("X-Authorization-Id") String userId) {
        return Mono.just("Hello: " + userId);
    }
}
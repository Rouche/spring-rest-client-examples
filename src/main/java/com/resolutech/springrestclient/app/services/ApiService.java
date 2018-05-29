package com.resolutech.springrestclient.app.services;

import java.util.List;

import com.resolutech.springrestclient.api.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ApiService {
    List<User> getUsers(Integer limit);

    Flux<User> getUsersReactive(Mono<Integer> limit);
}
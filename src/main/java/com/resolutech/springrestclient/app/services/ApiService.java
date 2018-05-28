package com.resolutech.springrestclient.app.services;

import java.util.List;

import com.resolutech.springrestclient.api.domain.User;

public interface ApiService {
    List<User> getUsers(Integer limit);
}
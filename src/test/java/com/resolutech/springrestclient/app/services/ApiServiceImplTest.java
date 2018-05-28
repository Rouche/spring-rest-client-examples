package com.resolutech.springrestclient.app.services;

import java.util.List;

import com.resolutech.springrestclient.api.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiServiceImplTest {

    @Autowired
    ApiService apiService;

    @Before
    public void setUp() {
    }

    @Test
    public void getUsers() {
        List<User> users = apiService.getUsers(3);

        assertNotNull(users);
        assertTrue(users.size() >= 3);
    }
}
package com.resolutech.springrestclient.app.controllers;

import com.resolutech.springrestclient.app.services.ApiService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ServerWebExchange;

@Slf4j
@Controller
public class UserController {

    ApiService apiService;

    public UserController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping({"","/", "/index"})
    public String index() {
        return "index";
    }

    @PostMapping("/users")
    public String formPost(ServerWebExchange exchange, Model model) {

//        exchange.getFormData().subscribe(map -> {
//            String limit = map.getFirst("limit");
//
//            log.debug("Received limit: [" + limit + "]");
//            if(StringUtils.isBlank(limit)) {
//                limit = "10";
//            }
//
//            model.addAttribute("users", apiService.getUsers(Integer.valueOf(limit)));
//        });

        model.addAttribute("users",
            apiService.getUsersReactive(exchange.getFormData()
                .map(multimap -> {
                    String limit = multimap.getFirst("limit");

                    log.debug("Received limit: [" + limit + "]");
                    if (StringUtils.isBlank(limit)) {
                        limit = "10";
                    }

                    return Integer.valueOf(limit);
                })
            )
        );

        return "userlist";
    }
}
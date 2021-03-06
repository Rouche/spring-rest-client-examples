package com.resolutech.springrestclient.app.services;

import java.util.List;

import com.resolutech.springrestclient.api.domain.User;
import com.resolutech.springrestclient.api.domain.UserData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ApiServiceImpl implements ApiService {

    // @Important rest template example
    private RestTemplate restTemplate;

    private final String api_url;

    public ApiServiceImpl(RestTemplate restTemplate, @Value("${api.url}") String api_url) {
        this.restTemplate = restTemplate;
        this.api_url = api_url;
    }

    public List<User> getUsers(Integer limit) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(api_url).queryParam("limit", limit);

        UserData userData = restTemplate.getForObject(builder.toUriString(), UserData.class);
        return userData.getData();
    }

    @Override
    public Flux<User> getUsersReactive(Mono<Integer> limit) {

        return limit.flatMapMany(integer ->
            WebClient.create(api_url)
                    .get()
                    .uri(uriBuilder -> uriBuilder.queryParam("limit", integer).build())
                    .accept(MediaType.APPLICATION_JSON)
                    .exchange()
                    .flatMap( clientResponse -> clientResponse.bodyToMono(UserData.class))
                    .flatMapIterable(UserData::getData)

        );
    }
}
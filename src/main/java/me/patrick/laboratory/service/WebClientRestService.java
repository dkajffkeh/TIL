package me.patrick.laboratory.service;

import lombok.AllArgsConstructor;
import me.patrick.laboratory.param.ResultEntity;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class WebClientRestService {

    private final WebClient webClient;

    public <T> ResultEntity<T> requestPost(String uri, Class<T> clazz, Object param) {

        return webClient.mutate()
                .baseUrl("http://localhost:8082")
                .build()
                .post()
                .uri(uri)
                .body(BodyInserters.fromValue(param))
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<ResultEntity<T>>() {})
                .block();
    }

    public <T> ResultEntity<T> requestGet(String uri, Class<T> clazz, Object param) {

        return webClient.mutate()
                .baseUrl("http://localhost:8082")
                .build()
                .get()
                .uri(uriBuilder -> uriBuilder.path(uri).build(1))
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<ResultEntity<T>>() {})
                .block();
    }

}

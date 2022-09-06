package me.patrick.laboratory.webclient;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootTest
public class WebClientTest {

    @Autowired
    private WebClient webClient;

    @Test
    @DisplayName("MonoTest")
    void monoTest() {
        Mono<String> helloWebClient = webClient.get()
                .uri("/v1/test")
                .retrieve()
                .bodyToMono(String.class);

        System.out.println(helloWebClient.block());
    }

    @Test
    @DisplayName("fluxTest")
    void fluxTest() {
        Flux<String> helloWebClient = webClient.get()
                .uri("/v1/test")
                .retrieve()
                .bodyToFlux(String.class);

        System.out.println(helloWebClient.blockLast());
    }
}

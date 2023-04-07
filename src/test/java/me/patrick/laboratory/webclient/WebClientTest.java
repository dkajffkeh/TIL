package me.patrick.laboratory.webclient;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class WebClientTest {

    @Autowired
    private WebClient webClient;

    @Test
    @DisplayName("Flux Test")
    void fluxTest() {
        System.out.println("Api요청");

        Map<String,String> map = new HashMap<>();

        Mono<String> stringMono = webClient.get()
                .uri(URI.create("http://localhost:8889/kotlin/test"))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class);

        stringMono.doOnSuccess(System.out::println).subscribe();


        System.out.println("haha");
    }
}

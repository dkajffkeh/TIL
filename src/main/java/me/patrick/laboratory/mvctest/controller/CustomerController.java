package me.patrick.laboratory.mvctest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import me.patrick.laboratory.param.Customer;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@AllArgsConstructor
public class CustomerController {

    private final WebClient webClient;
    private final ObjectMapper objectMapper;

    @GetMapping("/customers")
    public void findAll() {
        System.out.println("start");

        Stream<Customer> customerStream = webClient.mutate().build()
                .get()
                .uri("/v1/find/all")
                .retrieve()
                .bodyToFlux(Customer.class).toStream();

        List<Customer> customers = customerStream.map(customer -> objectMapper.convertValue(customer,Customer.class)).collect(Collectors.toList());

        System.out.println(customers);

        System.out.println("end");
    }

    @GetMapping(value = "/flux/delay", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> flux() {
         return webClient.get()
                .uri("/v1/find/all")
                .retrieve()
                .bodyToFlux(Customer.class)
                 .map(customer -> objectMapper.convertValue(customer,Customer.class))
                 .delayElements(Duration.ofSeconds(1)).log();
    }



}

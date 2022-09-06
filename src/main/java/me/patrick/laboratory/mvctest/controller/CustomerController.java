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

    /**
     * [2022-09-05 21:36:45.498] [http-nio-8081-exec-1] [28a1ff59] INFO  r.F.M.1 - onSubscribe(MonoFlatMapMany.FlatMapManyMain) 구독 시작
     * [2022-09-05 21:36:45.499] [http-nio-8081-exec-1] [28a1ff59] INFO  r.F.M.1 - request(unbounded) // 갯수 상관없이 전체 다받아옴
     * [2022-09-05 21:36:45.708] [reactor-http-nio-1] [] INFO  r.F.M.1 - onNext(me.patrick.laboratory.param.Customer@6cdfa759)
     * [2022-09-05 21:36:45.708] [reactor-http-nio-1] [] INFO  r.F.M.1 - onNext(me.patrick.laboratory.param.Customer@50a9949f)
     * [2022-09-05 21:36:45.708] [reactor-http-nio-1] [] INFO  r.F.M.1 - onNext(me.patrick.laboratory.param.Customer@516f45b1)
     * [2022-09-05 21:36:45.708] [reactor-http-nio-1] [] INFO  r.F.M.1 - onNext(me.patrick.laboratory.param.Customer@24e140a5)
     * [2022-09-05 21:36:45.708] [reactor-http-nio-1] [] INFO  r.F.M.1 - onNext(me.patrick.laboratory.param.Customer@3515de0f)
     * [2022-09-05 21:36:45.709] [reactor-http-nio-1] [] INFO  r.F.M.1 - onComplete() // 다 받아온후 Flux 종료
     */

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

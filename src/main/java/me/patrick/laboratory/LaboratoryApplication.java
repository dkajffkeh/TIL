package me.patrick.laboratory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LaboratoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LaboratoryApplication.class, args);
    }

/*    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            System.out.println("Api요청");

            Map<String,String> map = new HashMap<>();

            Mono<String> stringMono = webClient.get()
                    .uri(URI.create("https://localhost:8889/kotlin/test"))
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(String.class);

            Disposable disposable = stringMono.doOnSuccess(System.out::println).subscribe();

            System.out.println("haha");
        };
    }*/

}



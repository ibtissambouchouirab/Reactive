package reactive.client;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactive.Event;
import reactive.service.ReactiveServiceApplication;
import reactor.core.Disposable;

import java.util.Collections;

@SpringBootApplication
public class ReactiveClientApplication {

    public static void main(String[]  args){

        new SpringApplicationBuilder(ReactiveClientApplication.class)
                .properties(Collections.singletonMap("service.post", "8081"))
                .run(args);
    }

    @Bean
    WebClient client (){
        return WebClient.create("http://localhost:8080");
    }

    @Bean
    CommandLineRunner demo ( WebClient client1 ){
        return args -> {
            client1.get().uri("/events")
                    .accept(MediaType.TEXT_EVENT_STREAM)
                    .exchangeToFlux(rt -> rt.bodyToFlux(Event.class))
                    .subscribe( System.out::println);
        };


    }
}

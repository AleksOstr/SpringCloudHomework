package ru.gb.issuanceservice.provider;

import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import ru.geekbrains.booksevice.model.BookEntity;

import java.util.List;

@Component
public class BookProvider {

    private WebClient webClient;

    public BookProvider(ReactorLoadBalancerExchangeFilterFunction loadBalancerExchangeFilterFunction) {
        this.webClient = WebClient.builder()
                .filter(loadBalancerExchangeFilterFunction)
                .build();
    }

    public List<BookEntity> getBooks() {
        return webClient.get()
                .uri("http://book-service/api/book/all")
                .retrieve()
                .bodyToFlux(BookEntity.class)
                .collectList()
                .block();
    }

}

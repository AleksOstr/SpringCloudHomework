package ru.gb.issuanceservice.provider;

import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import ru.gb.issuanceservice.model.ReaderEntity;


import java.util.List;

@Component
public class ReaderProvider {

    private WebClient webClient;

    public ReaderProvider(ReactorLoadBalancerExchangeFilterFunction loadBalancerExchangeFilterFunction) {
        this.webClient = WebClient.builder()
                .filter(loadBalancerExchangeFilterFunction)
                .build();
    }

    public List<ReaderEntity> getReaders() {
        return webClient.get()
                .uri("http://reader-service/api/reader/all")
                .retrieve()
                .bodyToFlux(ReaderEntity.class)
                .collectList()
                .block();
    }
}

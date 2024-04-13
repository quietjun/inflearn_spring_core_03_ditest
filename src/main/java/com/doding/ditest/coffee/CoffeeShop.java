package com.doding.ditest.coffee;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Component
@Slf4j
public class CoffeeShop {
    // private final Barista barista; // Coffeeshop의 의존성
    private final ObjectProvider<Barista> baristaProvider;

    public Coffee orderCoffee(String client, String name) {
        // return barista.makeCoffee(client, name);
        return baristaProvider.getObject().makeCoffee(client, name);
    }

    @PostConstruct
    public void setup() {
        log.debug("하루 장사를 준비하자!: 집기, 재료 준비");
    }

    @PreDestroy
    public void cleanup() {
        log.debug("하루 장사 마감: 집기 정리, 정산.");
    }
}

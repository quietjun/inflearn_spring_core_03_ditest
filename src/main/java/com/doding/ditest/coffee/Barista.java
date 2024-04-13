package com.doding.ditest.coffee;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
// @RequiredArgsConstructor
@Lazy
@Slf4j
public class Barista {
    private final ApplicationContext ctx;

    public Barista(ApplicationContext ctx) {
        this.ctx = ctx;
        log.debug("드디어 바리스타 생성");
    }

    // 기능
    public Coffee makeCoffee(String client, String name) {
        // return new Coffee(client, name);
        return ctx.getBean(Coffee.class, client, name);
    }
}

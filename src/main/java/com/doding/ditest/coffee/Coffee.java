package com.doding.ditest.coffee;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Component
@Scope("prototype")
@Slf4j
public class Coffee {
    // 어떤 손님이 주문한 어떤 커피 : Coffee의 상태
    private final String client;
    private final String coffee;

    @PostConstruct
    public void setup() {
        log.debug("컵에 담아서 서비스!!");
    }

    // @PreDestroy : prototype bean은 지원하지 않음
    public void cleanup() {
        log.debug("마신 컵은 정리 필요");
    }
}

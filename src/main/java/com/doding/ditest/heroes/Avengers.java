package com.doding.ditest.heroes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Avengers {
    // 의존성 선언
    private IronMan iman;
    private Hulk hulk;
    private HulkBuster hb;

    // @Autowired // 생성자 주입
    public Avengers(@Qualifier("ironMan") IronMan iman, Hulk hulk) {
        log.debug("avengers 객체 생성:  iman: {}, hulk: {}", iman, hulk);
        this.iman = iman;
        this.hulk = hulk;
    }

    @Autowired
    public void setHulkBuster(HulkBuster hb) {
        log.debug("hulkbuster 설정: {}", hb);
        this.hb = hb;
    }
}

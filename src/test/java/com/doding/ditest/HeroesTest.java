package com.doding.ditest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.doding.ditest.heroes.Avengers;
import com.doding.ditest.heroes.HulkBuster;
import com.doding.ditest.heroes.IronMan;

import jakarta.annotation.Resource;

@SpringBootTest
public class HeroesTest {
    @Autowired // Avengers 타입의 빈을 주입해주세요!!
    Avengers avengers;

    @Test
    @DisplayName("hreoes 계열의 빈 생성 점검")
    public void avengerTest() {
        assertNotNull(avengers);
    }

    @Autowired
    @Qualifier("hb")
    IronMan iman;

    @Test
    public void ironManTest() {
        assertNotNull(iman);
        assertEquals(iman.getClass(), HulkBuster.class);
    }

    @Resource(name = "ironMan") // 타입: IronMan, 빈의 이름은 ironMan
    IronMan steelMan;

    @Test
    public void resourceTest() {
        assertNotNull(steelMan);
    }

}

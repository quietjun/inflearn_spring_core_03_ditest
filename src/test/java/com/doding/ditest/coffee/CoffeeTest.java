package com.doding.ditest.coffee;

import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class CoffeeTest {

    @Autowired
    ApplicationContext ctx;

    @Test
    @DisplayName("singleton과 prototype 스코프에서 빈의 동일성 확인")
    void scopeTest() {
        Coffee c1 = ctx.getBean(Coffee.class, "hong", "latte");
        Coffee c2 = ctx.getBean(Coffee.class, "hong", "latte");

        assertNotSame(c1, c2);

        CoffeeShop shop1 = ctx.getBean(CoffeeShop.class);
        CoffeeShop shop2 = ctx.getBean(CoffeeShop.class);
        assertSame(shop1, shop2);

        Coffee c3 = shop1.orderCoffee("hong", "latte");
        Coffee c4 = shop1.orderCoffee("hong", "latte");

        assertNotSame(c3, c4);
    }
}

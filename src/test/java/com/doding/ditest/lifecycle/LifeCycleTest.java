package com.doding.ditest.lifecycle;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.doding.ditest.coffee.Barista;
import com.doding.ditest.coffee.Coffee;
import com.doding.ditest.coffee.CoffeeShop;

@SpringBootTest
public class LifeCycleTest {
    @Autowired
    CoffeeShop shop;

    @Test
    @DisplayName("초기화 메서드와 소멸 메서드의 동작 확인")
    void makeCoffeeTest() {
        Coffee c1 = shop.orderCoffee("hong", "latte");
        c1.cleanup(); // prototype 빈의 소멸 메서드는 명시적으로 호출 필요

        Coffee c2 = shop.orderCoffee("hong", "latte");
        c2.cleanup();
    }

    @Test
    @DisplayName("게으른 바리스타 테스트")
    void lazyBaristaTest() {
        Coffee c1 = shop.orderCoffee("hong", "latte");
    }

}

package com.doding.ditest.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.doding.ditest.car.Car;

@SpringBootTest
@ActiveProfiles({ "dev", "oper" })
public class CarTest {

    @Autowired(required = false)
    @Qualifier("carForExercise")
    Car car;

    @Test
    public void carInjectTest() {
        // assertNull(car);
        assertEquals(car.getClass().getSimpleName(), "CarForExercise");
    }
}

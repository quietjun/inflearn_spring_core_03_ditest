package com.doding.ditest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.doding.ditest.phone.PhoneUser;
import com.doding.ditest.phone.SPhone;
import com.doding.ditest.phone.SmartPhone;

@SpringBootTest // junit과 springboot의 연동
public class PhoneTest {
    @Autowired
    ApplicationContext ctx;

    @Test
    public void printBeanNames() {
        String[] names = ctx.getBeanDefinitionNames();
        Arrays.stream(names).filter(name -> name.matches("(?i).*phone.*")).forEach(System.out::println);
    }

    @Test
    @DisplayName("spring container는 빈들을 singleton으로 관리한다.")
    public void singletonTest() {
        SPhone p1 = ctx.getBean(SPhone.class);
        SPhone p2 = ctx.getBean(SPhone.class);

        assertSame(p1, p2);

        PhoneUser user = ctx.getBean(PhoneUser.class);
        assertSame(user.getPhone(), p1);
    }

    @Test
    @DisplayName("spring container는 기본적으로 type 기반으로 빈 관리. 동일 타입의 빈 구분을 위해 name 필요")
    public void getPhoneTestByType() {
        assertThrows(NoUniqueBeanDefinitionException.class, () -> ctx.getBean(SmartPhone.class));
        // 이름 기반으로 보완
        SmartPhone phone = ctx.getBean("sphone", SmartPhone.class);
        assertEquals(phone.getClass().getName(), SPhone.class.getName());
    }
}

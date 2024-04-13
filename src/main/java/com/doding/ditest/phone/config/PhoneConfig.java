package com.doding.ditest.phone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.doding.ditest.phone.LPhone;
import com.doding.ditest.phone.PhoneUser;
import com.doding.ditest.phone.SPhone;

import lombok.extern.slf4j.Slf4j;

@Configuration // 이것은 설정파일입니다.
@Slf4j
public class PhoneConfig {

    @Bean // 이것은 빈입니다.!
    public SPhone sphone() {
        log.debug("sphone 타입 빈 생성");
        return new SPhone();
    }

    @Bean("myLphone")
    public LPhone lphone() {
        log.debug("lphone 타입 빈 생성");
        return new LPhone();
    }

    @Bean
    public PhoneUser phoneUser() {
        log.debug("phoneuser 타입 빈 생성");
        PhoneUser user = new PhoneUser(sphone());
        return user;
    }
}

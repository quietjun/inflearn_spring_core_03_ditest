package com.doding.ditest.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("oper")
public class OperProfileTest {

    @Value("${server.db.ip}")
    String ip;

    @Value("${server.db.user}")
    String user;

    @Value("${logging.level.[com.doding]}")
    String level;

    @Test
    public void profileTest() {
        assertEquals(ip, "192.168.0.1");
        assertEquals(user, "admin");
        assertEquals(level, "debug");
    }
}

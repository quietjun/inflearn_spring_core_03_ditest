package com.doding.ditest.phone;

import com.doding.ditest.phone.config.PhoneFactory;

public class PhoneTest {
    public static void main(String[] args) {
        PhoneUser pu = new PhoneUser(PhoneFactory.getPhone("L"));
        pu.usePhone();
    }
}

package com.doding.ditest.phone;

import lombok.Getter;

@Getter
public class PhoneUser {
    SmartPhone phone; // has a 관계 - member 변수

    public PhoneUser(SmartPhone phone) { // 생성자 주입
        // phone = new SPhone(); // 직접 객체 생성
        this.phone = phone; // 주입 받아서 사용
    }

    public void setPhone(SmartPhone phone) { // setter 메서드를 통한 주입
        this.phone = phone;
    }

    public void usePhone() {
        System.out.println(phone.getClass().getSimpleName() + "으로 통화 진행!");
    }
}

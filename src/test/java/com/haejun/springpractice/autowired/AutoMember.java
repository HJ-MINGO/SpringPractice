package com.haejun.springpractice.autowired;

/**
 * packageName    : com.haejun.springpractice.autowired
 * fileName       : AutoMember
 * author         : NAHAEJUN
 * date           : 2024-07-13
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-07-13        NAHAEJUN              최초생성
 */
/* 객체, 즉 인스턴스를 생성하려는 클래스이지,AutoMember는 스프링 빈이 아닌다.(따로 컴포넌트로 하여 빈을 등록하지 않았기 때문) */
public class AutoMember {

    private String name;

    private int age;

    private String gender;

    public AutoMember() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

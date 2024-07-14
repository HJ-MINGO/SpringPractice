package com.haejun.springpractice.exec2.user.dto;

/**
 * packageName    : com.haejun.springpractice.exec2.user.dto
 * fileName       : user
 * author         : NAHAEJUN
 * date           : 2024-06-29
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-06-29        NAHAEJUN              최초생성
 */
public class User {
    private long id;
    private String name;
    private int age;
    // 생성자를 아무것도 선언하지 않았을경우 컴파일 할떄 무조건 기볹생성자를 생성한다.
    public User() {}

    public User(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
    
    // Object클래스 toString 오버라이딩
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

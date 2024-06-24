package com.haejun.springpractice.exec1.member.dto;

import com.haejun.springpractice.exec1.member.Grade;

/**
 * packageName    : com.haejun.springpractice.exec1.member
 * fileName       : Member
 * author         : NAHAEJUN
 * date           : 2024-06-19
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-06-19        NAHAEJUN              최초생성
 */
public class Member {

    private Long id;
    private String name;
    private Grade grade;

    public Member() {}

    public Member(Long id, String name, Grade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}

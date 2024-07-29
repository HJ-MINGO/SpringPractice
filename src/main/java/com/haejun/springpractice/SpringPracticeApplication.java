package com.haejun.springpractice;

import com.haejun.springpractice.service.BeanMember;
import com.haejun.springpractice.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringPracticeApplication {


	// 인텔리제이 경우 자바를 실행할때 직접 실행이 아닌 gradle를 통해서 실행한다.
	public static void main(String[] args) {

		SpringApplication.run(SpringPracticeApplication.class, args);


	}
}

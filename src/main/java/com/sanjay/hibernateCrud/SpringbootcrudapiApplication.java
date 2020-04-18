package com.sanjay.hibernateCrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SpringbootcrudapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootcrudapiApplication.class, args);
		System.out.println("args = " + Arrays.deepToString(args));
	}

}

 package com.mytestapp.prog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		scanBasePackages = {"com.mytestapp.prog",
							"util"}
)
public class MytestappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MytestappApplication.class, args);
	}

}

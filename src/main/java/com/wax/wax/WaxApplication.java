package com.wax.wax;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class WaxApplication {

	public static void main(String[] args) {
		SpringApplication.run(WaxApplication.class, args);
	}

	@GetMapping
	public List<String> hello() {
		return List.of("Hello","Word");
	}

}

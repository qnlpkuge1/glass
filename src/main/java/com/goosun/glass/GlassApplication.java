package com.goosun.glass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GlassApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(GlassApplication.class, args);
	}
	
	@RequestMapping(value = "/",produces = "text/plain;charset=UTF-8")
    String index(){
        return "Hello Spring Boot! ";
    }
	
}

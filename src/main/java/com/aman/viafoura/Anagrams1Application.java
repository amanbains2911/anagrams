package com.aman.viafoura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.aman.viafoura.model.AnagramModel;
import com.aman.viafoura.model.AnagramsCount;

@SpringBootApplication
public class Anagrams1Application {

	
	@Bean 
	public AnagramModel getAnagramModel() {
		return new AnagramModel();
	}
	
	@Bean
	public AnagramsCount getAnagramsCount() {
		return new AnagramsCount();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Anagrams1Application.class, args);
	}

}

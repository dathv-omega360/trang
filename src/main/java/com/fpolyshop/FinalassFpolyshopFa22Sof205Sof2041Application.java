package com.fpolyshop;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FinalassFpolyshopFa22Sof205Sof2041Application {

	public static void main(String[] args) {
		SpringApplication.run(FinalassFpolyshopFa22Sof205Sof2041Application.class, args);
	}
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper;

	}
}

package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.entities.Country;
import com.example.demo.repositories.CountryRepository;

@EnableAutoConfiguration
@ComponentScan(basePackages="com.ba.demo")
@SpringBootApplication
public class CountriesApplication implements CommandLineRunner{
	
	@Autowired
	private CountryRepository countryRepository;

	public static void main(String[] args) {
		SpringApplication.run(CountriesApplication.class, args);
		System.out.println("Hello World!");
	}
	
	@Override
	public void run(String...args) throws Exception{
		countryRepository.save(new Country("Earth","World"));
		countryRepository.save(new Country("China","Peking"));
		countryRepository.save(new Country("Germany","Berlin"));
		countryRepository.save(new Country("USA","Washington DC"));
		countryRepository.save(new Country("Russia","Moscov"));
		countryRepository.save(new Country("TURKIYE","Ankara"));
	}
}

package com.dam2.bitacora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan

public class BitacoraApplication {

	public static void main(String[] args) {
		SpringApplication.run(BitacoraApplication.class, args);
		
	}
}

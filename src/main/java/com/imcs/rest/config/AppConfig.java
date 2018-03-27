package com.imcs.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.imcs.passenger.respository.services.PassengerService;
import com.imcs.passenger.respository.services.PassengerServiceImpl;

@Component
@Configuration
public class AppConfig {

	@Bean
	public PassengerService getPassengerService() {
		return new PassengerServiceImpl();
	}
}

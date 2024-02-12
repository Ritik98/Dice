package com.dice.weatherforecastsummary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class WeatherForecastSummaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherForecastSummaryApplication.class, args);
	}
	@Bean
	public RestTemplate rest() {
		return new RestTemplate();
	}
}

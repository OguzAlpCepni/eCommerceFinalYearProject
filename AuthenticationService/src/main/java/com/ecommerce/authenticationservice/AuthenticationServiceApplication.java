package com.ecommerce.authenticationservice;

import com.ecommerce.authenticationservice.core.exceptions.ProblemDetails;
import com.ecommerce.authenticationservice.core.exceptions.ServicesException;
import com.ecommerce.authenticationservice.core.exceptions.ValidationProblemDetails;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@EnableDiscoveryClient
@RestControllerAdvice
@SpringBootApplication
public class AuthenticationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationServiceApplication.class, args);
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleServicesExceptions(ServicesException servicesException){
		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage(servicesException.getMessage());
		return problemDetails;
	}
	@ExceptionHandler
	@ResponseStatus(code =HttpStatus.BAD_REQUEST)
	public ProblemDetails handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException){
		ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
		validationProblemDetails.setMessage("Validation exceptions");
		validationProblemDetails.setValidationErrors(new HashMap<String,String>());
		for(FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
			validationProblemDetails.getValidationErrors().put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return validationProblemDetails;
	}
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}

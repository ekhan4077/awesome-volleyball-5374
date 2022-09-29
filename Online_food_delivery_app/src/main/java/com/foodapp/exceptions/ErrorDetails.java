package com.foodapp.exceptions;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ErrorDetails {
	
	private LocalDate timestamp;
	private String message;
	private String details;
	
	

	
	
	

}

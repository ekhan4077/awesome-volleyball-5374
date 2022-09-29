package com.foodapp.exceptions;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

//Customer Exception Handler
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<ErrorDetails> customerExceptionHandler(CustomerException pe, WebRequest req){
		
		ErrorDetails err = new ErrorDetails();
			err.setTimestamp(LocalDate.now());
			err.setMessage(pe.getMessage());
			err.setDetails(req.getDescription(false));
			
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.NOT_FOUND);
		
	}
	
	
//Bill Exception Handler	
	@ExceptionHandler(BillException.class)
	public ResponseEntity<ErrorDetails> billExceptionHandler(BillException be, WebRequest req){
		
		ErrorDetails err = new ErrorDetails();
			err.setTimestamp(LocalDate.now());
			err.setMessage(be.getMessage());
			err.setDetails(req.getDescription(false));
			
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.NOT_FOUND);
		
	}
	
	
	
//Cart Exception Handler	
		@ExceptionHandler(CartException.class)
		public ResponseEntity<ErrorDetails> cartExceptionHandler(CartException ce, WebRequest req){
			
			ErrorDetails err = new ErrorDetails();
				err.setTimestamp(LocalDate.now());
				err.setMessage(ce.getMessage());
				err.setDetails(req.getDescription(false));
				
			return new ResponseEntity<ErrorDetails>(err,HttpStatus.NOT_FOUND);
			
		}
		
		
//Category Exception Handler	
		@ExceptionHandler(CategoryException.class)
		public ResponseEntity<ErrorDetails> categoryExceptionHandler(CategoryException ce, WebRequest req){
			
			ErrorDetails err = new ErrorDetails();
				err.setTimestamp(LocalDate.now());
				err.setMessage(ce.getMessage());
				err.setDetails(req.getDescription(false));
				
			return new ResponseEntity<ErrorDetails>(err,HttpStatus.NOT_FOUND);
			
		}
		
		
//Item Exception Handler	
		@ExceptionHandler(ItemException.class)
		public ResponseEntity<ErrorDetails> itemExceptionHandler(ItemException ie, WebRequest req){
			
			ErrorDetails err = new ErrorDetails();
				err.setTimestamp(LocalDate.now());
				err.setMessage(ie.getMessage());
				err.setDetails(req.getDescription(false));
				
			return new ResponseEntity<ErrorDetails>(err,HttpStatus.NOT_FOUND);
			
		}
		
//Order Exception Handler	
		@ExceptionHandler(OrderException.class)
		public ResponseEntity<ErrorDetails> orderExceptionHandler(OrderException oe, WebRequest req){
			
			ErrorDetails err = new ErrorDetails();
				err.setTimestamp(LocalDate.now());
				err.setMessage(oe.getMessage());
				err.setDetails(req.getDescription(false));
				
			return new ResponseEntity<ErrorDetails>(err,HttpStatus.NOT_FOUND);
			
		}
		
		
//Restaurant Exception Handler	
		@ExceptionHandler(RestaurantException.class)
		public ResponseEntity<ErrorDetails> orderExceptionHandler(RestaurantException re, WebRequest req){
			
			ErrorDetails err = new ErrorDetails();
				err.setTimestamp(LocalDate.now());
				err.setMessage(re.getMessage());
				err.setDetails(req.getDescription(false));
				
			return new ResponseEntity<ErrorDetails>(err,HttpStatus.NOT_FOUND);
			
		}
	
	
	
		

//Any other Exception Handler	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> exceptionHandler(Exception e, WebRequest req){
		
		ErrorDetails err = new ErrorDetails();
			err.setTimestamp(LocalDate.now());
			err.setMessage(e.getMessage());
			err.setDetails(req.getDescription(false));
			
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	
	
	
}

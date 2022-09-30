package com.foodapp.auth.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Login {

	@Id
	@NotNull
	private Integer userId;
	
	private String email;
	
	private String password;
	
}

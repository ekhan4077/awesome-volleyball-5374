package com.foodapp.model;


import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Customer {
	
	@Id
	private Integer customerId;
	private String firstName;
	private String lastName;
	private Integer age;
	private String gender;
	private String mobileNumber;
	private String email;
	
	@Embedded
	private Address address;

}

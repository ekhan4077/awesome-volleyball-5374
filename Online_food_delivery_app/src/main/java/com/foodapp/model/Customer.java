package com.foodapp.model;


import javax.persistence.*;


import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.Data;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="users")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	
	@NotNull
	private String firstName;
	
	@NotNull
	private String lastName;
	
	@NotNull
	@Pattern(regexp="[a-zA-Z0-9]{6,12}",message="Password must contain between 6 to 12 characters. Must be alphanumeric with both Upper and lowercase characters.")
	private String password;
	
	private Integer age;
	private String gender;
	
	@NotNull
	@Pattern(regexp="[0-9]{10}", message = "Mobile number must have 10 digits")
	private String mobileNumber;
	
	@Email
	@NotNull
	private String email;
	
	@Embedded
	private Address address;
	
	
}

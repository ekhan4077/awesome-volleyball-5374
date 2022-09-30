package com.foodapp.auth.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserSessionTrack {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	
	@Column(unique =  true)
	private Integer customerId;
	
	private String uuid;
	
	private LocalDateTime localDateTime;

	public UserSessionTrack(Integer userId, String uuid, LocalDateTime localDateTime) {
		super();
		this.customerId = userId;
		this.uuid = uuid;
		this.localDateTime = localDateTime;
	}
}

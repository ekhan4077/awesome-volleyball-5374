package com.foodapp.auth.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class AdminLogin {

    @Id
    @NotNull
    private Integer userId;

    private String name;

    private String password;
}
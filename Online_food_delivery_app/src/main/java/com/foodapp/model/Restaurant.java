package com.foodapp.model;

import java.util.List;



import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Integer restaurantId;

    @NotNull
    private String restaurantName;

    @NotNull
    private String managerName;

    @NotNull
    @Pattern(regexp="[0-9]{10}", message = "Mobile number must have 10 digits")
    private String contactNumber;

    @NotNull
    @Pattern(regexp="[a-zA-Z0-9]{6,12}",message="Password must contain between 6 to 12 characters. Must be alphanumeric with both Upper and lowercase characters.")
    private String password;



    @Embedded
    private Address address;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Item> itemLists;
}

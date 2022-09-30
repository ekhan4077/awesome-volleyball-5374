package com.foodapp.model;

import java.util.List;



import lombok.*;

import javax.persistence.*;

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
    private Integer restaurantId;
    private String restaurantName;
    private String managerName;
    private String contactNumber;
    
   
    @Embedded
    private Address address;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Item> itemLists;
}

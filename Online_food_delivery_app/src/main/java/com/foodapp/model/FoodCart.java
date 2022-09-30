package com.foodapp.model;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class FoodCart {
    @Id  
    private Integer cartId;

    @OneToOne
    private Customer customer;


    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> itemList;
}

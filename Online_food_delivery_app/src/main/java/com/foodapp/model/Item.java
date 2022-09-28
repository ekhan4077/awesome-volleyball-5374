package com.foodapp.model;

import java.util.List;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer itemId;
    private String itemName;

    private Integer quantity;
    private Double cost;

    @ManyToMany
    private List<Restaurant> Restaurant;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CategoryId", referencedColumnName = "catId")
    private Category category;
}

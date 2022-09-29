package com.foodapp.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.foodapp.model.FoodCart;
import lombok.*;

import javax.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;
    
    private LocalDateTime orderDate;
    private  String orderStatus;

    @ManyToOne
    private FoodCart cart;
}

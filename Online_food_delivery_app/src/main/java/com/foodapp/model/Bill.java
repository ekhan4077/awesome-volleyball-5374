package com.foodapp.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Bill {

    @Id
    private Integer billId;
    private LocalDateTime billDate;
    private Integer totalItem;
    private Double totalCost;

}

package com.foodapp.auth.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AdminSessionTrack {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @Column(unique =  true)
    private Integer restaurantId;


    private String uuid;

    private LocalDateTime localDateTime;

    public AdminSessionTrack(Integer restaurantId, String uuid, LocalDateTime localDateTime) {
        this.id = id;
        this.restaurantId = restaurantId;

        this.uuid = uuid;
        this.localDateTime = localDateTime;
    }
}
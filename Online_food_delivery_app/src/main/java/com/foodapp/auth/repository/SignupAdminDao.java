package com.foodapp.auth.repository;


import com.foodapp.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SignupAdminDao extends JpaRepository<Restaurant,Integer> {

    public Optional<Restaurant> findByRestaurantName(String name);
    public Optional<Restaurant> findByRestaurantId(Integer id);
}


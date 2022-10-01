package com.foodapp.auth.repository;

import com.foodapp.auth.models.AdminSessionTrack;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface AdminSessionDao extends JpaRepository<AdminSessionTrack,Integer> {

    public Optional<AdminSessionTrack> findByRestaurantId(Integer userId);

    public Optional<AdminSessionTrack> findByUuid(String uuid);
}

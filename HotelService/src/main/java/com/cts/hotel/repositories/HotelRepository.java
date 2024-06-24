package com.cts.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.hotel.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String>{

}

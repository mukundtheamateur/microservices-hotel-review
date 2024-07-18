package com.cts.hotel.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.hotel.entities.Hotel;
import com.cts.hotel.exceptions.ResourceNotFoundException;
import com.cts.hotel.repositories.HotelRepository;
import com.cts.hotel.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService{
	
	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Hotel create(Hotel hotel) {
		// TODO Auto-generated method stub
		String hotelId = UUID.randomUUID().toString();
		hotel.setId(hotelId);
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		
		List<Hotel> hotels =  hotelRepository.findAll();

		if(hotels.isEmpty()) return null;
		return hotels;
	}

	@Override
	public Hotel get(String id) {
		// TODO Auto-generated method stub
	   return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("hotel with given id not found !!"));
	}

}

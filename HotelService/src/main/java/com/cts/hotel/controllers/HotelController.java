package com.cts.hotel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.hotel.entities.Hotel;
import com.cts.hotel.services.HotelService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping( "/hotels")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	//create
	
	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		log.info("create Hotel controller is called!!");
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));	
	}
	
	
	//get single
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> createHotel(@PathVariable String hotelId){
		log.info("fetch A HOTEL BY hotelId");
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.get(hotelId))	;
	}
	
	//get all
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getAll(){
		log.info("fetch all the hotels");
		return ResponseEntity.ok(hotelService.getAll());
	}
	
	
	
	

}

package com.cts.user.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cts.user.entities.Hotel;
import com.cts.user.entities.Rating;
import com.cts.user.entities.User;
import com.cts.user.exceptions.ResourceNotFoundException;
import com.cts.user.external.services.HotelService;
import com.cts.user.repositories.UserRepository;
import com.cts.user.services.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private HotelService hotelService;
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public User saveUser(User user) {
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		log.info("userService saveUser returned successfully");
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		log.info("users list fetched successfully in service");
		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
		
		log.info("user with userID fetched successfully");
		User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user with given id can't be found: "+ userId));
	
		Rating[] fetchRatings = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + userId, Rating[].class);
		log.info("{}", fetchRatings);
		
		List<Rating> ratings = Arrays.stream(fetchRatings).toList();
		
		List<Rating> ratingList = ratings.stream().map(rating->{
			
			// fetching hotel details using restTemplate
			
//			ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTELSERVICE/hotels/" + rating.getHotelId(), Hotel.class);
//			Hotel hotel = forEntity.getBody();

			// fetching hotel details using Feign Client (Declarative http appraoch)
			Hotel hotel = hotelService.getHotel(rating.getHotelId());
			rating.setHotel(hotel);
			return rating;
			
		}).collect(Collectors.toList());
		
		user.setRatings(ratingList);
		
		return user;
	}

}

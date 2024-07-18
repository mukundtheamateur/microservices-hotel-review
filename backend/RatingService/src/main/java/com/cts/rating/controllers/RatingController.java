package com.cts.rating.controllers;

import com.cts.rating.entities.Rating;
import com.cts.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	private RatingService ratingService;

	@Autowired
    public RatingController(RatingService ratingService) {
    	this.ratingService = ratingService;
    }

    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));
    }

    // get all
    @GetMapping
    public ResponseEntity<List<Rating>> getRatings() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ratingService.getAllRatings());
    }

    // get by user
    @GetMapping(path = "/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ratingService.getRatingByUserId(userId));
    }

    // get by hotel
    @GetMapping(path = "/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ratingService.getRatingByHotelId(hotelId));
    }
}

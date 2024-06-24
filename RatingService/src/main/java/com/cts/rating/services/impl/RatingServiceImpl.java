package com.cts.rating.services.impl;

import com.cts.rating.entities.Rating;
import com.cts.rating.repositories.RatingRepository;
import com.cts.rating.services.RatingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class RatingServiceImpl implements RatingService {

    private RatingRepository ratingRepository;
    
    @Autowired
    public RatingServiceImpl(RatingRepository ratingRepository) {
    	this.ratingRepository = ratingRepository;
    }
    
    @Override
    public Rating createRating(Rating rating) {

        log.info("Inside createRating of RatingService");
        return ratingRepository.save(rating);
    }


    @Override
    public List<Rating> getAllRatings() {

        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }

    @Override
    public String updateRating(Rating rating) {
        return null;
    }

    @Override
    public String deleteRating(String ratingId) {
        return null;
    }

}

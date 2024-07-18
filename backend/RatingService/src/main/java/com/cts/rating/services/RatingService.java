package com.cts.rating.services;

import com.cts.rating.entities.Rating;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RatingService {


    public Rating createRating(Rating rating);

    public List<Rating> getAllRatings();
    public List<Rating> getRatingByUserId(String userId);

    public List<Rating> getRatingByHotelId(String hotelId);
    public String updateRating(Rating rating);

    public String deleteRating(String ratingId);
}

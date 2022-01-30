package com.lp.tbp_projekt.v2.api.services;

import com.lp.tbp_projekt.v2.api.dto.AddRatingDto;
import com.lp.tbp_projekt.v2.api.dto.UpdateRatingDto;

public interface RatingService
{
    boolean setSongRating(UpdateRatingDto updateRatingDto);
    boolean addSongRating(AddRatingDto addRatingDto);
}

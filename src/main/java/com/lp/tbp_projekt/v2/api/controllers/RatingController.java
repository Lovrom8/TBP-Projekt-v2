package com.lp.tbp_projekt.v2.api.controllers;

import com.lp.tbp_projekt.v2.api.dto.AddRatingDto;
import com.lp.tbp_projekt.v2.api.dto.UpdateRatingDto;
import com.lp.tbp_projekt.v2.api.models.api.RecommenderResponse;
import com.lp.tbp_projekt.v2.api.models.auth.AuthData;
import com.lp.tbp_projekt.v2.api.models.auth.AuthErrorData;
import com.lp.tbp_projekt.v2.api.models.auth.AuthRequest;
import com.lp.tbp_projekt.v2.api.services.AuthService;
import com.lp.tbp_projekt.v2.api.services.RatingService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class RatingController
{
    private final RatingService ratingService;

    public RatingController(RatingService ratingService)
    {
        this.ratingService = ratingService;
    }

    @RequestMapping(value = "/api/songs/rating", method = RequestMethod.POST)
    public ResponseEntity<?> addSongRating(@RequestBody AddRatingDto addRatingDto)
    {
        Authentication context = SecurityContextHolder.getContext().getAuthentication();
        String idJWT = context != null ? (String) context.getPrincipal() : null;

        if (idJWT == null)
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new RecommenderResponse<>(false, "Invalid credentials!", null));
        }

        try
        {
            addRatingDto.setUserId(idJWT);
            if (ratingService.addSongRating(addRatingDto))
            {
                return ResponseEntity.ok(new RecommenderResponse<>(true, "Song rating added!", null));
            }
            else
            {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new RecommenderResponse<>(true, "Song with this ID not found!", null));
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new RecommenderResponse<>(false, "User not found!", null));
        }
    }

    @RequestMapping(value = "/api/songs/rating", method = RequestMethod.PUT)
    public ResponseEntity<?> updateSongRating(@RequestBody UpdateRatingDto updateRatingDto)
    {
        Authentication context = SecurityContextHolder.getContext().getAuthentication();
        String idJWT = context != null ? (String) context.getPrincipal() : null;

        if (idJWT == null)
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new RecommenderResponse<>(false, "Invalid credentials!", null));
        }

        try
        {
            updateRatingDto.setUserId(idJWT);
            if (ratingService.setSongRating(updateRatingDto))
            {
                return ResponseEntity.ok(new RecommenderResponse<>(true, "Song rating updated!", null));
            }
            else
            {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new RecommenderResponse<>(true, "Song with this ID not found!", null));
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new RecommenderResponse<>(false, "User not found!", null));
        }
    }
}

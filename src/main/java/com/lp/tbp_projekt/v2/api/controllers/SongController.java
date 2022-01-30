package com.lp.tbp_projekt.v2.api.controllers;

import com.lp.tbp_projekt.v2.api.dto.AddRatingDto;
import com.lp.tbp_projekt.v2.api.models.api.RecommenderResponse;
import com.lp.tbp_projekt.v2.api.repository.SongRepository;
import com.lp.tbp_projekt.v2.api.services.SongService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class SongController
{
    private final SongService songService;

    public SongController(SongService songService)
    {
        this.songService = songService;
    }

    @RequestMapping(value = "/api/user/rated/songs", method = RequestMethod.GET)
    public ResponseEntity<?> addSongRating()
    {
        Authentication context = SecurityContextHolder.getContext().getAuthentication();
        String idJWT = context != null ? (String) context.getPrincipal() : null;

        if (idJWT == null)
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new RecommenderResponse<>(false, "Invalid credentials!", null));
        }

        try
        {
            return ResponseEntity.ok(new RecommenderResponse<>(true, "Rated songs found!", songService.getSongsRatedByUser(idJWT)));
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new RecommenderResponse<>(false, "User not found!", null));
        }
    }
}

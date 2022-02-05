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

import java.util.HashSet;
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
    public ResponseEntity<?> getSongsRatedByUser()
    {
        Authentication context = SecurityContextHolder.getContext().getAuthentication();
        String idJWT = context != null ? (String) context.getPrincipal() : null;

        if (idJWT == null)
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new RecommenderResponse<>(false, "Invalid credentials!", null));
        }

        try
        {
            return ResponseEntity.ok(new RecommenderResponse<>(true, "Song ratings found!", new HashSet<>(songService.getSongsRatedByUser(idJWT))));
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new RecommenderResponse<>(false, "User not found!", null));
        }
    }

    @RequestMapping(value = "/api/songs/{songId}", method = RequestMethod.GET)
    public ResponseEntity<?> getSongDetails(@PathVariable("songId") String songId)
    {
        Authentication context = SecurityContextHolder.getContext().getAuthentication();
        String idJWT = context != null ? (String) context.getPrincipal() : null;

        if (idJWT == null)
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new RecommenderResponse<>(false, "Invalid credentials!", null));
        }

        try
        {
            return ResponseEntity.ok(new RecommenderResponse<>(true, "Song details found!", songService.getSongDetails(songId)));
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new RecommenderResponse<>(false, "User not found!", null));
        }
    }

    @RequestMapping(value = "/api/songs/rating/{songId}", method = RequestMethod.GET)
    public ResponseEntity<?> getSongRating(@PathVariable("songId") String songId)
    {
        Authentication context = SecurityContextHolder.getContext().getAuthentication();
        String idJWT = context != null ? (String) context.getPrincipal() : null;

        if (idJWT == null)
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new RecommenderResponse<>(false, "Invalid credentials!", null));
        }

        try
        {
            return ResponseEntity.ok(new RecommenderResponse<>(true, "Song details found!", songService.getSongRating(idJWT, songId)));
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new RecommenderResponse<>(false, "User not found!", null));
        }
    }

    @RequestMapping(value = "/api/songs/unrated", method = RequestMethod.GET)
    public ResponseEntity<?> getUnratedSong()
    {
        Authentication context = SecurityContextHolder.getContext().getAuthentication();
        String idJWT = context != null ? (String) context.getPrincipal() : null;

        if (idJWT == null)
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new RecommenderResponse<>(false, "Invalid credentials!", null));
        }

        try
        {
            return ResponseEntity.ok(new RecommenderResponse<>(true, "Random unrated song found!", songService.getUnratedSong(idJWT)));
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new RecommenderResponse<>(false, "User not found!", null));
        }
    }

    @RequestMapping(value = "/api/songs/search/{searchTerm}", method = RequestMethod.GET)
    public ResponseEntity<?> getUnratedSong(@PathVariable("searchTerm") String searchTerm)
    {
        Authentication context = SecurityContextHolder.getContext().getAuthentication();
        String idJWT = context != null ? (String) context.getPrincipal() : null;

        if (idJWT == null)
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new RecommenderResponse<>(false, "Invalid credentials!", null));
        }

        try
        {
            return ResponseEntity.ok(new RecommenderResponse<>(true, "Song search results!", songService.getSongSearchResults(idJWT, searchTerm)));
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new RecommenderResponse<>(false, "User not found!", null));
        }
    }
}

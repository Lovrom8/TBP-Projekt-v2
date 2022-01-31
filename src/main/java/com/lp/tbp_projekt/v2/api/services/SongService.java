package com.lp.tbp_projekt.v2.api.services;

import com.lp.tbp_projekt.v2.api.dto.RatedSongsDto;
import com.lp.tbp_projekt.v2.api.dto.SongRatingDto;
import com.lp.tbp_projekt.v2.api.models.Song;

import java.util.List;

public interface SongService
{
    List<RatedSongsDto> getSongsRatedByUser(String userId);
    RatedSongsDto getSongDetails(String songId);
    SongRatingDto getSongRating(String userId, String songId);
}

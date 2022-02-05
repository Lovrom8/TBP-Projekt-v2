package com.lp.tbp_projekt.v2.api.services;

import com.lp.tbp_projekt.v2.api.dto.RatedSongsDto;
import com.lp.tbp_projekt.v2.api.dto.RecommendationDto;
import com.lp.tbp_projekt.v2.api.dto.SongRatingDto;
import com.lp.tbp_projekt.v2.api.models.Recommendation;
import com.lp.tbp_projekt.v2.api.models.Song;

import java.util.List;

public interface SongService
{
    List<RatedSongsDto> getSongsRatedByUser(String userId);
    RatedSongsDto getSongDetails(String songId);
    SongRatingDto getSongRating(String userId, String songId);
    RatedSongsDto getUnratedSong(String userId);
    List<RecommendationDto> getRecommendationsForUser(String userId);
    List<RatedSongsDto> getSongSearchResults(String userId, String searchTerm);
}

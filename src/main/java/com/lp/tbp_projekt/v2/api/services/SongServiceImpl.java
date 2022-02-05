package com.lp.tbp_projekt.v2.api.services;

import com.lp.tbp_projekt.v2.api.dto.RatedSongsDto;
import com.lp.tbp_projekt.v2.api.dto.RecommendationDto;
import com.lp.tbp_projekt.v2.api.dto.SongRatingDto;
import com.lp.tbp_projekt.v2.api.mappers.RatedSongMapper;
import com.lp.tbp_projekt.v2.api.mappers.RecommendationMapper;
import com.lp.tbp_projekt.v2.api.models.Recommendation;
import com.lp.tbp_projekt.v2.api.models.Song;
import com.lp.tbp_projekt.v2.api.repository.SongRepository;
import com.lp.tbp_projekt.v2.api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongServiceImpl implements SongService
{
    private final SongRepository songRepository;
    private final RatedSongMapper ratedSongMapper;
    private final UserRepository userRepository;
    private final RecommendationMapper recommendationMapper;

    public SongServiceImpl(SongRepository songRepository, RatedSongMapper ratedSongMapper, UserRepository userRepository, RecommendationMapper recommendationMapper)
    {
        this.songRepository = songRepository;
        this.ratedSongMapper = ratedSongMapper;
        this.userRepository = userRepository;
        this.recommendationMapper = recommendationMapper;
    }

    @Override
    public List<RatedSongsDto> getSongsRatedByUser(final String userId)
    {
        List<Song> songs = songRepository.findSongsRatedByUser(userId);
        List<RatedSongsDto> ratedSongs = new ArrayList<>();

        for (Song song : songs)
        {
            var ratedSong = ratedSongMapper.mapDto(song);
            ratedSong.setRating(userRepository.getRatingForSongByUser(userId, song.getId()));
            ratedSongs.add(ratedSong);
        }

        return ratedSongs;
    }

    @Override
    public RatedSongsDto getSongDetails(final String songId)
    {
        return ratedSongMapper.mapDto(songRepository.findById(songId).get());
    }

    @Override
    public SongRatingDto getSongRating(final String userId, final String songId)
    {
        Integer rating = songRepository.getSongRatingByUser(userId, songId);
        return new SongRatingDto(rating);
    }

    @Override
    public RatedSongsDto getUnratedSong(final String userId)
    {
        return ratedSongMapper.mapDto(songRepository.findUnratedSongsForUser(userId));
    }

    @Override
    public List<RecommendationDto> getRecommendationsForUser(final String userId)
    {
        List<RecommendationDto> recommendations = new ArrayList<>();

        for (Recommendation recommendedSong : songRepository.getRecommendationForUser(userId))
        {
            recommendations.add(recommendationMapper.mapDto(recommendedSong));
        }

        return recommendations;
    }

    @Override
    public List<RatedSongsDto> getSongSearchResults(final String userId, final String searchTerm)
    {
        List<Song> songs = songRepository.findSongsBySearchTerm(searchTerm);
        List<RatedSongsDto> ratedSongs = new ArrayList<>();

        for (Song song : songs)
        {
            var ratedSong = ratedSongMapper.mapDto(song);
            ratedSong.setRating(userRepository.getRatingForSongByUser(userId, song.getId()));
            ratedSongs.add(ratedSong);
        }

        return ratedSongs;
    }
}

package com.lp.tbp_projekt.v2.api.services;

import com.lp.tbp_projekt.v2.api.dto.RatedSongsDto;
import com.lp.tbp_projekt.v2.api.dto.SongRatingDto;
import com.lp.tbp_projekt.v2.api.mappers.RatedSongMapper;
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

    public SongServiceImpl(SongRepository songRepository, RatedSongMapper ratedSongMapper, UserRepository userRepository)
    {
        this.songRepository = songRepository;
        this.ratedSongMapper = ratedSongMapper;
        this.userRepository = userRepository;
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
    public List<Recommendation> getRecommendationsForUser(final String userId)
    {
        return songRepository.getRecommendationForUser(userId);
    }
}

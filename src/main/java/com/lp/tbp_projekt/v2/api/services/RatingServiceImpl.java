package com.lp.tbp_projekt.v2.api.services;

import com.lp.tbp_projekt.v2.api.dto.AddRatingDto;
import com.lp.tbp_projekt.v2.api.dto.UpdateRatingDto;
import com.lp.tbp_projekt.v2.api.models.Rating;
import com.lp.tbp_projekt.v2.api.models.Song;
import com.lp.tbp_projekt.v2.api.models.User;
import com.lp.tbp_projekt.v2.api.repository.SongRepository;
import com.lp.tbp_projekt.v2.api.repository.UserRepository;

import java.util.Optional;

public class RatingServiceImpl implements RatingService
{
    private final SongRepository songRepository;
    private final UserRepository userRepository;

    public RatingServiceImpl(SongRepository songRepository, UserRepository userRepository)
    {
        this.songRepository = songRepository;
        this.userRepository = userRepository;
    }

    @Override
    public boolean setSongRating(final UpdateRatingDto updateRatingDto)
    {
        Optional<Song> song = songRepository.findById(updateRatingDto.getSongId());
        if (song.isEmpty())
        {
            return false;
        }

        Song selectedSong = song.get();

        Optional<User> user = userRepository.findById(updateRatingDto.getUserId());
        if (user.isEmpty())
        {
            return false;
        }

        User selectedUser = user.get();

        selectedUser.updateRating(new Rating(selectedSong, updateRatingDto.getRating()));

        userRepository.save(selectedUser);

        return true;
    }

    @Override
    public boolean addSongRating(final AddRatingDto addRatingDto)
    {
        Optional<Song> song = songRepository.findById(addRatingDto.getSongId());
        if (song.isEmpty())
        {
            return false;
        }

        Song selectedSong = song.get();

        Optional<User> user = userRepository.findById(addRatingDto.getUserId());
        if (user.isEmpty())
        {
            return false;
        }

        User selectedUser = user.get();

        selectedUser.addRating(new Rating(selectedSong, addRatingDto.getRating()));

        userRepository.save(selectedUser);

        return true;
    }
}

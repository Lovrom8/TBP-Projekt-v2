package com.lp.tbp_projekt.v2.api.mappers;

import com.lp.tbp_projekt.v2.api.dto.RatedSongsDto;
import com.lp.tbp_projekt.v2.api.models.Song;
import org.springframework.stereotype.Component;

@Component
public class RatedSongMapper implements GenericMapper<RatedSongsDto, Song>
{
    @Override
    public RatedSongsDto mapDto(final Song entity)
    {
        if (entity == null)
        {
            return null;
        }

        RatedSongsDto ratedSong = new RatedSongsDto();

        ratedSong.setSongId(entity.getId());
        ratedSong.setSong(entity.getTitle());
        ratedSong.setGenre(entity.getGenre().getName());
        ratedSong.setSubgenres(entity.getAllSubgenres());
        ratedSong.setAlbumName(entity.getAlbum().getName());
        ratedSong.setArtist(entity.getAlbum().getArtist().getName());
        ratedSong.setAlbumUrl(entity.getAlbum().getUrl());

        return ratedSong;
    }

    @Override
    public Song map(final RatedSongsDto dto) throws Exception
    {
        return null;
    }
}

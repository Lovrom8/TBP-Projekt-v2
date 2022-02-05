package com.lp.tbp_projekt.v2.api.mappers;

import com.lp.tbp_projekt.v2.api.dto.RecommendationDto;
import com.lp.tbp_projekt.v2.api.models.Recommendation;
import org.springframework.stereotype.Component;

@Component
public class RecommendationMapper implements GenericMapper<RecommendationDto, Recommendation>
{
    @Override
    public RecommendationDto mapDto(final Recommendation entity)
    {
        if (entity == null)
        {
            return null;
        }

        RecommendationDto recommendedSong = new RecommendationDto();

        recommendedSong.setSongId(entity.getId());
        recommendedSong.setSongName(entity.getTitle());
        recommendedSong.setGenre(entity.getGenre().getName());
        recommendedSong.setSubgenres(entity.getAllSubgenres());
        recommendedSong.setAlbumName(entity.getAlbum().getName());
        recommendedSong.setArtistName(entity.getAlbum().getArtist().getName());
        recommendedSong.setAlbumUrl(entity.getAlbum().getUrl());
        recommendedSong.setScore(entity.getScore());

        return recommendedSong;
    }

    @Override
    public Recommendation map(final RecommendationDto dto) throws Exception
    {
        return null;
    }
}

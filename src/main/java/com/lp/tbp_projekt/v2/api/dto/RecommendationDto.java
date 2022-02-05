package com.lp.tbp_projekt.v2.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lp.tbp_projekt.v2.api.mappers.GenericMapper;
import com.lp.tbp_projekt.v2.api.models.Recommendation;
import com.lp.tbp_projekt.v2.api.models.Song;

public class RecommendationDto
{
    private String songId;
    private String albumName;
    @JsonProperty("artistName")
    private String artistName;
    @JsonProperty("songName")
    private String songName;
    private String genre;
    private String subgenres;
    private String albumUrl;
    private Double score;

    public RecommendationDto()
    {
    }

    public String getSongId()
    {
        return songId;
    }

    public void setSongId(final String songId)
    {
        this.songId = songId;
    }

    public String getAlbumName()
    {
        return albumName;
    }

    public void setAlbumName(final String albumName)
    {
        this.albumName = albumName;
    }

    public String getArtistName()
    {
        return artistName;
    }

    public void setArtistName(final String artistName)
    {
        this.artistName = artistName;
    }

    public String getSongName()
    {
        return songName;
    }

    public void setSongName(final String songName)
    {
        this.songName = songName;
    }

    public String getGenre()
    {
        return genre;
    }

    public void setGenre(final String genre)
    {
        this.genre = genre;
    }

    public String getSubgenres()
    {
        return subgenres;
    }

    public void setSubgenres(final String subgenres)
    {
        this.subgenres = subgenres;
    }

    public String getAlbumUrl()
    {
        return albumUrl;
    }

    public void setAlbumUrl(final String albumUrl)
    {
        this.albumUrl = albumUrl;
    }

    public Double getScore()
    {
        return score;
    }

    public void setScore(final Double score)
    {
        this.score = score;
    }
}

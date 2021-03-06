package com.lp.tbp_projekt.v2.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RatedSongsDto
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
    private Integer rating;

    public RatedSongsDto()
    {
    }

    public RatedSongsDto(final String songName, final String songId, final String albumName, final String artistName, final String genre, final String subgenres, final String albumUrl, final Integer rating)
    {
        this.songId = songId;
        this.albumName = albumName;
        this.artistName = artistName;
        this.genre = genre;
        this.subgenres = subgenres;
        this.albumUrl = albumUrl;
        this.rating = rating;
        this.songName = songName;
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

    public String getArtist()
    {
        return artistName;
    }

    public void setArtistName(final String artist)
    {
        this.artistName = artist;
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

    public Integer getRating()
    {
        return rating;
    }

    public void setRating(final Integer rating)
    {
        this.rating = rating;
    }

    public String getSong()
    {
        return songName;
    }

    public void setSongName(final String song)
    {
        this.songName = song;
    }
}

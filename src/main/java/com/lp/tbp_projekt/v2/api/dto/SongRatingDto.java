package com.lp.tbp_projekt.v2.api.dto;

public class SongRatingDto
{
    private Integer rating;

    public SongRatingDto()
    {
    }

    public SongRatingDto(final Integer rating)
    {
        this.rating = rating;
    }

    public Integer getRating()
    {
        return rating;
    }

    public void setRating(final Integer rating)
    {
        this.rating = rating;
    }
}

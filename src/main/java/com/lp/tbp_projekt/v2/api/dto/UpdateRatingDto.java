package com.lp.tbp_projekt.v2.api.dto;

public class UpdateRatingDto
{
    private String userId;
    private String songId;
    private Integer rating;

    public UpdateRatingDto(final String songId, final Integer rating, final String userId)
    {
        this.songId = songId;
        this.rating = rating;
        this.userId = userId;
    }

    public String getSongId()
    {
        return songId;
    }

    public void setSongId(final String songId)
    {
        this.songId = songId;
    }

    public Integer getRating()
    {
        return rating;
    }

    public void setRating(final Integer rating)
    {
        this.rating = rating;
    }

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(final String userId)
    {
        this.userId = userId;
    }
}

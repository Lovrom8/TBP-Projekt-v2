package com.lp.tbp_projekt.v2.api.models;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@RelationshipProperties
public class Rating
{
    @Id
    @GeneratedValue
    private Long id;

    @TargetNode
    private Song song;

    private int rating;

    public Rating(final Song song, final int rating)
    {
        this.song = song;
        this.rating = rating;
    }

    public Song getSong()
    {
        return song;
    }

    public int getRating()
    {
        return rating;
    }

    public void setSong(final Song song)
    {
        this.song = song;
    }

    public void setRating(final int rating)
    {
        this.rating = rating;
    }
}
package com.lp.tbp_projekt.v2.api.models;

import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

public class Recommendation
{
    private String id;
    private String title;
    private Album album;
    private Genre genre;
    private List<Subgenre> subgenres;
    private double score;

    public Recommendation(final String id, final String title, final Album album, final Genre genre, final List<Subgenre> subgenres, final double score)
    {
        this.id = id;
        this.title = title;
        this.album = album;
        this.genre = genre;
        this.subgenres = subgenres;
        this.score = score;
    }

    public String getId()
    {
        return id;
    }

    public void setId(final String id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(final String title)
    {
        this.title = title;
    }

    public Album getAlbum()
    {
        return album;
    }

    public void setAlbum(final Album album)
    {
        this.album = album;
    }

    public Genre getGenre()
    {
        return genre;
    }

    public void setGenre(final Genre genre)
    {
        this.genre = genre;
    }

    public List<Subgenre> getSubgenres()
    {
        return subgenres;
    }

    public void setSubgenres(final List<Subgenre> subgenres)
    {
        this.subgenres = subgenres;
    }

    public double getScore()
    {
        return score;
    }

    public void setScore(final double score)
    {
        this.score = score;
    }
}

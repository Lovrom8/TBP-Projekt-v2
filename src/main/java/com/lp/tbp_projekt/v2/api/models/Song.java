package com.lp.tbp_projekt.v2.api.models;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

import java.util.List;

@Node
public class Song
{
    @Id
    @GeneratedValue(generatorClass = UUIDStringGenerator.class)
    private String id;
    private String title;

    @Relationship(type = "ON_ALBUM")
    private Album album;
    @Relationship(type = "IN_GENRE")
    private Genre genre;
    @Relationship(type = "IN_SUBGENRES")
    private List<Subgenre> subgenres;

    public Song(final String title, final Genre genre, final Album album, final List<Subgenre> subgenres)
    {
        this.title = title;
        this.genre = genre;
        this.album = album;
        this.subgenres = subgenres;
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

    public Genre getGenre()
    {
        return genre;
    }

    public void setGenre(final Genre genre)
    {
        this.genre = genre;
    }

    public Album getAlbum()
    {
        return album;
    }

    public void setAlbum(final Album album)
    {
        this.album = album;
    }

    public List<Subgenre> getSubgenres()
    {
        return subgenres;
    }

    public void setSubgenres(final List<Subgenre> subgenres)
    {
        this.subgenres = subgenres;
    }
}

package com.lp.tbp_projekt.v2.api.models;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

@Node
public class Album
{
    @Id
    @GeneratedValue(generatorClass = UUIDStringGenerator.class)
    private String id;
    public String name;
    @Relationship(type = "BY_ARTIST")
    public Artist artist;
    public String url;

    public Album(final String name, final Artist artist, final String url)
    {
        this.name = name;
        this.artist = artist;
        this.url = url;
    }

    public String getId()
    {
        return id;
    }

    public void setId(final String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(final String url)
    {
        this.url = url;
    }

    public Artist getArtist()
    {
        return artist;
    }

    public void setArtist(final Artist artist)
    {
        this.artist = artist;
    }
}
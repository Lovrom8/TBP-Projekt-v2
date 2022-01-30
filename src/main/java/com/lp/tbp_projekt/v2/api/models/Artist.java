package com.lp.tbp_projekt.v2.api.models;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

@Node
public class Artist
{
    @Id
    @GeneratedValue(generatorClass = UUIDStringGenerator.class)
    public String id;
    public String name;
    public String country;

    public Artist(final String name, final String country)
    {
        this.name = name;
        this.country = country;
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

    public String getCountry()
    {
        return country;
    }

    public void setCountry(final String country)
    {
        this.country = country;
    }
}


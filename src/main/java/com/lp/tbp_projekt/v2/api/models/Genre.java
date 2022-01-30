package com.lp.tbp_projekt.v2.api.models;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

@Node
public class Genre
{
    @Id
    @GeneratedValue(generatorClass = UUIDStringGenerator.class)
    public String id;
    public String name;

    public Genre()
    {
    }

    public Genre(final String name)
    {
        this.name = name;
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
}

package com.lp.tbp_projekt.v2.api.models;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Node
public class User
{
    @Id
    @GeneratedValue(generatorClass = UUIDStringGenerator.class)
    private String id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    @Relationship(type = "RATED")
    private List<Rating> ratings;

    private User()
    {
    }

    public User(String firstName, String lastName, String username, String password, String email)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.ratings = new ArrayList<>();
    }

    public String getId()
    {
        return id;
    }

    public void setId(final String id)
    {
        this.id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(final String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(final String lastName)
    {
        this.lastName = lastName;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(final String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(final String password)
    {
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(final String email)
    {
        this.email = email;
    }

    public void addRating(Rating rating)
    {
        updateRating(rating);
    }

    public void updateRating(Rating rating)
    {
        this.ratings.removeIf(r -> Objects.equals(r.getSong().getId(), rating.getSong().getId()));
        this.ratings.add(rating);
    }
}

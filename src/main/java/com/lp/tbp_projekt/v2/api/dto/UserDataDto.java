package com.lp.tbp_projekt.v2.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.lp.tbp_projekt.v2.api.models.Genre;
import com.lp.tbp_projekt.v2.api.models.Subgenre;

import java.util.List;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserDataDto
{
    @JsonIgnore
    private String id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private List<Genre> likedGenres;
    private List<Subgenre> likedSubgenres;

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

    public String getEmail()
    {
        return email;
    }

    public void setEmail(final String email)
    {
        this.email = email;
    }

    public List<Genre> getLikedGenres()
    {
        return likedGenres;
    }

    public void setLikedGenres(final List<Genre> likedGenres)
    {
        this.likedGenres = likedGenres;
    }

    public List<Subgenre> getLikedSubgenres()
    {
        return likedSubgenres;
    }

    public void setLikedSubgenres(final List<Subgenre> likedSubgenres)
    {
        this.likedSubgenres = likedSubgenres;
    }

    public UserDataDto()
    {

    }

    public UserDataDto(final String firstName, final String lastName, final String username, final String email, final List<Genre> likedGenres, final List<Subgenre> likedSubgenres)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.likedGenres = likedGenres;
        this.likedSubgenres = likedSubgenres;
    }
}
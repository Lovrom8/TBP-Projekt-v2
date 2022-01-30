package com.lp.tbp_projekt.v2.api.models.auth;

public class RegisterData
{
    private final String firstName;
    private final String lastName;
    private final String username;
    private final String password;
    private final String email;

    public RegisterData(final String firstName, final String lastName, final String username, final String password, final String email)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public String getEmail()
    {
        return email;
    }
}

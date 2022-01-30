package com.lp.tbp_projekt.v2.api.models.auth;

public class AuthRequest
{
    private final String password;
    private final String email;

    public AuthRequest(final String password, final String email)
    {
        this.password = password;
        this.email = email;
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

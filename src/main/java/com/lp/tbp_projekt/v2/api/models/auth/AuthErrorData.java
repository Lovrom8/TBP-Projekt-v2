package com.lp.tbp_projekt.v2.api.models.auth;

import java.io.Serializable;

public class AuthErrorData implements Serializable
{
    public Throwable cause;
    public Throwable[] suppressed;

    public AuthErrorData(Exception exception)
    {
        this.suppressed = exception.getSuppressed();
        this.cause = exception.getCause();
    }
}

package com.lp.tbp_projekt.v2.api.services;

import com.lp.tbp_projekt.v2.api.models.User;
import com.lp.tbp_projekt.v2.api.models.auth.RegisterData;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public interface AuthService
{
    String authenticateUser(String email, String password) throws NoSuchAlgorithmException, InvalidKeySpecException;
    User checkUser(String emailProvided, String passwordProvided) throws NoSuchAlgorithmException, InvalidKeySpecException;
    Boolean registerUser(RegisterData data) throws NoSuchAlgorithmException, InvalidKeySpecException;
}

package com.lp.tbp_projekt.v2.api.services;

import com.lp.tbp_projekt.v2.api.models.User;
import com.lp.tbp_projekt.v2.api.models.auth.RegisterData;
import com.lp.tbp_projekt.v2.api.repository.UserRepository;
import com.lp.tbp_projekt.v2.api.util.JwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

@Service
public class AuthServiceImpl implements AuthService
{
    private final UserRepository userRepository;

    private final JwtUtil jwtUtil;

    public AuthServiceImpl(@Autowired UserRepository userRepository, @Autowired JwtUtil jwtUtil)
    {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    public String authenticateUser(String email, String password) throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        User user = checkUser(email, password);

        if (user == null)
        {
            return "";
        }

        return jwtUtil.generateToken(user.getId());
    }

    public User checkUser(String emailProvided, String passwordProvided) throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        User user = userRepository.findUserByEmail(emailProvided);

        if (user == null)
        {
            return null;
        }

        String password = user.getPassword();

        if (!password.contains("."))
        {
            return null;
        }

        String salt = StringUtils.split(password, '.')[0];
        String hashedPassword = StringUtils.split(password, '.')[1];

        if (salt == null || hashedPassword == null)
        {
            return null;
        }

        KeySpec spec = new PBEKeySpec(passwordProvided.toCharArray(), Base64.getDecoder().decode(salt), 65536, 256);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

        String passwordProvidedHashed = Base64.getEncoder().encodeToString(factory.generateSecret(spec).getEncoded());

        if (!StringUtils.equals(passwordProvidedHashed, hashedPassword))
        {
            return null;
        }

        return user;
    }

    private String generateSalt()
    {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        return Base64.getEncoder().encodeToString(salt);
    }

    private String hashPassword(String unhashedPass) throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        String salt = generateSalt();

        KeySpec spec = new PBEKeySpec(unhashedPass.toCharArray(), Base64.getDecoder().decode(salt), 65536, 256);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

        String hashedPass = Base64.getEncoder().encodeToString(factory.generateSecret(spec).getEncoded());

        return salt + "." + hashedPass;
    }

    public Boolean registerUser(RegisterData data) throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        String hashedPassword = hashPassword(data.getPassword());

        User newUser = new User(data.getFirstName(), data.getLastName(), data.getUsername(), hashedPassword, data.getEmail());

        if (newUser.getEmail().isEmpty() || newUser.getPassword().isEmpty() || newUser.getUsername().isEmpty())
        {
            return false;
        }

        userRepository.save(newUser);

        return true;
    }
}
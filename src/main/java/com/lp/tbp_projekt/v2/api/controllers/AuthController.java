package com.lp.tbp_projekt.v2.api.controllers;

import com.lp.tbp_projekt.v2.api.models.api.RecommenderResponse;
import com.lp.tbp_projekt.v2.api.models.auth.AuthData;
import com.lp.tbp_projekt.v2.api.models.auth.AuthErrorData;
import com.lp.tbp_projekt.v2.api.models.auth.AuthRequest;
import com.lp.tbp_projekt.v2.api.models.auth.RegisterData;
import com.lp.tbp_projekt.v2.api.services.AuthService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AuthController
{
    private final AuthService authService;

    public AuthController(@Autowired AuthService authService)
    {
        this.authService = authService;
    }

    @RequestMapping(value = "/api/auth", method = RequestMethod.POST)
    public ResponseEntity<?> loginUser(@RequestBody AuthRequest authenticationRequest)
    {
        try
        {
            String jwt = authService.authenticateUser(authenticationRequest.getEmail(), authenticationRequest.getPassword());

            if (StringUtils.isNotEmpty(jwt))
            {
                return ResponseEntity.ok(new RecommenderResponse<>(true, "Success!", new AuthData(jwt)));
            }
            else
            {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new RecommenderResponse<>(false, "Invalid credentials!", new AuthData(jwt)));
            }
        }
        catch (Exception ex)
        {
            System.out.println("- Error logging in");
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new RecommenderResponse<>(false, "There was an error on our side, please try again later.", new AuthErrorData(ex)));
        }
    }

    @RequestMapping(value = "/api/auth/register", method = RequestMethod.POST)
    public ResponseEntity<?> registerUser(@RequestBody RegisterData registerData)
    {
        try
        {
            if (authService.registerUser(registerData))
            {
                return ResponseEntity.ok(new RecommenderResponse<>(true, "Success!", null));
            }
            else
            {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new RecommenderResponse<>(false, "Bad register request!", null));
            }
        }
        catch (Exception ex)
        {
            System.out.println("- Error registering");
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new RecommenderResponse<>(false, "There was an error on our side, please try again later.", new AuthErrorData(ex)));
        }
    }
}
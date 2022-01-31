package com.lp.tbp_projekt.v2.api.controllers;

import com.lp.tbp_projekt.v2.api.dto.UserDataDto;
import com.lp.tbp_projekt.v2.api.models.api.RecommenderResponse;
import com.lp.tbp_projekt.v2.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController
{
    private final UserService userService;

    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @RequestMapping(value="/api/user", method = RequestMethod.GET)
    public ResponseEntity<?> getUser()
    {
        Authentication context = SecurityContextHolder.getContext().getAuthentication();
        String idJWT = context != null ? (String) context.getPrincipal() : null;

        if (idJWT == null)
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new RecommenderResponse<>(false, "Invalid credentials!", null));
        }

        try
        {
            UserDataDto userDto = userService.getUserForId(idJWT);
            return ResponseEntity.ok(new RecommenderResponse<>(true, "User found!", userDto));
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new RecommenderResponse<>(false, "User not found!", null));
        }
    }
}

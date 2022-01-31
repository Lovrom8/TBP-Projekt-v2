package com.lp.tbp_projekt.v2.api.services;

import com.lp.tbp_projekt.v2.api.dto.UserDataDto;

public interface UserService
{
    UserDataDto getUserForId(String userId);
}

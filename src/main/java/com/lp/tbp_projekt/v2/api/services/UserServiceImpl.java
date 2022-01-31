package com.lp.tbp_projekt.v2.api.services;

import com.lp.tbp_projekt.v2.api.dto.UserDataDto;
import com.lp.tbp_projekt.v2.api.mappers.UserDataMapper;
import com.lp.tbp_projekt.v2.api.models.User;
import com.lp.tbp_projekt.v2.api.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{
    private final UserRepository userRepo;
    private final UserDataMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserDataMapper userMapper)
    {
        this.userRepo = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDataDto getUserForId(final String userId)
    {
        User user = userRepo.findUserById(userId);
        return userMapper.mapDto(user);
    }
}

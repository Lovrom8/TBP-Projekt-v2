package com.lp.tbp_projekt.v2.api.mappers;

import com.lp.tbp_projekt.v2.api.dto.UserDataDto;
import com.lp.tbp_projekt.v2.api.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserDataMapper implements GenericMapper<UserDataDto, User>
{
    @Override
    public UserDataDto mapDto(final User entity)
    {
        if (entity == null)
        {
            return null;
        }

        UserDataDto userDto = new UserDataDto();

        userDto.setId(entity.getId());
        userDto.setFirstName(entity.getFirstName());
        userDto.setLastName(entity.getLastName());
        userDto.setUsername(entity.getUsername());
        userDto.setEmail(entity.getEmail());

        return userDto;
    }

    @Override
    public User map(final UserDataDto dto) throws Exception
    {
        return null;
    }
}
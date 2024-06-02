package com.capgemini.wsb.fitnesstracker.user.internal;

import com.capgemini.wsb.fitnesstracker.user.api.User;
import com.capgemini.wsb.fitnesstracker.user.api.UserDto;
import org.springframework.stereotype.Component;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto toDto(User user) {
        if (user == null) {
            return null;
        }

        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setBirthdate(user.getBirthdate());
        userDto.setEmail(user.getEmail());

        return userDto;
    }

    public User toEntity(UserDto userDto) {
        if (userDto == null) {
            return null;
        }

        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setBirthdate(userDto.getBirthdate());
        user.setEmail(userDto.getEmail());

        return user;
    }

    public void updateEntityFromDto(UserDto userDto, User user) {
        if (userDto == null || user == null) {
            return;
        }

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setBirthdate(userDto.getBirthdate());
        user.setEmail(userDto.getEmail());
    }
}



package com.capgemini.wsb.fitnesstracker.user.internal;

import com.capgemini.wsb.fitnesstracker.user.api.User;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
    public abstract UserDto toDto(User user);
    public abstract User toEntity(UserDto userDto);
    public abstract void updateEntityFromDto(UserDto userDto, @MappingTarget User user);
}


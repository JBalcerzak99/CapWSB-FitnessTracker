package com.capgemini.wsb.fitnesstracker.user.api;

import java.util.List;

/**
 * Interface (API) for modifying operations on {@link User} entities through the API.
 * Implementing classes are responsible for executing changes within a database transaction, whether by continuing an existing transaction or creating a new one if required.
 */
public interface UserService {
    List<UserDto> getAllUsers();
    UserDto getUserById(Long id);
    List<UserDto> searchUsersByEmail(String email);
    List<UserDto> searchUsersByAge(Integer age);
    UserDto createUser(UserDto userDto);
    UserDto updateUser(Long id, UserDto userDto);

    com.capgemini.wsb.fitnesstracker.user.internal.UserDto createUser(com.capgemini.wsb.fitnesstracker.user.internal.UserDto userDto);

    com.capgemini.wsb.fitnesstracker.user.internal.UserDto updateUser(Long id, com.capgemini.wsb.fitnesstracker.user.internal.UserDto userDto);

    void deleteUser(Long id);
}


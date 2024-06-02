package com.capgemini.wsb.fitnesstracker.user.api;

import java.util.List;

/**
 * Interface (API) for modifying operations on {@link User} entities through the API.
 * Implementing classes are responsible for executing changes within a database transaction, whether by continuing an existing transaction or creating a new one if required.
 */
public interface UserService {
    List<com.capgemini.wsb.fitnesstracker.user.internal.UserDto> getAllUsers();
    com.capgemini.wsb.fitnesstracker.user.internal.UserDto getUserById(Long id);
    List<com.capgemini.wsb.fitnesstracker.user.internal.UserDto> searchUsersByEmail(String email);
    List<com.capgemini.wsb.fitnesstracker.user.internal.UserDto> searchUsersByAge(Integer age);
    UserDto createUser(UserDto userDto);
    UserDto updateUser(Long id, UserDto userDto);

    com.capgemini.wsb.fitnesstracker.user.internal.UserDto createUser(com.capgemini.wsb.fitnesstracker.user.internal.UserDto userDto);

    com.capgemini.wsb.fitnesstracker.user.internal.UserDto updateUser(Long id, com.capgemini.wsb.fitnesstracker.user.internal.UserDto userDto);

    void deleteUser(Long id);
}


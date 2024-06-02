package com.capgemini.wsb.fitnesstracker.user.api;

import com.capgemini.wsb.fitnesstracker.user.internal.UserMapper;
import com.capgemini.wsb.fitnesstracker.user.internal.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(Long id) {
        return userMapper.toDto(userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found")));
    }

    @Override
    public List<UserDto> searchUsersByEmail(String email) {
        return userRepository.findByEmailContainingIgnoreCase(email).stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> searchUsersByAge(Integer age) {
        LocalDate thresholdDate = LocalDate.now().minusYears(age);
        return userRepository.findByBirthdateBefore(thresholdDate).stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        userMapper.updateEntityFromDto(userDto, user);
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    public com.capgemini.wsb.fitnesstracker.user.internal.UserDto createUser(com.capgemini.wsb.fitnesstracker.user.internal.UserDto userDto) {
        return null;
    }

    @Override
    public com.capgemini.wsb.fitnesstracker.user.internal.UserDto updateUser(Long id, com.capgemini.wsb.fitnesstracker.user.internal.UserDto userDto) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}


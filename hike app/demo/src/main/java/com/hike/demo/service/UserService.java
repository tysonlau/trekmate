package com.hike.demo.service;

import java.util.List;

import com.hike.demo.dto.UserDto;
import com.hike.demo.entity.User;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
}
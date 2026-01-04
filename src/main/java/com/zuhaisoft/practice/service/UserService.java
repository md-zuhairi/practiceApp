package com.zuhaisoft.practice.service;

import com.zuhaisoft.practice.dto.DeletedUserResponseDto;
import com.zuhaisoft.practice.dto.UserResponseDto;
import com.zuhaisoft.practice.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    ResponseEntity<List<UserResponseDto>> getAllUsers();

    ResponseEntity<UserResponseDto> getUserById(Long id);

    ResponseEntity<DeletedUserResponseDto> deleteUserById(Long id);
}

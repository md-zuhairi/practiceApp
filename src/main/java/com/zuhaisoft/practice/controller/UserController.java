package com.zuhaisoft.practice.controller;

import com.zuhaisoft.practice.dto.DeletedUserResponseDto;
import com.zuhaisoft.practice.dto.UserResponseDto;
import com.zuhaisoft.practice.entity.User;
import com.zuhaisoft.practice.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@RequestMapping("/api/practice/users")
public class UserController {

    UserService userService;

    @GetMapping()
    public ResponseEntity<List<UserResponseDto>> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUsers(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeletedUserResponseDto> deleteUser(@PathVariable Long id) {
        return userService.deleteUserById(id);
    }

}

package com.zuhaisoft.practice.service.impl;

import com.zuhaisoft.practice.dto.DeletedUserResponseDto;
import com.zuhaisoft.practice.dto.UserResponseDto;
import com.zuhaisoft.practice.entity.User;
import com.zuhaisoft.practice.repository.UserRepository;
import com.zuhaisoft.practice.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
class UserServiceImpl implements UserService {

    UserRepository userRepository ;
    ModelMapper modelMapper;

    @Override
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        List<User> users = userRepository.findAll();

        List<UserResponseDto> userResponseDtos = users.stream()
                .map(user -> modelMapper.map(user, UserResponseDto.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(userResponseDtos, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserResponseDto> getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if(user == null){
            return new ResponseEntity<>(modelMapper.map(new User(), UserResponseDto.class), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(modelMapper.map(user, UserResponseDto.class), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DeletedUserResponseDto> deleteUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if(user == null){
            return new ResponseEntity<>(modelMapper.map(new User(), DeletedUserResponseDto.class), HttpStatus.NOT_FOUND);
        }
        userRepository.deleteById(id);
        userRepository.flush();
        return new ResponseEntity<>(modelMapper.map(user, DeletedUserResponseDto.class), HttpStatus.OK);
    }
}


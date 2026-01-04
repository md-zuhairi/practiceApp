package com.zuhaisoft.practice.dto;

import com.zuhaisoft.practice.entity.Insurance;
import lombok.Data;

import java.util.Set;

@Data
public class UserResponseDto{
    Long id;
    String name;
    Integer age;
    Set<Insurance> insurances;
}

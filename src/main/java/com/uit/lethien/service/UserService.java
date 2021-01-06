/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.lethien.service;

import com.uit.lethien.dto.UserDto;
import com.uit.lethien.model.User;
import com.uit.lethien.repository.UserRepository;
import java.util.List;

/**
 *
 * @author LeThien
 */
public class UserService {

    private UserRepository userRepository = null;

    public UserService() {
        userRepository = new UserRepository();
    }

    public List<UserDto> getAllDto() {
        return userRepository.findAllDto();
    }

    public UserDto getById(int id) {
        User user = userRepository.findById(id);
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setUserName(user.getUserName());
        dto.setPassword(user.getPassword());
        dto.setFullname(user.getFullname());
        dto.setAddress(user.getAddress());
        dto.setPhone(user.getPhone());
        dto.setRoleId(user.getRoleId());
        return dto;
    }

    public UserDto getByUserName(String userName) {
        User user = userRepository.findByUserName(userName);
        if (user != null) {
            UserDto dto = new UserDto();
            dto.setId(user.getId());
            dto.setUserName(user.getUserName());
            dto.setPassword(user.getPassword());
            dto.setFullname(user.getFullname());
            dto.setAddress(user.getAddress());
            dto.setPhone(user.getPhone());
            dto.setRoleId(user.getRoleId());
            return dto;
        }
        return null;
    }

    public void add(UserDto dto) {
        User user = new User();
        user.setUserName(dto.getUserName());
        user.setPassword(dto.getPassword());
        user.setFullname(dto.getFullname());
        user.setAddress(dto.getAddress());
        user.setPhone(dto.getPhone());
        user.setRoleId(dto.getRoleId());
        userRepository.insert(user);
    }

    public void edit(UserDto dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setUserName(dto.getUserName());
        user.setPassword(dto.getPassword());
        user.setFullname(dto.getFullname());
        user.setAddress(dto.getAddress());
        user.setPhone(dto.getPhone());
        user.setRoleId(dto.getRoleId());
        userRepository.update(user);
    }

    public void removeById(int id) {
        userRepository.deleteById(id);
    }
}

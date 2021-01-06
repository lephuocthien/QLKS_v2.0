/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.lethien.service;

import com.uit.lethien.dto.RoleDto;
import com.uit.lethien.model.Role;
import com.uit.lethien.repository.RoleRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LeThien
 */
public class RoleService {

    private RoleRepository roleRepository = null;

    public RoleService() {
        roleRepository = new RoleRepository();
    }

    public List<RoleDto> getAll() {
        List<Role> roles = roleRepository.findAll();
        List<RoleDto> dtos = new ArrayList<RoleDto>();
        for (Role role : roles) {
            RoleDto dto = new RoleDto();
            dto.setId(role.getId());
            dto.setName(role.getName());
            dto.setDescription(role.getDescription());
            dtos.add(dto);
        }
        return dtos;
    }

    public RoleDto getById(int id) {
        Role role = roleRepository.findById(id);
        RoleDto dto = new RoleDto();
        dto.setId(role.getId());
        dto.setName(role.getName());
        dto.setDescription(role.getDescription());
        return dto;
    }

    public void add(RoleDto dto) {
        Role role = new Role();
        role.setName(dto.getName());
        role.setDescription(dto.getDescription());
        // Gọi hàm add của DAO để chạy câu lệnh INSERT
        roleRepository.insert(role);
    }

    public void edit(RoleDto dto) {
        // Chuyển dữ liệu từ DTO qua ENTITY
        Role role = new Role();
        role.setId(dto.getId());
        role.setName(dto.getName());
        role.setDescription(dto.getDescription());
        // Gọi hàm add của DAO để chạy câu lệnh INSERT
        roleRepository.update(role);
    }

    public void removeById(int id) {
        roleRepository.deleteById(id);
    }
}

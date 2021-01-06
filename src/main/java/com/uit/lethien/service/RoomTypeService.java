/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.lethien.service;

import com.uit.lethien.dto.RoomTypeDto;
import com.uit.lethien.model.RoomType;
import com.uit.lethien.repository.RoomTypeRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LeThien
 */
public class RoomTypeService {
    private RoomTypeRepository roomTypeRepository;

    public RoomTypeService() {
        this.roomTypeRepository = new RoomTypeRepository();
    }
    
    public List<RoomTypeDto> getAll() {
        List<RoomType> roomTypes = roomTypeRepository.findAll();
        List<RoomTypeDto> dtos = new ArrayList<RoomTypeDto>();
        for (RoomType roomType : roomTypes) {
            RoomTypeDto dto = new RoomTypeDto();
            dto.setId(roomType.getId());
            dto.setName(roomType.getName());
            dto.setPrice(roomType.getPrice());
            dtos.add(dto);
        }
        return dtos;
    }

    public RoomTypeDto getById(int id) {
        RoomType roomType = roomTypeRepository.finfById(id);
        RoomTypeDto dto = new RoomTypeDto();
        dto.setId(roomType.getId());
        dto.setName(roomType.getName());
        dto.setPrice(roomType.getPrice());
        return dto;
    }
    
    public void add(RoomTypeDto dto){
        RoomType roomType = new RoomType();
        roomType.setName(dto.getName());
        roomType.setPrice(dto.getPrice());
        roomTypeRepository.insert(roomType);
    }
    
    public void edit(RoomTypeDto dto){
        RoomType roomType = new RoomType();
        roomType.setId(dto.getId());
        roomType.setName(dto.getName());
        roomType.setPrice(dto.getPrice());
        roomTypeRepository.update(roomType);
    }
    
    public void removeById(int id){
        roomTypeRepository.deleteById(id);
    }
}

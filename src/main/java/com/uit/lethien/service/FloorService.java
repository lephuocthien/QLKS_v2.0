/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.lethien.service;

import com.uit.lethien.dto.FloorDto;
import com.uit.lethien.model.Floor;
import com.uit.lethien.repository.FloorRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LeThien
 */
public class FloorService {

    private FloorRepository floorRepository;

    public FloorService() {
        this.floorRepository = new FloorRepository();
    }

    public List<FloorDto> getAll() {
        List<Floor> floors = floorRepository.findAll();
        List<FloorDto> dtos = new ArrayList<FloorDto>();
        for (Floor floor : floors) {
            FloorDto dto = new FloorDto();
            dto.setId(floor.getId());
            dto.setName(floor.getName());
            dtos.add(dto);
        }
        return dtos;
    }

    public FloorDto getById(int id) {
        Floor floor = floorRepository.finfById(id);
        FloorDto dto = new FloorDto();
        dto.setId(floor.getId());
        dto.setName(floor.getName());
        return dto;
    }
    
    public void add(FloorDto dto){
        Floor floor = new Floor();
        floor.setName(dto.getName());
        floorRepository.insert(floor);
    }
    
    public void edit(FloorDto dto){
        Floor floor = new Floor();
        floor.setId(dto.getId());
        floor.setName(dto.getName());
        floorRepository.update(floor);
    }
    
    public void removeById(int id){
        floorRepository.deleteById(id);
    }
}

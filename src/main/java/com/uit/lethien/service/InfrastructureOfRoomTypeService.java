/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.lethien.service;

import com.uit.lethien.dto.InfrastructureOfRoomTypeDto;
import com.uit.lethien.model.InfrastructureOfRoomType;
import com.uit.lethien.repository.InfrastructureOfRoomTypeRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LeThien
 */
public class InfrastructureOfRoomTypeService {
    private InfrastructureOfRoomTypeRepository infrastrutureOfRoomTypeRepository 
            = new InfrastructureOfRoomTypeRepository();

    public InfrastructureOfRoomTypeService() {
        this.infrastrutureOfRoomTypeRepository = new InfrastructureOfRoomTypeRepository();
    }
    
    public List<InfrastructureOfRoomTypeDto> getAllByRoomTypeId(int roomTypeId){
        List<InfrastructureOfRoomType> infrastructureOfRoomTypes 
                = infrastrutureOfRoomTypeRepository.findAllByRoomTypeId(roomTypeId);
        List<InfrastructureOfRoomTypeDto> dtos = new ArrayList<InfrastructureOfRoomTypeDto>();
        for(InfrastructureOfRoomType infrastructureOfRoomType:infrastructureOfRoomTypes ){
            InfrastructureOfRoomTypeDto dto = new InfrastructureOfRoomTypeDto();
            dto.setInfrastructureId(infrastructureOfRoomType.getInfrastructureId());
            dto.setRoomTypeId(infrastructureOfRoomType.getRoomTypeId());
            dto.setCount(infrastructureOfRoomType.getCount());
            dtos.add(dto);
        }
        return dtos;
    }
    
    public InfrastructureOfRoomTypeDto getById(int infrastructureId, int roomTypeId){
         InfrastructureOfRoomType infrastructureOfRoomType 
                 = infrastrutureOfRoomTypeRepository.findById(infrastructureId, roomTypeId);
         if(infrastructureOfRoomType!=null){
            InfrastructureOfRoomTypeDto dto = new InfrastructureOfRoomTypeDto();
            dto.setInfrastructureId(infrastructureOfRoomType.getInfrastructureId());
            dto.setRoomTypeId(infrastructureOfRoomType.getRoomTypeId());
            dto.setCount(infrastructureOfRoomType.getCount());
            return dto;
         } else {
              return null;
         }
    }
    
    public void add(InfrastructureOfRoomTypeDto dto){
        InfrastructureOfRoomType infrastructureOfRoomType = new InfrastructureOfRoomType();
        infrastructureOfRoomType.setInfrastructureId(dto.getInfrastructureId());
        infrastructureOfRoomType.setRoomTypeId(dto.getRoomTypeId());
        infrastructureOfRoomType.setCount(dto.getCount());
        infrastrutureOfRoomTypeRepository.insert(infrastructureOfRoomType);  
    }
    
    public void edit(InfrastructureOfRoomTypeDto dto){
        InfrastructureOfRoomType infrastructureOfRoomType = new InfrastructureOfRoomType();
        infrastructureOfRoomType.setInfrastructureId(dto.getInfrastructureId());
        infrastructureOfRoomType.setRoomTypeId(dto.getRoomTypeId());
        infrastructureOfRoomType.setCount(dto.getCount());
        infrastrutureOfRoomTypeRepository.update(infrastructureOfRoomType);  
    }
    
    public void removeById(int infrastructureId, int roomTypeId){
        infrastrutureOfRoomTypeRepository.deleteById(infrastructureId, roomTypeId);
    }
}

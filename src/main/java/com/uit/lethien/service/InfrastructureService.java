/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.lethien.service;

import com.uit.lethien.dto.InfrastructureDto;
import com.uit.lethien.model.Infrastructure;
import com.uit.lethien.repository.InfrastructureRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LeThien
 */
public class InfrastructureService {
    private InfrastructureRepository infrastructureRepository;

    public InfrastructureService() {
        this.infrastructureRepository = new InfrastructureRepository();
    }
    
    public List<InfrastructureDto> getAll() {
        List<Infrastructure> infrastructures = infrastructureRepository.findAll();
        List<InfrastructureDto> dtos = new ArrayList<InfrastructureDto>();
        for (Infrastructure infrastructure : infrastructures) {
            InfrastructureDto dto = new InfrastructureDto();
            dto.setId(infrastructure.getId());
            dto.setName(infrastructure.getName());
            dto.setPrice(infrastructure.getPrice());
            dtos.add(dto);
        }
        return dtos;
    }

    public InfrastructureDto getById(int id) {
        Infrastructure infrastructure = infrastructureRepository.finfById(id);
        InfrastructureDto dto = new InfrastructureDto();
        dto.setId(infrastructure.getId());
        dto.setName(infrastructure.getName());
        dto.setPrice(infrastructure.getPrice());
        return dto;
    }
    
    public void add(InfrastructureDto dto){
        Infrastructure infrastructure = new Infrastructure();
        infrastructure.setName(dto.getName());
        infrastructure.setPrice(dto.getPrice());
        infrastructureRepository.insert(infrastructure);
    }
    
    public void edit(InfrastructureDto dto){
        Infrastructure infrastructure = new Infrastructure();
        infrastructure.setId(dto.getId());
        infrastructure.setName(dto.getName());
        infrastructure.setPrice(dto.getPrice());
        infrastructureRepository.update(infrastructure);
    }
    
    public void removeById(int id){
        infrastructureRepository.deleteById(id);
    }
}

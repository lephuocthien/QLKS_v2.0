/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.lethien.service;

import com.uit.lethien.dto.ServiceDto;
import com.uit.lethien.model.Service;
import com.uit.lethien.repository.ServiceRepository;
import com.uit.lethien.repository.ServiceRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LeThien
 */
public class ServiceService {

    private ServiceRepository serviceRepository;

    public ServiceService() {
        this.serviceRepository = new ServiceRepository();
    }

    public List<ServiceDto> getAll() {
        List<Service> services = serviceRepository.findAll();
        List<ServiceDto> dtos = new ArrayList<ServiceDto>();
        for (Service service : services) {
            ServiceDto dto = new ServiceDto();
            dto.setId(service.getId());
            dto.setName(service.getName());
            dto.setDvt(service.getDvt());
            dto.setPrice(service.getPrice());
            dtos.add(dto);
        }
        return dtos;
    }

    public ServiceDto getById(int id) {
        Service service = serviceRepository.findById(id);
        ServiceDto dto = new ServiceDto();
        dto.setId(service.getId());
        dto.setName(service.getName());
        dto.setDvt(service.getDvt());
        dto.setPrice(service.getPrice());
        return dto;
    }

    public void add(ServiceDto dto) {
        Service service = new Service();
        service.setName(dto.getName());
        service.setDvt(dto.getDvt());
        service.setPrice(dto.getPrice());
        // Gọi hàm add của DAO để chạy câu lệnh INSERT
        serviceRepository.insert(service);
    }

    public void edit(ServiceDto dto) {
        // Chuyển dữ liệu từ DTO qua ENTITY
        Service service = new Service();
        service.setId(dto.getId());
        service.setName(dto.getName());
        service.setDvt(dto.getDvt());
        service.setPrice(dto.getPrice());
        // Gọi hàm add của DAO để chạy câu lệnh INSERT
        serviceRepository.update(service);
    }

    public void removeById(int id) {
        serviceRepository.deleteById(id);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.lethien.service;

import com.uit.lethien.dto.RoomDto;
import com.uit.lethien.model.Room;
import com.uit.lethien.repository.RoomRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LeThien
 */
public class RoomService {

    private RoomRepository roomRepository = null;

    public RoomService() {
        roomRepository = new RoomRepository();
    }

    public List<RoomDto> getAll() {
        List<Room> rooms = roomRepository.findAll();
        List<RoomDto> dtos = new ArrayList<RoomDto>();
        for (Room room : rooms) {
            RoomDto dto = new RoomDto();
            dto.setId(room.getId());
            dto.setName(room.getName());
            dto.setFloorId(room.getFloorId());
            dto.setRoomTypeId(room.getRoomTypeId());
            dtos.add(dto);
        }
        return dtos;
    }

    public RoomDto getById(int id) {
        Room room = roomRepository.findById(id);
        if (room != null) {
            RoomDto dto = new RoomDto();
            dto.setId(room.getId());
            dto.setName(room.getName());
            dto.setFloorId(room.getFloorId());
            dto.setRoomTypeId(room.getRoomTypeId());
            return dto;
        } else {
            return null;
        }
    }

    public List<RoomDto> getByFloorId(int floorId) {
        List<Room> rooms = roomRepository.findByFloorId(floorId);
        List<RoomDto> dtos = new ArrayList<RoomDto>();
        for (Room room : rooms) {
            RoomDto dto = new RoomDto();
            dto.setId(room.getId());
            dto.setName(room.getName());
            dto.setFloorId(room.getFloorId());
            dto.setRoomTypeId(room.getRoomTypeId());
            dtos.add(dto);
        }
        return dtos;
    }

    public void add(RoomDto dto) {
        Room room = new Room();
        room.setName(dto.getName());
        room.setFloorId(dto.getFloorId());
        room.setRoomTypeId(dto.getRoomTypeId());
        // Gọi hàm add của DAO để chạy câu lệnh INSERT
        roomRepository.insert(room);
    }

    public void edit(RoomDto dto) {
        // Chuyển dữ liệu từ DTO qua ENTITY
        Room room = new Room();
        room.setId(dto.getId());
        room.setName(dto.getName());
        room.setFloorId(dto.getFloorId());
        room.setRoomTypeId(dto.getRoomTypeId());
        // Gọi hàm add của DAO để chạy câu lệnh INSERT
        roomRepository.update(room);
    }

    public void removeById(int id) {
        roomRepository.deleteById(id);
    }
}

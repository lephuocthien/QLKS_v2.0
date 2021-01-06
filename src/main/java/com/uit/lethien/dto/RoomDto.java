/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.lethien.dto;

/**
 *
 * @author LeThien
 */
public class RoomDto {
    private int id;
    private String name;
    private int floorId;
    private int roomTypeId;
    private String status;

    public RoomDto() {
    }

    public RoomDto(int id, String name, int floorId, int roomTypeId, String status) {
        this.id = id;
        this.name = name;
        this.floorId = floorId;
        this.roomTypeId = roomTypeId;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public int getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(int roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}

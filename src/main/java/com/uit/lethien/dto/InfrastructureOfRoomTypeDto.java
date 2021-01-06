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
public class InfrastructureOfRoomTypeDto {
    private int infrastructureId;
    private int roomTypeId;
    private int count;

    public InfrastructureOfRoomTypeDto() {
    }

    public InfrastructureOfRoomTypeDto(int infrastructureId, int roomTypeId, int count) {
        this.infrastructureId = infrastructureId;
        this.roomTypeId = roomTypeId;
        this.count = count;
    }

    public int getInfrastructureId() {
        return infrastructureId;
    }

    public void setInfrastructureId(int infrastructureId) {
        this.infrastructureId = infrastructureId;
    }

    public int getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(int roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    
    
    
}

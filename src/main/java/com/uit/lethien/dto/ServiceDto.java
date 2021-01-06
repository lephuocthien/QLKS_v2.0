/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.lethien.dto;

import java.math.BigDecimal;

/**
 *
 * @author LeThien
 */
public class ServiceDto {
    private int id;
    private String name;
    private String dvt;
    private BigDecimal price;

    public ServiceDto() {
    }

    public ServiceDto(int id, String name, String dvt, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.dvt = dvt;
        this.price = price;
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

    public String getDvt() {
        return dvt;
    }

    public void setDvt(String dvt) {
        this.dvt = dvt;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    
}

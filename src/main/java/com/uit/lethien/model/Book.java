/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.lethien.model;

import java.math.BigDecimal;
import java.util.Date;


/**
 *
 * @author LeThien
 */
public class Book {
    private int id;
    private int roomId;
    private int userId;
    private Date dateIn;
    private Date dateOut;
    private int count;
    private BigDecimal moneyTra;
    private BigDecimal moneyCon;
    private String cusName;
    private String cusCmnd;
    private String cusPhone;
    private String cusDiaChi;
    private Date cusNgaySinh;

    public Book() {
    }

    public Book(int id, int roomId, int userId, Date dateIn, Date dateOut, int count, BigDecimal moneyTra, BigDecimal moneyCon, String cusName, String cusCmnd, String cusPhone, String cusDiaChi, Date cusNgaySinh) {
        this.id = id;
        this.roomId = roomId;
        this.userId = userId;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.count = count;
        this.moneyTra = moneyTra;
        this.moneyCon = moneyCon;
        this.cusName = cusName;
        this.cusCmnd = cusCmnd;
        this.cusPhone = cusPhone;
        this.cusDiaChi = cusDiaChi;
        this.cusNgaySinh = cusNgaySinh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public BigDecimal getMoneyTra() {
        return moneyTra;
    }

    public void setMoneyTra(BigDecimal moneyTra) {
        this.moneyTra = moneyTra;
    }

    public BigDecimal getMoneyCon() {
        return moneyCon;
    }

    public void setMoneyCon(BigDecimal moneyCon) {
        this.moneyCon = moneyCon;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusCmnd() {
        return cusCmnd;
    }

    public void setCusCmnd(String cusCmnd) {
        this.cusCmnd = cusCmnd;
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
    }

    public String getCusDiaChi() {
        return cusDiaChi;
    }

    public void setCusDiaChi(String cusDiaChi) {
        this.cusDiaChi = cusDiaChi;
    }

    public Date getCusNgaySinh() {
        return cusNgaySinh;
    }

    public void setCusNgaySinh(Date cusNgaySinh) {
        this.cusNgaySinh = cusNgaySinh;
    }
    
    
}

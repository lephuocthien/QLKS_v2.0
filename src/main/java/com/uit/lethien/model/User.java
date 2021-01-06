/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.lethien.model;

/**
 *
 * @author LeThien
 */
public class User {
    private int id;
    private String userName;
    private String password;
    private String fullname;
    private String address;
    private String phone;
    private int roleId;

    public User() {
    }

    public User(int id, String userName, String password, String fullname, String address, String phone, int roleId) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.fullname = fullname;
        this.address = address;
        this.phone = phone;
        this.roleId = roleId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
    
    
}

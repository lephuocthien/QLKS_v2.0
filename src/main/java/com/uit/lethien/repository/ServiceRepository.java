/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.lethien.repository;

import com.uit.lethien.database.ConnectDatabase;
import com.uit.lethien.model.Service;
import com.uit.lethien.model.Service;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LeThien
 */
public class ServiceRepository {
     private Connection conn;

    public ServiceRepository() {
        conn = ConnectDatabase.connectDatabase();
    }
    
    public List<Service> findAll() {
        List<Service> services = new ArrayList<Service>();
        String query = "SELECT * FROM DICH_VU";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Service service = new Service();
                service.setId(rs.getInt("MADV"));
                service.setName(rs.getString("TENDV"));
                service.setDvt(rs.getString("DVT"));
                service.setPrice(rs.getBigDecimal("GIA"));
                services.add(service);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return services;
    }

    public Service findById(int id) {
        Service service = new Service();
        String query = "SELECT * FROM DICH_VU WHERE MADV = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                service.setId(rs.getInt("MADV"));
                service.setName(rs.getString("TENDV"));
                service.setDvt(rs.getString("DVT"));
                service.setPrice(rs.getBigDecimal("GIA"));
                break;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return service;
    }

    public void insert(Service service) {
        String query = "INSERT INTO DICH_VU(TENDV, DVT, GIA) VALUES (?, ?, ?)";
        try {
            // Tạo câu lệnh truy vấn sử dụng PreparedStatement
            PreparedStatement statement = conn.prepareStatement(query);
            // Thay thế dấu ? bằng dữ liệu lấy ra từ đối tượng service
            statement.setString(1, service.getName());
            statement.setString(2, service.getDvt());
            statement.setBigDecimal(3, service.getPrice());
            // Thực thi câu lệnh truy vấn
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Service service) {
        String query = "UPDATE DICH_VU SET TENDV = ?, DVT = ?, GIA = ? WHERE MADV = ?";
        try {
            // Tạo câu lệnh truy vấn sử dụng PreparedStatement
            PreparedStatement statement = conn.prepareStatement(query);
            // Thay thế dấu ? bằng dữ liệu lấy ra từ đối tượng service
            statement.setString(1, service.getName());
             statement.setString(2, service.getDvt());
            statement.setBigDecimal(3, service.getPrice());
            statement.setInt(4, service.getId());
            // Thực thi câu lệnh truy vấn
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(int id) {
        String query = "DELETE FROM DICH_VU WHERE MADV = ?";
        try {
            // Tạo câu lệnh truy vấn sử dụng PreparedStatement
            PreparedStatement statement = conn.prepareStatement(query);
            // Thay thế dấu ? bằng dữ liệu lấy ra từ đối tượng service
            statement.setInt(1, id);
            // Thực thi câu lệnh truy vấn
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

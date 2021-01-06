/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.lethien.repository;

import com.uit.lethien.database.ConnectDatabase;
import com.uit.lethien.model.Infrastructure;
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
public class InfrastructureRepository {

    private Connection conn;

    public InfrastructureRepository() {
        conn = ConnectDatabase.connectDatabase();
    }

    public List<Infrastructure> findAll() {
        List<Infrastructure> infrastructures = new ArrayList<Infrastructure>();
        String query = "SELECT * FROM CO_SO";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Infrastructure infrastructure = new Infrastructure();
                infrastructure.setId(rs.getInt("MACS"));
                infrastructure.setName(rs.getString("TEN"));
                infrastructure.setPrice(rs.getBigDecimal("GIA"));
                infrastructures.add(infrastructure);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return infrastructures;
    }

    public Infrastructure finfById(int id) {
        Infrastructure infrastructure = new Infrastructure();
        String query = "SELECT * FROM CO_SO WHERE MACS = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                infrastructure.setId(rs.getInt("MACS"));
                infrastructure.setName(rs.getString("TEN"));
                infrastructure.setPrice(rs.getBigDecimal("GIA"));
                break;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return infrastructure;
    }

    public void insert(Infrastructure infrastructure) {
        String query = "INSERT INTO CO_SO(TEN, GIA) VALUES (?, ?)";
        try {
            // Tạo câu lệnh truy vấn sử dụng PreparedStatement
            PreparedStatement statement = conn.prepareStatement(query);
            // Thay thế dấu ? bằng dữ liệu lấy ra từ đối tượng role
            statement.setString(1, infrastructure.getName());
            statement.setBigDecimal(2, infrastructure.getPrice());
            // Thực thi câu lệnh truy vấn
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Infrastructure infrastructure) {
        String query = "UPDATE CO_SO SET TEN = ?, GIA = ? WHERE MACS = ?";
        try {
            // Tạo câu lệnh truy vấn sử dụng PreparedStatement
            PreparedStatement statement = conn.prepareStatement(query);
            // Thay thế dấu ? bằng dữ liệu lấy ra từ đối tượng role
            statement.setString(1, infrastructure.getName());
            statement.setBigDecimal(2, infrastructure.getPrice());
            statement.setInt(3, infrastructure.getId());
            // Thực thi câu lệnh truy vấn
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(int id) {
        String query = "DELETE FROM CO_SO WHERE MACS = ?";
        try {
            // Tạo câu lệnh truy vấn sử dụng PreparedStatement
            PreparedStatement statement = conn.prepareStatement(query);
            // Thay thế dấu ? bằng dữ liệu lấy ra từ đối tượng role
            statement.setInt(1, id);
            // Thực thi câu lệnh truy vấn
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

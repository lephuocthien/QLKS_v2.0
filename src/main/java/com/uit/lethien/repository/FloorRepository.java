/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.lethien.repository;

import com.uit.lethien.database.ConnectDatabase;
import com.uit.lethien.model.Floor;
import com.uit.lethien.model.Role;
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
public class FloorRepository {

    private Connection conn;

    public FloorRepository() {
        conn = ConnectDatabase.connectDatabase();
    }

    public List<Floor> findAll() {
        List<Floor> floors = new ArrayList<Floor>();
        String query = "SELECT * FROM TANG";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Floor floor = new Floor();
                floor.setId(rs.getInt("MATANG"));
                floor.setName(rs.getString("TENTANG"));
                floors.add(floor);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return floors;
    }
    
    public Floor finfById(int id){
        Floor floor = new Floor();
        String query = "SELECT * FROM TANG WHERE MATANG = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                floor.setId(rs.getInt("MATANG"));
                floor.setName(rs.getString("TENTANG"));
                break;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return floor;
    }
    
    public void insert(Floor floor){
        String query = "INSERT INTO TANG(TENTANG) VALUES (?)";
        try {
            // Tạo câu lệnh truy vấn sử dụng PreparedStatement
            PreparedStatement statement = conn.prepareStatement(query);
            // Thay thế dấu ? bằng dữ liệu lấy ra từ đối tượng role
            statement.setString(1, floor.getName());
            // Thực thi câu lệnh truy vấn
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void update(Floor floor) {
        String query = "UPDATE TANG SET TENTANG = ? WHERE MATANG = ?";
        try {
            // Tạo câu lệnh truy vấn sử dụng PreparedStatement
            PreparedStatement statement = conn.prepareStatement(query);
            // Thay thế dấu ? bằng dữ liệu lấy ra từ đối tượng role
            statement.setString(1, floor.getName());
            statement.setInt(2, floor.getId());
            // Thực thi câu lệnh truy vấn
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(int id) {
        String query = "DELETE FROM TANG WHERE MATANG = ?";
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

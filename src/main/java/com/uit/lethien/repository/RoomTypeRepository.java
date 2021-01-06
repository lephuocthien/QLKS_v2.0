/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.lethien.repository;

import com.uit.lethien.database.ConnectDatabase;
import com.uit.lethien.model.RoomType;
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
public class RoomTypeRepository {
    private Connection conn;

    public RoomTypeRepository() {
        conn = ConnectDatabase.connectDatabase();
    }

    public List<RoomType> findAll() {
        List<RoomType> roomTypes = new ArrayList<RoomType>();
        String query = "SELECT * FROM LOAI_PHONG";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                RoomType roomType = new RoomType();
                roomType.setId(rs.getInt("MALP"));
                roomType.setName(rs.getString("LOAI"));
                roomType.setPrice(rs.getBigDecimal("GIA"));
                roomTypes.add(roomType);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return roomTypes;
    }

    public RoomType finfById(int id) {
        RoomType roomType = new RoomType();
        String query = "SELECT * FROM LOAI_PHONG WHERE MALP = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                roomType.setId(rs.getInt("MALP"));
                roomType.setName(rs.getString("LOAI"));
                roomType.setPrice(rs.getBigDecimal("GIA"));
                break;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return roomType;
    }

    public void insert(RoomType roomType) {
        String query = "INSERT INTO LOAI_PHONG(LOAI, GIA) VALUES (?, ?)";
        try {
            // Tạo câu lệnh truy vấn sử dụng PreparedStatement
            PreparedStatement statement = conn.prepareStatement(query);
            // Thay thế dấu ? bằng dữ liệu lấy ra từ đối tượng role
            statement.setString(1, roomType.getName());
            statement.setBigDecimal(2, roomType.getPrice());
            // Thực thi câu lệnh truy vấn
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(RoomType roomType) {
        String query = "UPDATE LOAI_PHONG SET LOAI = ?, GIA = ? WHERE MALP = ?";
        try {
            // Tạo câu lệnh truy vấn sử dụng PreparedStatement
            PreparedStatement statement = conn.prepareStatement(query);
            // Thay thế dấu ? bằng dữ liệu lấy ra từ đối tượng role
            statement.setString(1, roomType.getName());
            statement.setBigDecimal(2, roomType.getPrice());
            statement.setInt(3, roomType.getId());
            // Thực thi câu lệnh truy vấn
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(int id) {
        String query = "DELETE FROM LOAI_PHONG WHERE MALP = ?";
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

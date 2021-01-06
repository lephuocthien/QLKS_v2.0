/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.lethien.repository;

import com.uit.lethien.database.ConnectDatabase;
import com.uit.lethien.model.Room;
import com.uit.lethien.model.Room;
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
public class RoomRepository {
    private Connection conn;

    public RoomRepository() {
        conn = ConnectDatabase.connectDatabase();
    }
    
    public List<Room> findAll() {
        List<Room> rooms = new ArrayList<Room>();
        String query = "SELECT * FROM PHONG";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Room room = new Room();
                room.setId(rs.getInt("SOPHONG"));
                room.setName(rs.getString("TENPHONG"));
                room.setFloorId(rs.getInt("MATANG"));
                room.setRoomTypeId(rs.getInt("MALP"));
                rooms.add(room);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rooms;
    }

    public Room findById(int id) {
        Room room = new Room();
        String query = "SELECT * FROM PHONG WHERE SOPHONG = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                room.setId(rs.getInt("SOPHONG"));
                room.setName(rs.getString("TENPHONG"));
                room.setFloorId(rs.getInt("MATANG"));
                room.setRoomTypeId(rs.getInt("MALP"));
                return room;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Room> findByFloorId(int floorId) {
        List<Room> rooms = new ArrayList<Room>();
        String query = "SELECT * FROM PHONG WHERE MATANG = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, floorId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Room room = new Room();
                room.setId(rs.getInt("SOPHONG"));
                room.setName(rs.getString("TENPHONG"));
                room.setFloorId(rs.getInt("MATANG"));
                room.setRoomTypeId(rs.getInt("MALP"));
                rooms.add(room);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rooms;
    }
    
    public void insert(Room room) {
        String query = "INSERT INTO PHONG(TENPHONG, MATANG, MALP) VALUES (?, ?, ?)";
        try {
            // Tạo câu lệnh truy vấn sử dụng PreparedStatement
            PreparedStatement statement = conn.prepareStatement(query);
            // Thay thế dấu ? bằng dữ liệu lấy ra từ đối tượng room
            statement.setString(1, room.getName());
            statement.setInt(2, room.getFloorId());
            statement.setInt(3, room.getRoomTypeId());
            // Thực thi câu lệnh truy vấn
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Room room) {
        String query = "UPDATE PHONG SET TENPHONG = ?, MATANG = ?, MALP = ? WHERE SOPHONG = ?";
        try {
            // Tạo câu lệnh truy vấn sử dụng PreparedStatement
            PreparedStatement statement = conn.prepareStatement(query);
            // Thay thế dấu ? bằng dữ liệu lấy ra từ đối tượng room
             statement.setString(1, room.getName());
            statement.setInt(2, room.getFloorId());
            statement.setInt(3, room.getRoomTypeId());
            statement.setInt(4, room.getId());
            // Thực thi câu lệnh truy vấn
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(int id) {
        String query = "DELETE FROM PHONG WHERE SOPHONG = ?";
        try {
            // Tạo câu lệnh truy vấn sử dụng PreparedStatement
            PreparedStatement statement = conn.prepareStatement(query);
            // Thay thế dấu ? bằng dữ liệu lấy ra từ đối tượng room
            statement.setInt(1, id);
            // Thực thi câu lệnh truy vấn
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

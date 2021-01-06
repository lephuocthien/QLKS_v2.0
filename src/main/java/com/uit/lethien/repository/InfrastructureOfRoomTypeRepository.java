/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.lethien.repository;

import com.uit.lethien.database.ConnectDatabase;
import com.uit.lethien.model.Floor;
import com.uit.lethien.model.InfrastructureOfRoomType;
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
public class InfrastructureOfRoomTypeRepository {

    private Connection conn;

    public InfrastructureOfRoomTypeRepository() {
        conn = ConnectDatabase.connectDatabase();
    }

    public List<InfrastructureOfRoomType> findAllByRoomTypeId(int roomTypeId) {
        List<InfrastructureOfRoomType> infrastructureOfRoomTypes = new ArrayList<InfrastructureOfRoomType>();
        String query = "SELECT * FROM CT_LOAI_PHONG WHERE MALP = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, roomTypeId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                InfrastructureOfRoomType infrastructureOfRoomType = new InfrastructureOfRoomType();
                infrastructureOfRoomType.setInfrastructureId(rs.getInt("MACS"));
                infrastructureOfRoomType.setRoomTypeId(rs.getInt("MALP"));
                infrastructureOfRoomType.setCount(rs.getInt("SOLUONG"));
                infrastructureOfRoomTypes.add(infrastructureOfRoomType);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return infrastructureOfRoomTypes;
    }
    
    public InfrastructureOfRoomType findById(int infrastructureId, int roomTypeId) {
        InfrastructureOfRoomType infrastructureOfRoomType = new InfrastructureOfRoomType();
        String query = "SELECT * FROM CT_LOAI_PHONG WHERE MALP = ? AND MACS = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, roomTypeId);
            statement.setInt(2, infrastructureId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                infrastructureOfRoomType.setInfrastructureId(rs.getInt("MACS"));
                infrastructureOfRoomType.setRoomTypeId(rs.getInt("MALP"));
                infrastructureOfRoomType.setCount(rs.getInt("SOLUONG"));
                return infrastructureOfRoomType;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public void insert(InfrastructureOfRoomType infrastructureOfRoomType){
        String query = "INSERT INTO CT_LOAI_PHONG VALUES (?, ?, ?)";
        try {
            // Tạo câu lệnh truy vấn sử dụng PreparedStatement
            PreparedStatement statement = conn.prepareStatement(query);
            // Thay thế dấu ? bằng dữ liệu lấy ra từ đối tượng role
            statement.setInt(1, infrastructureOfRoomType.getInfrastructureId());
            statement.setInt(2, infrastructureOfRoomType.getRoomTypeId());
            statement.setInt(3, infrastructureOfRoomType.getCount());
            // Thực thi câu lệnh truy vấn
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void update(InfrastructureOfRoomType infrastructureOfRoomType){
        String query = "UPDATE CT_LOAI_PHONG SET SOLUONG = ? WHERE MALP = ? AND MACS = ?";
        try {
            // Tạo câu lệnh truy vấn sử dụng PreparedStatement
            PreparedStatement statement = conn.prepareStatement(query);
            // Thay thế dấu ? bằng dữ liệu lấy ra từ đối tượng role
            statement.setInt(1, infrastructureOfRoomType.getCount());           
            statement.setInt(2, infrastructureOfRoomType.getRoomTypeId());
            statement.setInt(3, infrastructureOfRoomType.getInfrastructureId());   
            // Thực thi câu lệnh truy vấn
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteById(int infrastructureId, int roomTypeId){
         String query = "DELETE FROM CT_LOAI_PHONG WHERE MACS = ? AND MALP = ?";
         try {
            // Tạo câu lệnh truy vấn sử dụng PreparedStatement
            PreparedStatement statement = conn.prepareStatement(query);
            // Thay thế dấu ? bằng dữ liệu lấy ra từ đối tượng role
            statement.setInt(1, infrastructureId);
            statement.setInt(2, roomTypeId);
            // Thực thi câu lệnh truy vấn
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.lethien.repository;

import com.uit.lethien.database.ConnectDatabase;
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
public class RoleRepository {

    private Connection conn;

    public RoleRepository() {
        conn = ConnectDatabase.connectDatabase();
    }

    public List<Role> findAll() {
        List<Role> roles = new ArrayList<Role>();
        String query = "SELECT * FROM ROLES";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Role role = new Role();
                role.setId(rs.getInt("id"));
                role.setName(rs.getString("name"));
                role.setDescription(rs.getString("description"));
                roles.add(role);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return roles;
    }

    public Role findById(int id) {
        Role role = new Role();
        String query = "SELECT * FROM ROLES WHERE id = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                role.setId(rs.getInt("id"));
                role.setName(rs.getString("name"));
                role.setDescription(rs.getString("description"));
                break;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return role;
    }

    public void add(Role role) {
        String query = "INSERT INTO roles(name, description) VALUES (?, ?)";
        try {
            // Tạo câu lệnh truy vấn sử dụng PreparedStatement
            PreparedStatement statement = conn.prepareStatement(query);
            // Thay thế dấu ? bằng dữ liệu lấy ra từ đối tượng role
            statement.setString(1, role.getName());
            statement.setString(2, role.getDescription());
            // Thực thi câu lệnh truy vấn
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Role role) {
        String query = "UPDATE roles SET name = ?, description = ? WHERE id = ?";
        try {
            // Tạo câu lệnh truy vấn sử dụng PreparedStatement
            PreparedStatement statement = conn.prepareStatement(query);
            // Thay thế dấu ? bằng dữ liệu lấy ra từ đối tượng role
            statement.setString(1, role.getName());
            statement.setString(2, role.getDescription());
            statement.setInt(3, role.getId());
            // Thực thi câu lệnh truy vấn
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(int id) {
        String query = "DELETE FROM roles WHERE id = ?";
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

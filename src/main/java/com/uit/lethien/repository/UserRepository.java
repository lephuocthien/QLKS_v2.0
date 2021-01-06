/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.lethien.repository;

import com.uit.lethien.database.ConnectDatabase;
import com.uit.lethien.dto.UserDto;
import com.uit.lethien.model.User;
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
public class UserRepository {

    private Connection conn;

    public UserRepository() {
        conn = ConnectDatabase.connectDatabase();
    }

    public List<UserDto> findAllDto() {
        List<UserDto> users = new ArrayList<UserDto>();
        String query = "SELECT "
                + "nv.MANV, "
                + "nv.TENTK, "
                + "nv.MATKHAU, "
                + "nv.HOTEN, "
                + "nv.DIACHI, "
                + "nv.SDT, "
                + "r.ID, "
                + "r.description "
                + "FROM NHAN_VIEN nv "
                + "JOIN ROLES r "
                + "ON nv.ROLE_ID = r.ID";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                UserDto user = new UserDto();
                user.setId(rs.getInt("nv.MANV"));
                user.setUserName(rs.getString("nv.TENTK"));
                user.setPassword(rs.getString("nv.MATKHAU"));
                user.setFullname(rs.getString("nv.HOTEN"));
                user.setAddress(rs.getString("nv.DIACHI"));
                user.setPhone(rs.getString("nv.SDT"));
                user.setRoleId(rs.getInt("r.ID"));
                user.setRoleDescription(rs.getString("r.description"));
                users.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return users;
    }

    public User findById(int id) {
        User user = new User();
        String query = "SELECT * FROM NHAN_VIEN WHERE MANV = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                user.setId(rs.getInt("MANV"));
                user.setUserName(rs.getString("TENTK"));
                user.setPassword(rs.getString("MATKHAU"));
                user.setFullname(rs.getString("HOTEN"));
                user.setAddress(rs.getString("DIACHI"));
                user.setPhone(rs.getString("SDT"));
                user.setRoleId(rs.getInt("ROLE_ID"));
                break;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    public User findByUserName(String userName) {
        User user = new User();
        String query = "SELECT * FROM NHAN_VIEN WHERE TENTK = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, userName);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                user.setId(rs.getInt("MANV"));
                user.setUserName(rs.getString("TENTK"));
                user.setPassword(rs.getString("MATKHAU"));
                user.setFullname(rs.getString("HOTEN"));
                user.setAddress(rs.getString("DIACHI"));
                user.setPhone(rs.getString("SDT"));
                user.setRoleId(rs.getInt("ROLE_ID"));
                return user;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void insert(User user) {
        String query = "INSERT INTO NHAN_VIEN"
                + "(TENTK, MATKHAU, HOTEN, DIACHI, SDT, ROLE_ID) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFullname());
            statement.setString(4, user.getAddress());
            statement.setString(5, user.getPhone());
            statement.setInt(6, user.getRoleId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(User user) {
        String queryWithPass = "UPDATE NHAN_VIEN SET "
                + "TENTK = ?, "
                + "MATKHAU = ?, "
                + "HOTEN = ?, "
                + "DIACHI = ?, "
                + "SDT = ?, "
                + "ROLE_ID = ? "
                + "WHERE MANV = ?";
        String queryWithOutPass = "UPDATE NHAN_VIEN SET "
                + "TENTK = ?, "
                + "HOTEN = ?, "
                + "DIACHI = ?, "
                + "SDT = ?, "
                + "ROLE_ID = ? "
                + "WHERE MANV = ?";
        try {
            if (user.getPassword().equals("")) {
                PreparedStatement statement = conn.prepareStatement(queryWithOutPass);
                statement.setString(1, user.getUserName());
                statement.setString(2, user.getFullname());
                statement.setString(3, user.getAddress());
                statement.setString(4, user.getPhone());
                statement.setInt(5, user.getRoleId());
                statement.setInt(6, user.getId());
                statement.executeUpdate();
            } else {
                PreparedStatement statement = conn.prepareStatement(queryWithPass);
                statement.setString(1, user.getUserName());
                statement.setString(2, user.getPassword());
                statement.setString(3, user.getFullname());
                statement.setString(4, user.getAddress());
                statement.setString(5, user.getPhone());
                statement.setInt(6, user.getRoleId());
                statement.setInt(7, user.getId());
                statement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteById(int id) {
        String query = "DELETE FROM NHAN_VIEN WHERE MANV = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

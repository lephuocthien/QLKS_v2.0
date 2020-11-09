/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.lethien.repository;

import com.uit.lethien.database.connectDatabase;
import com.uit.lethien.model.Role;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LeThien
 */
public class RoleRepository {

    private connectDatabase conn;

    public RoleRepository() {
        conn = new connectDatabase();
    }

    public List<Role> findAll() {
        List<Role> roles = new ArrayList<Role>();
        ResultSet rs = conn.ExcuteQueryGetTable("SELECT * from ROLES");
        try {
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
}

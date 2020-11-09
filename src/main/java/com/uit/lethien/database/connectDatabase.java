/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.lethien.database;
import java.sql.*;
/**
 *
 * @author LeThien
 */
public class connectDatabase {
    private final static String url ="jdbc:mysql://localhost:3306/qlks?useSSL=false";
    private final static String username = "root";
    private final static String password = "Lephuocthien1999";
    Connection conn;
    public connectDatabase(){	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn= DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			System.out.println("Không tìm thấy Driver!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Sai thông tin kết nối db!");
			e.printStackTrace();
		}
    }
    //Thực thi câu lệnh SELECT
    public ResultSet ExcuteQueryGetTable(String cauTruyVanSQL){
        try {
            Statement stmt = conn.createStatement();           
            ResultSet rs = stmt.executeQuery(cauTruyVanSQL);
            return rs;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
            
        return null;
    }
    //Thực thi INSERT, DELETE, UPDATE
    public void ExcuteQueryUpdateDB(String cauTruyVanSQL){
       
        try {
            try (Statement stmt = conn.createStatement()) {
                stmt.executeUpdate(cauTruyVanSQL);
                stmt.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
          
    }
}

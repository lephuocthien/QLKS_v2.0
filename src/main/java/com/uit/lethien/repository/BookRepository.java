/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.lethien.repository;

import com.uit.lethien.database.ConnectDatabase;
import com.uit.lethien.model.Book;
import com.uit.lethien.model.Book;
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
public class BookRepository {
    private Connection conn;

    public BookRepository() {
        conn = ConnectDatabase.connectDatabase();
    }
    
    public List<Book> findAll() {
        List<Book> books = new ArrayList<Book>();
        String query = "SELECT * FROM DAT_PHONG";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("MADAT"));
                book.setRoomId(rs.getInt("SOPHONG"));
                book.setUserId(rs.getInt("MANV"));
                book.setDateIn(rs.getDate("NGAYTHUE"));
                book.setDateOut(rs.getDate("NGAYTRA"));
                book.setCount(rs.getInt("SONGUOI"));
                book.setMoneyTra(rs.getBigDecimal("TIENTRA"));
                book.setMoneyCon(rs.getBigDecimal("TIENCON"));
                book.setCusName(rs.getString("HOTEN"));
                book.setCusCmnd(rs.getString("CMND"));
                book.setCusPhone(rs.getString("SDT"));
                book.setCusDiaChi(rs.getString("DIACHI"));
                book.setCusNgaySinh(rs.getDate("NGAYSINH"));
                books.add(book);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return books;
    }

    public Book findById(int id) {
        Book book = new Book();
        String query = "SELECT * FROM ROLES WHERE id = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                book.setId(rs.getInt("MADAT"));
                book.setRoomId(rs.getInt("SOPHONG"));
                book.setUserId(rs.getInt("MANV"));
                book.setDateIn(rs.getDate("NGAYTHUE"));
                book.setDateOut(rs.getDate("NGAYTRA"));
                book.setCount(rs.getInt("SONGUOI"));
                book.setMoneyTra(rs.getBigDecimal("TIENTRA"));
                book.setMoneyCon(rs.getBigDecimal("TIENCON"));
                book.setCusName(rs.getString("HOTEN"));
                book.setCusCmnd(rs.getString("CMND"));
                book.setCusPhone(rs.getString("SDT"));
                book.setCusDiaChi(rs.getString("DIACHI"));
                book.setCusNgaySinh(rs.getDate("NGAYSINH"));
                break;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return book;
    }
//
//    public void insert(Book book) {
//        String query = "INSERT INTO books(name, description) VALUES (?, ?)";
//        try {
//            // Tạo câu lệnh truy vấn sử dụng PreparedStatement
//            PreparedStatement statement = conn.prepareStatement(query);
//            // Thay thế dấu ? bằng dữ liệu lấy ra từ đối tượng book
//            statement.setString(1, book.getName());
//            statement.setString(2, book.getDescription());
//            // Thực thi câu lệnh truy vấn
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void update(Book book) {
//        String query = "UPDATE books SET name = ?, description = ? WHERE id = ?";
//        try {
//            // Tạo câu lệnh truy vấn sử dụng PreparedStatement
//            PreparedStatement statement = conn.prepareStatement(query);
//            // Thay thế dấu ? bằng dữ liệu lấy ra từ đối tượng book
//            statement.setString(1, book.getName());
//            statement.setString(2, book.getDescription());
//            statement.setInt(3, book.getId());
//            // Thực thi câu lệnh truy vấn
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void deleteById(int id) {
//        String query = "DELETE FROM books WHERE id = ?";
//        try {
//            // Tạo câu lệnh truy vấn sử dụng PreparedStatement
//            PreparedStatement statement = conn.prepareStatement(query);
//            // Thay thế dấu ? bằng dữ liệu lấy ra từ đối tượng book
//            statement.setInt(1, id);
//            // Thực thi câu lệnh truy vấn
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}

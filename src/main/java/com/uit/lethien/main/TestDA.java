/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uit.lethien.main;
import com.uit.lethien.repository.RoleRepository;
import com.uit.lethien.database.connectDatabase;
import com.uit.lethien.model.Role;
import com.uit.lethien.view.Home;
import com.uit.lethien.view.Infor;
import com.uit.lethien.view.Login;
import com.uit.lethien.view.Order;
import java.awt.Component;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.List;
import javax.swing.UIManager;
/**
 *
 * @author LeThien
 */
public class TestDA {
    private final static String LOOK_AND_FEEL = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, UnsupportedEncodingException {
        // TODO code application logic here
        System.setOut(new PrintStream(System.out, true, "UTF8"));
       try { 
        UIManager.setLookAndFeel(LOOK_AND_FEEL); 
        } catch(Exception ignored){}
       
       RoleRepository roleRepository = new RoleRepository();
       List<Role> roles = roleRepository.findAll();
       for(Role role:roles){
           System.out.println("");
           System.out.println("id: "+role.getId());
           System.out.println("name: "+role.getName());
           System.out.println("desc: "+role.getDescription());
       }
//       Login login = new Login();
//       login.setVisible(true);
        Home home = new Home();
        home.setVisible(true);
     
        
//        for(int i=1;i<=50;i++){
//            System.out.print("Jphong"+i+", ");
//        }
//        connectDatabase connect = new  connectDatabase ();
//        ResultSet rs = connect.ExcuteQueryGetTable("Select MATD from THUC_DON");
//        while (rs.next()){
//            String MATD = rs.getString("MATD");
//            System.out.println(MATD);
//        }
    }
    
}

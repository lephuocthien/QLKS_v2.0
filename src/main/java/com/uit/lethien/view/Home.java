/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.lethien.view;
//package images;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import com.uit.lethien.database.ConnectDatabase;
import com.uit.lethien.dto.RoleDto;
import com.uit.lethien.model.Role;
import com.uit.lethien.repository.RoleRepository;
import com.uit.lethien.service.RoleService;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.view.JasperViewer;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;

/**
 *
 * @author LeThien
 */
public final class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public abstract class JphongAction implements ActionListener {

//        @Override
//        public void actionPerformed(ActionEvent evt) {
//            JButton button = (JButton) evt.getSource();
//            String MAPHONG = button.getText();
//            String MADAT = "";
//            for (int i = 0; i < 50; i++) {
//                if (Tenphong[i].equals(MAPHONG)) {
//                    MADAT = Madatphong[i];
//                    System.out.println(MADAT + " " + MAPHONG);
//                }
//            }
//            new Booking(Home.this, MAPHONG, MADAT, MANV).setVisible(true);
//        }
    }

    public abstract class JsanhAction implements ActionListener {

//        @Override
//        public void actionPerformed(ActionEvent evt) {
//            JButton button = (JButton) evt.getSource();
//            String MASANH = button.getText();
//            String MADAT = "";
//            for (int i = 0; i < 6; i++) {
//                if (Maloaisanh[i].equals(MASANH)) {
//                    MADAT = Madattiec[i];
//                }
//            }
//            new Order(Home.this, MASANH, MADAT, MANV).setVisible(true);
//            // System.out.println("window closed");
//        }
    }
    public Order od;
    public String HOTEN_NV;
    public String MANV;
    public ConnectDatabase conn = new ConnectDatabase();
    public JButton Jphong[] = new JButton[50];
    public String Tenphong[] = new String[50];
    public String Madatphong[] = new String[50];
    public String Tinhtrangphong[] = new String[50];
    public String Maloaiphong[] = new String[50];
    public JButton Jsanh[] = new JButton[6];
    public String Tensanh[] = new String[50];
    public String Madattiec[] = new String[50];
    public String Tinhtrangsanh[] = new String[50];
    public String Maloaisanh[] = new String[50];
    public int Sophongthue;
    public int Sophongcoc;
    public int Sophongtrong;
    public int Sosanhthue;
    public int Sosanhcoc;
    public int Sosanhtrong;
//    public JphongAction ActionPhong = new JphongAction() {
//    };
//    public JsanhAction ActionSanh = new JsanhAction() {
//    };

    private RoleService roleService = null;
//    public void reset(Component[] component){
//            for(int i=0; i<component.length; i++)
//            {
//                if (component[i] instanceof JPanel){
//                    this.reset(((JPanel)component[i]).getComponents());
//                }
//                else{
//                    component[i].setEnabled(false);
//                }
//            }
//    }

    public void setJTableRole() {
        DefaultTableModel table = (DefaultTableModel) jTableRole.getModel();
        int row = table.getRowCount();
        for (int i = row - 1; i >= 0; i--) {
            table.removeRow(i);
        }
        for (RoleDto dto : roleService.getAll()) {
            table.addRow(new Object[]{dto.getId(), dto.getName(), dto.getDescription()});
        }

    }

    public Home() {
        initComponents();
        roleService = new RoleService();
        setJTableRole();
//        this.jTabbedPane4.setVisible(false);
//        Component[] component = Lap_phieu.getComponents();
//
//        // Reset user interface
//        for(int i=0; i<component.length; i++)
//        {
//            this.reset(component[i].getComponents());
////            if (component[i] instanceof JPanel){
////                this.reset(((JPanel)component[i]).getComponents());
////            }
////            else{
////                component[i].setEnabled(false);
////            }
////            Component[] componentTemp = component[i].getComponents();
//
//        }

//        DecimalFormat decimalFormat = (DecimalFormat)
//        NumberFormat.getNumberInstance(new Locale("<em>vi</em>" , "VN"));
//        decimalFormat.applyPattern("###,###,###");
//        JButton phong[]={Jphong1, Jphong2, Jphong3, Jphong4, Jphong5, Jphong6, Jphong7, Jphong8, Jphong9, Jphong10, 
//                         Jphong11, Jphong12, Jphong13, Jphong14, Jphong15, Jphong16, Jphong17, Jphong18, Jphong19, Jphong20, 
//                         Jphong21, Jphong22, Jphong23, Jphong24, Jphong25, Jphong26, Jphong27, Jphong28, Jphong29, Jphong30, 
//                         Jphong31, Jphong32, Jphong33, Jphong34, Jphong35, Jphong36, Jphong37, Jphong38, Jphong39, Jphong40, 
//                         Jphong41, Jphong42, Jphong43, Jphong44, Jphong45, Jphong46, Jphong47, Jphong48, Jphong49, Jphong50};
//        System.arraycopy(phong, 0, Jphong, 0, 50);
//        JButton sanh[]={SanhA, SanhB, SanhC, SanhD, SanhE, SanhF};
//        System.arraycopy(sanh, 0, Jsanh, 0, 6);
//        
//        SetTinhTrangPhongDefault();
//        SetMauPhong("tat ca","tat ca");
//        //SetSoPhong();
//        //SetTinhTrangPhongDateToDate("28/6/2019 14:00","2/7/2019 12:00");
//        for(int i=0; i<50;i++){
//        //    System.out.print(Tinhtrangphong[i]+" ");
//            if (!Tinhtrangphong[i].equals("")){
//                Jphong[i].addActionListener(ActionPhong);
//            }
//        }
//        
//        SetTinhTrangSanhDefault();
//        SetMauSanh("tat ca");
//        //SetSoSanh();
//        for(int i=0; i<6;i++){
//        //    System.out.print(Tinhtrangphong[i]+" ");
//            if (!Tinhtrangsanh[i].equals("")){
//                Jsanh[i].addActionListener(ActionSanh);
//            }
//        }
//        //ResultSet rs2 = conn.ExcuteQueryGetTable("Select* from SANH");
//        ResultSet rs3 = conn.ExcuteQueryGetTable("Select* from DICH_VU");
//        ResultSet rs4 = conn.ExcuteQueryGetTable("Select* from LOAI_PHONG");
//        ResultSet rs5 = conn.ExcuteQueryGetTable("Select* from THUC_DON");
//        DefaultComboBoxModel box1 = new DefaultComboBoxModel();
//        DefaultTableModel table2 = (DefaultTableModel) Tablegiadichvu.getModel();
//        int templ=0;
//        try {
//            while(rs3.next()){
//                String MADV = rs3.getString("MADV");
//                String TENDV = rs3.getString("TENDV");
//                box1.addElement(MADV+" - "+TENDV);
//                table2.addRow(new Object[]{templ++,rs3.getString("MADV"),
//                                            rs3.getString("TENDV"),rs3.getString("DVT"),decimalFormat.format(rs3.getInt("GIA"))});
//                
//            }
//            ComboBoxtendv.setModel(box1);
//        } catch (SQLException ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        DefaultTableModel table1 = (DefaultTableModel) Tablegiaphong.getModel();
//        DefaultComboBoxModel box2 = new DefaultComboBoxModel();
//        DefaultComboBoxModel box4 = new DefaultComboBoxModel();
//        int temp=1;
//        box4.addElement("Tất cả");
//        try {
//            while (rs4.next()){
//                table1.addRow(new Object[]{temp++,rs4.getString("MALP"),
//                                            rs4.getString("LOAI"),decimalFormat.format(rs4.getInt("GIA"))});
//                String MALP = rs4.getString("MALP");
//                box2.addElement(MALP);
//                box4.addElement(MALP);
//            }
//            ComboBoxloaiphong.setModel(box2);
//            
//            ComboBoxloai.setModel(box4);
//        } catch (SQLException ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        temp=1;
//        DefaultTableModel table3 = (DefaultTableModel) Tablegiathucdon.getModel();
//        DefaultComboBoxModel box3 = new DefaultComboBoxModel();
//        try {
//            while (rs5.next()){
//                table3.addRow(new Object[]{temp++,rs5.getString("MATD"),
//                                            rs5.getString("TEN"),decimalFormat.format(rs5.getInt("GIA"))});
//                String MATD = rs5.getString("MATD");
//                box3.addElement(MATD);
//            }
//            ComboBoxthucdon.setModel(box3);
//        } catch (SQLException ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        DefaultComboBoxModel box5 = new DefaultComboBoxModel();
//        ResultSet rs6 = conn.ExcuteQueryGetTable("Select* from NUOC_UONG");
//        try {
//            while(rs6.next()){
//            box5.addElement(rs6.getString("MANUOC"));    
//            }
//            ComboBoxnuoc.setModel(box5);
//        } catch (SQLException ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public Home(String HOTEN, String MA) {
        initComponents();
        HOTEN_NV = HOTEN;
        MANV = MA;
        LabelUser.setText(HOTEN_NV);
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(new Locale("<em>vi</em>", "VN"));
        decimalFormat.applyPattern("###,###,###");
//        JButton phong[]={Jphong1, Jphong2, Jphong3, Jphong4, Jphong5, Jphong6, Jphong7, Jphong8, Jphong9, Jphong10, 
//                         Jphong11, Jphong12, Jphong13, Jphong14, Jphong15, Jphong16, Jphong17, Jphong18, Jphong19, Jphong20, 
//                         Jphong21, Jphong22, Jphong23, Jphong24, Jphong25, Jphong26, Jphong27, Jphong28, Jphong29, Jphong30, 
//                         Jphong31, Jphong32, Jphong33, Jphong34, Jphong35, Jphong36, Jphong37, Jphong38, Jphong39, Jphong40, 
//                         Jphong41, Jphong42, Jphong43, Jphong44, Jphong45, Jphong46, Jphong47, Jphong48, Jphong49, Jphong50};
//        System.arraycopy(phong, 0, Jphong, 0, 50);
//        JButton sanh[]={SanhA, SanhB, SanhC, SanhD, SanhE, SanhF};
//        System.arraycopy(sanh, 0, Jsanh, 0, 6);
//        
//        SetTinhTrangPhongDefault();
//        SetMauPhong("tat ca","tat ca");
//        //SetTinhTrangPhongDateToDate("28/6/2019 14:00","2/7/2019 12:00");
//        for(int i=0; i<50;i++){
//        //    System.out.print(Tinhtrangphong[i]+" ");
//            if (!Tinhtrangphong[i].equals("")){
//                Jphong[i].addActionListener(ActionPhong);
//            }
//        }
//        
//        SetTinhTrangSanhDefault();
//        SetMauSanh("tat ca");
//        for(int i=0; i<6;i++){
//        //    System.out.print(Tinhtrangphong[i]+" ");
//            if (!Tinhtrangsanh[i].equals("")){
//                Jsanh[i].addActionListener(ActionSanh);
//            }
//        }
//        //ResultSet rs2 = conn.ExcuteQueryGetTable("Select* from SANH");
//        ResultSet rs3 = conn.ExcuteQueryGetTable("Select* from DICH_VU");
//        ResultSet rs4 = conn.ExcuteQueryGetTable("Select* from LOAI_PHONG");
//        ResultSet rs5 = conn.ExcuteQueryGetTable("Select* from THUC_DON");
//        DefaultComboBoxModel box1 = new DefaultComboBoxModel();
//        DefaultTableModel table2 = (DefaultTableModel) Tablegiadichvu.getModel();
//        int templ=0;
//        try {
//            while(rs3.next()){
//                String MADV = rs3.getString("MADV");
//                String TENDV = rs3.getString("TENDV");
//                box1.addElement(MADV+" - "+TENDV);
//                table2.addRow(new Object[]{templ++,rs3.getString("MADV"),
//                                            rs3.getString("TENDV"),rs3.getString("DVT"),decimalFormat.format(rs3.getInt("GIA"))});
//                
//            }
//            ComboBoxtendv.setModel(box1);
//        } catch (SQLException ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        DefaultTableModel table1 = (DefaultTableModel) Tablegiaphong.getModel();
//        DefaultComboBoxModel box2 = new DefaultComboBoxModel();
//        DefaultComboBoxModel box4 = new DefaultComboBoxModel();
//        int temp=1;
//        box4.addElement("Tất cả");
//        try {
//            while (rs4.next()){
//                table1.addRow(new Object[]{temp++,rs4.getString("MALP"),
//                                            rs4.getString("LOAI"),decimalFormat.format(rs4.getInt("GIA"))});
//                String MALP = rs4.getString("MALP");
//                box2.addElement(MALP);
//                box4.addElement(MALP);
//            }
//            ComboBoxloaiphong.setModel(box2);
//            
//            ComboBoxloai.setModel(box4);
//        } catch (SQLException ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        temp=1;
//        DefaultTableModel table3 = (DefaultTableModel) Tablegiathucdon.getModel();
//        DefaultComboBoxModel box3 = new DefaultComboBoxModel();
//        try {
//            while (rs5.next()){
//                table3.addRow(new Object[]{temp++,rs5.getString("MATD"),
//                                            rs5.getString("TEN"),decimalFormat.format(rs5.getInt("GIA"))});
//                String MATD = rs5.getString("MATD");
//                box3.addElement(MATD);
//            }
//            ComboBoxthucdon.setModel(box3);
//        } catch (SQLException ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        DefaultComboBoxModel box5 = new DefaultComboBoxModel();
//        ResultSet rs6 = conn.ExcuteQueryGetTable("Select* from NUOC_UONG");
//        try {
//            while(rs6.next()){
//            box5.addElement(rs6.getString("MANUOC"));    
//            }
//            ComboBoxnuoc.setModel(box5);
//        } catch (SQLException ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public void SetTinhTrangPhongDefault() {
//        //Sophongthue=0;
//        //Sophongcoc=0;
//        //Sophongtrong=0;
//        Arrays.fill(Tinhtrangphong,"");
//        Arrays.fill(Madatphong,"");
//        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//        int i=0;
//        ResultSet rs = conn.ExcuteQueryGetTable("Select * from PHONG");
//        try {
//            while(rs.next()){
//                Tenphong[i]=rs.getString("SOPHONG");
//                Maloaiphong[i]=rs.getString("MALP");
//                i++;
//            }
//            rs.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        ResultSet rs1 = conn.ExcuteQueryGetTable("Select* from PHONG where TINHTRANG not in(select TINHTRANG from PHONG where TINHTRANG='sua')");
//        try {
//            while(rs1.next()){
//                String SOPHONG = rs1.getString("SOPHONG");
//                for(int index=0;index<50;index++){
//                    if (Tenphong[index].equals(SOPHONG)){
//                        i=index;
//                    }
//                }
//                boolean check_1= false;
//                try (ResultSet rs2 = conn.ExcuteQueryGetTable("Select* from DAT_PHONG where SOPHONG='"+SOPHONG+"'")) {
//                    while(rs2.next()){
//                        String NGAYTHUE = dateFormat.format(rs2.getDate("NGAYTHUE"));
//                        String NGAYTRA = dateFormat.format(rs2.getDate("NGAYTRA"));
//                        check_1 = true;
//                        boolean check_2= false;
//                        try (ResultSet rs3 = conn.ExcuteQueryGetTable("Select* from DAT_PHONG where SOPHONG='"+SOPHONG+"' "
//                                + "and NGAYTHUE<=SYSDATE and NGAYTRA>=SYSDATE ")) {
//                            while(rs3.next()){
//                                String MADAT= rs3.getString("MADAT");
//                                check_2=true;
//                                boolean check_3= false;
//                                try (ResultSet rs4 = conn.ExcuteQueryGetTable("Select* from HOA_DON where MADAT='"+MADAT+"'")) {
//                                    while(rs4.next()){
//                                        check_3=true;
//                                        if (rs4.getString("TINHTRANG").equals("chua thanh toan")){
//                                            conn.ExcuteQueryUpdateDB("Update PHONG set PHONG.TINHTRANG='thue' where SOPHONG='"+SOPHONG+"'");
//                                            Tinhtrangphong[i]="thue";
//                                            Madatphong[i]=MADAT;
//                                           // Sophongthue++;
//                                            //Phongthue.setText(String.valueOf(Sophongthue));
//                                        }
//                                        else if (rs4.getString("TINHTRANG").equals("da thanh toan")){
//                                            conn.ExcuteQueryUpdateDB("Update PHONG set PHONG.TINHTRANG='trong' where SOPHONG='"+SOPHONG+"'");
//                                            Tinhtrangphong[i]="trong";
//                                            //Sophongtrong++;
//                                            //Phongtrong.setText(String.valueOf(Sophongtrong));
//                                        }
//                                    }
//                                }
//                                if(check_3==false){
//                                    conn.ExcuteQueryUpdateDB("Update PHONG set PHONG.TINHTRANG='coc' where SOPHONG='"+SOPHONG+"'");
//                                    Tinhtrangphong[i]="coc";
//                                    Madatphong[i]=MADAT;
//                                    //Sophongcoc++;
//                                   // Phongcoc.setText(String.valueOf(Sophongcoc));
//                                }
//                            }
//                        }
//                        if(check_2==false){
//                            boolean check_4=false;
//                            ResultSet rs5 = conn.ExcuteQueryGetTable("Select* from DAT_PHONG where SOPHONG='"+SOPHONG+"' "
//                                    + "and to_date(TO_CHAR(NGAYTHUE, 'DD/MM/YYYY')||'00:00','DD/MM/YYYY HH24:MI')<=SYSDATE and NGAYTHUE>=SYSDATE");
//                            while(rs5.next()){
//                                conn.ExcuteQueryUpdateDB("Update PHONG set PHONG.TINHTRANG='coc' where SOPHONG='"+SOPHONG+"'");
//                                Tinhtrangphong[i]="coc";
//                                Madatphong[i]=rs5.getString("MADAT");
//                                check_4 = true;
//                                //Sophongcoc++;
//                                //Phongcoc.setText(String.valueOf(Sophongcoc));
//                            }
//                            if (check_4==false){
//                                conn.ExcuteQueryUpdateDB("Update PHONG set PHONG.TINHTRANG='trong' where SOPHONG='"+SOPHONG+"'");
//                                Tinhtrangphong[i]="trong";
//                                //Sophongtrong++;
//                                //Phongtrong.setText(String.valueOf(Sophongtrong));
//                            }
//                        }
//                    }
//                }
//                if(check_1==false){
//                    conn.ExcuteQueryUpdateDB("Update PHONG set PHONG.TINHTRANG='trong' where SOPHONG='"+SOPHONG+"'");
//                    Tinhtrangphong[i]="trong";
//                    //Sophongtrong++;
//                    //Phongtrong.setText(String.valueOf(Sophongtrong));
//                }
//            }
//            rs1.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        SetSoPhong();
    }

    public void SetMauPhong(String TTP, String L) {
//            for(int i=0; i<50;i++){
//                String SOPHONG = Tenphong[i];
//                String TINHTRANG = Tinhtrangphong[i];
//                String LOAI = Maloaiphong[i];
//                //System.out.println(i+" "+TINHTRANG);
//                Jphong[i].setText(SOPHONG);
//                if(L.equals(LOAI)){
//                    switch (TTP){
//                        case "tat ca":               
//                            switch (TINHTRANG) {
//                                case "thue":
//                                    Jphong[i].setOpaque(true);
//                                    Jphong[i].setBorderPainted(false);
//                                    Jphong[i].setBackground(new Color(255,0,0));
//                                    //Sophongthue++;
//                                    //Phongthue.setText(String.valueOf(Sophongthue));
//                                    break;
//                                case "trong":
//                                    Jphong[i].setOpaque(true);
//                                    Jphong[i].setBorderPainted(false);
//                                    Jphong[i].setBackground(new Color(0,204,102));
//                                    //Sophongtrong++;
//                                    //Phongtrong.setText(String.valueOf(Sophongtrong));
//                                    break;
//                                case "coc":
//                                    Jphong[i].setOpaque(true);
//                                    Jphong[i].setBorderPainted(false);
//                                    Jphong[i].setBackground(new Color(0,153,255));
//                                    //Sophongcoc++;
//                                    //Phongcoc.setText(String.valueOf(Sophongcoc));
//                                    break;
//                                default:
//                                    Jphong[i].setOpaque(true);
//                                    Jphong[i].setBorderPainted(false);
//                                    Jphong[i].setBackground(new Color(240,240,240));
//                                    Jphong[i].setText("");
//                                    break;
//                            }
//                            break;
//                        case "thue":
//                            switch (TINHTRANG) {
//                                case "thue":
//                                    Jphong[i].setOpaque(true);
//                                    Jphong[i].setBorderPainted(false);
//                                    Jphong[i].setBackground(new Color(255,0,0));
//                                    //Sophongthue++;
//                                    //Phongthue.setText(String.valueOf(Sophongthue));
//                                    break;
//                                default:
//                                    Jphong[i].setOpaque(true);
//                                    Jphong[i].setBorderPainted(false);
//                                    Jphong[i].setBackground(new Color(240,240,240));
//                                    Jphong[i].setText("");
//                                    break;
//                            }
//                            break;
//                        case "coc":
//                            switch (TINHTRANG) {                            
//                                case "coc":
//                                    Jphong[i].setOpaque(true);
//                                    Jphong[i].setBorderPainted(false);
//                                    Jphong[i].setBackground(new Color(0,153,255));
//                                    //Sophongcoc++;
//                                    //Phongcoc.setText(String.valueOf(Sophongcoc));
//                                    break;
//                                default:
//                                    Jphong[i].setOpaque(true);
//                                    Jphong[i].setBorderPainted(false);
//                                    Jphong[i].setBackground(new Color(240,240,240));
//                                    Jphong[i].setText("");
//                                    break;
//                            }
//                            break;
//                        case "trong":
//                            switch (TINHTRANG) {                           
//                                case "trong":
//                                    Jphong[i].setOpaque(true);
//                                    Jphong[i].setBorderPainted(false);
//                                    Jphong[i].setBackground(new Color(0,204,102));
//                                    //Sophongtrong++;
//                                    //Phongtrong.setText(String.valueOf(Sophongtrong));
//                                    break;
//                                default:
//                                    Jphong[i].setOpaque(true);
//                                    Jphong[i].setBorderPainted(false);
//                                    Jphong[i].setBackground(new Color(240,240,240));
//                                    Jphong[i].setText("");
//                                    break;
//                            }
//                            break;
//
//                    }
//                }
//                else if(L.equals("tat ca")){
//                    switch (TTP){
//                        case "tat ca":               
//                            switch (TINHTRANG) {
//                                case "thue":
//                                    Jphong[i].setOpaque(true);
//                                    Jphong[i].setBorderPainted(false);
//                                    Jphong[i].setBackground(new Color(255,0,0));
//                                    //Sophongthue++;
//                                    //Phongthue.setText(String.valueOf(Sophongthue));
//                                    break;
//                                case "trong":
//                                    Jphong[i].setOpaque(true);
//                                    Jphong[i].setBorderPainted(false);
//                                    Jphong[i].setBackground(new Color(0,204,102));
//                                    //Sophongtrong++;
//                                    //Phongtrong.setText(String.valueOf(Sophongtrong));
//                                    break;
//                                case "coc":
//                                    Jphong[i].setOpaque(true);
//                                    Jphong[i].setBorderPainted(false);
//                                    Jphong[i].setBackground(new Color(0,153,255));
//                                    //Sophongcoc++;
//                                    //Phongcoc.setText(String.valueOf(Sophongcoc));
//                                    break;
//                                default:
//                                    Jphong[i].setOpaque(true);
//                                    Jphong[i].setBorderPainted(false);
//                                    Jphong[i].setBackground(new Color(240,240,240));
//                                    Jphong[i].setText("");
//                                    break;
//                            }
//                            break;
//                        case "thue":
//                            switch (TINHTRANG) {
//                                case "thue":
//                                    Jphong[i].setOpaque(true);
//                                    Jphong[i].setBorderPainted(false);
//                                    Jphong[i].setBackground(new Color(255,0,0));
//                                    //Sophongthue++;
//                                    //Phongthue.setText(String.valueOf(Sophongthue));
//                                    break;
//                                default:
//                                    Jphong[i].setOpaque(true);
//                                    Jphong[i].setBorderPainted(false);
//                                    Jphong[i].setBackground(new Color(240,240,240));
//                                    Jphong[i].setText("");
//                                    break;
//                            }
//                            break;
//                        case "coc":
//                            switch (TINHTRANG) {                            
//                                case "coc":
//                                    Jphong[i].setOpaque(true);
//                                    Jphong[i].setBorderPainted(false);
//                                    Jphong[i].setBackground(new Color(0,153,255));
//                                    //Sophongcoc++;
//                                    //Phongcoc.setText(String.valueOf(Sophongcoc));
//                                    break;
//                                default:
//                                    Jphong[i].setOpaque(true);
//                                    Jphong[i].setBorderPainted(false);
//                                    Jphong[i].setBackground(new Color(240,240,240));
//                                    Jphong[i].setText("");
//                                    break;
//                            }
//                            break;
//                        case "trong":
//                            switch (TINHTRANG) {                           
//                                case "trong":
//                                    Jphong[i].setOpaque(true);
//                                    Jphong[i].setBorderPainted(false);
//                                    Jphong[i].setBackground(new Color(0,204,102));
//                                    //Sophongtrong++;
//                                    //Phongtrong.setText(String.valueOf(Sophongtrong));
//                                    break;
//                                default:
//                                    Jphong[i].setOpaque(true);
//                                    Jphong[i].setBorderPainted(false);
//                                    Jphong[i].setBackground(new Color(240,240,240));
//                                    Jphong[i].setText("");
//                                    break;
//                            }
//                            break;
//
//                    }
//                }
//                else{
//                    Jphong[i].setOpaque(true);
//                    Jphong[i].setBorderPainted(false);
//                    Jphong[i].setBackground(new Color(240,240,240));
//                    Jphong[i].setText("");
//                }
//            }
    }

    public void SetTinhTrangPhongDateToDate(String DateIn, String DateOut) {
//        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//        DateIn = DateIn+" 14:00";
//        DateOut = DateOut+" 12:00";
//        int i=0;
//        Arrays.fill(Tinhtrangphong, "");
//        Arrays.fill(Madatphong, "");
//        ResultSet rs1 = conn.ExcuteQueryGetTable("Select* from PHONG where TINHTRANG not in(select TINHTRANG from PHONG where TINHTRANG='sua')");
//        try {
//            while(rs1.next()){
//                String SOPHONG = rs1.getString("SOPHONG");
//                for(int index=0;index<50;index++){
//                    if (Tenphong[index].equals(SOPHONG)){
//                        i=index;
//                    }
//                }
//                boolean check_1= false;
//                try (ResultSet rs2 = conn.ExcuteQueryGetTable("Select* from DAT_PHONG where SOPHONG='"+SOPHONG+"'")) {
//                    while(rs2.next()){
//                        String NGAYTHUE = dateFormat.format(rs2.getDate("NGAYTHUE"));
//                        String NGAYTRA = dateFormat.format(rs2.getDate("NGAYTRA"));
//                        check_1 = true;
//                        boolean check_2= false;
//                        try (ResultSet rs3 = conn.ExcuteQueryGetTable("Select* from DAT_PHONG where SOPHONG='"+SOPHONG+"' "
//                                + "and ((to_date('"+DateIn+"','DD/MM/YYYY HH24:MI')<=to_date('"+NGAYTHUE+"','DD/MM/YYYY HH24:MI')"
//                                        + " and to_date('"+NGAYTHUE+"','DD/MM/YYYY HH24:MI')<to_date('"+DateOut+"','DD/MM/YYYY HH24:MI'))"
//                                                + " or (to_date('"+DateIn+"','DD/MM/YYYY HH24:MI')<to_date('"+NGAYTRA+"','DD/MM/YYYY HH24:MI')"
//                                                        + " and to_date('"+NGAYTRA+"','DD/MM/YYYY HH24:MI')<=to_date('"+DateOut+"','DD/MM/YYYY HH24:MI')))")) {
//                            while(rs3.next()){
//                                String MADAT= rs3.getString("MADAT");
//                                check_2=true;
//                                boolean check_3= false;
//                                try (ResultSet rs4 = conn.ExcuteQueryGetTable("Select* from HOA_DON where MADAT='"+MADAT+"'")) {
//                                    while(rs4.next()){
//                                        check_3=true;
//                                        if (rs4.getString("TINHTRANG").equals("chua thanh toan")){
//                                            //conn.ExcuteQueryUpdateDB("Update PHONG set PHONG.TINHTRANG='thue' where SOPHONG='"+SOPHONG+"'");
//                                            Tinhtrangphong[i]="thue";
//                                            Madatphong[i]=MADAT;
//                                        }
//                                        else if (rs4.getString("TINHTRANG").equals("da thanh toan")){
//                                            //conn.ExcuteQueryUpdateDB("Update PHONG set PHONG.TINHTRANG='trong' where SOPHONG='"+SOPHONG+"'");
//                                            Tinhtrangphong[i]="trong";
//                                        }
//                                    }
//                                    rs4.close();
//                                }
//                                if(check_3==false){
//                                    // conn.ExcuteQueryUpdateDB("Update PHONG set PHONG.TINHTRANG='coc' where SOPHONG='"+SOPHONG+"'");
//                                    Tinhtrangphong[i]="coc";
//                                    Madatphong[i]=MADAT;
//                                }
//                            }
//                            rs3.close();
//                        }
//                        if(check_2==false){
//                            // conn.ExcuteQueryUpdateDB("Update PHONG set PHONG.TINHTRANG='trong' where SOPHONG='"+SOPHONG+"'");
//                            Tinhtrangphong[i]="trong";
//                        }
//                    }
//                    rs2.close();
//                }
//                if(check_1==false){
//                    //conn.ExcuteQueryUpdateDB("Update PHONG set PHONG.TINHTRANG='trong' where SOPHONG='"+SOPHONG+"'");
//                    Tinhtrangphong[i]="trong";
//                }
//            }
//            rs1.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
//    

    public void SetSoSanh() {
//        Sosanhthue=0;
//        Sosanhcoc=0;
//        Sosanhtrong=0;
//        Sanhthue.setText(String.valueOf(Sosanhthue));
//        Sanhtrong.setText(String.valueOf(Sosanhtrong));
//        Sanhcoc.setText(String.valueOf(Sosanhcoc));
//        for(int i=0;i<50;i++){
//         switch(Tinhtrangsanh[i]){
//            case "thue":
//                Sosanhthue++;
//                Sanhthue.setText(String.valueOf(Sosanhthue));
//                break;
//            case "trong": 
//                Sosanhtrong++;
//                Sanhtrong.setText(String.valueOf(Sosanhtrong));
//                break;
//            case "coc":
//                Sosanhcoc++;
//                Sanhcoc.setText(String.valueOf(Sosanhcoc));
//        }
//    }
    }
//    

    public void SetSoPhong() {
//        Sophongthue=0;
//        Sophongcoc=0;
//        Sophongtrong=0;
//        Phongthue.setText(String.valueOf(Sophongthue));
//        Phongtrong.setText(String.valueOf(Sophongtrong));
//        Phongcoc.setText(String.valueOf(Sophongcoc));       
//        for(int i=0;i<50;i++){
//            System.out.print(Tinhtrangphong[i]+" ");
//         switch(Tinhtrangphong[i]){
//            case "thue":
//                Sophongthue++;
//                Phongthue.setText(String.valueOf(Sophongthue));
//                break;
//            case "trong": 
//                Sophongtrong++;
//                Phongtrong.setText(String.valueOf(Sophongtrong));
//                break;
//            case "coc":
//                Sophongcoc++;
//                Phongcoc.setText(String.valueOf(Sophongcoc));
//                break;
//        }
//    }
    }
//    

    public void SetTinhTrangSanhDefault() {
//        //=0;
//        //Sosanhcoc=0;
//        //Sosanhtrong=0;
//        Arrays.fill(Tinhtrangsanh,"");
//        Arrays.fill(Madattiec,"");
//        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        int i=0;
//        ResultSet rs = conn.ExcuteQueryGetTable("Select * from SANH");
//        try {
//            while(rs.next()){
//                Tensanh[i]=rs.getString("TENSANH");
//                Maloaisanh[i]=rs.getString("MASANH");
//                i++;
//            }
//            rs.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        ResultSet rs1 = conn.ExcuteQueryGetTable("Select* from SANH where TINHTRANG not in(select TINHTRANG from SANH where TINHTRANG='sua')");
//        try {
//            while(rs1.next()){
//                String MASANH = rs1.getString("MASANH");
//                for(int index=0;index<6;index++){
//                    if (Maloaisanh[index].equals(MASANH)){
//                        i=index;
//                    }
//                }
//                boolean check_1= false;
//                try (ResultSet rs2 = conn.ExcuteQueryGetTable("Select* from DAT_TIEC where MASANH='"+MASANH+"'")) {
//                    while(rs2.next()){
//                        
//                        //String NGAYTRA = dateFormat.format(rs2.getDate("NGAYTRA"));
//                        check_1 = true;
//                        boolean check_2= false;
//                        try (ResultSet rs3 = conn.ExcuteQueryGetTable("Select* from DAT_TIEC where MASANH='"+MASANH+"' "
//                                + "and to_date(TGDIENRA,'DD/MM/YYYY')=to_date(SYSDATE,'DD/MM/YYYY')")) {
//                            while(rs3.next()){
//                                String TGDIENRA = dateFormat.format(rs3.getDate("TGDIENRA"));
//                                //System.out.println(TGDIENRA);
//                                String SOTIEC= rs3.getString("SOTIEC");
//                                check_2=true;
//                                boolean check_3= false;
//                                try (ResultSet rs4 = conn.ExcuteQueryGetTable("Select* from HD_TIEC where SOTIEC='"+SOTIEC+"'")) {
//                                    while(rs4.next()){
//                                        check_3=true;
//                                        if (rs4.getString("TINHTRANG").equals("chua thanh toan")){
//                                            conn.ExcuteQueryUpdateDB("Update SANH set SANH.TINHTRANG='thue' where MASANH='"+MASANH+"'");
//                                            Tinhtrangsanh[i]="thue";
//                                            Madattiec[i]=SOTIEC;
//                                            
//                                            //System.out.println("thue1");
//                                        }
//                                        else if (rs4.getString("TINHTRANG").equals("da thanh toan")){
//                                            conn.ExcuteQueryUpdateDB("Update SANH set SANH.TINHTRANG='trong' where MASANH='"+MASANH+"'");
//                                            Tinhtrangsanh[i]="trong";
//                                            
//                                              //System.out.println("trong2");
//                                        }
//                                    }
//                                }
//                                if(check_3==false){
//                                    conn.ExcuteQueryUpdateDB("Update SANH set SANH.TINHTRANG='coc' where MASANH='"+MASANH+"'");
//                                    Tinhtrangsanh[i]="coc";
//                                    Madattiec[i]=SOTIEC;
//                                    
//                                    //System.out.println("coc3");
//                                }
//                            }
//                        }
//                        if(check_2==false){
//                            /*boolean check_4=false;
//                            ResultSet rs5 = conn.ExcuteQueryGetTable("Select* from DAT_PHONG where SOPHONG='"+SOPHONG+"' "
//                                    + "and to_date('"+NGAYTHUE.substring(0,9)+" 00:00','DD/MM/YYYY HH24:MI')<=SYSDATE and to_date('"+NGAYTHUE+"','DD/MM/YYYY HH24:MI')>=SYSDATE ");
//                            while(rs5.next()){
//                                conn.ExcuteQueryUpdateDB("Update PHONG set PHONG.TINHTRANG='coc' where SOPHONG='"+SOPHONG+"'");
//                                Tinhtrangphong[i]="coc";
//                                Madatphong[i]=rs5.getString("MADAT");
//                                check_4 = true;
//                                Sophongcoc++;
//                                Phongcoc.setText(String.valueOf(Sophongcoc));
//                            }*/
//                            //if (check_4==false){
//                                conn.ExcuteQueryUpdateDB("Update SANH set SANH.TINHTRANG='trong' where MASANH='"+MASANH+"'");
//                                Tinhtrangsanh[i]="trong";
//                               
//                                  //System.out.println("trong4");
//                           //}
//                        }
//                    }
//                }
//                if(check_1==false){
//                    conn.ExcuteQueryUpdateDB("Update SANH set SANH.TINHTRANG='trong' where MASANH='"+MASANH+"'");
//                    Tinhtrangsanh[i]="trong";
//                    
//                      //System.out.println("trong5");
//                }
//            }
//            rs1.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        SetSoSanh();
    }
//    

    public void SetMauSanh(String TTS) {
//        for(int i=0; i<6;i++){
//                String TENSANH = Maloaisanh[i];
//                String TINHTRANG = Tinhtrangsanh[i];
//                //String MASANH= Maloaiphong[i];
//                //System.out.println(i+" "+TINHTRANG);
//                Jsanh[i].setText(TENSANH);
//                    switch (TTS){
//                        case "tat ca":               
//                            switch (TINHTRANG) {
//                                case "thue":
//                                    Jsanh[i].setOpaque(true);
//                                    Jsanh[i].setBorderPainted(false);
//                                    Jsanh[i].setBackground(new Color(255,0,0));
//                                    //Sophongthue++;
//                                    //Phongthue.setText(String.valueOf(Sophongthue));
//                                    break;
//                                case "trong":
//                                    Jsanh[i].setOpaque(true);
//                                    Jsanh[i].setBorderPainted(false);
//                                    Jsanh[i].setBackground(new Color(0,204,102));
//                                    //Sophongtrong++;
//                                    //Phongtrong.setText(String.valueOf(Sophongtrong));
//                                    break;
//                                case "coc":
//                                    Jsanh[i].setOpaque(true);
//                                    Jsanh[i].setBorderPainted(false);
//                                    Jsanh[i].setBackground(new Color(0,153,255));
//                                    //Sophongcoc++;
//                                    //Phongcoc.setText(String.valueOf(Sophongcoc));
//                                    break;
//                                default:
//                                    Jsanh[i].setOpaque(true);
//                                    Jsanh[i].setBorderPainted(false);
//                                    Jsanh[i].setBackground(new Color(240,240,240));
//                                    Jsanh[i].setText("");
//                                    break;
//                            }
//                            break;
//                        case "thue":
//                            switch (TINHTRANG) {
//                                case "thue":
//                                    Jsanh[i].setOpaque(true);
//                                    Jsanh[i].setBorderPainted(false);
//                                    Jsanh[i].setBackground(new Color(255,0,0));
//                                    //Sophongthue++;
//                                    //Phongthue.setText(String.valueOf(Sophongthue));
//                                    break;
//                                default:
//                                    Jsanh[i].setOpaque(true);
//                                    Jsanh[i].setBorderPainted(false);
//                                    Jsanh[i].setBackground(new Color(240,240,240));
//                                    Jsanh[i].setText("");
//                                    break;
//                            }
//                            break;
//                        case "coc":
//                            switch (TINHTRANG) {                            
//                                case "coc":
//                                    Jsanh[i].setOpaque(true);
//                                    Jsanh[i].setBorderPainted(false);
//                                    Jsanh[i].setBackground(new Color(0,153,255));
//                                    //Sophongcoc++;
//                                    //Phongcoc.setText(String.valueOf(Sophongcoc));
//                                    break;
//                                default:
//                                    Jsanh[i].setOpaque(true);
//                                    Jsanh[i].setBorderPainted(false);
//                                    Jsanh[i].setBackground(new Color(240,240,240));
//                                    Jsanh[i].setText("");
//                                    break;
//                            }
//                            break;
//                        case "trong":
//                            switch (TINHTRANG) {                           
//                                case "trong":
//                                    Jsanh[i].setOpaque(true);
//                                    Jsanh[i].setBorderPainted(false);
//                                    Jsanh[i].setBackground(new Color(0,204,102));
//                                    //Sophongtrong++;
//                                    //Phongtrong.setText(String.valueOf(Sophongtrong));
//                                    break;
//                                default:
//                                    Jsanh[i].setOpaque(true);
//                                    Jsanh[i].setBorderPainted(false);
//                                    Jsanh[i].setBackground(new Color(240,240,240));
//                                    Jsanh[i].setText("");
//                                    break;
//                            }
//                            break;
//
//                    }
//        }
    }
//    

    public void SetTinhTrangSanhDate(String DateIn2) {
//        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        //DateIn = DateIn;
//        //DateOut = DateOut;
//        int i=0;
//         System.out.println(DateIn2);
//        Arrays.fill(Tinhtrangsanh, "");
//        Arrays.fill(Madattiec, "");
//        ResultSet rs1 = conn.ExcuteQueryGetTable("Select* from SANH where TINHTRANG not in(select TINHTRANG from SANH where TINHTRANG='sua')");
//        try {
//            while(rs1.next()){
//                String MASANH = rs1.getString("MASANH");
//                for(int index=0;index<6;index++){
//                    if (Maloaisanh[index].equals(MASANH)){
//                        i=index;
//                    }
//                }
//                boolean check_1= false;
//                try (ResultSet rs2 = conn.ExcuteQueryGetTable("Select* from DAT_TIEC where MASANH='"+MASANH+"'")) {
//                    while(rs2.next()){
//                        String TGDIENRA = dateFormat.format(rs2.getDate("TGDIENRA"));
//                        //String NGAYTRA = dateFormat.format(rs2.getDate("NGAYTRA"));
//                        //System.out.println(TGDIENRA+" "+rs2.getString("SOTIEC"));
//                        
//                        check_1 = true;
//                        boolean check_2= false;
//                        try (ResultSet rs3 = conn.ExcuteQueryGetTable("Select* from DAT_TIEC where MASANH='"+MASANH+"' "
//                                + "and to_date('"+DateIn2+"','DD/MM/YYYY')=to_date(TO_CHAR(TGDIENRA, 'DD/MM/YYYY'),'DD/MM/YYYY')")) {
//                            while(rs3.next()){
//                                String SOTIEC= rs3.getString("SOTIEC");
//                                System.out.print(SOTIEC);
//                                check_2=true;
//                                boolean check_3= false;
//                                try (ResultSet rs4 = conn.ExcuteQueryGetTable("Select* from HD_TIEC where SOTIEC='"+SOTIEC+"'")) {
//                                    while(rs4.next()){
//                                        check_3=true;
//                                        if (rs4.getString("TINHTRANG").equals("chua thanh toan")){
//                                            //conn.ExcuteQueryUpdateDB("Update PHONG set PHONG.TINHTRANG='thue' where SOPHONG='"+SOPHONG+"'");
//                                            Tinhtrangsanh[i]="thue";
//                                            Madattiec[i]=SOTIEC;
//                                           // System.out.println("thue1");
//                                        }
//                                        else if (rs4.getString("TINHTRANG").equals("da thanh toan")){
//                                            //conn.ExcuteQueryUpdateDB("Update PHONG set PHONG.TINHTRANG='trong' where SOPHONG='"+SOPHONG+"'");
//                                            Tinhtrangsanh[i]="trong";
//                                           // System.out.println("trong2");
//                                        }
//                                    }
//                                    rs4.close();
//                                }
//                                if(check_3==false){
//                                    // conn.ExcuteQueryUpdateDB("Update PHONG set PHONG.TINHTRANG='coc' where SOPHONG='"+SOPHONG+"'");
//                                    Tinhtrangsanh[i]="coc";
//                                    Madattiec[i]=SOTIEC;
//                                   // System.out.println("coc3");
//                                }
//                            }
//                            rs3.close();
//                        }
//                        if(check_2==false){
//                            // conn.ExcuteQueryUpdateDB("Update PHONG set PHONG.TINHTRANG='trong' where SOPHONG='"+SOPHONG+"'");
//                            Tinhtrangsanh[i]="trong";
//                            //System.out.println("trong4");
//                        }
//                    }
//                    rs2.close();
//                }
//                if(check_1==false){
//                    //conn.ExcuteQueryUpdateDB("Update PHONG set PHONG.TINHTRANG='trong' where SOPHONG='"+SOPHONG+"'");
//                    Tinhtrangsanh[i]="trong";
//                    // System.out.println("trong5");
//                }
//            }
//            rs1.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel17 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jPanel45 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        LabelUser = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        Sanhthue = new javax.swing.JTextField();
        Sanhcoc = new javax.swing.JTextField();
        Sanhtrong = new javax.swing.JTextField();
        jPanel48 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        Phongthue = new javax.swing.JTextField();
        Phongcoc = new javax.swing.JTextField();
        Phongtrong = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        Home = new javax.swing.JPanel();
        Lap_phieu = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel18 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        Madatlapphieu = new javax.swing.JTextField();
        Tracuulapphieu = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        Tablephieuthue = new javax.swing.JTable();
        LapPhieuThue = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        Madatlapdichvu = new javax.swing.JTextField();
        Tracuulapdichvu = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        Tablelapdichvu = new javax.swing.JTable();
        jPanel26 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        ComboBoxtendv = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        Soluongdv = new javax.swing.JTextField();
        Themdichvu = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        Tabledichvu = new javax.swing.JTable();
        Canceldichvu = new javax.swing.JButton();
        Deletedichvu = new javax.swing.JButton();
        Okdichvu = new javax.swing.JButton();
        Bang_gia = new javax.swing.JPanel();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel20 = new javax.swing.JPanel();
        jPanel49 = new javax.swing.JPanel();
        jScrollPane19 = new javax.swing.JScrollPane();
        Tablegiaphong = new javax.swing.JTable();
        jPanel50 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        ComboBoxloaiphong = new javax.swing.JComboBox<>();
        jScrollPane20 = new javax.swing.JScrollPane();
        Tablecoso = new javax.swing.JTable();
        jPanel21 = new javax.swing.JPanel();
        jPanel51 = new javax.swing.JPanel();
        jScrollPane22 = new javax.swing.JScrollPane();
        Tablegiadichvu = new javax.swing.JTable();
        QL_phong = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        Tang_tret = new javax.swing.JPanel();
        Jphong1 = new javax.swing.JButton();
        Jphong6 = new javax.swing.JButton();
        Jphong2 = new javax.swing.JButton();
        Jphong3 = new javax.swing.JButton();
        Jphong4 = new javax.swing.JButton();
        Jphong5 = new javax.swing.JButton();
        Jphong7 = new javax.swing.JButton();
        Jphong8 = new javax.swing.JButton();
        Jphong9 = new javax.swing.JButton();
        Jphong10 = new javax.swing.JButton();
        Tang_1 = new javax.swing.JPanel();
        Jphong11 = new javax.swing.JButton();
        Jphong12 = new javax.swing.JButton();
        Jphong13 = new javax.swing.JButton();
        Jphong14 = new javax.swing.JButton();
        Jphong15 = new javax.swing.JButton();
        Jphong16 = new javax.swing.JButton();
        Jphong17 = new javax.swing.JButton();
        Jphong18 = new javax.swing.JButton();
        Jphong19 = new javax.swing.JButton();
        Jphong20 = new javax.swing.JButton();
        Tang_2 = new javax.swing.JPanel();
        Jphong21 = new javax.swing.JButton();
        Jphong22 = new javax.swing.JButton();
        Jphong23 = new javax.swing.JButton();
        Jphong24 = new javax.swing.JButton();
        Jphong25 = new javax.swing.JButton();
        Jphong26 = new javax.swing.JButton();
        Jphong27 = new javax.swing.JButton();
        Jphong28 = new javax.swing.JButton();
        Jphong29 = new javax.swing.JButton();
        Jphong30 = new javax.swing.JButton();
        Tang_3 = new javax.swing.JPanel();
        Jphong31 = new javax.swing.JButton();
        Jphong32 = new javax.swing.JButton();
        Jphong33 = new javax.swing.JButton();
        Jphong34 = new javax.swing.JButton();
        Jphong35 = new javax.swing.JButton();
        Jphong36 = new javax.swing.JButton();
        Jphong37 = new javax.swing.JButton();
        Jphong38 = new javax.swing.JButton();
        Jphong39 = new javax.swing.JButton();
        Jphong40 = new javax.swing.JButton();
        Tang_4 = new javax.swing.JPanel();
        Jphong41 = new javax.swing.JButton();
        Jphong42 = new javax.swing.JButton();
        Jphong43 = new javax.swing.JButton();
        Jphong44 = new javax.swing.JButton();
        Jphong45 = new javax.swing.JButton();
        Jphong46 = new javax.swing.JButton();
        Jphong47 = new javax.swing.JButton();
        Jphong48 = new javax.swing.JButton();
        Jphong49 = new javax.swing.JButton();
        Jphong50 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        ComboBoxTinhtrangphong = new javax.swing.JComboBox<>();
        Tracuuphong = new javax.swing.JButton();
        DateIn = new com.toedter.calendar.JDateChooser();
        DateOut = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        ComboBoxloai = new javax.swing.JComboBox<>();
        LamMoi = new javax.swing.JButton();
        QL_khach = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabledangluutru = new javax.swing.JTable();
        jPanel16 = new javax.swing.JPanel();
        Textdangluutru = new javax.swing.JTextField();
        Hoten1 = new javax.swing.JCheckBox();
        CMND1 = new javax.swing.JCheckBox();
        Sophong1 = new javax.swing.JCheckBox();
        Timkiemdangluutru = new javax.swing.JButton();
        Lammoidangluutru = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        Texthoten1 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        Textsdt1 = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        Textsophong1 = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        Textcmnd1 = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        Okdangluutru = new javax.swing.JButton();
        Deletedangluutru = new javax.swing.JButton();
        Ngayden1 = new com.toedter.calendar.JDateChooser();
        Ngaydi1 = new com.toedter.calendar.JDateChooser();
        Ngaysinh1 = new com.toedter.calendar.JDateChooser();
        jPanel14 = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        Texthoten2 = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        Textsdt2 = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        Textsophong2 = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        Textcmnd2 = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        Ngaysinh2 = new javax.swing.JTextField();
        Ngayden2 = new javax.swing.JTextField();
        Ngaydi2 = new javax.swing.JTextField();
        jScrollPane16 = new javax.swing.JScrollPane();
        Tabledaluutru = new javax.swing.JTable();
        jPanel43 = new javax.swing.JPanel();
        Textdaluutru = new javax.swing.JTextField();
        Hoten2 = new javax.swing.JCheckBox();
        CMND2 = new javax.swing.JCheckBox();
        Sophong2 = new javax.swing.JCheckBox();
        Timkiemdaluutru = new javax.swing.JButton();
        Lammoidaluutru = new javax.swing.JButton();
        Nha_hang = new javax.swing.JPanel();
        jTabbedPane7 = new javax.swing.JTabbedPane();
        jPanel34 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        Madatphieutiec = new javax.swing.JTextField();
        Tracuuphieutiec = new javax.swing.JButton();
        LapPhieuTiec = new javax.swing.JButton();
        jScrollPane14 = new javax.swing.JScrollPane();
        Tablephieutiec = new javax.swing.JTable();
        jPanel28 = new javax.swing.JPanel();
        SanhA = new javax.swing.JButton();
        SanhB = new javax.swing.JButton();
        SanhC = new javax.swing.JButton();
        SanhD = new javax.swing.JButton();
        SanhE = new javax.swing.JButton();
        SanhF = new javax.swing.JButton();
        jLabel62 = new javax.swing.JLabel();
        DateIn2 = new com.toedter.calendar.JDateChooser();
        jLabel64 = new javax.swing.JLabel();
        ComboBoxtinhtrangsanh = new javax.swing.JComboBox<>();
        Tracuutiec = new javax.swing.JButton();
        Lammoitiec = new javax.swing.JButton();
        jPanel29 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        ComboBoxthucdon = new javax.swing.JComboBox<>();
        jScrollPane10 = new javax.swing.JScrollPane();
        Tablethucdon = new javax.swing.JTable();
        jPanel30 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        Tablegiathucdon = new javax.swing.JTable();
        DS_HD = new javax.swing.JPanel();
        jTabbedPane9 = new javax.swing.JTabbedPane();
        jTabbedPane6 = new javax.swing.JTabbedPane();
        jPanel23 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        Tablephonghientai = new javax.swing.JTable();
        jButton86 = new javax.swing.JButton();
        Thanhtoanphong = new javax.swing.JButton();
        jPanel52 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        Madatphonghientai = new javax.swing.JTextField();
        Lammoiphonghientai = new javax.swing.JButton();
        Timkiemhoadonhientai = new javax.swing.JButton();
        jPanel53 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        Hoten_1 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        MDP_1 = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        CMND_1 = new javax.swing.JTextField();
        jLabel76 = new javax.swing.JLabel();
        Sophong_1 = new javax.swing.JTextField();
        jLabel77 = new javax.swing.JLabel();
        SDT_1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableDV = new javax.swing.JTable();
        jLabel82 = new javax.swing.JLabel();
        Tongtien_1 = new javax.swing.JTextField();
        jLabel83 = new javax.swing.JLabel();
        Coc_1 = new javax.swing.JTextField();
        jLabel84 = new javax.swing.JLabel();
        Conlai_1 = new javax.swing.JTextField();
        jLabel85 = new javax.swing.JLabel();
        Tiennhan_1 = new javax.swing.JTextField();
        jLabel86 = new javax.swing.JLabel();
        Tienthua_1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        Ngayden_1 = new javax.swing.JTextField();
        jLabel128 = new javax.swing.JLabel();
        Ngaydi_1 = new javax.swing.JTextField();
        InPhong = new javax.swing.JButton();
        jPanel24 = new javax.swing.JPanel();
        jPanel54 = new javax.swing.JPanel();
        jLabel87 = new javax.swing.JLabel();
        Madatphongdathanhtoan = new javax.swing.JTextField();
        Lammoiphongdathanhtoan = new javax.swing.JButton();
        Timkiemphongdathanhtoan = new javax.swing.JButton();
        jScrollPane21 = new javax.swing.JScrollPane();
        Tablephongdathanhtoan = new javax.swing.JTable();
        jPanel61 = new javax.swing.JPanel();
        jLabel129 = new javax.swing.JLabel();
        Hoten_2 = new javax.swing.JTextField();
        jLabel130 = new javax.swing.JLabel();
        MDP_2 = new javax.swing.JTextField();
        jLabel131 = new javax.swing.JLabel();
        CMND_2 = new javax.swing.JTextField();
        jLabel132 = new javax.swing.JLabel();
        Sophong_2 = new javax.swing.JTextField();
        jLabel133 = new javax.swing.JLabel();
        SDT_2 = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        TableDV2 = new javax.swing.JTable();
        jLabel134 = new javax.swing.JLabel();
        Tongtien_2 = new javax.swing.JTextField();
        jLabel135 = new javax.swing.JLabel();
        Coc_2 = new javax.swing.JTextField();
        jLabel136 = new javax.swing.JLabel();
        Conlai_2 = new javax.swing.JTextField();
        jLabel137 = new javax.swing.JLabel();
        Tiennhan_2 = new javax.swing.JTextField();
        jLabel138 = new javax.swing.JLabel();
        Tienthua_2 = new javax.swing.JTextField();
        jLabel139 = new javax.swing.JLabel();
        Ngayden_2 = new javax.swing.JTextField();
        jLabel140 = new javax.swing.JLabel();
        Ngaydi_2 = new javax.swing.JTextField();
        InPhong1 = new javax.swing.JButton();
        jButton87 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Thang1 = new com.toedter.calendar.JMonthChooser();
        jLabel2 = new javax.swing.JLabel();
        Nam1 = new com.toedter.calendar.JYearChooser();
        jButton53 = new javax.swing.JButton();
        Thongkephong = new javax.swing.JButton();
        jTabbedPane10 = new javax.swing.JTabbedPane();
        jPanel25 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        Tabletiechientai = new javax.swing.JTable();
        jButton90 = new javax.swing.JButton();
        Thanhtoantiec = new javax.swing.JButton();
        jPanel56 = new javax.swing.JPanel();
        jLabel95 = new javax.swing.JLabel();
        Madattiechientai = new javax.swing.JTextField();
        Lammoitiechientai = new javax.swing.JButton();
        Timkiemtiechientai = new javax.swing.JButton();
        jPanel57 = new javax.swing.JPanel();
        jLabel96 = new javax.swing.JLabel();
        Hoten_3 = new javax.swing.JTextField();
        jLabel102 = new javax.swing.JLabel();
        MDT_3 = new javax.swing.JTextField();
        jLabel103 = new javax.swing.JLabel();
        CMND_3 = new javax.swing.JTextField();
        jLabel104 = new javax.swing.JLabel();
        Masanh_3 = new javax.swing.JTextField();
        jLabel105 = new javax.swing.JLabel();
        SDT_3 = new javax.swing.JTextField();
        jLabel106 = new javax.swing.JLabel();
        MaTD_3 = new javax.swing.JTextField();
        jLabel107 = new javax.swing.JLabel();
        Soban_3 = new javax.swing.JTextField();
        jLabel108 = new javax.swing.JLabel();
        ComboBoxnuoc = new javax.swing.JComboBox<>();
        jLabel109 = new javax.swing.JLabel();
        Soluong_3 = new javax.swing.JTextField();
        Themnuoc = new javax.swing.JButton();
        Xoanuoc = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        Tablenuoc_3 = new javax.swing.JTable();
        jLabel110 = new javax.swing.JLabel();
        Tongtien_3 = new javax.swing.JTextField();
        jLabel111 = new javax.swing.JLabel();
        Coc_3 = new javax.swing.JTextField();
        jLabel112 = new javax.swing.JLabel();
        Conlai_3 = new javax.swing.JTextField();
        jLabel113 = new javax.swing.JLabel();
        Tiennhan_3 = new javax.swing.JTextField();
        jLabel114 = new javax.swing.JLabel();
        Tienthua_3 = new javax.swing.JTextField();
        InTiec = new javax.swing.JButton();
        jPanel58 = new javax.swing.JPanel();
        jPanel59 = new javax.swing.JPanel();
        jLabel115 = new javax.swing.JLabel();
        Madattiecdathanhtoan = new javax.swing.JTextField();
        Lammoitiecdathanhtoan = new javax.swing.JButton();
        Timkiemtiecdathanhtoan = new javax.swing.JButton();
        jScrollPane23 = new javax.swing.JScrollPane();
        Tabletiecdathanhtoan = new javax.swing.JTable();
        jPanel60 = new javax.swing.JPanel();
        jLabel116 = new javax.swing.JLabel();
        Hoten_4 = new javax.swing.JTextField();
        jLabel117 = new javax.swing.JLabel();
        MDT_4 = new javax.swing.JTextField();
        jLabel118 = new javax.swing.JLabel();
        CMND_4 = new javax.swing.JTextField();
        jLabel119 = new javax.swing.JLabel();
        Masanh_4 = new javax.swing.JTextField();
        jLabel120 = new javax.swing.JLabel();
        SDT_4 = new javax.swing.JTextField();
        jLabel121 = new javax.swing.JLabel();
        MaTD_4 = new javax.swing.JTextField();
        jLabel122 = new javax.swing.JLabel();
        Soban_4 = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        Tablenuoc_4 = new javax.swing.JTable();
        jLabel123 = new javax.swing.JLabel();
        Tongtien_4 = new javax.swing.JTextField();
        jLabel124 = new javax.swing.JLabel();
        Coc_4 = new javax.swing.JTextField();
        jLabel125 = new javax.swing.JLabel();
        Conlai_4 = new javax.swing.JTextField();
        jLabel126 = new javax.swing.JLabel();
        Tiennhan_4 = new javax.swing.JTextField();
        jLabel127 = new javax.swing.JLabel();
        Tienthua_4 = new javax.swing.JTextField();
        InTiec1 = new javax.swing.JButton();
        jButton91 = new javax.swing.JButton();
        jPanel39 = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        Thang2 = new com.toedter.calendar.JMonthChooser();
        jLabel4 = new javax.swing.JLabel();
        Nam2 = new com.toedter.calendar.JYearChooser();
        jButton68 = new javax.swing.JButton();
        Thongketiec = new javax.swing.JButton();
        Admin = new javax.swing.JPanel();
        jTabbedPane8 = new javax.swing.JTabbedPane();
        jPaneRole = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableRole = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextNewRoleName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextNewRoleDesc = new javax.swing.JTextField();
        jButtonAddRole = new javax.swing.JButton();
        jButtonCancelAddRole = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jTextRoleName = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextRoleDesc = new javax.swing.JTextField();
        jButtonUpdateRole = new javax.swing.JButton();
        jButtonCancelUpdateRole = new javax.swing.JButton();
        jButtonDeleteRole = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jTextRoleId = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        Logout = new javax.swing.JPanel();
        jPanel42 = new javax.swing.JPanel();
        Okelogout = new javax.swing.JButton();
        jButton101 = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QLKS v2.0");
        setResizable(false);

        jPanel33.setBackground(new java.awt.Color(153, 153, 153));

        jPanel45.setBackground(new java.awt.Color(204, 204, 204));

        jLabel59.setBackground(new java.awt.Color(255, 255, 255));
        jLabel59.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setText("NHÀ HÀNG & KHÁCH SẠN");

        jLabel58.setBackground(new java.awt.Color(255, 255, 255));
        jLabel58.setFont(new java.awt.Font("NSimSun", 3, 14)); // NOI18N
        jLabel58.setText("BANANA");

        jLabel60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hotel_1.png"))); // NOI18N
        jLabel60.setToolTipText("");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel34.setText("Ngày: 12 -06-2019");

        LabelUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/admin.png"))); // NOI18N
        LabelUser.setText("Hi: Admin");

        jPanel32.setBackground(new java.awt.Color(204, 204, 204));
        jPanel32.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sảnh", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(0, 153, 0))); // NOI18N

        jLabel37.setBackground(new java.awt.Color(102, 204, 0));
        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel37.setText("Còn trống:");
        jLabel37.setOpaque(true);

        jLabel38.setBackground(new java.awt.Color(255, 0, 0));
        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel38.setText("Đang thuê:");
        jLabel38.setOpaque(true);

        jLabel39.setBackground(new java.awt.Color(0, 153, 255));
        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel39.setText("Đã cọc:");
        jLabel39.setOpaque(true);

        Sanhthue.setEditable(false);
        Sanhthue.setText("0");

        Sanhcoc.setEditable(false);
        Sanhcoc.setText("0");

        Sanhtrong.setEditable(false);
        Sanhtrong.setText("0");

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Sanhthue, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Sanhcoc, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Sanhtrong, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jLabel37)
                    .addComponent(jLabel39)
                    .addComponent(Sanhthue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Sanhcoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Sanhtrong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel48.setBackground(new java.awt.Color(204, 204, 204));
        jPanel48.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Phòng\n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(0, 153, 0))); // NOI18N

        jLabel72.setBackground(new java.awt.Color(102, 204, 0));
        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel72.setText("Còn trống:");
        jLabel72.setOpaque(true);

        jLabel73.setBackground(new java.awt.Color(255, 0, 0));
        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel73.setText("Đang thuê:");
        jLabel73.setOpaque(true);

        jLabel74.setBackground(new java.awt.Color(0, 153, 255));
        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel74.setText("Đã cọc:");
        jLabel74.setOpaque(true);

        Phongthue.setEditable(false);
        Phongthue.setText("0");

        Phongcoc.setEditable(false);
        Phongcoc.setText("0");

        Phongtrong.setEditable(false);
        Phongtrong.setText("0");

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel73)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Phongthue, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel74)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Phongcoc, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel72)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Phongtrong, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel73)
                    .addComponent(jLabel72)
                    .addComponent(jLabel74)
                    .addComponent(Phongthue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Phongcoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Phongtrong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel34)
                .addGap(22, 22, 22)
                .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelUser)
                .addContainerGap())
            .addComponent(jPanel32, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTabbedPane1.setOpaque(true);

        javax.swing.GroupLayout HomeLayout = new javax.swing.GroupLayout(Home);
        Home.setLayout(HomeLayout);
        HomeLayout.setHorizontalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 980, Short.MAX_VALUE)
        );
        HomeLayout.setVerticalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 493, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Home                     ", new javax.swing.ImageIcon(getClass().getResource("/images/home.png")), Home); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel11.setText("Mã đặt phòng:");

        Tracuulapphieu.setText("Tra cứu");
        Tracuulapphieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TracuulapphieuActionPerformed(evt);
            }
        });

        Tablephieuthue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã đặt", "Họ tên", "CMND", "SĐT", "Phòng", "Ngày đến", "Ngày đi", "Tiền trả trước"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tablephieuthue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablephieuthueMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(Tablephieuthue);
        if (Tablephieuthue.getColumnModel().getColumnCount() > 0) {
            Tablephieuthue.getColumnModel().getColumn(0).setResizable(false);
            Tablephieuthue.getColumnModel().getColumn(0).setPreferredWidth(5);
        }

        LapPhieuThue.setText("Lập phiếu");
        LapPhieuThue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LapPhieuThueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Madatlapphieu, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108)
                .addComponent(Tracuulapphieu, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(220, Short.MAX_VALUE))
            .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LapPhieuThue, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Madatlapphieu)
                        .addComponent(Tracuulapphieu, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LapPhieuThue)
                .addGap(80, 80, 80))
        );

        jTabbedPane4.addTab("Phiếu thuê", jPanel18);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel12.setText("Mã đặt phòng:");

        Tracuulapdichvu.setText("Tra cứu");
        Tracuulapdichvu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TracuulapdichvuActionPerformed(evt);
            }
        });

        Tablelapdichvu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã đặt", "Họ tên", "CMND", "SDT", "Số Phòng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(Tablelapdichvu);
        if (Tablelapdichvu.getColumnModel().getColumnCount() > 0) {
            Tablelapdichvu.getColumnModel().getColumn(0).setResizable(false);
        }

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel13.setText("Tên dịch vụ:");

        ComboBoxtendv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DV1 - Karaoke", "DV2 - Giặt là", "DV3 - Coca", " " }));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel14.setText("Số lượng:");

        Soluongdv.setText("0");

        Themdichvu.setText("Thêm");
        Themdichvu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemdichvuActionPerformed(evt);
            }
        });

        Tabledichvu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã đặt", "Mã DV", "Tên DV", "Giá", "Số lượng", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane9.setViewportView(Tabledichvu);

        Canceldichvu.setText("Cancel");

        Deletedichvu.setText("Delete");
        Deletedichvu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletedichvuActionPerformed(evt);
            }
        });

        Okdichvu.setText("OK");
        Okdichvu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkdichvuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComboBoxtendv, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Soluongdv, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(Themdichvu, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Deletedichvu, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(143, Short.MAX_VALUE))
            .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Okdichvu, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(Canceldichvu))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(ComboBoxtendv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(Soluongdv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Themdichvu)
                    .addComponent(Deletedichvu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Canceldichvu)
                    .addComponent(Okdichvu)))
        );

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Madatlapdichvu, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(Tracuulapdichvu, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Madatlapdichvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tracuulapdichvu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane4.addTab("Phiếu dịch vụ", jPanel19);

        javax.swing.GroupLayout Lap_phieuLayout = new javax.swing.GroupLayout(Lap_phieu);
        Lap_phieu.setLayout(Lap_phieuLayout);
        Lap_phieuLayout.setHorizontalGroup(
            Lap_phieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane4, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        Lap_phieuLayout.setVerticalGroup(
            Lap_phieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 493, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Lập phiếu                ", new javax.swing.ImageIcon(getClass().getResource("/images/invoice.png")), Lap_phieu); // NOI18N

        jPanel49.setBackground(new java.awt.Color(204, 204, 204));
        jPanel49.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bảng giá phòng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(0, 153, 0))); // NOI18N

        Tablegiaphong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã loại phòng", "Tên loại phòng", "Giá "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane19.setViewportView(Tablegiaphong);

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel49Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel50.setBackground(new java.awt.Color(204, 204, 204));
        jPanel50.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi tiết loại phòng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(0, 153, 0))); // NOI18N

        jLabel42.setText("Loại phòng:");

        ComboBoxloaiphong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboBoxloaiphong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxloaiphongActionPerformed(evt);
            }
        });

        Tablecoso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã CS", "Tên"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane20.setViewportView(Tablecoso);
        if (Tablecoso.getColumnModel().getColumnCount() > 0) {
            Tablecoso.getColumnModel().getColumn(0).setResizable(false);
            Tablecoso.getColumnModel().getColumn(0).setPreferredWidth(5);
            Tablecoso.getColumnModel().getColumn(1).setResizable(false);
            Tablecoso.getColumnModel().getColumn(1).setPreferredWidth(10);
        }

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel50Layout.createSequentialGroup()
                        .addComponent(jLabel42)
                        .addGap(18, 18, 18)
                        .addComponent(ComboBoxloaiphong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 169, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(ComboBoxloaiphong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane20, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110)
                .addComponent(jPanel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(71, 71, 71))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane5.addTab("Bảng giá phòng", jPanel20);

        jPanel51.setBackground(new java.awt.Color(204, 204, 204));
        jPanel51.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bảng giá dịch vụ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(0, 153, 0))); // NOI18N

        Tablegiadichvu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã DV", "Tên DV", "DVT", "Giá"
            }
        ));
        jScrollPane22.setViewportView(Tablegiadichvu);

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane22, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel51Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane22, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(219, 219, 219)
                .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(231, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane5.addTab("Bảng giá dịch vụ", jPanel21);

        javax.swing.GroupLayout Bang_giaLayout = new javax.swing.GroupLayout(Bang_gia);
        Bang_gia.setLayout(Bang_giaLayout);
        Bang_giaLayout.setHorizontalGroup(
            Bang_giaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Bang_giaLayout.createSequentialGroup()
                .addComponent(jTabbedPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 980, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        Bang_giaLayout.setVerticalGroup(
            Bang_giaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane5)
        );

        jTabbedPane1.addTab("Bảng giá                  ", new javax.swing.ImageIcon(getClass().getResource("/images/catalog.png")), Bang_gia); // NOI18N

        Jphong1.setBackground(new java.awt.Color(0, 204, 102));
        Jphong1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong1.setText("SD001-01");
        Jphong1.setBorderPainted(false);

        Jphong6.setBackground(new java.awt.Color(0, 204, 102));
        Jphong6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong6.setText("SD001-06");
        Jphong6.setBorderPainted(false);

        Jphong2.setBackground(new java.awt.Color(255, 0, 0));
        Jphong2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong2.setText("SD001-02");
        Jphong2.setBorderPainted(false);
        Jphong2.setSelected(true);

        Jphong3.setBackground(new java.awt.Color(0, 204, 102));
        Jphong3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong3.setText("SD001-03");
        Jphong3.setBorderPainted(false);

        Jphong4.setBackground(new java.awt.Color(0, 153, 255));
        Jphong4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong4.setText("SD001-04");
        Jphong4.setBorderPainted(false);

        Jphong5.setBackground(new java.awt.Color(0, 204, 102));
        Jphong5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong5.setText("SD001-05");
        Jphong5.setBorderPainted(false);

        Jphong7.setBackground(new java.awt.Color(0, 153, 255));
        Jphong7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong7.setText("SD001-07");
        Jphong7.setBorderPainted(false);

        Jphong8.setBackground(new java.awt.Color(0, 204, 102));
        Jphong8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong8.setText("SD001-08");
        Jphong8.setBorderPainted(false);

        Jphong9.setBackground(new java.awt.Color(255, 0, 0));
        Jphong9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong9.setText("SD001-09");
        Jphong9.setBorderPainted(false);

        Jphong10.setBackground(new java.awt.Color(0, 153, 255));
        Jphong10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong10.setText("SD001-10");
        Jphong10.setBorderPainted(false);

        javax.swing.GroupLayout Tang_tretLayout = new javax.swing.GroupLayout(Tang_tret);
        Tang_tret.setLayout(Tang_tretLayout);
        Tang_tretLayout.setHorizontalGroup(
            Tang_tretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang_tretLayout.createSequentialGroup()
                .addGroup(Tang_tretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Jphong1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jphong6, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addGroup(Tang_tretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Jphong2, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(Jphong7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(70, 70, 70)
                .addGroup(Tang_tretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Jphong3, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(Jphong8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(70, 70, 70)
                .addGroup(Tang_tretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Jphong4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Jphong9, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                .addGap(70, 70, 70)
                .addGroup(Tang_tretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Jphong5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Jphong10, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Tang_tretLayout.setVerticalGroup(
            Tang_tretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang_tretLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Tang_tretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Jphong1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Jphong2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                    .addComponent(Jphong5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Jphong3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                    .addComponent(Jphong4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(Tang_tretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Jphong6, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(Jphong7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Jphong8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Jphong9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Jphong10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Tầng trệt", Tang_tret);

        Jphong11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong11.setText("jButton12");

        Jphong12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong12.setText("jButton14");

        Jphong13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong13.setText("jButton15");

        Jphong14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong14.setText("jButton16");

        Jphong15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong15.setText("jButton17");

        Jphong16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong16.setText("jButton13");

        Jphong17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong17.setText("jButton20");

        Jphong18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong18.setText("jButton19");

        Jphong19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong19.setText("jButton21");

        Jphong20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong20.setText("jButton22");
        Jphong20.setOpaque(false);

        javax.swing.GroupLayout Tang_1Layout = new javax.swing.GroupLayout(Tang_1);
        Tang_1.setLayout(Tang_1Layout);
        Tang_1Layout.setHorizontalGroup(
            Tang_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang_1Layout.createSequentialGroup()
                .addGroup(Tang_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Jphong11, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jphong16, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addGroup(Tang_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Jphong12, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(Jphong17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(70, 70, 70)
                .addGroup(Tang_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Jphong18, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(Jphong13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(70, 70, 70)
                .addGroup(Tang_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Jphong14, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(Jphong19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(70, 70, 70)
                .addGroup(Tang_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Jphong15, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(Jphong20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        Tang_1Layout.setVerticalGroup(
            Tang_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang_1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Tang_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(Tang_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Jphong13, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Jphong14, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Jphong12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Jphong11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Jphong15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(Tang_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Jphong16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Jphong18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Jphong17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Jphong19, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(Jphong20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Tầng 1", Tang_1);

        Jphong21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong21.setText("jButton18");

        Jphong22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong22.setText("jButton24");

        Jphong23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong23.setText("jButton25");

        Jphong24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong24.setText("jButton26");

        Jphong25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong25.setText("jButton27");

        Jphong26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong26.setText("jButton23");

        Jphong27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong27.setText("jButton28");

        Jphong28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong28.setText("jButton29");

        Jphong29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong29.setText("jButton30");

        Jphong30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong30.setText("jButton31");

        javax.swing.GroupLayout Tang_2Layout = new javax.swing.GroupLayout(Tang_2);
        Tang_2.setLayout(Tang_2Layout);
        Tang_2Layout.setHorizontalGroup(
            Tang_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang_2Layout.createSequentialGroup()
                .addGroup(Tang_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Jphong21, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jphong26, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addGroup(Tang_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Jphong22, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(Jphong27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(70, 70, 70)
                .addGroup(Tang_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Jphong23, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(Jphong28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(70, 70, 70)
                .addGroup(Tang_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Jphong24, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(Jphong29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(70, 70, 70)
                .addGroup(Tang_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Jphong25, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(Jphong30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        Tang_2Layout.setVerticalGroup(
            Tang_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang_2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Tang_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Tang_2Layout.createSequentialGroup()
                        .addComponent(Jphong22, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(Jphong21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Jphong23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Jphong24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Jphong25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(Tang_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Jphong26, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(Jphong27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Jphong28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Jphong29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Jphong30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(8, 8, 8))
        );

        jTabbedPane2.addTab("Tầng 2", Tang_2);

        Jphong31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong31.setText("jButton32");

        Jphong32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong32.setText("jButton34");

        Jphong33.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong33.setText("jButton35");

        Jphong34.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong34.setText("jButton36");

        Jphong35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong35.setText("jButton37");

        Jphong36.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong36.setText("jButton33");

        Jphong37.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong37.setText("jButton38");

        Jphong38.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong38.setText("jButton39");

        Jphong39.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong39.setText("jButton40");

        Jphong40.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong40.setText("jButton41");

        javax.swing.GroupLayout Tang_3Layout = new javax.swing.GroupLayout(Tang_3);
        Tang_3.setLayout(Tang_3Layout);
        Tang_3Layout.setHorizontalGroup(
            Tang_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang_3Layout.createSequentialGroup()
                .addGroup(Tang_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Jphong31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Jphong36, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addGroup(Tang_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Jphong32, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(Jphong37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(70, 70, 70)
                .addGroup(Tang_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Jphong33, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(Jphong38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(70, 70, 70)
                .addGroup(Tang_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Jphong34, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(Jphong39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(70, 70, 70)
                .addGroup(Tang_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Jphong35, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(Jphong40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        Tang_3Layout.setVerticalGroup(
            Tang_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang_3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Tang_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Jphong35, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(Jphong34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Jphong33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Jphong32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Jphong31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(Tang_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Jphong36, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(Jphong37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Jphong38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Jphong39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Jphong40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Tầng 3", Tang_3);

        Jphong41.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong41.setText("jButton42");

        Jphong42.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong42.setText("jButton44");

        Jphong43.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong43.setText("jButton45");

        Jphong44.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong44.setText("jButton46");

        Jphong45.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong45.setText("jButton47");

        Jphong46.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong46.setText("jButton43");

        Jphong47.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong47.setText("jButton48");

        Jphong48.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong48.setText("jButton49");

        Jphong49.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong49.setText("jButton50");

        Jphong50.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Jphong50.setText("jButton51");

        javax.swing.GroupLayout Tang_4Layout = new javax.swing.GroupLayout(Tang_4);
        Tang_4.setLayout(Tang_4Layout);
        Tang_4Layout.setHorizontalGroup(
            Tang_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang_4Layout.createSequentialGroup()
                .addGroup(Tang_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Jphong41, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(Jphong46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(70, 70, 70)
                .addGroup(Tang_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Jphong42, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(Jphong47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(70, 70, 70)
                .addGroup(Tang_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Jphong43, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(Jphong48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(70, 70, 70)
                .addGroup(Tang_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Jphong44, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(Jphong49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(70, 70, 70)
                .addGroup(Tang_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Jphong45, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(Jphong50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        Tang_4Layout.setVerticalGroup(
            Tang_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang_4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Tang_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Jphong45, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(Jphong43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Jphong42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Jphong41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Jphong44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(Tang_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Jphong46, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(Jphong47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Jphong48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Jphong49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Jphong50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Tẩng 4", Tang_4);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel8.setText("Từ ngày:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel9.setText("Đến ngày:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel10.setText("Tình trạng:");

        ComboBoxTinhtrangphong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Còn trống", "Đã cọc", "Đang thuê" }));

        Tracuuphong.setText("Tra cứu");
        Tracuuphong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TracuuphongActionPerformed(evt);
            }
        });

        DateIn.setDateFormatString("dd/MM/yyyy"); // NOI18N

        DateOut.setDateFormatString("dd/MM/yyyy");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel5.setText("Loại:");

        ComboBoxloai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        LamMoi.setText("Làm mới");
        LamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout QL_phongLayout = new javax.swing.GroupLayout(QL_phong);
        QL_phong.setLayout(QL_phongLayout);
        QL_phongLayout.setHorizontalGroup(
            QL_phongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
            .addGroup(QL_phongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DateIn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DateOut, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ComboBoxTinhtrangphong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ComboBoxloai, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Tracuuphong, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        QL_phongLayout.setVerticalGroup(
            QL_phongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, QL_phongLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(QL_phongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(QL_phongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jLabel10)
                        .addComponent(ComboBoxTinhtrangphong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Tracuuphong)
                        .addComponent(jLabel5)
                        .addComponent(ComboBoxloai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LamMoi))
                    .addComponent(DateIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(QL_phongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DateOut, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2))
        );

        jTabbedPane1.addTab("Quản lý phòng        ", new javax.swing.ImageIcon(getClass().getResource("/images/room.png")), QL_phong); // NOI18N

        Tabledangluutru.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Họ tên", "Số phòng", "CMND", "Ngày đến", "Ngày đi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabledangluutru.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabledangluutruMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabledangluutru);
        if (Tabledangluutru.getColumnModel().getColumnCount() > 0) {
            Tabledangluutru.getColumnModel().getColumn(0).setResizable(false);
            Tabledangluutru.getColumnModel().getColumn(0).setPreferredWidth(5);
        }

        jPanel16.setBackground(new java.awt.Color(204, 204, 204));
        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(0, 153, 0))); // NOI18N

        Hoten1.setText("Họ tên");
        Hoten1.setOpaque(false);

        CMND1.setText("CMND/Passport");
        CMND1.setOpaque(false);

        Sophong1.setText("Số phòng");
        Sophong1.setOpaque(false);

        Timkiemdangluutru.setText("Tìm kiếm");
        Timkiemdangluutru.setOpaque(false);
        Timkiemdangluutru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimkiemdangluutruActionPerformed(evt);
            }
        });

        Lammoidangluutru.setText("Làm mới");
        Lammoidangluutru.setOpaque(false);
        Lammoidangluutru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LammoidangluutruActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(Textdangluutru)
                        .addContainerGap())
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(Hoten1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, Short.MAX_VALUE)
                        .addComponent(CMND1)
                        .addGap(18, 18, 18)
                        .addComponent(Sophong1)
                        .addGap(40, 40, 40))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Timkiemdangluutru)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Lammoidangluutru)
                        .addContainerGap())))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Textdangluutru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Hoten1)
                    .addComponent(CMND1)
                    .addComponent(Sophong1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Timkiemdangluutru)
                    .addComponent(Lammoidangluutru)))
        );

        jPanel22.setBackground(new java.awt.Color(204, 204, 204));
        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(0, 153, 0))); // NOI18N

        jLabel19.setText("Họ tên:");

        jLabel28.setText("Số phòng:");

        jLabel46.setText("SĐT:");

        jLabel47.setText("CMND/Passport:");

        jLabel48.setText("Ngày sinh:");

        jLabel49.setText("Ngày đến:");

        jLabel50.setText("Ngày đi:");

        Okdangluutru.setText("OK");
        Okdangluutru.setOpaque(false);
        Okdangluutru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkdangluutruActionPerformed(evt);
            }
        });

        Deletedangluutru.setText("Xóa");
        Deletedangluutru.setOpaque(false);
        Deletedangluutru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletedangluutruActionPerformed(evt);
            }
        });

        Ngayden1.setDateFormatString("dd/MM/yyyy");

        Ngaydi1.setDateFormatString("dd/MM/yyyy");

        Ngaysinh1.setDateFormatString("dd/MM/yyyy");
        Ngaysinh1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(Okdangluutru, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Deletedangluutru, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel49)
                            .addComponent(jLabel50))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Ngayden1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Ngaydi1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel48)
                        .addGap(32, 32, 32)
                        .addComponent(Ngaysinh1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addGap(34, 34, 34)
                        .addComponent(Textsophong1))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel47)
                            .addComponent(jLabel19)
                            .addComponent(jLabel46))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Texthoten1)
                            .addComponent(Textsdt1)
                            .addComponent(Textcmnd1))))
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(Texthoten1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(Textcmnd1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(Textsdt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(Textsophong1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Ngaysinh1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel49)
                    .addComponent(Ngayden1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel50)
                    .addComponent(Ngaydi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Okdangluutru)
                    .addComponent(Deletedangluutru))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );

        jTabbedPane3.addTab("Đang lưu trú", jPanel13);

        jPanel41.setBackground(new java.awt.Color(204, 204, 204));
        jPanel41.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(0, 153, 0))); // NOI18N

        jLabel51.setText("Họ tên:");

        Texthoten2.setEditable(false);

        jLabel52.setText("Số phòng:");

        Textsdt2.setEditable(false);

        jLabel53.setText("SĐT:");

        Textsophong2.setEditable(false);

        jLabel54.setText("CMND/Passport:");

        Textcmnd2.setEditable(false);

        jLabel55.setText("Ngày sinh:");

        jLabel56.setText("Ngày đến:");

        jLabel57.setText("Ngày đi:");

        Ngaysinh2.setEditable(false);

        Ngayden2.setEditable(false);

        Ngaydi2.setEditable(false);

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel54)
                            .addComponent(jLabel51)
                            .addComponent(jLabel53)
                            .addComponent(jLabel52)
                            .addComponent(jLabel55)
                            .addComponent(jLabel56))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Texthoten2)
                            .addComponent(Textsophong2)
                            .addComponent(Textsdt2)
                            .addComponent(Textcmnd2)
                            .addComponent(Ngaysinh2)
                            .addComponent(Ngayden2)))
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addComponent(jLabel57)
                        .addGap(60, 60, 60)
                        .addComponent(Ngaydi2)))
                .addContainerGap())
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(Texthoten2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(Textcmnd2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(Textsdt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Textsophong2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(Ngaysinh2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(Ngayden2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(Ngaydi2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Tabledaluutru.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Họ tên", "Số phòng", "CMND", "Ngày đến", "Ngày đi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabledaluutru.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabledaluutruMouseClicked(evt);
            }
        });
        jScrollPane16.setViewportView(Tabledaluutru);
        if (Tabledaluutru.getColumnModel().getColumnCount() > 0) {
            Tabledaluutru.getColumnModel().getColumn(0).setResizable(false);
            Tabledaluutru.getColumnModel().getColumn(0).setPreferredWidth(5);
            Tabledaluutru.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel43.setBackground(new java.awt.Color(204, 204, 204));
        jPanel43.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(0, 153, 0))); // NOI18N

        Hoten2.setText("Họ tên");
        Hoten2.setOpaque(false);

        CMND2.setText("CMND/Passport");
        CMND2.setOpaque(false);

        Sophong2.setText("Số phòng");
        Sophong2.setOpaque(false);

        Timkiemdaluutru.setText("Tìm kiếm");
        Timkiemdaluutru.setOpaque(false);
        Timkiemdaluutru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimkiemdaluutruActionPerformed(evt);
            }
        });

        Lammoidaluutru.setText("Làm mới");
        Lammoidaluutru.setOpaque(false);
        Lammoidaluutru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LammoidaluutruActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addComponent(Textdaluutru)
                        .addContainerGap())
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addComponent(Hoten2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CMND2)
                        .addGap(18, 18, 18)
                        .addComponent(Sophong2)
                        .addGap(40, 40, 40))
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Timkiemdaluutru)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Lammoidaluutru)
                        .addContainerGap())))
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Textdaluutru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Hoten2)
                    .addComponent(CMND2)
                    .addComponent(Sophong2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Timkiemdaluutru)
                    .addComponent(Lammoidaluutru)))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Đã lưu trú", jPanel14);

        javax.swing.GroupLayout QL_khachLayout = new javax.swing.GroupLayout(QL_khach);
        QL_khach.setLayout(QL_khachLayout);
        QL_khachLayout.setHorizontalGroup(
            QL_khachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
        );
        QL_khachLayout.setVerticalGroup(
            QL_khachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
        );

        jTabbedPane1.addTab("Quản lý khách hàng", new javax.swing.ImageIcon(getClass().getResource("/images/guest.png")), QL_khach); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel15.setText("Mã đặt tiệc:");

        Tracuuphieutiec.setText("Tra cứu");
        Tracuuphieutiec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TracuuphieutiecActionPerformed(evt);
            }
        });

        LapPhieuTiec.setText("Lập phiếu");
        LapPhieuTiec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LapPhieuTiecActionPerformed(evt);
            }
        });

        Tablephieutiec.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã đặt tiệc", "Họ tên", "Mã thực đơn", "Mã sảnh", "CMND", "SDT", "Thời gian", "Cọc", "Còn lạil"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane14.setViewportView(Tablephieutiec);

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Madatphieutiec, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(Tracuuphieutiec, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 323, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(LapPhieuTiec, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(Madatphieutiec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tracuuphieutiec))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LapPhieuTiec, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane7.addTab("Lập phiếu tiệc", jPanel34);

        SanhA.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        SanhA.setText("Sảnh A");
        SanhA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SanhAActionPerformed(evt);
            }
        });

        SanhB.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        SanhB.setText("Sảnh B");

        SanhC.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        SanhC.setText("Sảnh C");

        SanhD.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        SanhD.setText("Sảnh D");

        SanhE.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        SanhE.setText("Sảnh E");

        SanhF.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        SanhF.setText("Sảnh F");

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel62.setText("Từ ngày:");

        DateIn2.setDateFormatString("dd/MM/yyyy"); // NOI18N

        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel64.setText("Tình trạng:");

        ComboBoxtinhtrangsanh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Còn trống", "Đã cọc", "Đang thuê" }));

        Tracuutiec.setText("Tra cứu");
        Tracuutiec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TracuutiecActionPerformed(evt);
            }
        });

        Lammoitiec.setText("Làm mới");
        Lammoitiec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LammoitiecActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(SanhA, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SanhB, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(SanhC, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(SanhD, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(SanhE, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(SanhF, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(jLabel62)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DateIn2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel64)
                        .addGap(18, 18, 18)
                        .addComponent(ComboBoxtinhtrangsanh, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(Tracuutiec, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Lammoitiec, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77))))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel62)
                        .addComponent(jLabel64)
                        .addComponent(ComboBoxtinhtrangsanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Tracuutiec)
                        .addComponent(Lammoitiec))
                    .addComponent(DateIn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SanhA, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SanhB, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SanhC, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SanhD, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SanhF, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SanhE, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(133, Short.MAX_VALUE))
        );

        jTabbedPane7.addTab("Đặt tiệc", jPanel28);

        jPanel31.setBackground(new java.awt.Color(204, 204, 204));
        jPanel31.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi tiết thực đơn\n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(0, 153, 0))); // NOI18N

        jLabel66.setText("Thực đơn");

        ComboBoxthucdon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboBoxthucdon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxthucdonActionPerformed(evt);
            }
        });

        Tablethucdon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên món"
            }
        ));
        jScrollPane10.setViewportView(Tablethucdon);
        if (Tablethucdon.getColumnModel().getColumnCount() > 0) {
            Tablethucdon.getColumnModel().getColumn(0).setMinWidth(30);
            Tablethucdon.getColumnModel().getColumn(0).setPreferredWidth(30);
            Tablethucdon.getColumnModel().getColumn(0).setMaxWidth(5);
        }

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(jLabel66)
                        .addGap(18, 18, 18)
                        .addComponent(ComboBoxthucdon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel66)
                    .addComponent(ComboBoxthucdon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel30.setBackground(new java.awt.Color(204, 204, 204));
        jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bảng giá\n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(0, 153, 0))); // NOI18N

        Tablegiathucdon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã TD", "Tên TD", "Giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane15.setViewportView(Tablegiathucdon);
        if (Tablegiathucdon.getColumnModel().getColumnCount() > 0) {
            Tablegiathucdon.getColumnModel().getColumn(0).setResizable(false);
            Tablegiathucdon.getColumnModel().getColumn(0).setPreferredWidth(5);
            Tablegiathucdon.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(113, 113, 113))
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        jTabbedPane7.addTab("Thực đơn", jPanel29);

        javax.swing.GroupLayout Nha_hangLayout = new javax.swing.GroupLayout(Nha_hang);
        Nha_hang.setLayout(Nha_hangLayout);
        Nha_hangLayout.setHorizontalGroup(
            Nha_hangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane7, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        Nha_hangLayout.setVerticalGroup(
            Nha_hangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane7)
        );

        jTabbedPane1.addTab("Nhà hàng              ", new javax.swing.ImageIcon(getClass().getResource("/images/restaurant.png")), Nha_hang); // NOI18N

        Tablephonghientai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Số HD", "Họ tên", "Số phòng", "CMND", "Tổng tiền", "Cọc", "Còn lạil"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tablephonghientai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablephonghientaiMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(Tablephonghientai);
        if (Tablephonghientai.getColumnModel().getColumnCount() > 0) {
            Tablephonghientai.getColumnModel().getColumn(0).setResizable(false);
            Tablephonghientai.getColumnModel().getColumn(0).setPreferredWidth(20);
        }

        jButton86.setText("Cancel");

        Thanhtoanphong.setText("Thanh toán");
        Thanhtoanphong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThanhtoanphongActionPerformed(evt);
            }
        });

        jPanel52.setBackground(new java.awt.Color(204, 204, 204));
        jPanel52.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm\n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(0, 153, 0))); // NOI18N

        jLabel43.setText("Mã đặt phòng:");

        Lammoiphonghientai.setText("Làm mới");
        Lammoiphonghientai.setOpaque(false);
        Lammoiphonghientai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LammoiphonghientaiActionPerformed(evt);
            }
        });

        Timkiemhoadonhientai.setText("Tìm kiếm");
        Timkiemhoadonhientai.setOpaque(false);
        Timkiemhoadonhientai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimkiemhoadonhientaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel43)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Madatphonghientai)
                .addGap(16, 16, 16))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel52Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(Timkiemhoadonhientai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Lammoiphonghientai)
                .addContainerGap())
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(Madatphonghientai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lammoiphonghientai)
                    .addComponent(Timkiemhoadonhientai)))
        );

        jPanel53.setBackground(new java.awt.Color(204, 204, 204));
        jPanel53.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin thanh toán", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(0, 153, 0))); // NOI18N

        jLabel44.setText("Họ tên:");

        Hoten_1.setEditable(false);

        jLabel45.setText("MĐP:");

        MDP_1.setEditable(false);

        jLabel75.setText("CMND\\Passport:");

        CMND_1.setEditable(false);

        jLabel76.setText("Số phòng:");

        Sophong_1.setEditable(false);

        jLabel77.setText("SĐT:");

        SDT_1.setEditable(false);

        TableDV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên DV", "Giá", "SL", "Tổng tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(TableDV);
        if (TableDV.getColumnModel().getColumnCount() > 0) {
            TableDV.getColumnModel().getColumn(2).setResizable(false);
            TableDV.getColumnModel().getColumn(2).setPreferredWidth(5);
        }

        jLabel82.setText("Tổng tiền:");

        Tongtien_1.setEditable(false);

        jLabel83.setText("Đã cọc:");

        Coc_1.setEditable(false);

        jLabel84.setText("Còn lại:");

        Conlai_1.setEditable(false);

        jLabel85.setText("Nhận:");

        jLabel86.setText("Thừa:");

        Tienthua_1.setEditable(false);

        jLabel16.setText("Ngày đến:");

        Ngayden_1.setEditable(false);

        jLabel128.setText("Ngày đi:");

        Ngaydi_1.setEditable(false);

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel82)
                    .addComponent(jLabel84)
                    .addComponent(jLabel85))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Tongtien_1)
                    .addComponent(Conlai_1)
                    .addComponent(Tiennhan_1, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel53Layout.createSequentialGroup()
                        .addComponent(jLabel83)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Coc_1))
                    .addGroup(jPanel53Layout.createSequentialGroup()
                        .addComponent(jLabel86)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Tienthua_1))))
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel53Layout.createSequentialGroup()
                        .addComponent(jLabel44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Hoten_1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel53Layout.createSequentialGroup()
                        .addComponent(jLabel77)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SDT_1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel76)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Sophong_1)
                    .addGroup(jPanel53Layout.createSequentialGroup()
                        .addComponent(jLabel45)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(MDP_1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addComponent(jLabel75)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CMND_1))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel53Layout.createSequentialGroup()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Ngayden_1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel128)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Ngaydi_1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(Hoten_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45)
                    .addComponent(MDP_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel75)
                    .addComponent(CMND_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel77)
                    .addComponent(SDT_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel76)
                    .addComponent(Sophong_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(Ngayden_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel128)
                    .addComponent(Ngaydi_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel82)
                    .addComponent(Tongtien_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel83)
                    .addComponent(Coc_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel84)
                    .addComponent(Conlai_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel85)
                    .addComponent(Tiennhan_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel86)
                    .addComponent(Tienthua_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        InPhong.setText("In hóa đơn");
        InPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InPhongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(Thanhtoanphong)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(InPhong)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton86))
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Thanhtoanphong)
                    .addComponent(InPhong)
                    .addComponent(jButton86)))
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane6.addTab("Hóa đơn hiện tại", jPanel23);

        jPanel54.setBackground(new java.awt.Color(204, 204, 204));
        jPanel54.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm\n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(0, 153, 0))); // NOI18N

        jLabel87.setText("Mã đặt phòng:");

        Lammoiphongdathanhtoan.setText("Làm mới");
        Lammoiphongdathanhtoan.setOpaque(false);
        Lammoiphongdathanhtoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LammoiphongdathanhtoanActionPerformed(evt);
            }
        });

        Timkiemphongdathanhtoan.setText("Tìm kiếm");
        Timkiemphongdathanhtoan.setOpaque(false);
        Timkiemphongdathanhtoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimkiemphongdathanhtoanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel54Layout = new javax.swing.GroupLayout(jPanel54);
        jPanel54.setLayout(jPanel54Layout);
        jPanel54Layout.setHorizontalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel87)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Madatphongdathanhtoan)
                .addGap(16, 16, 16))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel54Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(Timkiemphongdathanhtoan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Lammoiphongdathanhtoan)
                .addContainerGap())
        );
        jPanel54Layout.setVerticalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel87)
                    .addComponent(Madatphongdathanhtoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lammoiphongdathanhtoan)
                    .addComponent(Timkiemphongdathanhtoan)))
        );

        Tablephongdathanhtoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Số HD", "Họ tên", "Số phòng", "CMND", "Tổng tiền", "Cọc", "Còn lạil"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tablephongdathanhtoan.setToolTipText("Bảng\n");
        Tablephongdathanhtoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablephongdathanhtoanMouseClicked(evt);
            }
        });
        jScrollPane21.setViewportView(Tablephongdathanhtoan);
        if (Tablephongdathanhtoan.getColumnModel().getColumnCount() > 0) {
            Tablephongdathanhtoan.getColumnModel().getColumn(0).setResizable(false);
            Tablephongdathanhtoan.getColumnModel().getColumn(0).setPreferredWidth(20);
        }

        jPanel61.setBackground(new java.awt.Color(204, 204, 204));
        jPanel61.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin thanh toán", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(0, 153, 0))); // NOI18N

        jLabel129.setText("Họ tên:");

        Hoten_2.setEditable(false);

        jLabel130.setText("MĐP:");

        MDP_2.setEditable(false);

        jLabel131.setText("CMND\\Passport:");

        CMND_2.setEditable(false);

        jLabel132.setText("Số phòng:");

        Sophong_2.setEditable(false);

        jLabel133.setText("SĐT:");

        SDT_2.setEditable(false);

        TableDV2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên DV", "Giá", "SL", "Tổng tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(TableDV2);
        if (TableDV2.getColumnModel().getColumnCount() > 0) {
            TableDV2.getColumnModel().getColumn(2).setResizable(false);
            TableDV2.getColumnModel().getColumn(2).setPreferredWidth(5);
        }

        jLabel134.setText("Tổng tiền:");

        Tongtien_2.setEditable(false);

        jLabel135.setText("Đã cọc:");

        Coc_2.setEditable(false);

        jLabel136.setText("Còn lại:");

        Conlai_2.setEditable(false);

        jLabel137.setText("Nhận:");

        Tiennhan_2.setEditable(false);

        jLabel138.setText("Thừa:");

        Tienthua_2.setEditable(false);

        jLabel139.setText("Ngày đến:");

        Ngayden_2.setEditable(false);

        jLabel140.setText("Ngày đi:");

        Ngaydi_2.setEditable(false);

        javax.swing.GroupLayout jPanel61Layout = new javax.swing.GroupLayout(jPanel61);
        jPanel61.setLayout(jPanel61Layout);
        jPanel61Layout.setHorizontalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel61Layout.createSequentialGroup()
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel134)
                    .addComponent(jLabel136)
                    .addComponent(jLabel137))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Tongtien_2)
                    .addComponent(Conlai_2)
                    .addComponent(Tiennhan_2, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel61Layout.createSequentialGroup()
                        .addComponent(jLabel135)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Coc_2))
                    .addGroup(jPanel61Layout.createSequentialGroup()
                        .addComponent(jLabel138)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Tienthua_2))))
            .addGroup(jPanel61Layout.createSequentialGroup()
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel61Layout.createSequentialGroup()
                        .addComponent(jLabel129)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Hoten_2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel61Layout.createSequentialGroup()
                        .addComponent(jLabel133)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SDT_2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel132)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Sophong_2)
                    .addGroup(jPanel61Layout.createSequentialGroup()
                        .addComponent(jLabel130)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(MDP_2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanel61Layout.createSequentialGroup()
                .addComponent(jLabel131)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CMND_2))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel61Layout.createSequentialGroup()
                .addComponent(jLabel139)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Ngayden_2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel140)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Ngaydi_2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel61Layout.setVerticalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel61Layout.createSequentialGroup()
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel129)
                    .addComponent(Hoten_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel130)
                    .addComponent(MDP_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel131)
                    .addComponent(CMND_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel133)
                    .addComponent(SDT_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel132)
                    .addComponent(Sophong_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel139)
                    .addComponent(Ngayden_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel140)
                    .addComponent(Ngaydi_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel134)
                    .addComponent(Tongtien_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel135)
                    .addComponent(Coc_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel136)
                    .addComponent(Conlai_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel137)
                    .addComponent(Tiennhan_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel138)
                    .addComponent(Tienthua_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 64, Short.MAX_VALUE))
        );

        InPhong1.setText("In hóa đơn");
        InPhong1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InPhong1ActionPerformed(evt);
            }
        });

        jButton87.setText("Cancel");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(InPhong1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton87)))
                .addGap(20, 20, 20))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addComponent(jPanel54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InPhong1)
                    .addComponent(jButton87))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane6.addTab("Hóa đơn đã thanh toán", jPanel24);

        jPanel38.setBackground(new java.awt.Color(204, 204, 204));
        jPanel38.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chọn thời gian lập thống kê", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(0, 153, 0))); // NOI18N

        jLabel1.setText("Tháng:");

        jLabel2.setText("Năm:");

        jButton53.setText("Cancel");
        jButton53.setOpaque(false);

        Thongkephong.setText("Lập thống kê");
        Thongkephong.setOpaque(false);
        Thongkephong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThongkephongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Thang1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Nam1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addComponent(Thongkephong)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addComponent(jButton53, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Thang1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Nam1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton53)
                    .addComponent(Thongkephong))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(345, 345, 345)
                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(355, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        jTabbedPane6.addTab("Thống kê doanh thu phòng", jPanel15);

        jTabbedPane9.addTab("Hóa đơn phòng", jTabbedPane6);

        Tabletiechientai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Số HD", "Họ tên", "CMND", "Mã sảnh", "Tổng tiền", "Cọc", "Còn lạil"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabletiechientai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabletiechientaiMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(Tabletiechientai);
        if (Tabletiechientai.getColumnModel().getColumnCount() > 0) {
            Tabletiechientai.getColumnModel().getColumn(0).setResizable(false);
            Tabletiechientai.getColumnModel().getColumn(0).setPreferredWidth(20);
        }

        jButton90.setText("Cancel");

        Thanhtoantiec.setText("Thanh toán");
        Thanhtoantiec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThanhtoantiecActionPerformed(evt);
            }
        });

        jPanel56.setBackground(new java.awt.Color(204, 204, 204));
        jPanel56.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm\n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(0, 153, 0))); // NOI18N

        jLabel95.setText("Mã đặt tiệc:");

        Lammoitiechientai.setText("Làm mới");
        Lammoitiechientai.setOpaque(false);
        Lammoitiechientai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LammoitiechientaiActionPerformed(evt);
            }
        });

        Timkiemtiechientai.setText("Tìm kiếm");
        Timkiemtiechientai.setOpaque(false);
        Timkiemtiechientai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimkiemtiechientaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel56Layout = new javax.swing.GroupLayout(jPanel56);
        jPanel56.setLayout(jPanel56Layout);
        jPanel56Layout.setHorizontalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel95)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Madattiechientai)
                .addGap(16, 16, 16))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel56Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(Timkiemtiechientai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Lammoitiechientai)
                .addContainerGap())
        );
        jPanel56Layout.setVerticalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel95)
                    .addComponent(Madattiechientai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lammoitiechientai)
                    .addComponent(Timkiemtiechientai)))
        );

        jPanel57.setBackground(new java.awt.Color(204, 204, 204));
        jPanel57.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin thanh toán", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(0, 153, 0))); // NOI18N

        jLabel96.setText("Họ tên:");

        Hoten_3.setEditable(false);

        jLabel102.setText("MĐT:");

        MDT_3.setEditable(false);

        jLabel103.setText("CMND\\Passport:");

        CMND_3.setEditable(false);

        jLabel104.setText("Mã sảnh:");

        Masanh_3.setEditable(false);

        jLabel105.setText("SĐT:");

        SDT_3.setEditable(false);

        jLabel106.setText("Mã TĐ:");

        MaTD_3.setEditable(false);

        jLabel107.setText("Số bàn:");

        Soban_3.setEditable(false);

        jLabel108.setText("Nước:");

        ComboBoxnuoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel109.setText("SL:");

        Themnuoc.setText("Thêm");
        Themnuoc.setOpaque(false);
        Themnuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemnuocActionPerformed(evt);
            }
        });

        Xoanuoc.setText("Xóa");
        Xoanuoc.setOpaque(false);
        Xoanuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XoanuocActionPerformed(evt);
            }
        });

        Tablenuoc_3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Tên nước", "Giá", "SL", "Tổng tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(Tablenuoc_3);
        if (Tablenuoc_3.getColumnModel().getColumnCount() > 0) {
            Tablenuoc_3.getColumnModel().getColumn(0).setMinWidth(15);
            Tablenuoc_3.getColumnModel().getColumn(0).setPreferredWidth(30);
            Tablenuoc_3.getColumnModel().getColumn(0).setMaxWidth(30);
            Tablenuoc_3.getColumnModel().getColumn(3).setMinWidth(15);
            Tablenuoc_3.getColumnModel().getColumn(3).setPreferredWidth(30);
            Tablenuoc_3.getColumnModel().getColumn(3).setMaxWidth(30);
        }

        jLabel110.setText("Tổng tiền:");

        Tongtien_3.setEditable(false);

        jLabel111.setText("Đã cọc:");

        Coc_3.setEditable(false);

        jLabel112.setText("Còn lại:");

        Conlai_3.setEditable(false);

        jLabel113.setText("Nhận:");

        jLabel114.setText("Thừa:");

        Tienthua_3.setEditable(false);

        javax.swing.GroupLayout jPanel57Layout = new javax.swing.GroupLayout(jPanel57);
        jPanel57.setLayout(jPanel57Layout);
        jPanel57Layout.setHorizontalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel57Layout.createSequentialGroup()
                        .addComponent(jLabel96)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Hoten_3, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel57Layout.createSequentialGroup()
                        .addComponent(jLabel103)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CMND_3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel57Layout.createSequentialGroup()
                        .addComponent(jLabel102)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(MDT_3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel57Layout.createSequentialGroup()
                        .addComponent(jLabel104)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Masanh_3))))
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel57Layout.createSequentialGroup()
                        .addComponent(jLabel108)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboBoxnuoc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel57Layout.createSequentialGroup()
                        .addComponent(jLabel105)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SDT_3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel57Layout.createSequentialGroup()
                        .addComponent(jLabel106)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MaTD_3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel107)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Soban_3))
                    .addGroup(jPanel57Layout.createSequentialGroup()
                        .addComponent(jLabel109)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Soluong_3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Themnuoc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Xoanuoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel110)
                    .addComponent(jLabel112)
                    .addComponent(jLabel113))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Tongtien_3)
                    .addComponent(Conlai_3)
                    .addComponent(Tiennhan_3, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel57Layout.createSequentialGroup()
                        .addComponent(jLabel111)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Coc_3))
                    .addGroup(jPanel57Layout.createSequentialGroup()
                        .addComponent(jLabel114)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Tienthua_3))))
        );
        jPanel57Layout.setVerticalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel96)
                    .addComponent(Hoten_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel102)
                    .addComponent(MDT_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel103)
                    .addComponent(CMND_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel104)
                    .addComponent(Masanh_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel105)
                    .addComponent(SDT_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel106)
                    .addComponent(MaTD_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel107)
                    .addComponent(Soban_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ComboBoxnuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel109)
                        .addComponent(Soluong_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Themnuoc)
                        .addComponent(Xoanuoc))
                    .addComponent(jLabel108))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel110)
                    .addComponent(Tongtien_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel111)
                    .addComponent(Coc_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel112)
                    .addComponent(Conlai_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel113)
                    .addComponent(Tiennhan_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel114)
                    .addComponent(Tienthua_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 67, Short.MAX_VALUE))
        );

        InTiec.setText("In hóa đơn");
        InTiec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InTiecActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(Thanhtoantiec)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(InTiec)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton90))
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Thanhtoantiec)
                    .addComponent(InTiec)
                    .addComponent(jButton90)))
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addComponent(jPanel56, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane10.addTab("Hóa đơn hiện tại", jPanel25);

        jPanel59.setBackground(new java.awt.Color(204, 204, 204));
        jPanel59.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm\n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(0, 153, 0))); // NOI18N

        jLabel115.setText("Mã đặt tiệc:");

        Lammoitiecdathanhtoan.setText("Làm mới");
        Lammoitiecdathanhtoan.setOpaque(false);
        Lammoitiecdathanhtoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LammoitiecdathanhtoanActionPerformed(evt);
            }
        });

        Timkiemtiecdathanhtoan.setText("Tìm kiếm");
        Timkiemtiecdathanhtoan.setOpaque(false);
        Timkiemtiecdathanhtoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimkiemtiecdathanhtoanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel59Layout = new javax.swing.GroupLayout(jPanel59);
        jPanel59.setLayout(jPanel59Layout);
        jPanel59Layout.setHorizontalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel115)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Madattiecdathanhtoan)
                .addGap(16, 16, 16))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel59Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(Timkiemtiecdathanhtoan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Lammoitiecdathanhtoan)
                .addContainerGap())
        );
        jPanel59Layout.setVerticalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel115)
                    .addComponent(Madattiecdathanhtoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lammoitiecdathanhtoan)
                    .addComponent(Timkiemtiecdathanhtoan)))
        );

        Tabletiecdathanhtoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Số HD", "Họ tên", "CMND", "Mã sảnh", "Tổng tiền", "Cọc", "Còn lạil"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabletiecdathanhtoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabletiecdathanhtoanMouseClicked(evt);
            }
        });
        jScrollPane23.setViewportView(Tabletiecdathanhtoan);
        if (Tabletiecdathanhtoan.getColumnModel().getColumnCount() > 0) {
            Tabletiecdathanhtoan.getColumnModel().getColumn(0).setResizable(false);
            Tabletiecdathanhtoan.getColumnModel().getColumn(0).setPreferredWidth(5);
        }

        jPanel60.setBackground(new java.awt.Color(204, 204, 204));
        jPanel60.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin thanh toán", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(0, 153, 0))); // NOI18N

        jLabel116.setText("Họ tên:");

        Hoten_4.setEditable(false);

        jLabel117.setText("MĐT:");

        MDT_4.setEditable(false);

        jLabel118.setText("CMND\\Passport:");

        CMND_4.setEditable(false);

        jLabel119.setText("Mã sảnh:");

        Masanh_4.setEditable(false);

        jLabel120.setText("SĐT:");

        SDT_4.setEditable(false);

        jLabel121.setText("Mã TĐ:");

        MaTD_4.setEditable(false);

        jLabel122.setText("Số bàn:");

        Soban_4.setEditable(false);

        Tablenuoc_4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Tên nước", "Giá", "SL", "Tổng tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(Tablenuoc_4);
        if (Tablenuoc_4.getColumnModel().getColumnCount() > 0) {
            Tablenuoc_4.getColumnModel().getColumn(0).setMinWidth(15);
            Tablenuoc_4.getColumnModel().getColumn(0).setPreferredWidth(30);
            Tablenuoc_4.getColumnModel().getColumn(0).setMaxWidth(30);
            Tablenuoc_4.getColumnModel().getColumn(3).setMinWidth(15);
            Tablenuoc_4.getColumnModel().getColumn(3).setPreferredWidth(30);
            Tablenuoc_4.getColumnModel().getColumn(3).setMaxWidth(30);
        }

        jLabel123.setText("Tổng tiền:");

        Tongtien_4.setEditable(false);

        jLabel124.setText("Đã cọc:");

        Coc_4.setEditable(false);

        jLabel125.setText("Còn lại:");

        Conlai_4.setEditable(false);

        jLabel126.setText("Nhận:");

        Tiennhan_4.setEditable(false);

        jLabel127.setText("Thừa:");

        Tienthua_4.setEditable(false);

        javax.swing.GroupLayout jPanel60Layout = new javax.swing.GroupLayout(jPanel60);
        jPanel60.setLayout(jPanel60Layout);
        jPanel60Layout.setHorizontalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel60Layout.createSequentialGroup()
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel60Layout.createSequentialGroup()
                        .addComponent(jLabel116)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Hoten_4, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel60Layout.createSequentialGroup()
                        .addComponent(jLabel118)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CMND_4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel60Layout.createSequentialGroup()
                        .addComponent(jLabel117)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(MDT_4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel60Layout.createSequentialGroup()
                        .addComponent(jLabel119)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Masanh_4))))
            .addGroup(jPanel60Layout.createSequentialGroup()
                .addComponent(jLabel120)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SDT_4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel121)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MaTD_4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel122)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Soban_4))
            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel60Layout.createSequentialGroup()
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel123)
                    .addComponent(jLabel125)
                    .addComponent(jLabel126))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Tongtien_4)
                    .addComponent(Conlai_4)
                    .addComponent(Tiennhan_4, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel60Layout.createSequentialGroup()
                        .addComponent(jLabel124)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Coc_4))
                    .addGroup(jPanel60Layout.createSequentialGroup()
                        .addComponent(jLabel127)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Tienthua_4))))
        );
        jPanel60Layout.setVerticalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel60Layout.createSequentialGroup()
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel116)
                    .addComponent(Hoten_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel117)
                    .addComponent(MDT_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel118)
                    .addComponent(CMND_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel119)
                    .addComponent(Masanh_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel120)
                    .addComponent(SDT_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel121)
                    .addComponent(MaTD_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel122)
                    .addComponent(Soban_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel123)
                    .addComponent(Tongtien_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel124)
                    .addComponent(Coc_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel125)
                    .addComponent(Conlai_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel126)
                    .addComponent(Tiennhan_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel127)
                    .addComponent(Tienthua_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 67, Short.MAX_VALUE))
        );

        InTiec1.setText("In hóa đơn");
        InTiec1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InTiec1ActionPerformed(evt);
            }
        });

        jButton91.setText("Cancel");

        javax.swing.GroupLayout jPanel58Layout = new javax.swing.GroupLayout(jPanel58);
        jPanel58.setLayout(jPanel58Layout);
        jPanel58Layout.setHorizontalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel58Layout.createSequentialGroup()
                        .addComponent(InTiec1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton91)))
                .addGap(18, 18, 18))
        );
        jPanel58Layout.setVerticalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addComponent(jPanel59, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InTiec1)
                    .addComponent(jButton91))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane10.addTab("Hóa đơn đã thanh toán", jPanel58);

        jPanel40.setBackground(new java.awt.Color(204, 204, 204));
        jPanel40.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chọn thời gian lập thống kê", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(0, 153, 0))); // NOI18N

        jLabel3.setText("Tháng:");

        jLabel4.setText("Năm:");

        jButton68.setText("Cancel");
        jButton68.setOpaque(false);

        Thongketiec.setText("Lập thống kê");
        Thongketiec.setOpaque(false);
        Thongketiec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThongketiecActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Thang2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Nam2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addComponent(Thongketiec)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addComponent(jButton68, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Thang2, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Nam2, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton68)
                    .addComponent(Thongketiec))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(360, Short.MAX_VALUE))
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel39Layout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        jTabbedPane10.addTab("Thống kê doanh thu tiệc", jPanel39);

        jTabbedPane9.addTab("Hóa đơn tiệc", jTabbedPane10);

        javax.swing.GroupLayout DS_HDLayout = new javax.swing.GroupLayout(DS_HD);
        DS_HD.setLayout(DS_HDLayout);
        DS_HDLayout.setHorizontalGroup(
            DS_HDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DS_HDLayout.createSequentialGroup()
                .addComponent(jTabbedPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 981, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        DS_HDLayout.setVerticalGroup(
            DS_HDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane9)
        );

        jTabbedPane1.addTab("Danh sách hóa đơn", new javax.swing.ImageIcon(getClass().getResource("/images/bill.png")), DS_HD); // NOI18N

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách quyền", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(0, 153, 0))); // NOI18N

        jTableRole.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Tên quyền", "Chú thích"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableRole.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableRoleMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableRole);
        if (jTableRole.getColumnModel().getColumnCount() > 0) {
            jTableRole.getColumnModel().getColumn(0).setMinWidth(15);
            jTableRole.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTableRole.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thêm mới", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(0, 153, 0))); // NOI18N

        jLabel6.setText("Tên quyền:");

        jLabel7.setText("Chú thích:");

        jButtonAddRole.setText("OK");
        jButtonAddRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddRoleActionPerformed(evt);
            }
        });

        jButtonCancelAddRole.setText("Cancel");
        jButtonCancelAddRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelAddRoleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextNewRoleName)
                            .addComponent(jTextNewRoleDesc)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jButtonAddRole, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                        .addComponent(jButtonCancelAddRole, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextNewRoleName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextNewRoleDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddRole)
                    .addComponent(jButtonCancelAddRole))
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cập nhật", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(0, 153, 0))); // NOI18N

        jLabel17.setText("Tên quyền:");

        jLabel18.setText("Chú thích:");

        jButtonUpdateRole.setText("OK");
        jButtonUpdateRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateRoleActionPerformed(evt);
            }
        });

        jButtonCancelUpdateRole.setText("Cancel");
        jButtonCancelUpdateRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelUpdateRoleActionPerformed(evt);
            }
        });

        jButtonDeleteRole.setText("Xoá");
        jButtonDeleteRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteRoleActionPerformed(evt);
            }
        });

        jLabel20.setText("Id:");

        jTextRoleId.setEnabled(false);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jButtonUpdateRole, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCancelUpdateRole, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jButtonDeleteRole, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextRoleDesc))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextRoleName)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jTextRoleId, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jTextRoleId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTextRoleName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jTextRoleDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonUpdateRole)
                    .addComponent(jButtonCancelUpdateRole)
                    .addComponent(jButtonDeleteRole))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPaneRoleLayout = new javax.swing.GroupLayout(jPaneRole);
        jPaneRole.setLayout(jPaneRoleLayout);
        jPaneRoleLayout.setHorizontalGroup(
            jPaneRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaneRoleLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPaneRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        jPaneRoleLayout.setVerticalGroup(
            jPaneRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaneRoleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPaneRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPaneRoleLayout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane8.addTab("Quyền", jPaneRole);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 975, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 465, Short.MAX_VALUE)
        );

        jTabbedPane8.addTab("Nhân viên", jPanel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 975, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 465, Short.MAX_VALUE)
        );

        jTabbedPane8.addTab("Khách sạn", jPanel4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 975, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 465, Short.MAX_VALUE)
        );

        jTabbedPane8.addTab("Nhà hàng", jPanel5);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 975, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 465, Short.MAX_VALUE)
        );

        jTabbedPane8.addTab("tab5", jPanel6);

        javax.swing.GroupLayout AdminLayout = new javax.swing.GroupLayout(Admin);
        Admin.setLayout(AdminLayout);
        AdminLayout.setHorizontalGroup(
            AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane8)
        );
        AdminLayout.setVerticalGroup(
            AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane8)
        );

        jTabbedPane1.addTab("Admin                      ", new javax.swing.ImageIcon(getClass().getResource("/images/admin_setting.png")), Admin); // NOI18N

        jPanel42.setBackground(new java.awt.Color(204, 204, 204));
        jPanel42.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LOGOUT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        Okelogout.setText("OK");
        Okelogout.setOpaque(false);
        Okelogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkelogoutActionPerformed(evt);
            }
        });

        jButton101.setText("Cance");
        jButton101.setOpaque(false);

        jLabel41.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("Bạn muốn đăng xuất khỏi phần mềm ?");

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(Okelogout, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 238, Short.MAX_VALUE)
                .addComponent(jButton101, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
            .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel42Layout.createSequentialGroup()
                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Okelogout)
                    .addComponent(jButton101))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout LogoutLayout = new javax.swing.GroupLayout(Logout);
        Logout.setLayout(LogoutLayout);
        LogoutLayout.setHorizontalGroup(
            LogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogoutLayout.createSequentialGroup()
                .addGap(242, 242, 242)
                .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(212, Short.MAX_VALUE))
        );
        LogoutLayout.setVerticalGroup(
            LogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogoutLayout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(150, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Logout                      ", new javax.swing.ImageIcon(getClass().getResource("/images/logout.png")), Logout); // NOI18N

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addComponent(jLabel60)
                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel45Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(11, 11, 11))
                            .addGroup(jPanel45Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jLabel58)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 982, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel45Layout.createSequentialGroup()
                                .addComponent(jLabel59)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel58)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TracuulapdichvuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TracuulapdichvuActionPerformed
//        DefaultTableModel model = (DefaultTableModel) Tablelapdichvu.getModel();
//        DefaultTableModel model1 = (DefaultTableModel) Tabledichvu.getModel();
//        String MADAT = Madatlapdichvu.getText();
//        String SOHDDV = "";
//        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(new Locale("<em>vi</em>", "VN"));
//        decimalFormat.applyPattern("###,###,###");
//        boolean check = false;
//        ResultSet rs1 = conn.ExcuteQueryGetTable("SELECT * FROM HOA_DON where MADAT='" + MADAT + "'");
//        int temp1 = model.getRowCount();
//        int temp2 = model1.getRowCount();
//        for (int i = temp1 - 1; i >= 0; i--) {
//            model.removeRow(i);
//        }
//        for (int i = temp2 - 1; i >= 0; i--) {
//            model1.removeRow(i);
//        }
//        try {
//            while (rs1.next()) {
//                check = true;
//            }
//            if (check == false) {
//                JOptionPane.showMessageDialog(rootPane, "Mã đặt phòng chưa được thêm vào hóa đơn");
//            } else {
//                ResultSet rs = conn.ExcuteQueryGetTable("SELECT * FROM DAT_PHONG where MADAT='" + MADAT + "'");
//                while (rs.next()) {
//                    model.addRow(new Object[]{rs.getString("MADAT"), rs.getString("HOTEN"), rs.getString("CMND"),
//                        rs.getString("SDT"), rs.getString("SOPHONG")
//                    });
//                }
//                check = false;
//                ResultSet rs2 = conn.ExcuteQueryGetTable("SELECT * FROM HD_DICH_VU where MADAT='" + MADAT + "'");
//                while (rs2.next()) {
//                    check = true;
//                    SOHDDV = rs2.getString("SOHDDV");
//                }
//                if (check == true) {
//                    ResultSet rs3 = conn.ExcuteQueryGetTable("SELECT * FROM CTHD_DICH_VU where SOHDDV='" + SOHDDV + "'");
//                    while (rs3.next()) {
//                        ResultSet rs4 = conn.ExcuteQueryGetTable("SELECT * FROM DICH_VU where MADV='" + rs3.getString("MADV") + "'");
//                        while (rs4.next()) {
//                            model1.addRow(new Object[]{MADAT, rs3.getString("MADV"), rs4.getString("TENDV"),
//                                decimalFormat.format(rs4.getInt("GIA")), rs3.getInt("SOLUONG"),
//                                decimalFormat.format(rs3.getInt("SOLUONG") * rs4.getInt("GIA"))
//                            });
//                        }
//                    }
//                }
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_TracuulapdichvuActionPerformed

    private void ThanhtoanphongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThanhtoanphongActionPerformed
//        int index = Tablephonghientai.getSelectedRow();
//        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(new Locale("<em>vi</em>", "VN"));
//        decimalFormat.applyPattern("###,###,###");
//        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//        DefaultTableModel model = (DefaultTableModel) Tablephonghientai.getModel();
//        String SOHD = model.getValueAt(index, 0).toString();
//        ResultSet rs1 = conn.ExcuteQueryGetTable("SELECT * FROM HOA_DON HD inner join DAT_PHONG DP "
//                + "on HD.MADAT=DP.MADAT "
//                + "where HD.SOHD='" + SOHD + "' and HD.TINHTRANG='chua thanh toan'");
//        try {
//            while (rs1.next()) {
//                String TIENNHAN = Tiennhan_1.getText();
//                int Tien = Integer.parseInt(TIENNHAN);
//                if (Tien >= (rs1.getInt("TONGTIEN") - rs1.getInt("TIENTRA"))) {
//                    String Tienthua = String.valueOf(Tien - (rs1.getInt("TONGTIEN") - rs1.getInt("TIENTRA")));
//                    System.out.println(Tienthua);
//                    conn.ExcuteQueryUpdateDB("Update HOA_DON HD "
//                            + "set HD.TIENNHAN=" + TIENNHAN + ",HD.TIENTHUA=" + Tienthua + ","
//                            + "HD.NGAYLAP=to_date(to_char(SYSDATE,'DD/MM/YYYY HH24:MI'),'DD/MM/YYYY HH24:MI'),"
//                            + "HD.TINHTRANG='da thanh toan' "
//                            + "where HD.SOHD='" + SOHD + "'");
//                    Tienthua_1.setText(decimalFormat.format(Tien - (rs1.getInt("TONGTIEN") - rs1.getInt("TIENTRA"))));
//                    JOptionPane.showMessageDialog(rootPane, "Thanh toán thành công");
//                } else {
//                    JOptionPane.showMessageDialog(rootPane, "Nhập số tiền sai !");
//                }
//            }
//            // TODO add your handling code here:
//        } catch (SQLException ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//        }
////        SetTinhTrangPhongDefault();
////        SetMauPhong("tat ca","tat ca");
////        SetTinhTrangPhongDefault();
////        SetMauPhong("tat ca","tat ca");
    }//GEN-LAST:event_ThanhtoanphongActionPerformed

    private void OkelogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkelogoutActionPerformed
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_OkelogoutActionPerformed

    private void ThanhtoantiecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThanhtoantiecActionPerformed
//        int index = Tabletiechientai.getSelectedRow();
//        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(new Locale("<em>vi</em>", "VN"));
//        decimalFormat.applyPattern("###,###,###");
//        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//        DefaultTableModel model = (DefaultTableModel) Tabletiechientai.getModel();
//        String SOHDTIEC = model.getValueAt(index, 0).toString();
//        ResultSet rs1 = conn.ExcuteQueryGetTable("SELECT * FROM HD_TIEC HD inner join DAT_TIEC DT "
//                + "on HD.SOTIEC=DT.SOTIEC "
//                + "where HD.SOHDTIEC='" + SOHDTIEC + "' and HD.TINHTRANG='chua thanh toan'");
//        try {
//            while (rs1.next()) {
//                String TIENNHAN = Tiennhan_3.getText();
//                int Tien = Integer.parseInt(TIENNHAN);
//                if (Tien >= (rs1.getInt("TONGTIEN") - rs1.getInt("COC"))) {
//                    String Tienthua = String.valueOf(Tien - (rs1.getInt("TONGTIEN") - rs1.getInt("COC")));
//                    System.out.println(Tienthua);
//                    conn.ExcuteQueryUpdateDB("Update HD_TIEC HD "
//                            + "set HD.TIENTRA=" + TIENNHAN + ",HD.TIENTHUA=" + Tienthua + ","
//                            + "HD.NGAYLAP=to_date(to_char(SYSDATE,'DD/MM/YYYY HH24:MI'),'DD/MM/YYYY HH24:MI'),"
//                            + "HD.TINHTRANG='da thanh toan' "
//                            + "where HD.SOHDTIEC='" + SOHDTIEC + "'");
//                    Tienthua_3.setText(decimalFormat.format(Tien - (rs1.getInt("TONGTIEN") - rs1.getInt("COC"))));
//                    JOptionPane.showMessageDialog(rootPane, "Thanh toán thành công");
//                } else {
//                    JOptionPane.showMessageDialog(rootPane, "Nhập số tiền sai !");
//                }
//            }
//            // TODO add your handling code here:
//        } catch (SQLException ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//        }
////        SetTinhTrangSanhDefault();
////        SetMauSanh("tat ca");
//        // TODO add your handling code here:
////        SetTinhTrangSanhDefault();
////        SetMauSanh("tat ca");
//        // TODO add your handling code here:
    }//GEN-LAST:event_ThanhtoantiecActionPerformed

    private void LapPhieuThueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LapPhieuThueActionPerformed
//        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        String SOHDDV = "";
//        try {
//            ResultSet rs3 = conn.ExcuteQueryGetTable("select 'HD'||to_char(SOHDDV_SEQ.NEXTVAL) from dual");
//            while (rs3.next()) {
//                SOHDDV = rs3.getString("'HD'||to_char(SOHDDV_SEQ.NEXTVAL)");
//            }
//            //conn.ExcuteQueryUpdateDB("Insert into HD_DICH_VU VALUES('"+SOHDDV+"','"+MANV+"','"+MADAT+"',"+
//            //String.valueOf(THANHTIEN)+",SYSDATE)");
//            //conn.ExcuteQueryUpdateDB("update HOA_DON set HOA_DON.TONGTIEN=HOA_DON.TONGTIEN+"+String.valueOf(THANHTIEN)+
//            //  ",HOA_DON.SOHDDV='"+SOHDDV+"' where HOA_DON.MADAT='"+MADAT+"'");
//            DefaultTableModel model = (DefaultTableModel) Tablephieuthue.getModel();
//            int index = Tablephieuthue.getSelectedRow();
//            if (index != -1) {
//                boolean check = false;
//                String MADAT = (String) model.getValueAt(index, 0);
//                ResultSet rs = conn.ExcuteQueryGetTable("Select * from HOA_DON where MADAT='" + MADAT + "'");
//                while (rs.next()) {
//                    check = true;
//                }
//                if (check == true) {
//                    JOptionPane.showMessageDialog(rootPane, "Mã đặt phòng này đã được thêm trước đó!");
//                } else {
//                    ResultSet rs1 = conn.ExcuteQueryGetTable("Select * from DAT_PHONG where MADAT='" + MADAT + "'");
//                    while (rs1.next()) {
//                        String TONGTIEN = String.valueOf(rs1.getInt("TIENTRA") + rs1.getInt("TIENCON"));
//                        String NGSINH = dateFormat.format(rs1.getDate("NGAYSINH"));
//                        String NGTHUE = dateFormat.format(rs1.getDate("NGAYTHUE"));
//                        String NGTRA = dateFormat.format(rs1.getDate("NGAYTRA"));
//                        conn.ExcuteQueryUpdateDB("Insert into HD_DICH_VU VALUES('" + SOHDDV + "','" + MANV + "','" + MADAT + "',0,SYSDATE)");
//                        conn.ExcuteQueryUpdateDB("Insert into HOA_DON(SOHDDV,MANV,MADAT, TINHTRANG, TONGTIEN) VALUES('" + SOHDDV + "','" + MANV + "','" + MADAT + "','chua thanh toan'," + TONGTIEN + ")");
//                        conn.ExcuteQueryUpdateDB("Insert into LUU_TRU values('LT'||to_char(ID_SEQ.NEXTVAL),'" + rs1.getString("SOPHONG")
//                                + "','" + rs1.getString("HOTEN") + "'," + rs1.getString("CMND") + "," + rs1.getString("SDT")
//                                + ",to_date('" + NGSINH + "','DD/MM/YYYY'),to_date('" + NGTHUE + " 12:00','DD/MM/YYYY HH24:MI'),"
//                                + "'" + MADAT + "',to_date('" + NGTRA + " 12:00','DD/MM/YYYY HH24:MI'))");
//                        //System.out.printf("Insert into HOA_DON(MADAT, TINHTRANG, TONGTIEN) VALUES('"+MADAT+"','chua thanh toan',"+TONGTIEN+")");
//                        /*for (int i=0;i<50;i++){
//                            if(rs1.getString("SOPHONG").equals(Tenphong[i])){
//                                index=i;
//                            }
//                        }
//                        Jphong[index].setOpaque(true);
//                        Jphong[index].setBorderPainted(false);
//                        Jphong[index].setBackground(new Color(255,0,0));
//                        Sophongthue++;
//                        Sophongcoc--;
//                        Phongthue.setText(String.valueOf(Sophongthue));
////                        Phongcoc.setText(String.valueOf(Sophongcoc)); */
////                        SetTinhTrangPhongDefault();
////                        SetMauPhong("tat ca","tat ca");
//                        Class.forName("oracle.jdbc.driver.OracleDriver");
//                        java.sql.Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "lethien", "31101999");
//                        JasperDesign jd = JRXmlLoader.load("C:\\Users\\LeThien\\Desktop\\QLKS_GUI\\QLKS_v1.0\\src\\report\\Phieuthue.jrxml");
//                        JRDesignQuery newQuery = new JRDesignQuery();
//                        newQuery.setText("select DISTINCT DP.MADAT, DP.SOPHONG, DP.MANV,DP.NGAYTHUE,DP.NGAYTRA,DP.TIENTRA,DP.TIENCON, DP.HOTEN, DP.CMND,DP.SDT, DP.DIACHI, NV.HOTEN as TENNV, DP.TIENTRA+DP.TIENCON as TONGTIEN,LP.GIA,LP.LOAI\n"
//                                + "from DAT_PHONG DP inner join NHAN_VIEN NV\n"
//                                + "on DP.MANV=NV.MANV\n"
//                                + "inner join PHONG P\n"
//                                + "on DP.SOPHONG=P.SOPHONG\n"
//                                + "inner join LOAI_PHONG LP\n"
//                                + "on P.MALP=LP.MALP	\n"
//                                + "where DP.MADAT='" + MADAT + "'");
//                        jd.setQuery(newQuery);
//                        JasperReport jr = JasperCompileManager.compileReport(jd);
//                        JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
//                        JasperViewer.viewReport(jp, false);
//                    }
//                }
//            } else {
//                JOptionPane.showMessageDialog(rootPane, "Chưa chọn đối tượng !");
//            }
//        } catch (JRException | ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_LapPhieuThueActionPerformed

    private void LapPhieuTiecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LapPhieuTiecActionPerformed
//        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//        try {
//            DefaultTableModel model = (DefaultTableModel) Tablephieutiec.getModel();
//            int index = Tablephieutiec.getSelectedRow();
//            if (index != -1) {
//                boolean check = false;
//                String SOTIEC = (String) model.getValueAt(index, 0);
//                ResultSet rs = conn.ExcuteQueryGetTable("Select * from HD_TIEC where SOTIEC='" + SOTIEC + "'");
//                while (rs.next()) {
//                    check = true;
//                }
//                if (check == true) {
//                    JOptionPane.showMessageDialog(rootPane, "Mã đặt tiệc này đã được thêm trước đó!");
//                } else {
//                    ResultSet rs1 = conn.ExcuteQueryGetTable("Select * from DAT_TIEC where SOTIEC='" + SOTIEC + "'");
//                    while (rs1.next()) {
//                        String TONGTIEN = String.valueOf(rs1.getInt("COC") + rs1.getInt("TIENCON"));
//                        //String NGSINH = dateFormat.format(rs1.getDate("NGAYSINH"));
//                        //String TGDIENRA= dateFormat.format(rs1.getDate("NGAYTHUE"));
//                        //String NGTRA = dateFormat.format(rs1.getDate("NGAYTRA"));
//                        conn.ExcuteQueryUpdateDB("Insert into HD_TIEC(SOTIEC, TINHTRANG, TONGTIEN, TIENNUOC) VALUES('" + SOTIEC + "','chua thanh toan'," + TONGTIEN + ",0)");
//                        /*conn.ExcuteQueryUpdateDB("Insert into LUU_TRU values('LT'||to_char(ID_SEQ.NEXTVAL),'"+rs1.getString("SOPHONG")
//                        +"','"+rs1.getString("HOTEN")+"',"+rs1.getString("CMND")+","+rs1.getString("SDT")
//                        +",to_date('"+NGSINH+"','DD/MM/YYYY HH24:MI'),to_date('"+NGTHUE+" 12:00','DD/MM/YYYY HH24:MI'),"
//                                +"'"+MADAT+"',to_date('"+NGTRA+" 12:00','DD/MM/YYYY HH24:MI'))");*/
//                        //System.out.printf("Insert into HOA_DON(MADAT, TINHTRANG, TONGTIEN) VALUES('"+MADAT+"','chua thanh toan',"+TONGTIEN+")");
//                        /*for (int i=0;i<50;i++){
//                            if(rs1.getString("SOPHONG").equals(Tenphong[i])){
//                                index=i;
//                            }
//                        }
//                        Jphong[index].setOpaque(true);
//                        Jphong[index].setBorderPainted(false);
//                        Jphong[index].setBackground(new Color(255,0,0));
//                        Sophongthue++;
//                        Sophongcoc--;
//                        Phongthue.setText(String.valueOf(Sophongthue));
//                        Phongcoc.setText(String.valueOf(Sophongcoc)); */
////                        SetTinhTrangSanhDefault();
////                        SetMauSanh("tat ca");
//                        Class.forName("oracle.jdbc.driver.OracleDriver");
//                        java.sql.Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "lethien", "31101999");
//                        //InputStream in = new FileInputStream(new File("C:\\Users\\LeThien\\Desktop\\QLKS_GUI\\QLKS_v1.0\\src\\report\\Phieuthue.jrxml"));  
//                        JasperDesign jd = JRXmlLoader.load("C:\\Users\\LeThien\\Desktop\\QLKS_GUI\\QLKS_v1.0\\src\\report\\Phieutiec.jrxml");
//                        JRDesignQuery newQuery = new JRDesignQuery();
//                        newQuery.setText("select DISTINCT DT.SOTIEC, KHT.HOTEN, KHT.SDT, KHT.CMND, LT.TENLT, S.TENSANH, DT.SOBAN, TD.TEN, TD.GIA, CTTD.TENMON,CTTD.MATD, NV.MANV, NV.HOTEN AS TENNV,TD.GIA*DT.SOBAN as THANHTIEN, DT.COC,DT.TIENCON, DT.TGDIENRA\n"
//                                + "from \n"
//                                + "DAT_TIEC DT inner join KHACH_HANG_TIEC KHT on DT.MAKHTIEC=KHT.MAKHTIEC\n"
//                                + "inner join LOAI_TIEC LT on LT.MALT=DT.MALT\n"
//                                + "inner join SANH S on S.MASANH=DT.MASANH\n"
//                                + "inner join THUC_DON TD on TD.MATD=DT.MATD\n"
//                                + "inner join CT_THUC_DON CTTD on TD.MATD=CTTD.MATD\n"
//                                + "inner join NHAN_VIEN NV on NV.MANV=DT.MANV\n"
//                                + "WHERE DT.SOTIEC='" + SOTIEC + "'");
//                        jd.setQuery(newQuery);
//                        JasperReport jr = JasperCompileManager.compileReport(jd);
//                        HashMap para = new HashMap();
//                        JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
//                        JasperViewer.viewReport(jp, false);
//                    }
//                }
//            } else {
//                JOptionPane.showMessageDialog(rootPane, "Chưa chọn đối tượng !");
//            }
//        } catch (JRException | ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_LapPhieuTiecActionPerformed

    private void InPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InPhongActionPerformed
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "lethien", "31101999");
            //InputStream in = new FileInputStream(new File("C:\\Users\\LeThien\\Desktop\\QLKS_GUI\\QLKS_v1.0\\src\\report\\Phieuthue.jrxml"));  
            JasperDesign jd = JRXmlLoader.load("C:\\Users\\LeThien\\Desktop\\QLKS_GUI\\QLKS_v1.0\\src\\report\\Hoadonphong.jrxml");
            JRDesignQuery newQuery = new JRDesignQuery();
            newQuery.setText("select DISTINCT DP.MADAT, DP.SOPHONG, DP.MANV,DP.NGAYTHUE,DP.NGAYTRA,"
                    + "DP.TIENTRA,DP.TIENCON, DP.TIENTRA+DP.TIENCON as TIENPHONG, DP.HOTEN, DP.CMND,DP.SDT,"
                    + " DP.DIACHI, NV.HOTEN as TENNV, HD.TONGTIEN, LP.GIA AS GIAPHONG, LP.LOAI,HD.SOHD,"
                    + " HD.TIENNHAN, HD.TIENTHUA, HDDV.THANHTIEN, CTDV.SOLUONG, DV.TENDV, DV.DVT, DV.GIA AS GIADV,"
                    + " CTDV.SOLUONG*DV.GIA AS TONG, (DP.NGAYTRA-DP.NGAYTHUE) as SONGAY \n"
                    + "from DAT_PHONG DP inner join NHAN_VIEN NV on DP.MANV=NV.MANV\n"
                    + "inner join PHONG P on DP.SOPHONG=P.SOPHONG\n"
                    + "inner join LOAI_PHONG LP on P.MALP=LP.MALP\n"
                    + "inner join HOA_DON HD on HD.MADAT=DP.MADAT\n"
                    + "inner join HD_DICH_VU HDDV on HDDV.SOHDDV=HD.SOHDDV\n"
                    + "inner join CTHD_DICH_VU CTDV on HDDV.SOHDDV=CTDV.SOHDDV\n"
                    + "inner join DICH_VU DV on DV.MADV=CTDV.MADV\n"
                    + "where HD.MADAT='" + Madatphonghientai.getText() + "'");
            jd.setQuery(newQuery);
            JasperReport jr = JasperCompileManager.compileReport(jd);
            HashMap para = new HashMap();
            JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
            JasperViewer.viewReport(jp, false);
        } catch (JRException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_InPhongActionPerformed

    private void InTiecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InTiecActionPerformed
        String SOTIEC = Madattiechientai.getText();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "lethien", "31101999");
            //InputStream in = new FileInputStream(new File("C:\\Users\\LeThien\\Desktop\\QLKS_GUI\\QLKS_v1.0\\src\\report\\Phieuthue.jrxml"));  
            JasperDesign jd = JRXmlLoader.load("C:\\Users\\LeThien\\Desktop\\QLKS_GUI\\QLKS_v1.0\\src\\report\\Hoadontiec.jrxml");
            JRDesignQuery newQuery = new JRDesignQuery();
            newQuery.setText("select DISTINCT DT.SOTIEC, KHT.HOTEN, KHT.SDT, KHT.CMND, LT.TENLT, S.TENSANH, DT.SOBAN, TD.TEN as TENTD, TD.GIA as GIATD, TD.MATD, NV.MANV, NV.HOTEN AS TENNV,TD.GIA*DT.SOBAN as THANHTIEN, DT.COC,DT.TIENCON, HD.SOHDTIEC, HD.TONGTIEN, HD.TIENTRA, HD.TIENTHUA, HD.TIENNUOC, CTN.SOLUONG, N.TEN as TENNUOC, N.GIA as GIANUOC, N.MANUOC, N.GIA*CTN.SOLUONG AS SUMNUOC\n"
                    + "from \n"
                    + "DAT_TIEC DT inner join KHACH_HANG_TIEC KHT on DT.MAKHTIEC=KHT.MAKHTIEC\n"
                    + "inner join LOAI_TIEC LT on LT.MALT=DT.MALT\n"
                    + "inner join SANH S on S.MASANH=DT.MASANH\n"
                    + "inner join THUC_DON TD on TD.MATD=DT.MATD\n"
                    + "inner join CT_THUC_DON CTTD on TD.MATD=CTTD.MATD\n"
                    + "inner join NHAN_VIEN NV on NV.MANV=DT.MANV\n"
                    + "inner join HD_TIEC HD on HD.SOTIEC=DT.SOTIEC\n"
                    + "inner join CT_NUOC_UONG CTN on CTN.SOHDTIEC=HD.SOHDTIEC\n"
                    + "inner join NUOC_UONG N on N.MANUOC=CTN.MANUOC\n"
                    + "WHERE HD.SOTIEC='" + SOTIEC + "'");
            jd.setQuery(newQuery);
            JasperReport jr = JasperCompileManager.compileReport(jd);
            HashMap para = new HashMap();
            JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
            JasperViewer.viewReport(jp, false);
        } catch (JRException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_InTiecActionPerformed

    private void ThongketiecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThongketiecActionPerformed
        int t = Thang2.getMonth() + 1;
        int y = Nam2.getYear();
        System.out.println(String.valueOf(t) + " " + String.valueOf(y));
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "lethien", "31101999");
            //InputStream in = new FileInputStream(new File("C:\\Users\\LeThien\\Desktop\\QLKS_GUI\\QLKS_v1.0\\src\\report\\Phieuthue.jrxml"));  
            JasperDesign jd = JRXmlLoader.load("C:\\Users\\LeThien\\Desktop\\QLKS_GUI\\QLKS_v1.0\\src\\report\\Thongketiec.jrxml");
            JRDesignQuery newQuery = new JRDesignQuery();
            newQuery.setText("SELECT distinct EXTRACT(MONTH FROM NGAYLAP),  EXTRACT(YEAR FROM NGAYLAP), HDT.SOHDTIEC, HDT.MANV, HDT.SOTIEC, HDT.NGAYLAP, HDT.TONGTIEN, HDT.TIENNUOC\n"
                    + "FROM HD_TIEC HDT INNER JOIN DAT_TIEC DT ON HDT.SOTIEC=DT.SOTIEC\n"
                    + "WHERE EXTRACT(MONTH FROM NGAYLAP)=" + String.valueOf(t) + " AND EXTRACT(YEAR FROM NGAYLAP)=" + String.valueOf(y));
            jd.setQuery(newQuery);
            JasperReport jr = JasperCompileManager.compileReport(jd);
            HashMap para = new HashMap();
            JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
            JasperViewer.viewReport(jp, false);
        } catch (JRException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ThongketiecActionPerformed

    private void ThongkephongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThongkephongActionPerformed
//        int t = Thang1.getMonth() + 1;
//        int y = Nam1.getYear();
//        //System.out.println(String.valueOf(t)+" "+String.valueOf(y));
//        try {
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            java.sql.Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "lethien", "31101999");
//            //InputStream in = new FileInputStream(new File("C:\\Users\\LeThien\\Desktop\\QLKS_GUI\\QLKS_v1.0\\src\\report\\Phieuthue.jrxml"));  
//            JasperDesign jd = JRXmlLoader.load("C:\\Users\\LeThien\\Desktop\\QLKS_GUI\\QLKS_v1.0\\src\\report\\Thongkephong.jrxml");
//            JRDesignQuery newQuery = new JRDesignQuery();
//            newQuery.setText("SELECT distinct EXTRACT(MONTH FROM NGAYLAP),EXTRACT(YEAR FROM NGAYLAP), SOHD,MADAT, SOHDDV, MANV, NGAYLAP, TONGTIEN\n"
//                    + "FROM HOA_DON \n"
//                    + "WHERE EXTRACT(MONTH FROM NGAYLAP)=" + String.valueOf(t) + " AND EXTRACT(YEAR FROM NGAYLAP)=" + String.valueOf(y));
//            jd.setQuery(newQuery);
//            JasperReport jr = JasperCompileManager.compileReport(jd);
//            HashMap para = new HashMap();
//            JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
//            JasperViewer.viewReport(jp, false);
//        } catch (JRException | ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_ThongkephongActionPerformed

    private void SanhAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SanhAActionPerformed
        Order ord = new Order();
        ord.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_SanhAActionPerformed

    private void TracuulapphieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TracuulapphieuActionPerformed
//        DefaultTableModel model = (DefaultTableModel) Tablephieuthue.getModel();
//        String s = Madatlapphieu.getText();
//        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(new Locale("<em>vi</em>", "VN"));
//        decimalFormat.applyPattern("###,###,###");
//        boolean check = false;
//        ResultSet rs = conn.ExcuteQueryGetTable("SELECT * FROM DAT_PHONG");
//        int temp = model.getRowCount();
//        for (int i = temp - 1; i >= 0; i--) {
//            model.removeRow(i);
//        }
//        try {
//            while (rs.next()) {
//                if (s.equals(rs.getString("MADAT"))) {
//                    model.addRow(new Object[]{rs.getString("MADAT"), rs.getString("HOTEN"), rs.getString("CMND"),
//                        rs.getString("SDT"), rs.getString("SOPHONG"),
//                        dateFormat.format(rs.getDate("NGAYTHUE")), dateFormat.format(rs.getDate("NGAYTRA")),
//                        decimalFormat.format(rs.getInt("TIENTRA"))
//                    });
//                    check = true;
//                    //if ((dateFormat.format(rs.getDate("NGAYTRA"))) < (dateFormat.format(rs.getDate("NGAYTHUE")))){
//                    // String tam=dateFormat.format(rs.getDate("NGAYTRA")).toString().substring(0,9);
//                    //System.out.println(tam+" 14:00");
//                    //}
//                }
//            }
//            if (check == false) {
//                JOptionPane.showMessageDialog(rootPane, "Mã đặt phòng không tồn tại");
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_TracuulapphieuActionPerformed

    private void TablephieuthueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablephieuthueMouseClicked
        int index = Tablephieuthue.getSelectedRow();
        // TODO add your handling code here:
    }//GEN-LAST:event_TablephieuthueMouseClicked

    private void ThemdichvuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemdichvuActionPerformed
//        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(new Locale("<em>vi</em>", "VN"));
//        decimalFormat.applyPattern("###,###,###");
//        DefaultTableModel model = (DefaultTableModel) Tablelapdichvu.getModel();
//        DefaultTableModel model1 = (DefaultTableModel) Tabledichvu.getModel();
//        int index = Tablelapdichvu.getRowCount();
//        if ((index != 0) && (!Soluongdv.getText().equals("0"))) {
//            String MADAT = (String) model.getValueAt(0, 0);
//            //ResultSet rs1 = conn.ExcuteQueryGetTable("SELECT * FROM HD_DICH_VU where");
//            String MADV = ComboBoxtendv.getSelectedItem().toString().substring(0, 3);
//            int SL = Integer.parseInt(Soluongdv.getText());
//            ResultSet rs = conn.ExcuteQueryGetTable("SELECT * FROM DICH_VU");
//            try {
//                while (rs.next()) {
//                    boolean check = true;
//                    int templ1 = -1;
//                    if (MADV.equals(rs.getString("MADV"))) {
//                        int temp = model1.getRowCount();
//                        for (int i = temp - 1; i >= 0; i--) {
//                            if (((String) model1.getValueAt(i, 1)).equals(MADV)) {
//                                check = false;
//                                templ1 = i;
//                            }
//                        }
//                        if (check == false) {
//                            model1.setValueAt((int) model1.getValueAt(templ1, 4) + SL, templ1, 4);
//                            model1.setValueAt(decimalFormat.format((int) model1.getValueAt(templ1, 4) * rs.getInt("GIA")), templ1, 5);
//                        } else {
//                            model1.addRow(new Object[]{MADAT, rs.getString("MADV"), rs.getString("TENDV"),
//                                decimalFormat.format(rs.getInt("GIA")), SL, decimalFormat.format(SL * rs.getInt("GIA"))
//                            });
//                        }
//                    }
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } else {
//            JOptionPane.showMessageDialog(rootPane, "Chưa chọn đối tượng! ");
//        }
//        // TODO add your handling code here:
    }//GEN-LAST:event_ThemdichvuActionPerformed

    private void DeletedichvuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletedichvuActionPerformed
        int index = Tabledichvu.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) Tabledichvu.getModel();
        if (index != -1) {
            model.removeRow(index);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Chưa chọn đối tượng");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_DeletedichvuActionPerformed

    private void OkdichvuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkdichvuActionPerformed
//        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(new Locale("<em>vi</em>", "VN"));
//        decimalFormat.applyPattern("###,###,###");
//        String SOHDDV = "/0";
//        int THANHTIEN = 0;
//        int TIENPHONG = 0;
//        boolean check = false;
//        DefaultTableModel model = (DefaultTableModel) Tabledichvu.getModel();
//        int index = model.getRowCount();
//        if (index != 0) {
//            try {
//                String MADAT = (String) model.getValueAt(0, 0);
//                ResultSet rs9 = conn.ExcuteQueryGetTable("SELECT * FROM DAT_PHONG where MADAT='" + MADAT + "'");
//                while (rs9.next()) {
//                    TIENPHONG = rs9.getInt("TIENTRA") + rs9.getInt("TIENCON");
//                }
//                ResultSet rs = conn.ExcuteQueryGetTable("SELECT SOHDDV FROM HD_DICH_VU where MADAT='" + MADAT + "'");
//                for (int i = 0; i < index; i++) {
//                    ResultSet rs1 = conn.ExcuteQueryGetTable("SELECT GIA FROM DICH_VU where MADV='" + (String) model.getValueAt(i, 1) + "'");
//                    while (rs1.next()) {
//                        int GIA = rs1.getInt("GIA");
//                        THANHTIEN = THANHTIEN + (int) model.getValueAt(i, 4) * GIA;
//                    }
//                }
//                while (rs.next()) {
//                    check = true;
//                    SOHDDV = rs.getString("SOHDDV");
//                }
//                if (check == true) {
//                    conn.ExcuteQueryUpdateDB("Delete from CTHD_DICH_VU where SOHDDV='" + SOHDDV + "'");
//                    for (int i = 0; i < index; i++) {
//                        conn.ExcuteQueryUpdateDB("Insert into CTHD_DICH_VU VALUES ('" + SOHDDV + "','" + (String) model.getValueAt(i, 1)
//                                + "'," + String.valueOf((int) model.getValueAt(i, 4)) + ")");
//                    }
//                    conn.ExcuteQueryUpdateDB("update HD_DICH_VU set HD_DICH_VU.THANHTIEN=" + String.valueOf(THANHTIEN)
//                            + ", HD_DICH_VU.NGAYLAP=SYSDATE where HD_DICH_VU.SOHDDV='" + SOHDDV + "'");
//                    conn.ExcuteQueryUpdateDB("update HOA_DON set HOA_DON.TONGTIEN=" + String.valueOf(THANHTIEN) + "+" + String.valueOf(TIENPHONG)
//                            + ", HOA_DON.SOHDDV='" + SOHDDV + "' where HOA_DON.MADAT='" + MADAT + "'");
//                    JOptionPane.showMessageDialog(rootPane, "Cập nật thành công! ");
//                } else {
//                    ResultSet rs3 = conn.ExcuteQueryGetTable("select 'HD'||to_char(SOHDDV_SEQ.NEXTVAL) from dual");
//                    while (rs3.next()) {
//                        SOHDDV = rs3.getString("'HD'||to_char(SOHDDV_SEQ.NEXTVAL)");
//                    }
//                    conn.ExcuteQueryUpdateDB("Insert into HD_DICH_VU VALUES('" + SOHDDV + "','" + MANV + "','" + MADAT + "',"
//                            + String.valueOf(THANHTIEN) + ",SYSDATE)");
//                    conn.ExcuteQueryUpdateDB("update HOA_DON set HOA_DON.TONGTIEN=HOA_DON.TONGTIEN+" + String.valueOf(THANHTIEN)
//                            + ",HOA_DON.SOHDDV='" + SOHDDV + "' where HOA_DON.MADAT='" + MADAT + "'");
//                    ResultSet rs2 = conn.ExcuteQueryGetTable("SELECT SOHDDV FROM HD_DICH_VU where MADAT='" + MADAT + "'");
//                    while (rs2.next()) {
//                        SOHDDV = rs2.getString("SOHDDV");
//                    }
//                    System.out.println(SOHDDV);
//                    for (int i = 0; i < index; i++) {
//                        conn.ExcuteQueryUpdateDB("Insert into CTHD_DICH_VU VALUES ('" + SOHDDV + "','" + (String) model.getValueAt(i, 1)
//                                + "'," + String.valueOf((int) model.getValueAt(i, 4)) + ")");
//                    }
//                    JOptionPane.showMessageDialog(rootPane, "Thêm thành công! ");
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } else {
//            JOptionPane.showMessageDialog(rootPane, "Chưa chọn dịch vụ! ");
//        }
    }//GEN-LAST:event_OkdichvuActionPerformed

    private void ComboBoxloaiphongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxloaiphongActionPerformed
//        String MALP = ComboBoxloaiphong.getSelectedItem().toString();
//        DefaultTableModel model = (DefaultTableModel) Tablecoso.getModel();
//        ResultSet rs1 = conn.ExcuteQueryGetTable("SELECT MACS FROM CT_LOAI_PHONG where MALP='" + MALP + "'");
//        int i = 1;
//        int temp = model.getRowCount();
//        for (int j = temp - 1; j >= 0; j--) {
//            model.removeRow(j);
//        }
//        try {
//            while (rs1.next()) {
//                String MACS = rs1.getString("MACS");
//                ResultSet rs2 = conn.ExcuteQueryGetTable("SELECT * FROM CO_SO where MACS='" + MACS + "'");
//                while (rs2.next()) {
//                    model.addRow(new Object[]{i++, MACS, rs2.getString("TEN")});
//                }
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_ComboBoxloaiphongActionPerformed

    private void ComboBoxthucdonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxthucdonActionPerformed
//        String MATD = ComboBoxthucdon.getSelectedItem().toString();
//        DefaultTableModel model = (DefaultTableModel) Tablethucdon.getModel();
//        ResultSet rs1 = conn.ExcuteQueryGetTable("SELECT * FROM CT_THUC_DON where MATD='" + MATD + "'");
//        int i = 1;
//        int temp = model.getRowCount();
//        for (int j = temp - 1; j >= 0; j--) {
//            model.removeRow(j);
//        }
//        try {
//            while (rs1.next()) {
//                model.addRow(new Object[]{i++, rs1.getString("TENMON")});
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//        }        // TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxthucdonActionPerformed

    private void TracuuphongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TracuuphongActionPerformed

//        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        String NGAYTHUE = dateFormat.format(DateIn.getDate());
//        String NGAYTRA = dateFormat.format(DateOut.getDate());
//        String TINHTRANG = ComboBoxTinhtrangphong.getSelectedItem().toString();
//        switch (TINHTRANG) {
//            case "Tất cả":
//                TINHTRANG = "tat ca";
//                break;
//            case "Còn trống":
//                TINHTRANG = "trong";
//                break;
//            case "Đang thuê":
//                TINHTRANG = "thue";
//                break;
//            case "Đã cọc":
//                TINHTRANG = "coc";
//                break;
//        }
//        String LOAI = ComboBoxloai.getSelectedItem().toString();
//        if (LOAI.equals("Tất cả")) {
//            LOAI = "tat ca";
//        }
////        SetTinhTrangPhongDateToDate(NGAYTHUE,NGAYTRA);
////        SetMauPhong(TINHTRANG,LOAI);
//        //SetTinhTrangPhongDefault();
//
//        // TODO add your handling code here:
    }//GEN-LAST:event_TracuuphongActionPerformed

    private void LamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LamMoiActionPerformed
//        SetTinhTrangPhongDefault();
//        SetMauPhong("tat ca","tat ca");
        // TODO add your handling code here:
    }//GEN-LAST:event_LamMoiActionPerformed

    private void TimkiemdangluutruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimkiemdangluutruActionPerformed
//        String text = Textdangluutru.getText();
//        DefaultTableModel model = (DefaultTableModel) Tabledangluutru.getModel();
//        int temp = model.getRowCount();
//        for (int j = temp - 1; j >= 0; j--) {
//            model.removeRow(j);
//        }
//        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//        if (!text.equals("")) {
//            try {
//                boolean check = false;
//                if (Hoten1.isSelected()) {
//                    ResultSet rs1 = conn.ExcuteQueryGetTable("SELECT * FROM LUU_TRU where HOTEN='" + text + "' and (NGAYDEN<=SYSDATE and SYSDATE<=NGAYDI)");
//                    while (rs1.next()) {
//                        check = true;
//                        model.addRow(new Object[]{rs1.getString("ID"), rs1.getString("HOTEN"), rs1.getString("SOPHONG"), rs1.getString("CMND"),
//                            dateFormat.format(rs1.getDate("NGAYDEN")), dateFormat.format(rs1.getDate("NGAYDI"))});
//                        /*if(!rs1.getString("MADAT").equals(null)&&!rs1.getString("MADAT").equals("")){
//                                Ngayden1.getDateEditor().setEnabled(false);   
//                                Ngaydi1.getDateEditor().setEnabled(false);  
//                            }*/
//                    }
//                    rs1.close();
//                    if (check == false) {
//                        JOptionPane.showMessageDialog(rootPane, "Không tìm thấy !");
//                    }
//                } else if (CMND1.isSelected()) {
//                    try {
//                        temp = Integer.parseInt(text);
//                    } catch (NumberFormatException e) {
//                        temp = 0;
//                    }
//                    if (temp != 0) {
//                        ResultSet rs1 = conn.ExcuteQueryGetTable("SELECT * FROM LUU_TRU where CMND=" + text + " and (NGAYDEN<=SYSDATE and SYSDATE<=NGAYDI)");
//                        while (rs1.next()) {
//                            check = true;
//                            model.addRow(new Object[]{rs1.getString("ID"), rs1.getString("HOTEN"), rs1.getString("SOPHONG"), rs1.getString("CMND"),
//                                dateFormat.format(rs1.getDate("NGAYDEN")), dateFormat.format(rs1.getDate("NGAYDI"))});
//                        }
//                        rs1.close();
//                        if (check == false) {
//                            JOptionPane.showMessageDialog(rootPane, "Không tìm thấy !");
//                        }
//                    } else {
//                        JOptionPane.showMessageDialog(rootPane, "Không tìm thấy");
//                    }
//                } else if (Sophong1.isSelected()) {
//                    ResultSet rs1 = conn.ExcuteQueryGetTable("SELECT * FROM LUU_TRU where SOPHONG='" + text + "' and (NGAYDEN<=SYSDATE and SYSDATE<=NGAYDI)");
//                    while (rs1.next()) {
//                        check = true;
//                        model.addRow(new Object[]{rs1.getString("ID"), rs1.getString("HOTEN"), rs1.getString("SOPHONG"), rs1.getString("CMND"),
//                            dateFormat.format(rs1.getDate("NGAYDEN")), dateFormat.format(rs1.getDate("NGAYDI"))});
//                    }
//                    rs1.close();
//                    if (check == false) {
//                        JOptionPane.showMessageDialog(rootPane, "Không tìm thấy !");
//                    }
//                } else {
//                    JOptionPane.showMessageDialog(rootPane, "Chưa chọn phạm vi!");
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } else {
//            JOptionPane.showMessageDialog(rootPane, "Chưa nhập thông tin!");
//        }
//        // TODO add your handling code here:
    }//GEN-LAST:event_TimkiemdangluutruActionPerformed

    private void TabledangluutruMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabledangluutruMouseClicked
//        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//        int index = Tabledangluutru.getSelectedRow();
//        DefaultTableModel model = (DefaultTableModel) Tabledangluutru.getModel();
//        String ID = model.getValueAt(index, 0).toString();
//        ResultSet rs1 = conn.ExcuteQueryGetTable("SELECT * FROM LUU_TRU where ID='" + ID + "'");
//        try {
//            while (rs1.next()) {
//                Texthoten1.setText(rs1.getString("HOTEN"));
//                Textcmnd1.setText(rs1.getString("CMND"));
//                Textsdt1.setText(rs1.getString("SDT"));
//                Textsophong1.setText(rs1.getString("SOPHONG"));
//                Ngaysinh1.setDate(rs1.getDate("NGAYSINH"));
//                Ngayden1.setDate(rs1.getDate("NGAYDEN"));
//                Ngaydi1.setDate(rs1.getDate("NGAYDI"));
//                //System.out.println("'"+rs1.getString("MADAT")+"'");
//                if (rs1.getString("MADAT") != null) {
//                    Ngayden1.getDateEditor().setEnabled(false);
//                    Ngaydi1.getDateEditor().setEnabled(false);
//                    Ngaysinh1.getDateEditor().setEnabled(false);
//                    Texthoten1.setEditable(false);
//                    Textcmnd1.setEditable(false);
//                    Textsdt1.setEditable(false);
//                    Textsophong1.setEditable(false);
//                }
//            }
//            rs1.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_TabledangluutruMouseClicked

    private void TimkiemdaluutruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimkiemdaluutruActionPerformed
//        String text = Textdaluutru.getText();
//        DefaultTableModel model = (DefaultTableModel) Tabledaluutru.getModel();
//        int temp = model.getRowCount();
//        for (int j = temp - 1; j >= 0; j--) {
//            model.removeRow(j);
//        }
//        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//        if (!text.equals("")) {
//            try {
//                boolean check = false;
//                if (Hoten2.isSelected()) {
//                    ResultSet rs1 = conn.ExcuteQueryGetTable("SELECT * FROM LUU_TRU where HOTEN='" + text + "' and NGAYDEN<SYSDATE and SYSDATE>=NGAYDI");
//                    while (rs1.next()) {
//                        check = true;
//                        model.addRow(new Object[]{rs1.getString("ID"), rs1.getString("HOTEN"), rs1.getString("SOPHONG"), rs1.getString("CMND"),
//                            dateFormat.format(rs1.getDate("NGAYDEN")), dateFormat.format(rs1.getDate("NGAYDI"))});
//                        /*if(!rs1.getString("MADAT").equals(null)&&!rs1.getString("MADAT").equals("")){
//                                Ngayden1.getDateEditor().setEnabled(false);   
//                                Ngaydi1.getDateEditor().setEnabled(false);  
//                            }*/
//                    }
//                    rs1.close();
//                    if (check == false) {
//                        JOptionPane.showMessageDialog(rootPane, "Không tìm thấy !");
//                    }
//                } else if (CMND2.isSelected()) {
//                    try {
//                        temp = Integer.parseInt(text);
//                    } catch (NumberFormatException e) {
//                        temp = 0;
//                    }
//                    if (temp != 0) {
//                        ResultSet rs1 = conn.ExcuteQueryGetTable("SELECT * FROM LUU_TRU where CMND=" + text + " and NGAYDEN<SYSDATE and SYSDATE>=NGAYDI");
//                        while (rs1.next()) {
//                            check = true;
//                            model.addRow(new Object[]{rs1.getString("ID"), rs1.getString("HOTEN"), rs1.getString("SOPHONG"), rs1.getString("CMND"),
//                                dateFormat.format(rs1.getDate("NGAYDEN")), dateFormat.format(rs1.getDate("NGAYDI"))});
//                        }
//                        rs1.close();
//                        if (check == false) {
//                            JOptionPane.showMessageDialog(rootPane, "Không tìm thấy !");
//                        }
//                    } else {
//                        JOptionPane.showMessageDialog(rootPane, "Không tìm thấy");
//                    }
//                } else if (Sophong2.isSelected()) {
//                    ResultSet rs1 = conn.ExcuteQueryGetTable("SELECT * FROM LUU_TRU where SOPHONG='" + text + "' and NGAYDEN<SYSDATE and SYSDATE>=NGAYDI");
//                    while (rs1.next()) {
//                        check = true;
//                        model.addRow(new Object[]{rs1.getString("ID"), rs1.getString("HOTEN"), rs1.getString("SOPHONG"), rs1.getString("CMND"),
//                            dateFormat.format(rs1.getDate("NGAYDEN")), dateFormat.format(rs1.getDate("NGAYDI"))});
//                    }
//                    rs1.close();
//                    if (check == false) {
//                        JOptionPane.showMessageDialog(rootPane, "Không tìm thấy !");
//                    }
//                } else {
//                    JOptionPane.showMessageDialog(rootPane, "Chưa chọn phạm vi!");
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } else {
//            JOptionPane.showMessageDialog(rootPane, "Chưa nhập thông tin!");
//        }
//        // TODO add your handling code here:
//        // TODO add your handling code here:
    }//GEN-LAST:event_TimkiemdaluutruActionPerformed

    private void TabledaluutruMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabledaluutruMouseClicked
//        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        int index = Tabledaluutru.getSelectedRow();
//        DefaultTableModel model = (DefaultTableModel) Tabledaluutru.getModel();
//        String ID = model.getValueAt(index, 0).toString();
//        ResultSet rs1 = conn.ExcuteQueryGetTable("SELECT * FROM LUU_TRU where ID='" + ID + "'");
//        try {
//            while (rs1.next()) {
//                Texthoten2.setText(rs1.getString("HOTEN"));
//                Textcmnd2.setText(rs1.getString("CMND"));
//                Textsdt2.setText(rs1.getString("SDT"));
//                Textsophong2.setText(rs1.getString("SOPHONG"));
//                Ngaysinh2.setText(dateFormat.format(rs1.getDate("NGAYSINH")));
//                Ngayden2.setText(dateFormat.format(rs1.getDate("NGAYDEN")));
//                Ngaydi2.setText(dateFormat.format(rs1.getDate("NGAYDI")));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        // TODO add your handling code here:
//        // TODO add your handling code here:
    }//GEN-LAST:event_TabledaluutruMouseClicked

    private void OkdangluutruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkdangluutruActionPerformed
//        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        int index = Tabledangluutru.getSelectedRow();
//        DefaultTableModel model = (DefaultTableModel) Tabledangluutru.getModel();
//        //System.out.println(Ngayden1.getDate());
//        if (index == -1) {
//            if (!Texthoten1.getText().equals("")
//                    && !Textcmnd1.getText().equals("")
//                    && !Textsdt1.getText().equals("")
//                    && !Textsophong1.getText().equals("")
//                    && !Ngaysinh1.getDate().equals(null)
//                    && !Ngayden1.getDate().equals(null)
//                    && !Ngaydi1.getDate().equals(null)) {
//                String NGSINH = dateFormat.format(Ngaysinh1.getDate());
//                String NGTHUE = dateFormat.format(Ngayden1.getDate());
//                String NGTRA = dateFormat.format(Ngaydi1.getDate());
//                conn.ExcuteQueryUpdateDB("Insert into LUU_TRU values('LT'||to_char(ID_SEQ.NEXTVAL),'" + Textsophong1.getText()
//                        + "','" + Texthoten1.getText() + "'," + Textcmnd1.getText() + "," + Textsdt1.getText()
//                        + ",to_date('" + NGSINH + "','DD/MM/YYYY HH24:MI'),to_date('" + NGTHUE + " 12:00','DD/MM/YYYY HH24:MI'),"
//                        + "'',to_date('" + NGTRA + " 12:00','DD/MM/YYYY HH24:MI'))");
//                JOptionPane.showMessageDialog(rootPane, "Thêm thành công");
//            } else {
//                JOptionPane.showMessageDialog(rootPane, "Nhap sai!");
//            }
//        } else {
//            // String ID = model.getValueAt(index, 0).toString();
//            String ID = model.getValueAt(index, 0).toString();
//            if (!Texthoten1.getText().equals("") && !Textcmnd1.getText().equals("")
//                    && !Textsdt1.getText().equals("") && !Textsophong1.getText().equals("")
//                    && !Ngaysinh1.getDate().equals(null) && !Ngayden1.getDate().equals(null)
//                    && !Ngaydi1.getDate().equals(null)) {
//                String NGSINH = dateFormat.format(Ngaysinh1.getDate());
//                String NGTHUE = dateFormat.format(Ngayden1.getDate());
//                String NGTRA = dateFormat.format(Ngaydi1.getDate());
//                conn.ExcuteQueryUpdateDB("UPDATE LUU_TRU "
//                        + "set LUU_TRU.SOPHONG='" + Textsophong1.getText() + "',"
//                        + "LUU_TRU.HOTEN='" + Texthoten1.getText() + "',"
//                        + "LUU_TRU.CMND=" + Textcmnd1.getText() + ","
//                        + "LUU_TRU.SDT=" + Textsdt1.getText() + ","
//                        + "LUU_TRU.NGAYSINH=to_date('" + NGSINH + "','DD/MM/YYYY HH24:MI'),"
//                        + "LUU_TRU.NGAYDEN=to_date('" + NGTHUE + " 12:00','DD/MM/YYYY HH24:MI'),"
//                        + "LUU_TRU.NGAYDI=to_date('" + NGTRA + " 14:00','DD/MM/YYYY HH24:MI') "
//                        + "where LUU_TRU.ID='" + ID + "'");
//                JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công");
//            } else {
//                JOptionPane.showMessageDialog(rootPane, "Nhap sai!");
//            }
//        }
//        // TODO add your handling code here:
    }//GEN-LAST:event_OkdangluutruActionPerformed

    private void DeletedangluutruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletedangluutruActionPerformed
//        int index = Tabledangluutru.getSelectedRow();
//        DefaultTableModel model = (DefaultTableModel) Tabledangluutru.getModel();
//        if (index == -1) {
//            JOptionPane.showMessageDialog(rootPane, "Chưa chọn đối tượng!");
//        } else {
//            String ID = model.getValueAt(index, 0).toString();
//            ResultSet rs1 = conn.ExcuteQueryGetTable("Select* from LUU_TRU where ID='" + ID + "'");
//            try {
//                while (rs1.next()) {
//                    if (rs1.getString("MADAT") != null) {
//                        JOptionPane.showMessageDialog(rootPane, "Khách hàng này không thể xóa!");
//                    } else {
//                        int click = JOptionPane.showConfirmDialog(rootPane, "Bạn muốn xóa ?", "Delete", WIDTH);
//                        if (click == JOptionPane.YES_OPTION) {
//                            conn.ExcuteQueryUpdateDB("Delete from LUU_TRU where LUU_TRU.ID='" + ID + "'");
//                            JOptionPane.showMessageDialog(rootPane, "Xóa thành công " + ID);
//                        }
//                    }
//                }
//                rs1.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//        }
//// TODO add your handling code here:
    }//GEN-LAST:event_DeletedangluutruActionPerformed

    private void LammoidangluutruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LammoidangluutruActionPerformed
//        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        DefaultTableModel model = (DefaultTableModel) Tabledangluutru.getModel();
//        Textdangluutru.setText("");
//        Hoten1.setSelected(false);
//        CMND1.setSelected(false);
//        Sophong1.setSelected(false);
//        Texthoten1.setText("");
//        Textcmnd1.setText("");
//        Textsdt1.setText("");
//        Textsophong1.setText("");
//        Ngaysinh1.setDate(null);
//        Ngayden1.setDate(null);
//        Ngaydi1.setDate(null);
//        int temp = model.getRowCount();
//        for (int j = temp - 1; j >= 0; j--) {
//            model.removeRow(j);
//        }
//        ResultSet rs1 = conn.ExcuteQueryGetTable("SELECT * FROM LUU_TRU where(NGAYDEN<=SYSDATE and SYSDATE<=NGAYDI)");
//        try {
//            while (rs1.next()) {
//                model.addRow(new Object[]{rs1.getString("ID"), rs1.getString("HOTEN"), rs1.getString("SOPHONG"), rs1.getString("CMND"),
//                    dateFormat.format(rs1.getDate("NGAYDEN")), dateFormat.format(rs1.getDate("NGAYDI"))});
//            }
//            rs1.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        // TODO add your handling code here:
//        // TODO add your handling code here:
    }//GEN-LAST:event_LammoidangluutruActionPerformed

    private void LammoidaluutruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LammoidaluutruActionPerformed
//        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        DefaultTableModel model = (DefaultTableModel) Tabledaluutru.getModel();
//        Textdaluutru.setText("");
//        Hoten2.setSelected(false);
//        CMND2.setSelected(false);
//        Sophong2.setSelected(false);
//        Texthoten2.setText("");
//        Textcmnd2.setText("");
//        Textsdt2.setText("");
//        Textsophong2.setText("");
//        Ngaysinh2.setText("");
//        Ngayden2.setText("");
//        Ngaydi2.setText("");
//        int temp = model.getRowCount();
//        for (int j = temp - 1; j >= 0; j--) {
//            model.removeRow(j);
//        }
//        ResultSet rs1 = conn.ExcuteQueryGetTable("SELECT * FROM LUU_TRU where NGAYDEN<SYSDATE and SYSDATE>=NGAYDI");
//        try {
//            while (rs1.next()) {
//                model.addRow(new Object[]{rs1.getString("ID"), rs1.getString("HOTEN"), rs1.getString("SOPHONG"), rs1.getString("CMND"),
//                    dateFormat.format(rs1.getDate("NGAYDEN")), dateFormat.format(rs1.getDate("NGAYDI"))});
//            }
//            rs1.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        // TODO add your handling code here:
//        // TODO add your handling code here:
    }//GEN-LAST:event_LammoidaluutruActionPerformed

    private void TracuuphieutiecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TracuuphieutiecActionPerformed
//        DefaultTableModel model = (DefaultTableModel) Tablephieutiec.getModel();
//        String s = Madatphieutiec.getText();
//        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(new Locale("<em>vi</em>", "VN"));
//        decimalFormat.applyPattern("###,###,###");
//        boolean check = false;
//        ResultSet rs = conn.ExcuteQueryGetTable("SELECT * FROM DAT_TIEC DT inner join KHACH_HANG_TIEC KHT "
//                + "on DT.MAKHTIEC=KHT.MAKHTIEC");
//        int temp = model.getRowCount();
//        for (int i = temp - 1; i >= 0; i--) {
//            model.removeRow(i);
//        }
//        try {
//            while (rs.next()) {
//                if (s.equals(rs.getString("SOTIEC"))) {
//                    model.addRow(new Object[]{rs.getString("SOTIEC"), rs.getString("HOTEN"), rs.getString("MATD"),
//                        rs.getString("MASANH"), rs.getString("CMND"), rs.getString("SDT"),
//                        dateFormat.format(rs.getDate("TGDIENRA")), decimalFormat.format(rs.getInt("COC")),
//                        decimalFormat.format(rs.getInt("TIENCON"))
//                    });
//                    check = true;
//                    //if ((dateFormat.format(rs.getDate("NGAYTRA"))) < (dateFormat.format(rs.getDate("NGAYTHUE")))){
//                    // String tam=dateFormat.format(rs.getDate("NGAYTRA")).toString().substring(0,9);
//                    //System.out.println(tam+" 14:00");
//                    //}
//                }
//            }
//            if (check == false) {
//                JOptionPane.showMessageDialog(rootPane, "Mã đặt phòng không tồn tại");
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        // TODO add your handling code here:
//        // TODO add your handling code here:
    }//GEN-LAST:event_TracuuphieutiecActionPerformed

    private void TracuutiecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TracuutiecActionPerformed
//        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        String NGAYTHUE = dateFormat.format(DateIn2.getDate());
//        //String NGAYTRA = dateFormat.format(DateOut2.getDate());
//        String TINHTRANG = ComboBoxtinhtrangsanh.getSelectedItem().toString();
//        switch (TINHTRANG) {
//            case "Tất cả":
//                TINHTRANG = "tat ca";
//                break;
//            case "Còn trống":
//                TINHTRANG = "trong";
//                break;
//            case "Đang thuê":
//                TINHTRANG = "thue";
//                break;
//            case "Đã cọc":
//                TINHTRANG = "coc";
//                break;
//        }
////        SetTinhTrangSanhDate(NGAYTHUE);
////        SetMauSanh(TINHTRANG);
//        // TODO add your handling code here:
    }//GEN-LAST:event_TracuutiecActionPerformed

    private void LammoitiecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LammoitiecActionPerformed
//        SetTinhTrangSanhDefault();
//        SetMauSanh("tat ca");
        // TODO add your handling code here:
    }//GEN-LAST:event_LammoitiecActionPerformed

    private void TimkiemhoadonhientaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimkiemhoadonhientaiActionPerformed
//        String MADAT = Madatphonghientai.getText();
//        DefaultTableModel model = (DefaultTableModel) Tablephonghientai.getModel();
//        int temp = model.getRowCount();
//        for (int j = temp - 1; j >= 0; j--) {
//            model.removeRow(j);
//        }
//        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(new Locale("<em>vi</em>", "VN"));
//        decimalFormat.applyPattern("###,###,###");
//        boolean check = false;
//        if (!MADAT.equals("")) {
//            try {
//                ResultSet rs = conn.ExcuteQueryGetTable("SELECT * FROM HOA_DON HD inner join DAT_PHONG DP on DP.MADAT=HD.MADAT "
//                        + "where DP.MADAT='" + MADAT + "' and HD.TINHTRANG='chua thanh toan'");
//                while (rs.next()) {
//                    check = true;
//                    model.addRow(new Object[]{rs.getString("SOHD"), rs.getString("HOTEN"), rs.getString("SOPHONG"), rs.getString("CMND"),
//                        decimalFormat.format(rs.getInt("TONGTIEN")), decimalFormat.format(rs.getInt("TIENTRA")),
//                        decimalFormat.format(rs.getInt("TONGTIEN") - rs.getInt("TIENTRA"))});
//                }
//                rs.close();
//                if (check == false) {
//                    JOptionPane.showMessageDialog(rootPane, "Không tìm thấy !");
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } else {
//            JOptionPane.showMessageDialog(rootPane, "Chưa nhập thông tin!");
//        }
//        // TODO add your handling code here:
    }//GEN-LAST:event_TimkiemhoadonhientaiActionPerformed

    private void TablephonghientaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablephonghientaiMouseClicked
//        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(new Locale("<em>vi</em>", "VN"));
//        decimalFormat.applyPattern("###,###,###");
//        int index = Tablephonghientai.getSelectedRow();
//        DefaultTableModel model = (DefaultTableModel) Tablephonghientai.getModel();
//        String SOHD = model.getValueAt(index, 0).toString();
//        System.out.println(SOHD);
//        ResultSet rs1 = conn.ExcuteQueryGetTable("SELECT * FROM HOA_DON HD inner join DAT_PHONG DP "
//                + "on HD.MADAT=DP.MADAT "
//                + " where HD.SOHD='" + SOHD + "'");
//        String SOHDDV = "";
//        try {
//            while (rs1.next()) {
//                SOHDDV = rs1.getString("SOHDDV");
//                Hoten_1.setText(rs1.getString("HOTEN"));
//                MDP_1.setText(rs1.getString("MADAT"));
//                SDT_1.setText(rs1.getString("SDT"));
//                Sophong_1.setText(rs1.getString("SOPHONG"));
//                CMND_1.setText(rs1.getString("CMND"));
//                //Ngaysinh1.setDate(rs1.getDate("NGAYSINH"));
//                Ngayden_1.setText(dateFormat.format(rs1.getDate("NGAYTHUE")));
//                Ngaydi_1.setText(dateFormat.format(rs1.getDate("NGAYTRA")));
//                Tongtien_1.setText(decimalFormat.format(rs1.getInt("TONGTIEN")));
//                Coc_1.setText(decimalFormat.format(rs1.getInt("TIENTRA")));
//                Conlai_1.setText(decimalFormat.format(rs1.getInt("TONGTIEN") - rs1.getInt("TIENTRA")));
//                //System.out.println("'"+rs1.getString("MADAT")+"'");
//            }
//            rs1.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        DefaultTableModel model1 = (DefaultTableModel) TableDV.getModel();
//        int temp = model1.getRowCount();
//        for (int j = temp - 1; j >= 0; j--) {
//            model1.removeRow(j);
//        }
//        ResultSet rs2 = conn.ExcuteQueryGetTable("SELECT * FROM HD_DICH_VU HDDV inner join CTHD_DICH_VU CTHD "
//                + "on HDDV.SOHDDV=CTHD.SOHDDV "
//                + "inner join DICH_VU DV "
//                + "on CTHD.MADV=DV.MADV  where HDDV.SOHDDV='" + SOHDDV + "'");
//        try {
//            while (rs2.next()) {
//                model1.addRow(new Object[]{rs2.getString("TENDV"), decimalFormat.format(rs2.getInt("GIA")), rs2.getInt("SOLUONG"),
//                    decimalFormat.format(rs2.getInt("GIA") * rs2.getInt("SOLUONG"))});
//            }
//            rs2.close();
//            // TODO add your handling code here:
//        } catch (SQLException ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_TablephonghientaiMouseClicked

    private void TimkiemphongdathanhtoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimkiemphongdathanhtoanActionPerformed
//        String MADAT = Madatphongdathanhtoan.getText();
//        DefaultTableModel model = (DefaultTableModel) Tablephongdathanhtoan.getModel();
//        int temp = model.getRowCount();
//        for (int j = temp - 1; j >= 0; j--) {
//            model.removeRow(j);
//        }
//        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(new Locale("<em>vi</em>", "VN"));
//        decimalFormat.applyPattern("###,###,###");
//        boolean check = false;
//        if (!MADAT.equals("")) {
//            try {
//                ResultSet rs = conn.ExcuteQueryGetTable("SELECT * FROM HOA_DON HD inner join DAT_PHONG DP on DP.MADAT=HD.MADAT "
//                        + "where DP.MADAT='" + MADAT + "' and HD.TINHTRANG='da thanh toan'");
//                while (rs.next()) {
//                    check = true;
//                    model.addRow(new Object[]{rs.getString("SOHD"), rs.getString("HOTEN"), rs.getString("SOPHONG"), rs.getString("CMND"),
//                        decimalFormat.format(rs.getInt("TONGTIEN")), decimalFormat.format(rs.getInt("TIENTRA")),
//                        decimalFormat.format(rs.getInt("TONGTIEN") - rs.getInt("TIENTRA"))});
//                }
//                rs.close();
//                if (check == false) {
//                    JOptionPane.showMessageDialog(rootPane, "Không tìm thấy !");
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } else {
//            JOptionPane.showMessageDialog(rootPane, "Chưa nhập thông tin!");
//        }
//        // TODO add your handling code here:
    }//GEN-LAST:event_TimkiemphongdathanhtoanActionPerformed

    private void TablephongdathanhtoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablephongdathanhtoanMouseClicked
//        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(new Locale("<em>vi</em>", "VN"));
//        decimalFormat.applyPattern("###,###,###");
//        int index = Tablephongdathanhtoan.getSelectedRow();
//        DefaultTableModel model = (DefaultTableModel) Tablephongdathanhtoan.getModel();
//        String SOHD = model.getValueAt(index, 0).toString();
//        ResultSet rs1 = conn.ExcuteQueryGetTable("SELECT * FROM HOA_DON HD inner join DAT_PHONG DP "
//                + "on HD.MADAT=DP.MADAT "
//                + "inner join HD_DICH_VU HDDV "
//                + "on HD.SOHDDV=HDDV.SOHDDV  where HD.SOHD='" + SOHD + "'");
//        String SOHDDV = "";
//        try {
//            while (rs1.next()) {
//                SOHDDV = rs1.getString("SOHDDV");
//                Hoten_2.setText(rs1.getString("HOTEN"));
//                MDP_2.setText(rs1.getString("CMND"));
//                SDT_2.setText(rs1.getString("SDT"));
//                Sophong_2.setText(rs1.getString("SOPHONG"));
//                CMND_2.setText(rs1.getString("CMND"));
//                //Ngaysinh1.setDate(rs1.getDate("NGAYSINH"));
//                Ngayden_2.setText(dateFormat.format(rs1.getDate("NGAYTHUE")));
//                Ngaydi_2.setText(dateFormat.format(rs1.getDate("NGAYTRA")));
//                Tongtien_2.setText(decimalFormat.format(rs1.getInt("TONGTIEN")));
//                Coc_2.setText(decimalFormat.format(rs1.getInt("TIENTRA")));
//                Conlai_2.setText(decimalFormat.format(rs1.getInt("TONGTIEN") - rs1.getInt("TIENTRA")));
//                Tiennhan_2.setText(decimalFormat.format(rs1.getInt("TIENNHAN")));
//                Tienthua_2.setText(decimalFormat.format(rs1.getInt("TIENTHUA")));
//                //System.out.println("'"+rs1.getString("MADAT")+"'");
//            }
//            rs1.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        DefaultTableModel model1 = (DefaultTableModel) TableDV2.getModel();
//        int temp = model1.getRowCount();
//        for (int j = temp - 1; j >= 0; j--) {
//            model1.removeRow(j);
//        }
//        ResultSet rs2 = conn.ExcuteQueryGetTable("SELECT * FROM HD_DICH_VU HDDV inner join CTHD_DICH_VU CTHD "
//                + "on HDDV.SOHDDV=CTHD.SOHDDV "
//                + "inner join DICH_VU DV "
//                + "on CTHD.MADV=DV.MADV  where HDDV.SOHDDV='" + SOHDDV + "'");
//        try {
//            while (rs2.next()) {
//                model1.addRow(new Object[]{rs2.getString("TENDV"), decimalFormat.format(rs2.getInt("GIA")), rs2.getInt("SOLUONG"),
//                    decimalFormat.format(rs2.getInt("GIA") * rs2.getInt("SOLUONG"))});
//            }
//            rs2.close();
//            // TODO add your handling code here:
//        } catch (SQLException ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        // TODO add your handling code here:
//        // TODO add your handling code here:
    }//GEN-LAST:event_TablephongdathanhtoanMouseClicked

    private void LammoiphonghientaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LammoiphonghientaiActionPerformed
//        DefaultTableModel model = (DefaultTableModel) Tablephonghientai.getModel();
//        int temp = model.getRowCount();
//        for (int j = temp - 1; j >= 0; j--) {
//            model.removeRow(j);
//        }
//        DefaultTableModel model1 = (DefaultTableModel) TableDV.getModel();
//        temp = model1.getRowCount();
//        for (int j = temp - 1; j >= 0; j--) {
//            model1.removeRow(j);
//        }
//        Madatphonghientai.setText("");
//        Hoten_1.setText("");
//        MDP_1.setText("");
//        SDT_1.setText("");
//        Sophong_1.setText("");
//        CMND_1.setText("");
//        //Ngaysinh1.setDate(rs1.getDate("NGAYSINH"));
//        Ngayden_1.setText("");
//        Ngaydi_1.setText("");
//        Tongtien_1.setText("");
//        Coc_1.setText("");
//        Conlai_1.setText("");
//        Tiennhan_1.setText("");
//        Tienthua_1.setText("");
//        // TODO add your handling code here:
    }//GEN-LAST:event_LammoiphonghientaiActionPerformed

    private void LammoiphongdathanhtoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LammoiphongdathanhtoanActionPerformed
//        DefaultTableModel model = (DefaultTableModel) Tablephongdathanhtoan.getModel();
//        int temp = model.getRowCount();
//        for (int j = temp - 1; j >= 0; j--) {
//            model.removeRow(j);
//        }
//        DefaultTableModel model1 = (DefaultTableModel) TableDV2.getModel();
//        temp = model1.getRowCount();
//        for (int j = temp - 1; j >= 0; j--) {
//            model1.removeRow(j);
//        }
//        Madatphongdathanhtoan.setText("");
//        Hoten_2.setText("");
//        MDP_2.setText("");
//        SDT_2.setText("");
//        Sophong_2.setText("");
//        CMND_2.setText("");
//        //Ngaysinh1.setDate(rs1.getDate("NGAYSINH"));
//        Ngayden_2.setText("");
//        Ngaydi_2.setText("");
//        Tongtien_2.setText("");
//        Coc_2.setText("");
//        Conlai_2.setText("");
//        Tiennhan_2.setText("");
//        Tienthua_2.setText("");
//        // TODO add your handling code here:
//        // TODO add your handling code here:
    }//GEN-LAST:event_LammoiphongdathanhtoanActionPerformed

    private void TimkiemtiechientaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimkiemtiechientaiActionPerformed
//        String SOTIEC = Madattiechientai.getText();
//        DefaultTableModel model = (DefaultTableModel) Tabletiechientai.getModel();
//        int temp = model.getRowCount();
//        for (int j = temp - 1; j >= 0; j--) {
//            model.removeRow(j);
//        }
//        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(new Locale("<em>vi</em>", "VN"));
//        decimalFormat.applyPattern("###,###,###");
//        boolean check = false;
//        if (!SOTIEC.equals("")) {
//            try {
//                ResultSet rs = conn.ExcuteQueryGetTable("SELECT * FROM HD_TIEC HD inner join DAT_TIEC DP on DP.SOTIEC=HD.SOTIEC "
//                        + "inner join KHACH_HANG_TIEC KHT on KHT.MAKHTIEC=DP.MAKHTIEC "
//                        + "where DP.SOTIEC='" + SOTIEC + "' and HD.TINHTRANG='chua thanh toan'");
//                while (rs.next()) {
//                    check = true;
//                    model.addRow(new Object[]{rs.getString("SOHDTIEC"), rs.getString("HOTEN"), rs.getString("MASANH"), rs.getString("CMND"),
//                        decimalFormat.format(rs.getInt("TONGTIEN")), decimalFormat.format(rs.getInt("COC")),
//                        decimalFormat.format(rs.getInt("TONGTIEN") - rs.getInt("COC"))});
//                }
//                rs.close();
//                if (check == false) {
//                    JOptionPane.showMessageDialog(rootPane, "Không tìm thấy !");
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } else {
//            JOptionPane.showMessageDialog(rootPane, "Chưa nhập thông tin!");
//        }
//        // TODO add your handling code here:
    }//GEN-LAST:event_TimkiemtiechientaiActionPerformed

    private void TabletiechientaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabletiechientaiMouseClicked
//        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(new Locale("<em>vi</em>", "VN"));
//        decimalFormat.applyPattern("###,###,###");
//        int index = Tabletiechientai.getSelectedRow();
//        DefaultTableModel model = (DefaultTableModel) Tabletiechientai.getModel();
//        String SOHDTIEC = model.getValueAt(index, 0).toString();
//        System.out.println(SOHDTIEC);
//        ResultSet rs1 = conn.ExcuteQueryGetTable("SELECT * FROM HD_TIEC HD inner join DAT_TIEC DT "
//                + "on HD.SOTIEC=DT.SOTIEC "
//                + "inner join KHACH_HANG_TIEC KHT "
//                + "on DT.MAKHTIEC=KHT.MAKHTIEC  where HD.SOHDTIEC='" + SOHDTIEC + "'");
//        //String SOHDDV="";
//        try {
//            while (rs1.next()) {
//                //SOHDDV=rs1.getString("SOHDDV");
//                Hoten_3.setText(rs1.getString("HOTEN"));
//                MDT_3.setText(rs1.getString("SOTIEC"));
//                SDT_3.setText(rs1.getString("SDT"));
//                Masanh_3.setText(rs1.getString("MASANH"));
//                CMND_3.setText(rs1.getString("CMND"));
//                MaTD_3.setText(rs1.getString("MATD"));
//                Soban_3.setText(rs1.getString("SOBAN"));
//                //Ngaysinh1.setDate(rs1.getDate("NGAYSINH"));
//                //Ngayden_1.setText(dateFormat.format(rs1.getDate("NGAYTHUE")));
//                //Ngaydi_1.setText(dateFormat.format(rs1.getDate("NGAYTRA")));
//                Tongtien_3.setText(decimalFormat.format(rs1.getInt("TONGTIEN")));
//                Coc_3.setText(decimalFormat.format(rs1.getInt("COC")));
//                Conlai_3.setText(decimalFormat.format(rs1.getInt("TONGTIEN") - rs1.getInt("COC")));
//                //System.out.println("'"+rs1.getString("MADAT")+"'");
//            }
//            rs1.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        DefaultTableModel model1 = (DefaultTableModel) Tablenuoc_3.getModel();
//        int temp = model1.getRowCount();
//        for (int j = temp - 1; j >= 0; j--) {
//            model1.removeRow(j);
//        }
//        ResultSet rs2 = conn.ExcuteQueryGetTable("SELECT * FROM HD_TIEC HD inner join CT_NUOC_UONG CTN "
//                + "on CTN.SOHDTIEC=HD.SOHDTIEC "
//                + "inner join NUOC_UONG NC "
//                + "on NC.MANUOC=CTN.MANUOC  where HD.SOHDTIEC='" + SOHDTIEC + "'");
//        try {
//            while (rs2.next()) {
//                model1.addRow(new Object[]{rs2.getString("MANUOC"), rs2.getString("TEN"), decimalFormat.format(rs2.getInt("GIA")), rs2.getInt("SOLUONG"),
//                    decimalFormat.format(rs2.getInt("GIA") * rs2.getInt("SOLUONG"))});
//            }
//            rs2.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        /*DefaultTableModel model1 = (DefaultTableModel) TableDV.getModel(); 
//        int temp=model1.getRowCount();
//        for (int j = temp-1;j>=0;j--){
//            model1.removeRow(j);
//        }
//        ResultSet rs2 = conn.ExcuteQueryGetTable("SELECT * FROM HD_DICH_VU HDDV inner join CTHD_DICH_VU CTHD "
//                + "on HDDV.SOHDDV=CTHD.SOHDDV "
//                + "inner join DICH_VU DV "
//                + "on CTHD.MADV=DV.MADV  where HDDV.SOHDDV='"+SOHDDV+"'");
//        try {
//            while(rs2.next()){
//                model1.addRow(new Object[]{rs2.getString("TENDV"),decimalFormat.format(rs2.getInt("GIA")),rs2.getInt("SOLUONG"),
//                                                        decimalFormat.format(rs2.getInt("GIA")*rs2.getInt("SOLUONG"))});
//            }
//            rs2.close();
//            // TODO add your handling code here:
//        } catch (SQLException ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//        }*/
//        // TODO add your handling code here:
//        /*DefaultTableModel model1 = (DefaultTableModel) TableDV.getModel(); 
//        int temp=model1.getRowCount();
//        for (int j = temp-1;j>=0;j--){
//            model1.removeRow(j);
//        }
//        ResultSet rs2 = conn.ExcuteQueryGetTable("SELECT * FROM HD_DICH_VU HDDV inner join CTHD_DICH_VU CTHD "
//                + "on HDDV.SOHDDV=CTHD.SOHDDV "
//                + "inner join DICH_VU DV "
//                + "on CTHD.MADV=DV.MADV  where HDDV.SOHDDV='"+SOHDDV+"'");
//        try {
//            while(rs2.next()){
//                model1.addRow(new Object[]{rs2.getString("TENDV"),decimalFormat.format(rs2.getInt("GIA")),rs2.getInt("SOLUONG"),
//                                                        decimalFormat.format(rs2.getInt("GIA")*rs2.getInt("SOLUONG"))});
//            }
//            rs2.close();
//            // TODO add your handling code here:
//        } catch (SQLException ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//        }*/
//        // TODO add your handling code here:
    }//GEN-LAST:event_TabletiechientaiMouseClicked

    private void ThemnuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemnuocActionPerformed
//        int index = Tabletiechientai.getSelectedRow();
//        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(new Locale("<em>vi</em>", "VN"));
//        decimalFormat.applyPattern("###,###,###");
//        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//        DefaultTableModel model = (DefaultTableModel) Tabletiechientai.getModel();
//        String SOHDTIEC = model.getValueAt(index, 0).toString();
//        String MANUOC = ComboBoxnuoc.getSelectedItem().toString();
//        String SL = Soluong_3.getText();
//        DefaultTableModel model1 = (DefaultTableModel) Tablenuoc_3.getModel();
//        int temp = model1.getRowCount();
//        for (int j = temp - 1; j >= 0; j--) {
//            model1.removeRow(j);
//        }
//        boolean check = false;
//        ResultSet rs = conn.ExcuteQueryGetTable("Select * from CT_NUOC_UONG where MANUOC='" + MANUOC + "' and SOHDTIEC='" + SOHDTIEC + "'");
//        try {
//            while (rs.next()) {
//                check = true;
//                conn.ExcuteQueryUpdateDB("Update CT_NUOC_UONG CTN set  "
//                        + "CTN.SOLUONG=CTN.SOLUONG+" + SL + " where CTN.MANUOC='" + MANUOC + "' and CTN.SOHDTIEC='" + SOHDTIEC + "'");
//            }
//            rs.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        if (check == false) {
//            conn.ExcuteQueryUpdateDB("Insert into CT_NUOC_UONG values('" + MANUOC + "','" + SOHDTIEC + "'," + SL + ")");
//        }
//        ResultSet rs1 = conn.ExcuteQueryGetTable("SELECT * FROM HD_TIEC HD inner join CT_NUOC_UONG CTN "
//                + "on CTN.SOHDTIEC=HD.SOHDTIEC "
//                + "inner join NUOC_UONG NC "
//                + "on NC.MANUOC=CTN.MANUOC  where HD.SOHDTIEC='" + SOHDTIEC + "'");
//        try {
//            while (rs1.next()) {
//                conn.ExcuteQueryUpdateDB("Update HD_TIEC HD set "
//                        + "HD.TONGTIEN=HD.TONGTIEN+" + SL + "*" + rs1.getString("GIA") + ",HD.TIENNUOC=HD.TIENNUOC+" + SL + "*" + rs1.getString("GIA"));
//                model1.addRow(new Object[]{rs1.getString("MANUOC"), rs1.getString("TEN"), decimalFormat.format(rs1.getInt("GIA")), rs1.getInt("SOLUONG"),
//                    decimalFormat.format(rs1.getInt("GIA") * rs1.getInt("SOLUONG"))});
//            }
//            rs1.close();
//            ResultSet rs2 = conn.ExcuteQueryGetTable("Select * from HD_TIEC HD inner join DAT_TIEC DT on DT.SOTIEC=HD.SOTIEC where HD.SOHDTIEC='" + SOHDTIEC + "'");
//            while (rs2.next()) {
//                Tongtien_3.setText(decimalFormat.format(rs2.getInt("TONGTIEN")));
//                Conlai_3.setText(decimalFormat.format(rs2.getInt("TONGTIEN") - rs2.getInt("COC")));
//            }
//            // TODO add your handling code here:
//        } catch (SQLException ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_ThemnuocActionPerformed

    private void XoanuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoanuocActionPerformed
//        int index = Tabletiechientai.getSelectedRow();
//        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(new Locale("<em>vi</em>", "VN"));
//        decimalFormat.applyPattern("###,###,###");
//        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//        DefaultTableModel model = (DefaultTableModel) Tabletiechientai.getModel();
//        String SOHDTIEC = model.getValueAt(index, 0).toString();
//        DefaultTableModel model1 = (DefaultTableModel) Tablenuoc_3.getModel();
//        index = Tablenuoc_3.getSelectedRow();
//        String MANUOC = model1.getValueAt(index, 0).toString();
//        String SL = model1.getValueAt(index, 3).toString();
//        model1.removeRow(index);
//        ResultSet rs1 = conn.ExcuteQueryGetTable("SELECT * FROM HD_TIEC HD inner join CT_NUOC_UONG CTN "
//                + "on CTN.SOHDTIEC=HD.SOHDTIEC "
//                + "inner join NUOC_UONG NC "
//                + "on NC.MANUOC=CTN.MANUOC  where CTN.SOHDTIEC='" + SOHDTIEC + "' and CTN.MANUOC='" + MANUOC + "'");
//        try {
//            while (rs1.next()) {
//                conn.ExcuteQueryUpdateDB("Update HD_TIEC HD set "
//                        + "HD.TONGTIEN=HD.TONGTIEN-" + SL + "*" + rs1.getString("GIA") + ",HD.TIENNUOC=HD.TIENNUOC-" + SL + "*" + rs1.getString("GIA"));
//            }
//            conn.ExcuteQueryUpdateDB("Delete from CT_NUOC_UONG CTN where CTN.SOHDTIEC='" + SOHDTIEC + "' and CTN.MANUOC='" + MANUOC + "'");
//            rs1.close();
//            ResultSet rs2 = conn.ExcuteQueryGetTable("Select * from HD_TIEC HD inner join DAT_TIEC DT on DT.SOTIEC=HD.SOTIEC "
//                    + "where HD.SOHDTIEC='" + SOHDTIEC + "'");
//            while (rs2.next()) {
//                Tongtien_3.setText(decimalFormat.format(rs2.getInt("TONGTIEN")));
//                Conlai_3.setText(decimalFormat.format(rs2.getInt("TONGTIEN") - rs2.getInt("COC")));
//            }
//            // TODO add your handling code here:
//        } catch (SQLException ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        // TODO add your handling code here:
//        // TODO add your handling code here:
    }//GEN-LAST:event_XoanuocActionPerformed

    private void TimkiemtiecdathanhtoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimkiemtiecdathanhtoanActionPerformed
//        String SOTIEC = Madattiecdathanhtoan.getText();
//        DefaultTableModel model = (DefaultTableModel) Tabletiecdathanhtoan.getModel();
//        int temp = model.getRowCount();
//        for (int j = temp - 1; j >= 0; j--) {
//            model.removeRow(j);
//        }
//        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(new Locale("<em>vi</em>", "VN"));
//        decimalFormat.applyPattern("###,###,###");
//        boolean check = false;
//        if (!SOTIEC.equals("")) {
//            try {
//                ResultSet rs = conn.ExcuteQueryGetTable("SELECT * FROM HD_TIEC HD inner join DAT_TIEC DP on DP.SOTIEC=HD.SOTIEC "
//                        + "inner join KHACH_HANG_TIEC KHT on KHT.MAKHTIEC=DP.MAKHTIEC "
//                        + "where DP.SOTIEC='" + SOTIEC + "' and HD.TINHTRANG='da thanh toan'");
//                while (rs.next()) {
//                    check = true;
//                    model.addRow(new Object[]{rs.getString("SOHDTIEC"), rs.getString("HOTEN"), rs.getString("MASANH"), rs.getString("CMND"),
//                        decimalFormat.format(rs.getInt("TONGTIEN")), decimalFormat.format(rs.getInt("COC")),
//                        decimalFormat.format(rs.getInt("TONGTIEN") - rs.getInt("COC"))});
//                }
//                rs.close();
//                if (check == false) {
//                    JOptionPane.showMessageDialog(rootPane, "Không tìm thấy !");
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } else {
//            JOptionPane.showMessageDialog(rootPane, "Chưa nhập thông tin!");
//        }
//        // TODO add your handling code here:
    }//GEN-LAST:event_TimkiemtiecdathanhtoanActionPerformed

    private void TabletiecdathanhtoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabletiecdathanhtoanMouseClicked
//        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(new Locale("<em>vi</em>", "VN"));
//        decimalFormat.applyPattern("###,###,###");
//        int index = Tabletiecdathanhtoan.getSelectedRow();
//        DefaultTableModel model = (DefaultTableModel) Tabletiecdathanhtoan.getModel();
//        String SOHDTIEC = model.getValueAt(index, 0).toString();
//        ResultSet rs1 = conn.ExcuteQueryGetTable("SELECT * FROM HD_TIEC HD inner join DAT_TIEC DT "
//                + "on HD.SOTIEC=DT.SOTIEC "
//                + "inner join KHACH_HANG_TIEC KHT "
//                + "on DT.MAKHTIEC=KHT.MAKHTIEC  where HD.SOHDTIEC='" + SOHDTIEC + "'");
//        //String SOHDDV="";
//        try {
//            while (rs1.next()) {
//                //SOHDDV=rs1.getString("SOHDDV");
//                Hoten_4.setText(rs1.getString("HOTEN"));
//                MDT_4.setText(rs1.getString("SOTIEC"));
//                SDT_4.setText(rs1.getString("SDT"));
//                Masanh_4.setText(rs1.getString("MASANH"));
//                CMND_4.setText(rs1.getString("CMND"));
//                MaTD_4.setText(rs1.getString("MATD"));
//                Soban_4.setText(rs1.getString("SOBAN"));
//                //Ngaysinh1.setDate(rs1.getDate("NGAYSINH"));
//                //Ngayden_1.setText(dateFormat.format(rs1.getDate("NGAYTHUE")));
//                //Ngaydi_1.setText(dateFormat.format(rs1.getDate("NGAYTRA")));
//                Tongtien_4.setText(decimalFormat.format(rs1.getInt("TONGTIEN")));
//                Coc_4.setText(decimalFormat.format(rs1.getInt("COC")));
//                Conlai_4.setText(decimalFormat.format(rs1.getInt("TONGTIEN") - rs1.getInt("COC")));
//                Tiennhan_4.setText(decimalFormat.format(rs1.getInt("TIENTRA")));
//                Tienthua_4.setText(decimalFormat.format(rs1.getInt("TIENTHUA")));
//                //System.out.println("'"+rs1.getString("MADAT")+"'");
//            }
//            rs1.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        DefaultTableModel model1 = (DefaultTableModel) Tablenuoc_4.getModel();
//        int temp = model1.getRowCount();
//        for (int j = temp - 1; j >= 0; j--) {
//            model1.removeRow(j);
//        }
//        ResultSet rs2 = conn.ExcuteQueryGetTable("SELECT * FROM HD_TIEC HD inner join CT_NUOC_UONG CTN "
//                + "on CTN.SOHDTIEC=HD.SOHDTIEC "
//                + "inner join NUOC_UONG NC "
//                + "on NC.MANUOC=CTN.MANUOC  where HD.SOHDTIEC='" + SOHDTIEC + "'");
//        try {
//            while (rs2.next()) {
//                model1.addRow(new Object[]{rs2.getString("MANUOC"), rs2.getString("TEN"), decimalFormat.format(rs2.getInt("GIA")), rs2.getInt("SOLUONG"),
//                    decimalFormat.format(rs2.getInt("GIA") * rs2.getInt("SOLUONG"))});
//            }
//            rs2.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        // TODO add your handling code here:
//        // TODO add your handling code here:
    }//GEN-LAST:event_TabletiecdathanhtoanMouseClicked

    private void LammoitiechientaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LammoitiechientaiActionPerformed
//        DefaultTableModel model = (DefaultTableModel) Tabletiechientai.getModel();
//        int temp = model.getRowCount();
//        for (int j = temp - 1; j >= 0; j--) {
//            model.removeRow(j);
//        }
//        DefaultTableModel model1 = (DefaultTableModel) Tablenuoc_3.getModel();
//        temp = model1.getRowCount();
//        for (int j = temp - 1; j >= 0; j--) {
//            model1.removeRow(j);
//        }
//        Madattiechientai.setText("");
//        Hoten_3.setText("");
//        MDT_3.setText("");
//        SDT_3.setText("");
//        Masanh_3.setText("");
//        CMND_3.setText("");
//        //Ngaysinh1.setDate(rs1.getDate("NGAYSINH"));
//        //Ngayden_1.setText("");
//        //Ngaydi_1.setText("");
//        MaTD_3.setText("");
//        Soban_3.setText("");
//        Soluong_3.setText("");
//        Tongtien_3.setText("");
//        Coc_3.setText("");
//        Conlai_3.setText("");
//        Tiennhan_3.setText("");
//        Tienthua_3.setText("");
//        // TODO add your handling code here:
    }//GEN-LAST:event_LammoitiechientaiActionPerformed

    private void LammoitiecdathanhtoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LammoitiecdathanhtoanActionPerformed
//        DefaultTableModel model = (DefaultTableModel) Tabletiecdathanhtoan.getModel();
//        int temp = model.getRowCount();
//        for (int j = temp - 1; j >= 0; j--) {
//            model.removeRow(j);
//        }
//        DefaultTableModel model1 = (DefaultTableModel) Tablenuoc_4.getModel();
//        temp = model1.getRowCount();
//        for (int j = temp - 1; j >= 0; j--) {
//            model1.removeRow(j);
//        }
//        Madattiecdathanhtoan.setText("");
//        Hoten_4.setText("");
//        MDT_4.setText("");
//        SDT_4.setText("");
//        Masanh_4.setText("");
//        CMND_4.setText("");
//        //Ngaysinh1.setDate(rs1.getDate("NGAYSINH"));
//        //Ngayden_1.setText("");
//        //Ngaydi_1.setText("");
//        MaTD_4.setText("");
//        Soban_4.setText("");
//        //Soluong_3.setText("");
//        Tongtien_4.setText("");
//        Coc_4.setText("");
//        Conlai_4.setText("");
//        Tiennhan_4.setText("");
//        Tienthua_4.setText("");
//        // TODO add your handling code here:
    }//GEN-LAST:event_LammoitiecdathanhtoanActionPerformed

    private void jTableRoleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableRoleMouseClicked
        int index = jTableRole.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jTableRole.getModel();
        int id = (int) model.getValueAt(index, 0);

        RoleDto dto = roleService.getById(id);
        jTextRoleId.setText(Integer.toString(dto.getId()));
        jTextRoleName.setText(dto.getName());
        jTextRoleDesc.setText(dto.getDescription());
    }//GEN-LAST:event_jTableRoleMouseClicked

    private void jButtonAddRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddRoleActionPerformed

        String name = jTextNewRoleName.getText();
        String desc = jTextNewRoleDesc.getText();
        if ((!name.equals("")) && (!desc.equals(""))) {
            RoleDto dto = new RoleDto();

            dto.setName(name);
            dto.setDescription(desc);

            roleService.add(dto);
            
            jTextNewRoleName.setText("");
            jTextNewRoleDesc.setText("");
            setJTableRole();
        }
    }//GEN-LAST:event_jButtonAddRoleActionPerformed

    private void jButtonCancelAddRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelAddRoleActionPerformed

        jTextNewRoleName.setText("");
        jTextNewRoleDesc.setText("");
    }//GEN-LAST:event_jButtonCancelAddRoleActionPerformed

    private void jButtonUpdateRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateRoleActionPerformed

        int id = Integer.parseInt(jTextRoleId.getText());
        String name = jTextRoleName.getText();
        String desc = jTextRoleDesc.getText();

        RoleDto dto = new RoleDto();
        dto.setId(id);
        dto.setName(name);
        dto.setDescription(desc);

        roleService.edit(dto);
        jTextRoleId.setText("");
        jTextRoleName.setText("");
        jTextRoleDesc.setText("");
        setJTableRole();
    }//GEN-LAST:event_jButtonUpdateRoleActionPerformed

    private void jButtonDeleteRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteRoleActionPerformed

        int id = Integer.parseInt(jTextRoleId.getText());
        roleService.removeById(id);
        jTextRoleId.setText("");
        jTextRoleName.setText("");
        jTextRoleDesc.setText("");
        setJTableRole();
    }//GEN-LAST:event_jButtonDeleteRoleActionPerformed

    private void jButtonCancelUpdateRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelUpdateRoleActionPerformed

        jTextRoleId.setText("");
        jTextRoleName.setText("");
        jTextRoleDesc.setText("");
    }//GEN-LAST:event_jButtonCancelUpdateRoleActionPerformed

    private void InPhong1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InPhong1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InPhong1ActionPerformed

    private void InTiec1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InTiec1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InTiec1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Home().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Admin;
    private javax.swing.JPanel Bang_gia;
    private javax.swing.JCheckBox CMND1;
    private javax.swing.JCheckBox CMND2;
    private javax.swing.JTextField CMND_1;
    private javax.swing.JTextField CMND_2;
    private javax.swing.JTextField CMND_3;
    private javax.swing.JTextField CMND_4;
    private javax.swing.JButton Canceldichvu;
    private javax.swing.JTextField Coc_1;
    private javax.swing.JTextField Coc_2;
    private javax.swing.JTextField Coc_3;
    private javax.swing.JTextField Coc_4;
    private javax.swing.JComboBox<String> ComboBoxTinhtrangphong;
    private javax.swing.JComboBox<String> ComboBoxloai;
    private javax.swing.JComboBox<String> ComboBoxloaiphong;
    private javax.swing.JComboBox<String> ComboBoxnuoc;
    private javax.swing.JComboBox<String> ComboBoxtendv;
    private javax.swing.JComboBox<String> ComboBoxthucdon;
    private javax.swing.JComboBox<String> ComboBoxtinhtrangsanh;
    private javax.swing.JTextField Conlai_1;
    private javax.swing.JTextField Conlai_2;
    private javax.swing.JTextField Conlai_3;
    private javax.swing.JTextField Conlai_4;
    private javax.swing.JPanel DS_HD;
    private com.toedter.calendar.JDateChooser DateIn;
    private com.toedter.calendar.JDateChooser DateIn2;
    private com.toedter.calendar.JDateChooser DateOut;
    private javax.swing.JButton Deletedangluutru;
    private javax.swing.JButton Deletedichvu;
    private javax.swing.JPanel Home;
    private javax.swing.JCheckBox Hoten1;
    private javax.swing.JCheckBox Hoten2;
    private javax.swing.JTextField Hoten_1;
    private javax.swing.JTextField Hoten_2;
    private javax.swing.JTextField Hoten_3;
    private javax.swing.JTextField Hoten_4;
    private javax.swing.JButton InPhong;
    private javax.swing.JButton InPhong1;
    private javax.swing.JButton InTiec;
    private javax.swing.JButton InTiec1;
    private javax.swing.JButton Jphong1;
    private javax.swing.JButton Jphong10;
    private javax.swing.JButton Jphong11;
    private javax.swing.JButton Jphong12;
    private javax.swing.JButton Jphong13;
    private javax.swing.JButton Jphong14;
    private javax.swing.JButton Jphong15;
    private javax.swing.JButton Jphong16;
    private javax.swing.JButton Jphong17;
    private javax.swing.JButton Jphong18;
    private javax.swing.JButton Jphong19;
    private javax.swing.JButton Jphong2;
    private javax.swing.JButton Jphong20;
    private javax.swing.JButton Jphong21;
    private javax.swing.JButton Jphong22;
    private javax.swing.JButton Jphong23;
    private javax.swing.JButton Jphong24;
    private javax.swing.JButton Jphong25;
    private javax.swing.JButton Jphong26;
    private javax.swing.JButton Jphong27;
    private javax.swing.JButton Jphong28;
    private javax.swing.JButton Jphong29;
    private javax.swing.JButton Jphong3;
    private javax.swing.JButton Jphong30;
    private javax.swing.JButton Jphong31;
    private javax.swing.JButton Jphong32;
    private javax.swing.JButton Jphong33;
    private javax.swing.JButton Jphong34;
    private javax.swing.JButton Jphong35;
    private javax.swing.JButton Jphong36;
    private javax.swing.JButton Jphong37;
    private javax.swing.JButton Jphong38;
    private javax.swing.JButton Jphong39;
    private javax.swing.JButton Jphong4;
    private javax.swing.JButton Jphong40;
    private javax.swing.JButton Jphong41;
    private javax.swing.JButton Jphong42;
    private javax.swing.JButton Jphong43;
    private javax.swing.JButton Jphong44;
    private javax.swing.JButton Jphong45;
    private javax.swing.JButton Jphong46;
    private javax.swing.JButton Jphong47;
    private javax.swing.JButton Jphong48;
    private javax.swing.JButton Jphong49;
    private javax.swing.JButton Jphong5;
    private javax.swing.JButton Jphong50;
    private javax.swing.JButton Jphong6;
    private javax.swing.JButton Jphong7;
    private javax.swing.JButton Jphong8;
    private javax.swing.JButton Jphong9;
    private javax.swing.JLabel LabelUser;
    private javax.swing.JButton LamMoi;
    private javax.swing.JButton Lammoidaluutru;
    private javax.swing.JButton Lammoidangluutru;
    private javax.swing.JButton Lammoiphongdathanhtoan;
    private javax.swing.JButton Lammoiphonghientai;
    private javax.swing.JButton Lammoitiec;
    private javax.swing.JButton Lammoitiecdathanhtoan;
    private javax.swing.JButton Lammoitiechientai;
    private javax.swing.JButton LapPhieuThue;
    private javax.swing.JButton LapPhieuTiec;
    private javax.swing.JPanel Lap_phieu;
    private javax.swing.JPanel Logout;
    private javax.swing.JTextField MDP_1;
    private javax.swing.JTextField MDP_2;
    private javax.swing.JTextField MDT_3;
    private javax.swing.JTextField MDT_4;
    private javax.swing.JTextField MaTD_3;
    private javax.swing.JTextField MaTD_4;
    private javax.swing.JTextField Madatlapdichvu;
    private javax.swing.JTextField Madatlapphieu;
    private javax.swing.JTextField Madatphieutiec;
    private javax.swing.JTextField Madatphongdathanhtoan;
    private javax.swing.JTextField Madatphonghientai;
    private javax.swing.JTextField Madattiecdathanhtoan;
    private javax.swing.JTextField Madattiechientai;
    private javax.swing.JTextField Masanh_3;
    private javax.swing.JTextField Masanh_4;
    private com.toedter.calendar.JYearChooser Nam1;
    private com.toedter.calendar.JYearChooser Nam2;
    private com.toedter.calendar.JDateChooser Ngayden1;
    private javax.swing.JTextField Ngayden2;
    private javax.swing.JTextField Ngayden_1;
    private javax.swing.JTextField Ngayden_2;
    private com.toedter.calendar.JDateChooser Ngaydi1;
    private javax.swing.JTextField Ngaydi2;
    private javax.swing.JTextField Ngaydi_1;
    private javax.swing.JTextField Ngaydi_2;
    private com.toedter.calendar.JDateChooser Ngaysinh1;
    private javax.swing.JTextField Ngaysinh2;
    private javax.swing.JPanel Nha_hang;
    private javax.swing.JButton Okdangluutru;
    private javax.swing.JButton Okdichvu;
    private javax.swing.JButton Okelogout;
    private javax.swing.JTextField Phongcoc;
    private javax.swing.JTextField Phongthue;
    private javax.swing.JTextField Phongtrong;
    private javax.swing.JPanel QL_khach;
    private javax.swing.JPanel QL_phong;
    private javax.swing.JTextField SDT_1;
    private javax.swing.JTextField SDT_2;
    private javax.swing.JTextField SDT_3;
    private javax.swing.JTextField SDT_4;
    private javax.swing.JButton SanhA;
    private javax.swing.JButton SanhB;
    private javax.swing.JButton SanhC;
    private javax.swing.JButton SanhD;
    private javax.swing.JButton SanhE;
    private javax.swing.JButton SanhF;
    private javax.swing.JTextField Sanhcoc;
    private javax.swing.JTextField Sanhthue;
    private javax.swing.JTextField Sanhtrong;
    private javax.swing.JTextField Soban_3;
    private javax.swing.JTextField Soban_4;
    private javax.swing.JTextField Soluong_3;
    private javax.swing.JTextField Soluongdv;
    private javax.swing.JCheckBox Sophong1;
    private javax.swing.JCheckBox Sophong2;
    private javax.swing.JTextField Sophong_1;
    private javax.swing.JTextField Sophong_2;
    private javax.swing.JTable TableDV;
    private javax.swing.JTable TableDV2;
    private javax.swing.JTable Tablecoso;
    private javax.swing.JTable Tabledaluutru;
    private javax.swing.JTable Tabledangluutru;
    private javax.swing.JTable Tabledichvu;
    private javax.swing.JTable Tablegiadichvu;
    private javax.swing.JTable Tablegiaphong;
    private javax.swing.JTable Tablegiathucdon;
    private javax.swing.JTable Tablelapdichvu;
    private javax.swing.JTable Tablenuoc_3;
    private javax.swing.JTable Tablenuoc_4;
    private javax.swing.JTable Tablephieuthue;
    private javax.swing.JTable Tablephieutiec;
    private javax.swing.JTable Tablephongdathanhtoan;
    private javax.swing.JTable Tablephonghientai;
    private javax.swing.JTable Tablethucdon;
    private javax.swing.JTable Tabletiecdathanhtoan;
    private javax.swing.JTable Tabletiechientai;
    private javax.swing.JPanel Tang_1;
    private javax.swing.JPanel Tang_2;
    private javax.swing.JPanel Tang_3;
    private javax.swing.JPanel Tang_4;
    private javax.swing.JPanel Tang_tret;
    private javax.swing.JTextField Textcmnd1;
    private javax.swing.JTextField Textcmnd2;
    private javax.swing.JTextField Textdaluutru;
    private javax.swing.JTextField Textdangluutru;
    private javax.swing.JTextField Texthoten1;
    private javax.swing.JTextField Texthoten2;
    private javax.swing.JTextField Textsdt1;
    private javax.swing.JTextField Textsdt2;
    private javax.swing.JTextField Textsophong1;
    private javax.swing.JTextField Textsophong2;
    private com.toedter.calendar.JMonthChooser Thang1;
    private com.toedter.calendar.JMonthChooser Thang2;
    private javax.swing.JButton Thanhtoanphong;
    private javax.swing.JButton Thanhtoantiec;
    private javax.swing.JButton Themdichvu;
    private javax.swing.JButton Themnuoc;
    private javax.swing.JButton Thongkephong;
    private javax.swing.JButton Thongketiec;
    private javax.swing.JTextField Tiennhan_1;
    private javax.swing.JTextField Tiennhan_2;
    private javax.swing.JTextField Tiennhan_3;
    private javax.swing.JTextField Tiennhan_4;
    private javax.swing.JTextField Tienthua_1;
    private javax.swing.JTextField Tienthua_2;
    private javax.swing.JTextField Tienthua_3;
    private javax.swing.JTextField Tienthua_4;
    private javax.swing.JButton Timkiemdaluutru;
    private javax.swing.JButton Timkiemdangluutru;
    private javax.swing.JButton Timkiemhoadonhientai;
    private javax.swing.JButton Timkiemphongdathanhtoan;
    private javax.swing.JButton Timkiemtiecdathanhtoan;
    private javax.swing.JButton Timkiemtiechientai;
    private javax.swing.JTextField Tongtien_1;
    private javax.swing.JTextField Tongtien_2;
    private javax.swing.JTextField Tongtien_3;
    private javax.swing.JTextField Tongtien_4;
    private javax.swing.JButton Tracuulapdichvu;
    private javax.swing.JButton Tracuulapphieu;
    private javax.swing.JButton Tracuuphieutiec;
    private javax.swing.JButton Tracuuphong;
    private javax.swing.JButton Tracuutiec;
    private javax.swing.JButton Xoanuoc;
    private javax.swing.JButton jButton101;
    private javax.swing.JButton jButton53;
    private javax.swing.JButton jButton68;
    private javax.swing.JButton jButton86;
    private javax.swing.JButton jButton87;
    private javax.swing.JButton jButton90;
    private javax.swing.JButton jButton91;
    private javax.swing.JButton jButtonAddRole;
    private javax.swing.JButton jButtonCancelAddRole;
    private javax.swing.JButton jButtonCancelUpdateRole;
    private javax.swing.JButton jButtonDeleteRole;
    private javax.swing.JButton jButtonUpdateRole;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JPanel jPaneRole;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane10;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTabbedPane jTabbedPane6;
    private javax.swing.JTabbedPane jTabbedPane7;
    private javax.swing.JTabbedPane jTabbedPane8;
    private javax.swing.JTabbedPane jTabbedPane9;
    private javax.swing.JTable jTableRole;
    private javax.swing.JTextField jTextNewRoleDesc;
    private javax.swing.JTextField jTextNewRoleName;
    private javax.swing.JTextField jTextRoleDesc;
    private javax.swing.JTextField jTextRoleId;
    private javax.swing.JTextField jTextRoleName;
    // End of variables declaration//GEN-END:variables
}

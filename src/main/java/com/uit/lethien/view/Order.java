/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.lethien.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import com.uit.lethien.database.connectDatabase;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import com.uit.lethien.view.Home;

/**
 *
 * @author LeThien
 */
public class Order extends javax.swing.JFrame {

    /**
     * Creates new form Order
     */
    public connectDatabase conn = new connectDatabase();
    public String MASANH;
    public String SOTIEC;
    public Home H;
    public String MANV;
    public Order() {
        initComponents();
        DateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat dateFormat2 = new SimpleDateFormat("HH:mm");
        SOTIEC = "DT21";
        MASANH = "S2";
        //String MATD1="TD3";
        String GIA = "";
        DecimalFormat decimalFormat = (DecimalFormat)
        NumberFormat.getNumberInstance(new Locale("<em>vi</em>" , "VN"));
        decimalFormat.applyPattern("###,###,###");
        ResultSet rs = conn.ExcuteQueryGetTable("Select* from THUC_DON");
        DefaultComboBoxModel box = new DefaultComboBoxModel();
        try {
            while (rs.next()){
                String MATD = rs.getString("MATD");
                box.addElement(MATD);
            }
            ComboBoxThucdon.setModel(box);
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ComboBoxThucdon.setSelectedItem(MATD1);
        if(!SOTIEC.equals("")){
            ResultSet rs1 = conn.ExcuteQueryGetTable("Select* from THUC_DON TD inner join DAT_TIEC DT "
                                                    + "on TD.MATD=DT.MATD "
                                                    + "inner join KHACH_HANG_TIEC KHT "
                                                    + "on KHT.MAKHTIEC=DT.MAKHTIEC where DT.SOTIEC='"+SOTIEC+"'");
            try {
                while(rs1.next()){
                    Hoten.setText(rs1.getString("HOTEN"));
                    Cmnd.setText(rs1.getString("CMND"));
                    Sdt.setText(rs1.getString("SDT"));
                    Datedienra.setDate(rs1.getDate("TGDIENRA"));
                    ComboBoxtime.setSelectedItem(dateFormat2.format(rs1.getDate("TGDIENRA")));
                    ComboBoxThucdon.setSelectedItem(rs1.getString("MATD"));
                    Soban.setText(rs1.getString("SOBAN"));
                    Tongtien.setText(decimalFormat.format(rs1.getInt("COC")+rs1.getInt("TIENCON")));
                    Tiencoc.setText(decimalFormat.format(rs1.getInt("COC")));
                    Madattiec.setText(SOTIEC);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public Order(Home test, String M, String N,String NV) {
        DateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat dateFormat2 = new SimpleDateFormat("HH:mm");
        SOTIEC = N;
        MASANH = M;
        H= test;
        MANV=NV;
        System.out.print(MANV);
        //String MATD1="TD3";
        String GIA = "";
        initComponents();
        DecimalFormat decimalFormat = (DecimalFormat)
        NumberFormat.getNumberInstance(new Locale("<em>vi</em>" , "VN"));
        decimalFormat.applyPattern("###,###,###");
        ResultSet rs = conn.ExcuteQueryGetTable("Select* from THUC_DON");
        DefaultComboBoxModel box = new DefaultComboBoxModel();
        try {
            while (rs.next()){
                String MATD = rs.getString("MATD");
                box.addElement(MATD);
            }
            ComboBoxThucdon.setModel(box);
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ComboBoxThucdon.setSelectedItem(MATD1);
        if(!SOTIEC.equals("")){
            ResultSet rs1 = conn.ExcuteQueryGetTable("Select* from THUC_DON TD inner join DAT_TIEC DT "
                                                    + "on TD.MATD=DT.MATD "
                                                    + "inner join KHACH_HANG_TIEC KHT "
                                                    + "on KHT.MAKHTIEC=DT.MAKHTIEC where DT.SOTIEC='"+SOTIEC+"'");
            try {
                while(rs1.next()){
                    Hoten.setText(rs1.getString("HOTEN"));
                    Cmnd.setText(rs1.getString("CMND"));
                    Sdt.setText(rs1.getString("SDT"));
                    Datedienra.setDate(rs1.getDate("TGDIENRA"));
                    ComboBoxtime.setSelectedItem(dateFormat2.format(rs1.getDate("TGDIENRA")));
                    ComboBoxThucdon.setSelectedItem(rs1.getString("MATD"));
                    Soban.setText(rs1.getString("SOBAN"));
                    Tongtien.setText(decimalFormat.format(rs1.getInt("COC")+rs1.getInt("TIENCON")));
                    Tiencoc.setText(decimalFormat.format(rs1.getInt("COC")));
                    Madattiec.setText(SOTIEC);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        Hoten = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        Cmnd = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        Sdt = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        Datedienra = new com.toedter.calendar.JDateChooser();
        jLabel22 = new javax.swing.JLabel();
        Tiencoc = new javax.swing.JTextField();
        OK = new javax.swing.JButton();
        Cancel = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        Madattiec = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        ComboBoxThucdon = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        Soban = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        Tongtien = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        ComboBoxtime = new javax.swing.JComboBox<>();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ĐẶT TIỆC");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin đặt tiệc\n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(0, 153, 0))); // NOI18N

        jLabel16.setText("Họ Tên:");

        jLabel17.setText("CMND/Passport:");

        jLabel19.setText("SĐT:");

        jLabel20.setText("Thời gian diễn ra:");

        Datedienra.setDateFormatString("dd/MM/yyyy");

        jLabel22.setText("Tiền cọc:");

        Tiencoc.setEditable(false);

        OK.setText("OK");
        OK.setOpaque(false);
        OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKActionPerformed(evt);
            }
        });

        Cancel.setText("Cancel");
        Cancel.setOpaque(false);
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });

        Delete.setText("Delete");
        Delete.setOpaque(false);
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("Mã đặt tiệc:");

        Madattiec.setEditable(false);

        jLabel18.setText("Thực đơn:");

        ComboBoxThucdon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel21.setText("Số bàn:");

        jLabel25.setText("Tổng tiền:");

        Tongtien.setEditable(false);

        jLabel1.setText("Giờ");

        ComboBoxtime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10:00", "11:00", "12:00", "13:00", "14:00", "17:00", "18:00", "19:00", "20:00", "21:00" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(16, 16, 16)))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Cmnd, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                            .addComponent(Hoten)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Sdt))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ComboBoxThucdon, 0, 110, Short.MAX_VALUE)
                            .addComponent(Datedienra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Soban))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ComboBoxtime, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(51, 51, 51)
                        .addComponent(Tongtien))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(OK, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addComponent(Delete)
                                .addGap(18, 18, 18)
                                .addComponent(Cancel))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Madattiec, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(Tiencoc))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(Hoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(Cmnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(Sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Datedienra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ComboBoxtime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(ComboBoxThucdon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(Soban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(Tongtien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(Tiencoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(Madattiec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OK)
                    .addComponent(Delete)
                    .addComponent(Cancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKActionPerformed
        DateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat dateFormat2 = new SimpleDateFormat("HH:mm");
        DecimalFormat decimalFormat = (DecimalFormat)
        NumberFormat.getNumberInstance(new Locale("<em>vi</em>" , "VN"));
        decimalFormat.applyPattern("###,###,###");
        if(!SOTIEC.equals("")){
            String HOTEN = Hoten.getText();
            String CMND = Cmnd.getText();
            String SDT = Sdt.getText();
            String SOBAN = Soban.getText();
            String TIME = ComboBoxtime.getSelectedItem().toString();
            String MATD= ComboBoxThucdon.getSelectedItem().toString();
            ResultSet rs = conn.ExcuteQueryGetTable("Select* from DAT_TIEC DT inner join KHACH_HANG_TIEC KHT "
                                                    + "on KHT.MAKHTIEC=DT.MAKHTIEC where DT.SOTIEC='"+SOTIEC+"'");
            ResultSet rs9= conn.ExcuteQueryGetTable("Select* from THUC_DON where MATD='"+MATD+"'");
            String GIA="";
            String MAKHTIEC="";
            try {
                while(rs.next()){
                    MAKHTIEC=rs.getString("MAKHTIEC");
                }
                rs.close();
                while(rs9.next()){
                    GIA = rs9.getString("GIA");
                }
                rs9.close();
            } catch (SQLException ex) {
                Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (!SDT.equals("")&&
                    !HOTEN.equals("")&&!CMND.equals("")&&
                    !Datedienra.getDate().equals(null)&&
                    !SOBAN.equals("")){
                String TGDIENRA= dateFormat1.format(Datedienra.getDate());
                conn.ExcuteQueryUpdateDB("UPDATE DAT_TIEC DT set "+
                        "DT.MANV='"+MANV+"',DT.TGDIENRA=to_date('"+TGDIENRA+" "+TIME+"','DD/MM/YYYY HH24:MI'),"+
                        "DT.MATD='"+MATD+"',DT.SOBAN="+SOBAN+",DT.COC="+GIA+"*"+SOBAN+"*0.5,DT.TIENCON="+GIA+"*"+SOBAN+"*0.5 "
                                + "where DT.SOTIEC='"+SOTIEC+"'");
                conn.ExcuteQueryUpdateDB("UPDATE KHACH_HANG_TIEC KHT set "+
                        "KHT.HOTEN='"+HOTEN+"',"+
                        "KHT.CMND="+CMND+","+
                        "KHT.SDT="+SDT+""+
                        "where KHT.MAKHTIEC='"+MAKHTIEC+"'");
                conn.ExcuteQueryUpdateDB("UPDATE HD_TIEC HD set HD.MANV='"+MANV+"',HD.TONGTIEN="+GIA+"*"+SOBAN+" where HD.SOTIEC='"+SOTIEC+"' ");
                ResultSet rs3 = conn.ExcuteQueryGetTable("Select* from DAT_TIEC where SOTIEC='"+SOTIEC+"'");
                try {
                    while(rs3.next()){
                        Tongtien.setText(decimalFormat.format(rs3.getInt("TIENCON")+rs3.getInt("COC")));
                        Tiencoc.setText(decimalFormat.format(rs3.getInt("COC")));
                    }
                    JOptionPane.showMessageDialog(rootPane," Cập nhật thành công "+SOTIEC+"");
                    rs3.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else {
                JOptionPane.showMessageDialog(rootPane," Chưa nhập đủ thông tin!");
            }
        }
        else{
            String HOTEN = Hoten.getText();
            String CMND = Cmnd.getText();
            String SDT = Sdt.getText();
            String SOBAN = Soban.getText();
            String TIME = ComboBoxtime.getSelectedItem().toString();
            String MATD= ComboBoxThucdon.getSelectedItem().toString();
            ResultSet rs9= conn.ExcuteQueryGetTable("Select* from THUC_DON where MATD='"+MATD+"'");
            String GIA="";
            String MAKHTIEC="";
            try {
                while(rs9.next()){
                    GIA = rs9.getString("GIA");
                }
                rs9.close();
            } catch (SQLException ex) {
                Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (!SDT.equals("")&&
                    !HOTEN.equals("")&&!CMND.equals("")&&
                    !Datedienra.getDate().equals(null)&&
                    !SOBAN.equals("")){
                String TGDIENRA= dateFormat1.format(Datedienra.getDate());
                ResultSet rs3 = conn.ExcuteQueryGetTable("Select'DT'||to_char(SOTIEC_SEQ.NEXTVAL) from dual");
                ResultSet rs4 = conn.ExcuteQueryGetTable("Select'KH'||to_char(MAKHTIEC_SEQ.NEXTVAL) from dual");
                try {
                    while(rs3.next()){
                        SOTIEC=rs3.getString("'DT'||to_char(SOTIEC_SEQ.NEXTVAL)");
                    }
                    rs3.close();
                    while(rs4.next()){
                        MAKHTIEC=rs4.getString("'KH'||to_char(MAKHTIEC_SEQ.NEXTVAL)");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
                }
                conn.ExcuteQueryUpdateDB("Insert into KHACH_HANG_TIEC VALUES('"+MAKHTIEC+"','"+HOTEN+"','"+SDT+"','"+CMND+"')");
                conn.ExcuteQueryUpdateDB("Insert into DAT_TIEC(SOTIEC,MANV,MAKHTIEC,MASANH,MATD,SOBAN,TGDIENRA,COC,TIENCON) VALUES("
                        + "'"+SOTIEC+"','"+MANV+"','"+MAKHTIEC+"','"+MASANH+"',"
                                + "'"+MATD+"',"+SOBAN+",to_date('"+TGDIENRA+" "+TIME+"','DD/MM/YYYY HH24:MI'),"
                                +""+GIA+"*"+SOBAN+"*0.5,"+GIA+"*"+SOBAN+"*0.5)");
                conn.ExcuteQueryUpdateDB("Update DAT_TIEC DT set DT.MALT='LT1'");
                ResultSet rs2 = conn.ExcuteQueryGetTable("Select* from DAT_TIEC where SOTIEC='"+SOTIEC+"'");
                try {
                    while(rs2.next()){
                        Tongtien.setText(decimalFormat.format(rs2.getInt("TIENCON")+rs2.getInt("COC")));
                        Tiencoc.setText(decimalFormat.format(rs2.getInt("COC")));
                        Madattiec.setText(SOTIEC);
                        JOptionPane.showMessageDialog(rootPane," Mã đặt tiệc là "+SOTIEC+"");
                    }
                    rs2.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else {
            JOptionPane.showMessageDialog(rootPane," Chưa nhập đủ thông tin!");
            }   
//            H.SetTinhTrangSanhDefault();
//            H.SetMauSanh("tat ca");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_OKActionPerformed

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        this.setVisible(false);         // TODO add your handling code here:
    }//GEN-LAST:event_CancelActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        if (!SOTIEC.equals("")){
            boolean check=false;
            String MAKHTIEC="";
            ResultSet rs1 = conn.ExcuteQueryGetTable("Select* from HD_TIEC where SOTIEC='"+SOTIEC+"'");
            ResultSet rs2 = conn.ExcuteQueryGetTable("Select* from DAT_TIEC where SOTIEC='"+SOTIEC+"'");
            try {
                while(rs1.next()){
                    check=true;
                }
                rs1.close();
                while(rs2.next()){
                    MAKHTIEC=rs2.getString("MAKHTIEC");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (check==false){
                int click=JOptionPane.showConfirmDialog(rootPane,"Bạn muốn xóa ?", "Delete", WIDTH);
                if(click == JOptionPane.YES_OPTION){
                    conn.ExcuteQueryUpdateDB("Delete from DAT_TIEC where DAT_TIEC.SOTIEC='"+SOTIEC+"'");
                    conn.ExcuteQueryUpdateDB("Delete from KHACH_HANG_TIEC KHT where KHT.MAKHTIEC='"+MAKHTIEC+"'");
                    JOptionPane.showMessageDialog(rootPane, "Xóa thành công "+SOTIEC);
                    this.setVisible(false);
                }
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Sảnh đang thuê không được xóa !");
            }
        }
//         H.SetTinhTrangSanhDefault();
//            H.SetMauSanh("tat ca");
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteActionPerformed

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
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Order().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancel;
    private javax.swing.JTextField Cmnd;
    private javax.swing.JComboBox<String> ComboBoxThucdon;
    private javax.swing.JComboBox<String> ComboBoxtime;
    private com.toedter.calendar.JDateChooser Datedienra;
    private javax.swing.JButton Delete;
    private javax.swing.JTextField Hoten;
    private javax.swing.JTextField Madattiec;
    private javax.swing.JButton OK;
    private javax.swing.JTextField Sdt;
    private javax.swing.JTextField Soban;
    private javax.swing.JTextField Tiencoc;
    private javax.swing.JTextField Tongtien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

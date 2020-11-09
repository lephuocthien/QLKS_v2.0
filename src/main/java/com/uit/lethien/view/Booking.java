/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.lethien.view;

import com.uit.lethien.database.connectDatabase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author LeThien
 */
public class Booking extends javax.swing.JFrame {

    /**
     * Creates new form Booking
     */
    
    public String MAPHONG;
    public String MADAT;
    public String GIA;
    public String TIENDV;
    public String MANV;
    public Home H;
    public connectDatabase conn= new connectDatabase();
        
    public Booking() {
        initComponents(); 
        MADAT="DP120";
        MAPHONG="P1001";
        TIENDV="0";
        DecimalFormat decimalFormat = (DecimalFormat)
        NumberFormat.getNumberInstance(new Locale("<em>vi</em>" , "VN"));
        decimalFormat.applyPattern("###,###,###");
        ResultSet rs = conn.ExcuteQueryGetTable("Select LP.GIA from PHONG P inner join LOAI_PHONG LP"+
                                                " on P.MALP=LP.MALP where SOPHONG='"+MAPHONG+"'");
        try {
            while(rs.next()){
                GIA=rs.getString("GIA");
                System.out.print(GIA);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs2 = conn.ExcuteQueryGetTable("Select* from HD_DICH_VU DV "+
                                                        " where DV.MADAT='"+MADAT+"'");
        try {
            while(rs2.next()){
                TIENDV=rs2.getString("THANHTIEN");
            }
            rs2.close();
        } catch (SQLException ex) {
            Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(!MADAT.equals("")){
            ResultSet rs1 = conn.ExcuteQueryGetTable("Select* from DAT_PHONG DP "+
                                                        " where DP.MADAT='"+MADAT+"'");
            try {
                while(rs1.next()){
                    System.out.println();
                    //TIENDV=rs1.getString("THANHTIEN");
                    HoTen.setText(rs1.getString("HOTEN"));
                    SoCMND.setText(rs1.getString("CMND"));
                    SoDienThoai.setText(rs1.getString("SDT"));
                    NgaySinh.setDate(rs1.getDate("NGAYSINH"));
                    DateIn.setDate(rs1.getDate("NGAYTHUE"));
                    DateOut.setDate(rs1.getDate("NGAYTRA"));
                    SumTien.setText(decimalFormat.format(rs1.getInt("TIENTRA")+rs1.getInt("TIENCON")));
                    TienCoc.setText(decimalFormat.format(rs1.getInt("TIENTRA")));
                    MaDatPhong.setText(MADAT);
                }
                rs1.close();
            } catch (SQLException ex) {
                Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public Booking(Home test,String M, String N, String NV) {
        initComponents(); 
        MANV=NV;
        MADAT=N;
        MAPHONG=M;
        TIENDV="0";
        H=test;
        DecimalFormat decimalFormat = (DecimalFormat)
        NumberFormat.getNumberInstance(new Locale("<em>vi</em>" , "VN"));
        decimalFormat.applyPattern("###,###,###");
        ResultSet rs = conn.ExcuteQueryGetTable("Select LP.GIA from PHONG P inner join LOAI_PHONG LP"+
                                                " on P.MALP=LP.MALP where SOPHONG='"+MAPHONG+"'");
        try {
            while(rs.next()){
                GIA=rs.getString("GIA");
                System.out.print(GIA);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs2 = conn.ExcuteQueryGetTable("Select* from HD_DICH_VU DV "+
                                                        " where DV.MADAT='"+MADAT+"'");
        try {
            while(rs2.next()){
                TIENDV=rs2.getString("THANHTIEN");
            }
            rs2.close();
        } catch (SQLException ex) {
            Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(!MADAT.equals("")){
            ResultSet rs1 = conn.ExcuteQueryGetTable("Select* from DAT_PHONG DP "+
                                                        " where DP.MADAT='"+MADAT+"'");
            try {
                while(rs1.next()){
                    System.out.println();
                    //TIENDV=rs1.getString("THANHTIEN");
                    HoTen.setText(rs1.getString("HOTEN"));
                    SoCMND.setText(rs1.getString("CMND"));
                    SoDienThoai.setText(rs1.getString("SDT"));
                    NgaySinh.setDate(rs1.getDate("NGAYSINH"));
                    DateIn.setDate(rs1.getDate("NGAYTHUE"));
                    DateOut.setDate(rs1.getDate("NGAYTRA"));
                    SumTien.setText(decimalFormat.format(rs1.getInt("TIENTRA")+rs1.getInt("TIENCON")));
                    TienCoc.setText(decimalFormat.format(rs1.getInt("TIENTRA")));
                    MaDatPhong.setText(MADAT);
                }
                rs1.close();
            } catch (SQLException ex) {
                Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        HoTen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        SoCMND = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        NgaySinh = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        SoDienThoai = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        DateIn = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        DateOut = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        TienCoc = new javax.swing.JTextField();
        OK = new javax.swing.JButton();
        Cancel = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        MaDatPhong = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        SumTien = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ĐẶT PHÒNG");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin đặt phòng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(0, 153, 0))); // NOI18N

        jLabel2.setText("Họ Tên:");

        jLabel3.setText("CMND/Passport:");

        jLabel4.setText("Ngày sinh:");

        NgaySinh.setDateFormatString("dd/MM/yyyy");

        jLabel5.setText("SĐT:");

        jLabel6.setText("Ngày đến:");

        DateIn.setDateFormatString("dd/MM/yyyy");

        jLabel7.setText("Ngày đi:");

        DateOut.setDateFormatString("dd/MM/yyyy");

        jLabel8.setText("Tiền cọc:");

        TienCoc.setEditable(false);

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

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Mã đặt phòng:");

        MaDatPhong.setEditable(false);

        jLabel1.setText("Tổng tiền:");

        SumTien.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 98, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(OK, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(Delete)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(MaDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)))
                        .addComponent(Cancel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DateIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(NgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SoDienThoai))
                            .addComponent(SoCMND)
                            .addComponent(HoTen)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DateOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(51, 51, 51)
                        .addComponent(SumTien))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TienCoc)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(HoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(SoCMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(NgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DateIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(DateOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(SumTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(TienCoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(MaDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OK)
                    .addComponent(Cancel)
                    .addComponent(Delete))
                .addContainerGap())
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
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        DecimalFormat decimalFormat = (DecimalFormat)
        NumberFormat.getNumberInstance(new Locale("<em>vi</em>" , "VN"));
        decimalFormat.applyPattern("###,###,###");
        if(!MADAT.equals("")){
            String HOTEN = HoTen.getText();
            String CMND = SoCMND.getText();
            String SDT = SoDienThoai.getText();
            if (!SDT.equals("")&&
                    !HOTEN.equals("")&&!CMND.equals("")&&
                    !NgaySinh.getDate().equals(null)&&
                    !DateIn.getDate().equals(null)&&
                    !DateOut.getDate().equals(null)){
                String NGSINH = dateFormat.format(NgaySinh.getDate());
                String NGTHUE = dateFormat.format(DateIn.getDate());
                String NGTRA = dateFormat.format(DateOut.getDate());    
                conn.ExcuteQueryUpdateDB("UPDATE DAT_PHONG set "+
                        "DAT_PHONG.MANV='"+MANV+"',DAT_PHONG.NGAYTHUE=to_date('"+NGTHUE+" 14:00','DD/MM/YYYY HH24:MI'),"+
                        "DAT_PHONG.NGAYTRA=to_date('"+NGTRA+" 12:00','DD/MM/YYYY HH24:MI'),"+
                        "DAT_PHONG.TIENTRA=(ROUND((to_date('"+NGTRA+" 12:00','DD/MM/YYYY HH24:MI')-to_date('"+NGTHUE+" 14:00','DD/MM/YYYY HH24:MI')))*"+GIA+"*0.5),"+
                                "DAT_PHONG.TIENCON=(ROUND((to_date('"+NGTRA+" 12:00','DD/MM/YYYY HH24:MI')-to_date('"+NGTHUE+" 14:00','DD/MM/YYYY HH24:MI')))*"+GIA+"*0.5),"+
                                "DAT_PHONG.HOTEN='"+HOTEN+"',DAT_PHONG.CMND="+CMND+",DAT_PHONG.SDT="+SDT+",DAT_PHONG.NGAYSINH=to_date('"+NGSINH+"','DD/MM/YYYY')"+
                        "where DAT_PHONG.MADAT='"+MADAT+"'");
                conn.ExcuteQueryUpdateDB("UPDATE LUU_TRU set "+
                        "LUU_TRU.NGAYDEN=to_date('"+NGTHUE+" 14:00','DD/MM/YYYY HH24:MI'),"+
                        "LUU_TRU.NGAYDI=to_date('"+NGTRA+" 12:00','DD/MM/YYYY HH24:MI'),"+
                        //"DAT_PHONG.NGAYTRA=to_date('"+NGTRA+" 12:00','DD/MM/YYYY HH24:MI'),"+
                        //"DAT_PHONG.TIENTRA=(ROUND((to_date('"+NGTRA+" 12:00','DD/MM/YYYY HH24:MI')-to_date('"+NGTHUE+" 14:00','DD/MM/YYYY HH24:MI')))*"+GIA+"*0.5),"+
                               // "DAT_PHONG.TIENCON=(ROUND((to_date('"+NGTRA+" 12:00','DD/MM/YYYY HH24:MI')-to_date('"+NGTHUE+" 14:00','DD/MM/YYYY HH24:MI')))*"+GIA+"*0.5),"+
                                "LUU_TRU.HOTEN='"+HOTEN+"',LUU_TRU.CMND="+CMND+",LUU_TRU.SDT="+SDT+",LUU_TRU.NGAYSINH=to_date('"+NGSINH+"','DD/MM/YYYY')"+
                        "where LUU_TRU.MADAT='"+MADAT+"'");
                conn.ExcuteQueryUpdateDB("UPDATE HOA_DON set HOA_DON.MANV='"+MANV+"',HOA_DON.TONGTIEN="+
                        "(ROUND((to_date('"+NGTRA+" 12:00','DD/MM/YYYY HH24:MI')-to_date('"+NGTHUE+" 14:00','DD/MM/YYYY HH24:MI')))*"+GIA+")+"+
                        TIENDV+" where HOA_DON.MADAT='"+MADAT+"'");
                ResultSet rs3 = conn.ExcuteQueryGetTable("Select* from DAT_PHONG where MADAT='"+MADAT+"'");
                try {
                    while(rs3.next()){
                        SumTien.setText(decimalFormat.format(rs3.getInt("TIENTRA")+rs3.getInt("TIENCON")));
                        TienCoc.setText(decimalFormat.format(rs3.getInt("TIENTRA")));
                    }
                    JOptionPane.showMessageDialog(rootPane," Cập nhật thành công "+MADAT+"");
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
            String HOTEN = HoTen.getText();
            String CMND = SoCMND.getText();
            String SDT = SoDienThoai.getText();
            if (!SDT.equals("")&&
                    !HOTEN.equals("")&&!CMND.equals("")&&
                    !NgaySinh.getDate().equals(null)&&
                    !DateIn.getDate().equals(null)&&
                    !DateOut.getDate().equals(null)){
                String NGSINH = dateFormat.format(NgaySinh.getDate());
                String NGTHUE = dateFormat.format(DateIn.getDate());
                String NGTRA = dateFormat.format(DateOut.getDate());
                ResultSet rs3 = conn.ExcuteQueryGetTable("Select'DP'||to_char(MADAT_SEQ.NEXTVAL) from dual");
                try {
                    while(rs3.next()){
                        MADAT=rs3.getString("'DP'||to_char(MADAT_SEQ.NEXTVAL)");
                    }
                    rs3.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
                }
                conn.ExcuteQueryUpdateDB("Insert into DAT_PHONG(MANV,MADAT,SOPHONG,NGAYTHUE,NGAYTRA,TIENTRA, TIENCON, HOTEN, CMND, SDT, NGAYSINH) VALUES('"+MANV+"','"+MADAT+"','"+
                        MAPHONG+"',to_date('"+NGTHUE+" 14:00','DD/MM/YYYY HH24:MI'),"+
                        "to_date('"+NGTRA+" 12:00','DD/MM/YYYY HH24:MI'),"+
                        "(ROUND((to_date('"+NGTRA+" 12:00','DD/MM/YYYY HH24:MI')-to_date('"+NGTHUE+" 14:00','DD/MM/YYYY HH24:MI')))*"+GIA+"*0.5),"+
                                "(ROUND((to_date('"+NGTRA+" 12:00','DD/MM/YYYY HH24:MI')-to_date('"+NGTHUE+" 14:00','DD/MM/YYYY HH24:MI')))*"+GIA+"*0.5),"+
                                "'"+HOTEN+"',"+CMND+","+SDT+",to_date('"+NGSINH+"','DD/MM/YYYY'))");
                ResultSet rs2 = conn.ExcuteQueryGetTable("Select* from DAT_PHONG where MADAT='"+MADAT+"'");
                try {
                    while(rs2.next()){
                        SumTien.setText(decimalFormat.format(rs2.getInt("TIENTRA")+rs2.getInt("TIENCON")));
                        TienCoc.setText(decimalFormat.format(rs2.getInt("TIENTRA")));
                        MaDatPhong.setText(MADAT);
                        JOptionPane.showMessageDialog(rootPane," Mã đặt phòng là "+MADAT+"");
                    }
                    rs2.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else {
            JOptionPane.showMessageDialog(rootPane," Chưa nhập đủ thông tin!");
            }    
        }
//        H.SetTinhTrangPhongDefault();
//        H.SetMauPhong("tat ca","tat ca");
    // TODO add your handling code here:
    }//GEN-LAST:event_OKActionPerformed

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_CancelActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        if (!MADAT.equals("")){
            boolean check=false;
            ResultSet rs1 = conn.ExcuteQueryGetTable("Select* from HOA_DON where MADAT='"+MADAT+"'");
            try {
                while(rs1.next()){
                    check=true;
                }
                rs1.close();
            } catch (SQLException ex) {
                Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (check==false){
                int click=JOptionPane.showConfirmDialog(rootPane,"Bạn muốn xóa ?", "Delete", WIDTH);
                if(click == JOptionPane.YES_OPTION){
                    conn.ExcuteQueryUpdateDB("Delete from DAT_PHONG where DAT_PHONG.MADAT='"+MADAT+"'");
                    JOptionPane.showMessageDialog(rootPane, "Xóa thành công "+MADAT);
                    this.setVisible(false);
                }
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Phòng đang thuê không được xóa !");
            }
        }
//        H.SetTinhTrangPhongDefault();
//        H.SetMauPhong("tat ca","tat ca");
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
            java.util.logging.Logger.getLogger(Booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Booking().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancel;
    private com.toedter.calendar.JDateChooser DateIn;
    private com.toedter.calendar.JDateChooser DateOut;
    private javax.swing.JButton Delete;
    private javax.swing.JTextField HoTen;
    private javax.swing.JTextField MaDatPhong;
    private com.toedter.calendar.JDateChooser NgaySinh;
    private javax.swing.JButton OK;
    private javax.swing.JTextField SoCMND;
    private javax.swing.JTextField SoDienThoai;
    private javax.swing.JTextField SumTien;
    private javax.swing.JTextField TienCoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

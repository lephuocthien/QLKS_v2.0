/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.lethien.view;

import com.uit.lethien.view.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import com.uit.lethien.database.ConnectDatabase;
import com.uit.lethien.dto.RoleDto;
import com.uit.lethien.dto.UserDto;
import com.uit.lethien.service.RoleService;
import com.uit.lethien.service.UserService;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import com.uit.lethien.view.Home;
import java.util.List;

/**
 *
 * @author LeThien
 */
public class UserEdit extends javax.swing.JFrame {

    /**
     * Creates new form Order
     */
//    public ConnectDatabase conn = new ConnectDatabase();
//    public String MASANH;
//    public String SOTIEC;
    private Home home;
    private int id;
    private UserService userService = null;
    private RoleService roleService = null;

    public void setComboBoxRoleDescription(int roleId) {
        List<RoleDto> dtos = roleService.getAll();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        RoleDto role;
        for (RoleDto dto : dtos) {
            model.addElement(dto);
        }
        comboBoxRoleDescription.setModel(model);
        if (roleId != 0) {
            comboBoxRoleDescription.getModel().setSelectedItem(roleService.getById(roleId));
        }
    }

    public void setInforEdit() {
        UserDto user = userService.getById(id);
        jTextFieldFullname.setText(user.getFullname());
        jTextFieldAddress.setText(user.getAddress());
        jTextFieldPhone.setText(user.getPhone());
        jTextFieldUserName.setText(user.getUserName());
        setComboBoxRoleDescription(user.getRoleId());

    }

    public UserEdit() {
        initComponents();
        userService = new UserService();
        roleService = new RoleService();
        this.id = 3;
        setInforEdit();
//        DateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
//        DateFormat dateFormat2 = new SimpleDateFormat("HH:mm");
//        SOTIEC = "DT21";
//        MASANH = "S2";
//        //String MATD1="TD3";
//        String GIA = "";
//        DecimalFormat decimalFormat = (DecimalFormat)
//        NumberFormat.getNumberInstance(new Locale("<em>vi</em>" , "VN"));
//        decimalFormat.applyPattern("###,###,###");
//        ResultSet rs = conn.ExcuteQueryGetTable("Select* from THUC_DON");
//        DefaultComboBoxModel box = new DefaultComboBoxModel();
//        try {
//            while (rs.next()){
//                String MATD = rs.getString("MATD");
//                box.addElement(MATD);
//            }
//            ComboBoxThucdon.setModel(box);
//            rs.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        //ComboBoxThucdon.setSelectedItem(MATD1);
//        if(!SOTIEC.equals("")){
//            ResultSet rs1 = conn.ExcuteQueryGetTable("Select* from THUC_DON TD inner join DAT_TIEC DT "
//                                                    + "on TD.MATD=DT.MATD "
//                                                    + "inner join KHACH_HANG_TIEC KHT "
//                                                    + "on KHT.MAKHTIEC=DT.MAKHTIEC where DT.SOTIEC='"+SOTIEC+"'");
//            try {
//                while(rs1.next()){
//                    Hoten.setText(rs1.getString("HOTEN"));
//                    Cmnd.setText(rs1.getString("CMND"));
//                    Sdt.setText(rs1.getString("SDT"));
//                    Datedienra.setDate(rs1.getDate("TGDIENRA"));
//                    ComboBoxtime.setSelectedItem(dateFormat2.format(rs1.getDate("TGDIENRA")));
//                    ComboBoxThucdon.setSelectedItem(rs1.getString("MATD"));
//                    Soban.setText(rs1.getString("SOBAN"));
//                    Tongtien.setText(decimalFormat.format(rs1.getInt("COC")+rs1.getInt("TIENCON")));
//                    Tiencoc.setText(decimalFormat.format(rs1.getInt("COC")));
//                    Madattiec.setText(SOTIEC);
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }

    public UserEdit(Home home, int id) {
        initComponents();
        userService = new UserService();
        roleService = new RoleService();
        this.home = home;
        this.id = id;
        setInforEdit();
//        DateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
//        DateFormat dateFormat2 = new SimpleDateFormat("HH:mm");
//        SOTIEC = N;
//        MASANH = M;
//        H= test;
//        MANV=NV;
//        System.out.print(MANV);
//        //String MATD1="TD3";
//        String GIA = "";
//        DecimalFormat decimalFormat = (DecimalFormat)
//        NumberFormat.getNumberInstance(new Locale("<em>vi</em>" , "VN"));
//        decimalFormat.applyPattern("###,###,###");
//        ResultSet rs = conn.ExcuteQueryGetTable("Select* from THUC_DON");
//        DefaultComboBoxModel box = new DefaultComboBoxModel();
//        try {
//            while (rs.next()){
//                String MATD = rs.getString("MATD");
//                box.addElement(MATD);
//            }
//            ComboBoxThucdon.setModel(box);
//            rs.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        //ComboBoxThucdon.setSelectedItem(MATD1);
//        if(!SOTIEC.equals("")){
//            ResultSet rs1 = conn.ExcuteQueryGetTable("Select* from THUC_DON TD inner join DAT_TIEC DT "
//                                                    + "on TD.MATD=DT.MATD "
//                                                    + "inner join KHACH_HANG_TIEC KHT "
//                                                    + "on KHT.MAKHTIEC=DT.MAKHTIEC where DT.SOTIEC='"+SOTIEC+"'");
//            try {
//                while(rs1.next()){
//                    Hoten.setText(rs1.getString("HOTEN"));
//                    Cmnd.setText(rs1.getString("CMND"));
//                    Sdt.setText(rs1.getString("SDT"));
//                    Datedienra.setDate(rs1.getDate("TGDIENRA"));
//                    ComboBoxtime.setSelectedItem(dateFormat2.format(rs1.getDate("TGDIENRA")));
//                    ComboBoxThucdon.setSelectedItem(rs1.getString("MATD"));
//                    Soban.setText(rs1.getString("SOBAN"));
//                    Tongtien.setText(decimalFormat.format(rs1.getInt("COC")+rs1.getInt("TIENCON")));
//                    Tiencoc.setText(decimalFormat.format(rs1.getInt("COC")));
//                    Madattiec.setText(SOTIEC);
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
//            }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldFullname = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextFieldAddress = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jTextFieldPhone = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jButtonOk = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jTextFieldUserName = new javax.swing.JTextField();
        comboBoxRoleDescription = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        jPasswordFieldPassword = new javax.swing.JPasswordField();
        jPasswordFieldConfirmPassword = new javax.swing.JPasswordField();

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
        setTitle("CẬP NHẬT");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin nhân viên\n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(0, 153, 0))); // NOI18N

        jLabel16.setText("Họ Tên:");

        jLabel17.setText("Địa chỉ:");

        jLabel19.setText("SĐT:");

        jLabel20.setText("Chức vụ:");

        jLabel22.setText("Mật khẩu:");

        jButtonOk.setText("OK");
        jButtonOk.setOpaque(false);
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });

        jButtonCancel.setText("Cancel");
        jButtonCancel.setOpaque(false);
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jButtonDelete.setText("Delete");
        jButtonDelete.setOpaque(false);
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jLabel25.setText("Tên tài khoản:");

        comboBoxRoleDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxRoleDescriptionActionPerformed(evt);
            }
        });

        jLabel23.setText("Nhập lại mật khẩu:");

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
                            .addComponent(jTextFieldAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                            .addComponent(jTextFieldFullname)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPhone))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxRoleDescription, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jButtonOk, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(jButtonDelete)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCancel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25)
                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldUserName)
                            .addComponent(jPasswordFieldPassword)
                            .addComponent(jPasswordFieldConfirmPassword))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jTextFieldFullname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTextFieldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxRoleDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jPasswordFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jPasswordFieldConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOk)
                    .addComponent(jButtonDelete)
                    .addComponent(jButtonCancel))
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

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed
        UserDto user = new UserDto();
        String password = new String(jPasswordFieldPassword.getPassword());
        String confirmPassword = new String(jPasswordFieldConfirmPassword.getPassword());
        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(rootPane, "Nhập sai password!");
        } else {
            user.setId(this.id);
            user.setFullname(jTextFieldFullname.getText());
            user.setAddress(jTextFieldAddress.getText());
            user.setPhone(jTextFieldPhone.getText());
            user.setUserName(jTextFieldUserName.getText());
            user.setPassword(password);
            user.setRoleId(((RoleDto) comboBoxRoleDescription.getSelectedItem()).getId());
            if (user.getUserName().equals(userService.getById(id).getUserName())) {
                try {
                    userService.edit(user);
                    home.setJTableUserByAdmin();
                    JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công!");
                    this.setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(rootPane, "Lỗi!");
                }
            } else {
                if (userService.getByUserName(user.getUserName()) == null) {
                    try {
                        userService.edit(user);
                        home.setJTableUserByAdmin();
                        JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công!");
                        this.setVisible(false);
                    } catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(rootPane, "Lỗi!");
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Tên tài khoản đã tồn tại!");
                }
            }
        }
    }//GEN-LAST:event_jButtonOkActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        this.setVisible(false);         // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        try {
            userService.removeById(id);
            home.setJTableUserByAdmin();
            JOptionPane.showMessageDialog(rootPane, "Xoá thành công!");
            this.setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Xoá thất bại!");
            this.setVisible(false);
            
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void comboBoxRoleDescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxRoleDescriptionActionPerformed
//        RoleDto dto = (RoleDto) comboBoxRoleDescription.getSelectedItem();
//        System.out.println(dto.getId());
//        System.out.println(dto.getName());
        System.out.println(((RoleDto) comboBoxRoleDescription.getSelectedItem()).getId());
    }//GEN-LAST:event_comboBoxRoleDescriptionActionPerformed

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
            java.util.logging.Logger.getLogger(UserEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserEdit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboBoxRoleDescription;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordFieldConfirmPassword;
    private javax.swing.JPasswordField jPasswordFieldPassword;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldAddress;
    private javax.swing.JTextField jTextFieldFullname;
    private javax.swing.JTextField jTextFieldPhone;
    private javax.swing.JTextField jTextFieldUserName;
    // End of variables declaration//GEN-END:variables
}

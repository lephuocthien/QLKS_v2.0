/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.lethien.view;

import javax.swing.JButton;

/**
 *
 * @author LeThien
 */
public class Test extends javax.swing.JFrame {

    /**
     * Creates new form Test
     */
    private javax.swing.JButton Jphong1;
    private javax.swing.JButton Jphong2;
    private javax.swing.JButton Jphong3;
    private javax.swing.JButton Jphong4;
    private javax.swing.JButton Jphong5;
    private javax.swing.JButton Jphong6;
    private javax.swing.JButton Jphong7;
    private javax.swing.JButton Jphong8;
    private javax.swing.JButton Jphong9;
    private javax.swing.JButton Jphong10;
    private javax.swing.JPanel Tang_tret;
    public Test() {
        Jphong1 = new javax.swing.JButton();
        Jphong2 = new javax.swing.JButton();
        Jphong3 = new javax.swing.JButton();
        Jphong4 = new javax.swing.JButton();
        Jphong5 = new javax.swing.JButton();
        Jphong6 = new javax.swing.JButton();
        Jphong7 = new javax.swing.JButton();
        Jphong8 = new javax.swing.JButton();
        Jphong9 = new javax.swing.JButton();
        Jphong10 = new javax.swing.JButton();
        Tang_tret = new javax.swing.JPanel();
        
        initComponents();
        
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
        JButton phong[]={Jphong1, Jphong2, Jphong3, Jphong4, Jphong5, Jphong6, Jphong7, Jphong8, Jphong9, Jphong10};
        
        javax.swing.GroupLayout Tang_tretLayout = new javax.swing.GroupLayout(Tang_tret);
        Tang_tret.setLayout(Tang_tretLayout);
        for(int i=0;i<phong.length; i++){
//            System.out.println(i);
            Tang_tretLayout.setHorizontalGroup(
            Tang_tretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang_tretLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Tang_tretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(phong[i], javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))  
//                    .addGap(70, 70, 70)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            
        );
        }
//        Tang_tretLayout.setVerticalGroup(
//            Tang_tretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(Tang_tretLayout.createSequentialGroup()
//                .addContainerGap()
//                .addGroup(Tang_tretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
//                    .addComponent(Jphong1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
//                    .addGap(18, 18, 18)
//                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//            
//        );
//        }
//        Tang_tretLayout.setHorizontalGroup(
//            Tang_tretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(Tang_tretLayout.createSequentialGroup()
//                .addContainerGap()
//                .addGroup(Tang_tretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
//                    .addComponent(Jphong2, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
//                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//        );
//        Tang_tretLayout.setVerticalGroup(
//            Tang_tretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(Tang_tretLayout.createSequentialGroup()
//                .addContainerGap()
//                .addGroup(Tang_tretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
//                    .addComponent(Jphong2, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
//                
//                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//        );
//        }
//        Tang_tretLayout.setHorizontalGroup(
//            Tang_tretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(Tang_tretLayout.createSequentialGroup()
//                .addGroup(Tang_tretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
//                    .addComponent(Jphong1, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
//                    .addComponent(Jphong6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//                .addGap(70, 70, 70)
//                .addGroup(Tang_tretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
//                    .addComponent(Jphong2, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
//                    .addComponent(Jphong7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//                .addGap(70, 70, 70)
//                .addGroup(Tang_tretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
//                    .addComponent(Jphong3, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
//                    .addComponent(Jphong8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//                .addGap(70, 70, 70)
//                .addGroup(Tang_tretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
//                    .addComponent(Jphong4, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
//                    .addComponent(Jphong9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//                .addGap(70, 70, 70)
//                .addGroup(Tang_tretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
//                    .addComponent(Jphong5, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
//                    .addComponent(Jphong10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//        );
//        Tang_tretLayout.setVerticalGroup(
//            Tang_tretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(Tang_tretLayout.createSequentialGroup()
//                .addContainerGap()
//                .addGroup(Tang_tretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
//                    .addComponent(Jphong1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
//                    .addComponent(Jphong2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                    .addComponent(Jphong5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                    .addComponent(Jphong3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                    .addComponent(Jphong4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//                .addGap(18, 18, 18)
//                .addGroup(Tang_tretLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
//                    .addComponent(Jphong6, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
//                    .addComponent(Jphong7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                    .addComponent(Jphong8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                    .addComponent(Jphong9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                    .addComponent(Jphong10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//                .addContainerGap())
//        );

        jTabbedPane2.addTab("Tầng trệt", Tang_tret);
//        jPanel1.add(jTabbedPane2);
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
        jTabbedPane2 = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 415, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Test().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane2;
    // End of variables declaration//GEN-END:variables
}

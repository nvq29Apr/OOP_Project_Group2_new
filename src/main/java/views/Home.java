/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import dataprocessors.GetDataFromJson;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.NFT;

/**
 *
 * @author quyetdaika
 */
public class Home extends javax.swing.JFrame implements GetDataFromJson {
    
    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        defaultTableModel = (DefaultTableModel)jTable1.getModel();
        nfts = getNFTsFromJson();
        btnTimeSlotClicked(btn1H.getText());
//        jScrollPane1.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        jlbHome = new javax.swing.JLabel();
        jlbNFT = new javax.swing.JLabel();
        jlbNFT1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        filterPanel = new javax.swing.JPanel();
        btnSearch = new javax.swing.JButton();
        jtfSearch = new javax.swing.JTextField();
        btn1H = new javax.swing.JButton();
        btn6H = new javax.swing.JButton();
        btn24H = new javax.swing.JButton();
        btn7D = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        header.setBackground(new java.awt.Color(204, 255, 204));
        header.setMinimumSize(new java.awt.Dimension(785, 57));
        header.setName(""); // NOI18N

        jlbHome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbHome.setText("Home");
        jlbHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbHomeMouseClicked(evt);
            }
        });

        jlbNFT.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jlbNFT.setText("NFT");

        jlbNFT1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jlbNFT1.setText("Tweet");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Blog");

        btnExit.setBackground(new java.awt.Color(255, 153, 153));
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jlbHome, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlbNFT)
                .addGap(28, 28, 28)
                .addComponent(jlbNFT1)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(54, 54, 54)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbHome)
                    .addComponent(jlbNFT)
                    .addComponent(jlbNFT1)
                    .addComponent(jLabel1)
                    .addComponent(btnExit))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        btnSearch.setBackground(new java.awt.Color(255, 255, 204));
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jtfSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfSearchKeyPressed(evt);
            }
        });

        btn1H.setBackground(new java.awt.Color(204, 255, 255));
        btn1H.setText("1H");
        btn1H.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1HActionPerformed(evt);
            }
        });

        btn6H.setBackground(new java.awt.Color(204, 255, 255));
        btn6H.setText("6H");
        btn6H.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6HActionPerformed(evt);
            }
        });

        btn24H.setBackground(new java.awt.Color(204, 255, 255));
        btn24H.setText("24H");
        btn24H.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn24HActionPerformed(evt);
            }
        });

        btn7D.setBackground(new java.awt.Color(204, 255, 255));
        btn7D.setText("7D");
        btn7D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7DActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout filterPanelLayout = new javax.swing.GroupLayout(filterPanel);
        filterPanel.setLayout(filterPanelLayout);
        filterPanelLayout.setHorizontalGroup(
            filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, filterPanelLayout.createSequentialGroup()
                .addComponent(btnSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 243, Short.MAX_VALUE)
                .addComponent(btn1H, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn6H, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn24H, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn7D, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        filterPanelLayout.setVerticalGroup(
            filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn7D)
                    .addComponent(btn24H)
                    .addComponent(btnSearch)
                    .addComponent(jtfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn6H)
                    .addComponent(btn1H))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setEnabled(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Volume", "Change", "Floor price", "Owners", "Items"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(153, 153, 153));
        jTable1.setInheritsPopupMenu(true);
        jTable1.setShowGrid(true);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(filterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(filterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn6HActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6HActionPerformed
        // TODO add your handling code here:
        btnTimeSlotClicked(btn6H.getText());
    }//GEN-LAST:event_btn6HActionPerformed

    private void btn24HActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn24HActionPerformed
        // TODO add your handling code here:
        btnTimeSlotClicked(btn24H.getText());
    }//GEN-LAST:event_btn24HActionPerformed

    private void btn7DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7DActionPerformed
        // TODO add your handling code here:
        btnTimeSlotClicked(btn7D.getText());
    }//GEN-LAST:event_btn7DActionPerformed

    private void btn1HActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1HActionPerformed
        // TODO add your handling code here:
        btnTimeSlotClicked(btn1H.getText());
    }//GEN-LAST:event_btn1HActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        if(jtfSearch.getText().equals("")) return;
        defaultTableModel.setRowCount(0);
        for(NFT x : currentNfts){
            if(x.getName().toLowerCase().contains(jtfSearch.getText().toLowerCase())) 
                defaultTableModel.addRow(x.getNFT());
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void jlbHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbHomeMouseClicked
        // TODO add your handling code here:
        filterPanel.setVisible(false);
        jScrollPane1.setVisible(false);
        
    }//GEN-LAST:event_jlbHomeMouseClicked

    private void jtfSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfSearchKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() ==  KeyEvent.VK_ENTER){
            if(jtfSearch.getText().equals("")) return;
            defaultTableModel.setRowCount(0);
            for(NFT x : currentNfts){
                if(x.getName().toLowerCase().contains(jtfSearch.getText().toLowerCase())) 
                    defaultTableModel.addRow(x.getNFT());
            }
        }
    }//GEN-LAST:event_jtfSearchKeyPressed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed
    
    private void btnTimeSlotClicked(String timeSlot){
        currentNfts = getNFTsByTimeslot(timeSlot);
        defaultTableModel.setRowCount(0);
        for(NFT x : currentNfts){
            defaultTableModel.addRow(x.getNFT());
        }
    }
    
    private List<NFT> getNFTsByTimeslot(String timeSlot){
        List<NFT> result = new ArrayList<>();
        for(NFT x : nfts){
            if(x.getTimeSlot().equals(timeSlot)) result.add(x);
        }
        return result;
    }
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
                if ("Nimbus".equals(info.getName())) {
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }
    DefaultTableModel defaultTableModel;
    private List<NFT> currentNfts;
    private List<NFT> nfts;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1H;
    private javax.swing.JButton btn24H;
    private javax.swing.JButton btn6H;
    private javax.swing.JButton btn7D;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSearch;
    private javax.swing.JPanel filterPanel;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jlbHome;
    private javax.swing.JLabel jlbNFT;
    private javax.swing.JLabel jlbNFT1;
    private javax.swing.JTextField jtfSearch;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author bridge-ai
 */
public class HomePage extends javax.swing.JFrame {

    /**
     * Creates new form HomePage
     */
    public HomePage() {
        initComponents();
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
        logoutBtn = new javax.swing.JButton();
        votingBtn = new javax.swing.JButton();
        studentName = new javax.swing.JLabel();
        studentId = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        desciptionBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logoutBtn.setBackground(new java.awt.Color(255, 255, 255));
        logoutBtn.setText("ออกจากระบบ");
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });
        jPanel1.add(logoutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 153, 40));

        votingBtn.setBackground(new java.awt.Color(255, 255, 255));
        votingBtn.setText("เลือกตั้ง");
        jPanel1.add(votingBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 153, 40));

        studentName.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        studentName.setForeground(new java.awt.Color(255, 255, 255));
        studentName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        studentName.setText("พิสิฐไชย เรืองวัฒนาพงษ์");
        studentName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 250, -1));

        studentId.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        studentId.setForeground(new java.awt.Color(255, 255, 255));
        studentId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        studentId.setText("63070121");
        jPanel1.add(studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 250, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/unnamed (1) 1.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        desciptionBtn.setBackground(new java.awt.Color(255, 255, 255));
        desciptionBtn.setText("คำแนะนำ");
        desciptionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desciptionBtnActionPerformed(evt);
            }
        });
        jPanel1.add(desciptionBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 153, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/Home.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void desciptionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desciptionBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_desciptionBtnActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logoutBtnActionPerformed

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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    public JButton getVotingBtn() {
        return votingBtn;
    }

    public void setVotingBtn(JButton votingBtn) {
        this.votingBtn = votingBtn;
    }

    public JLabel getStudentId() {
        return studentId;
    }

    public void setStudentId(JLabel studentId) {
        this.studentId = studentId;
    }

    public JLabel getStudentName() {
        return studentName;
    }

    public void setStudentName(JLabel studentName) {
        this.studentName = studentName;
    }

    public JButton getLogoutBtn() {
        return logoutBtn;
    }

    public JButton getDesciptionBtn() {
        return desciptionBtn;
    }

    public void setDesciptionBtn(JButton desciptionBtn) {
        this.desciptionBtn = desciptionBtn;
    }

    public void setLogoutBtn(JButton logoutBtn) {
        this.logoutBtn = logoutBtn;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton desciptionBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JLabel studentId;
    private javax.swing.JLabel studentName;
    private javax.swing.JButton votingBtn;
    // End of variables declaration//GEN-END:variables
}

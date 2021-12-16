/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author bridge-ai
 */
public class AdminPanel extends javax.swing.JFrame {

    /**
     * Creates new form AddminPanal
     */
    public AdminPanel() {
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

        jSpinner1 = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        setTimeBtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        setTimeTextField = new javax.swing.JTextField();
        addLeaderBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        candidateTable = new javax.swing.JTable();
        candidateLabel = new javax.swing.JLabel();
        adminLabel = new javax.swing.JLabel();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        setTimeBtn.setBackground(new java.awt.Color(255, 255, 255));
        setTimeBtn.setText("กำหนดเวลาโหวต");
        jPanel2.add(setTimeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 170, -1, 37));

        logoutBtn.setBackground(new java.awt.Color(255, 255, 255));
        logoutBtn.setText("ออกจากระบบ");
        logoutBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jPanel2.add(logoutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 430, 138, 35));

        setTimeTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        setTimeTextField.setText("00:00:00");
        jPanel2.add(setTimeTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 120, 138, 40));

        addLeaderBtn.setBackground(new java.awt.Color(255, 255, 255));
        addLeaderBtn.setText("เพื่มผู้ลงสมัคร");
        jPanel2.add(addLeaderBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 380, 138, 38));

        jScrollPane2.setBackground(new java.awt.Color(139, 199, 235));

        candidateTable.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        candidateTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ลำดับ", "รหัสนักศึกษา", "ชื่อ นามสกุล", "นโยบาย", "คะแนน"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(candidateTable);
        if (candidateTable.getColumnModel().getColumnCount() > 0) {
            candidateTable.getColumnModel().getColumn(0).setResizable(false);
            candidateTable.getColumnModel().getColumn(1).setResizable(false);
            candidateTable.getColumnModel().getColumn(2).setResizable(false);
            candidateTable.getColumnModel().getColumn(3).setResizable(false);
            candidateTable.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 600, 350));

        candidateLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        candidateLabel.setText("ผู้ลงสมัครเลือกตั้ง");
        candidateLabel.setToolTipText("");
        jPanel2.add(candidateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        adminLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/AdminPanal.png"))); // NOI18N
        adminLabel.setText("ผู้");
        jPanel2.add(adminLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminPanel().setVisible(true);
            }
        });
    }

    public JButton getAddLeaderBtn() {
        return addLeaderBtn;
    }

    public void setAddLeaderBtn(JButton addLeaderBtn) {
        this.addLeaderBtn = addLeaderBtn;
    }

    public JButton getSetTimeBtn() {
        return setTimeBtn;
    }

    public void setSetTimeBtn(JButton setTimeBtn) {
        this.setTimeBtn = setTimeBtn;
    }

    public JTextField getSetTimeTextField() {
        return setTimeTextField;
    }

    public void setSetTimeTextField(JTextField setTimeTextField) {
        this.setTimeTextField = setTimeTextField;
    }

    public JButton getLogoutBtn() {
        return logoutBtn;
    }

    public void setLogoutBtn(JButton logoutBtn) {
        this.logoutBtn = logoutBtn;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addLeaderBtn;
    private javax.swing.JLabel adminLabel;
    private javax.swing.JLabel candidateLabel;
    private javax.swing.JTable candidateTable;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton setTimeBtn;
    private javax.swing.JTextField setTimeTextField;
    // End of variables declaration//GEN-END:variables

    public JTable getCandidateTable() {
        return candidateTable;
    }

    public void setCandidateTable(JTable candidateTable) {
        this.candidateTable = candidateTable;
    }

}

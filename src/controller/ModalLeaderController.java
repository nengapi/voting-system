package controller;

import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.CandidateModel;
import view.AdminPanel;
import view.ModalLeader;

public class ModalLeaderController implements ActionListener {
    private ModalLeader view;
    private CandidateModel model;
    private AdminPanel adminView;
    
    public ModalLeaderController(AdminPanel AdminView) {
        view = new ModalLeader();
        model = new CandidateModel();
        adminView = AdminView;
        
        view.setVisible(true);
        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        view.getRegisBtn().addActionListener(this);
        view.getCancelBtn().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(view.getRegisBtn())) {
            String name = view.getNameTextField().getText();
            String student_id = view.getStudentIdTextField().getText();
            String policy = view.getPolicyTextField().getText();
            
            if(model.insert(student_id, name, policy)) {
                view.dispose();
                adminView.dispose();
                new AdminPanelController();
                JOptionPane.showMessageDialog(null, "เพิ่มผู้สมัครสำเร็จ", "Successfully", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "เพิ่มผู้สมัครไม่สำเร็จ", "Failed", JOptionPane.ERROR_MESSAGE);
            }
        } else if (ae.getSource().equals(view.getCancelBtn())) {
            view.dispose();
        }
    }
    
}

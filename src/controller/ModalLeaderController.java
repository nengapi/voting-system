package controller;

import java.awt.event.*;
import javax.swing.JFrame;
import model.CandidateModel;
import view.ModalLeader;

public class ModalLeaderController implements ActionListener {
    private ModalLeader view;
    private CandidateModel model;
    
    public ModalLeaderController() {
        view = new ModalLeader();
        model = new CandidateModel();
        
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
                System.out.println("Candidate was registered successed");
            } else {
                System.out.println("Candidate was registered failed");
            }
        } else if (ae.getSource().equals(view.getCancelBtn())) {
            view.dispose();
        }
    }
    
}

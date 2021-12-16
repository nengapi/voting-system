package controller;

import java.awt.event.*;
import javax.swing.JFrame;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import view.AdminPanel;
import model.Candidate;
import model.VotingTimeModel;
import model.CandidateModel;

public class AdminPanelController implements ActionListener {
    private AdminPanel view;
    private CandidateModel candidateModel;
    private VotingTimeModel votingTimeModel;
    
    public AdminPanelController() {
        view = new AdminPanel();
        candidateModel = new CandidateModel();
        votingTimeModel = new VotingTimeModel();
        
        view.setVisible(true);
        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        view.getAddLeaderBtn().addActionListener(this);
        view.getSetTimeBtn().addActionListener(this);
        view.getLogoutBtn().addActionListener(this);
        
        //show all candidate
        ArrayList<Candidate> candidate = candidateModel.getCandidateList();
        for(int i = 0; i < candidate.size(); i++) {
        }
        String[] votingTime = votingTimeModel.get().split("/");
        view.getSetTimeTextField().setText(votingTime[0]);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(view.getAddLeaderBtn())) {
            new ModalLeaderController();
        } else if(ae.getSource().equals(view.getSetTimeBtn())) {
            if(votingTimeModel.update(view.getSetTimeTextField().getText())) {
                JOptionPane.showMessageDialog(null, "กำหนดเวลาสำเร็จ", "Successfully", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "กำหนดเวลาไม่สำเร็จ", "Failed", JOptionPane.ERROR_MESSAGE);
            }
        } else if (ae.getSource().equals(view.getLogoutBtn())) {
            System.exit(0);
        }
    }
    
}

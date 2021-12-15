package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import model.CandidateModel;
import view.AdminPanel;
import java.util.ArrayList;
import model.Candidate;
import model.VotingTimeModel;

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
        
        ArrayList<Candidate> candidate = candidateModel.getAll();
        for(int i = 0; i < candidate.size(); i++) {
            System.out.println(candidate.get(i).getStudent_id()+", "+candidate.get(i).getName());
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(view.getAddLeaderBtn())) {
            new ModalLeaderController();
        } else if(ae.getSource().equals(view.getSetTimeBtn())) {
            if(votingTimeModel.update(view.getSetTimeTextField().getText())) {
                System.out.println("Time was set.");
            } else {
                System.out.println("Set time failed.");
            }
        }
    }
    
}

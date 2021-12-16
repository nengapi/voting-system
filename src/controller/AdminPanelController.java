package controller;

import java.awt.event.*;
import javax.swing.JFrame;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import view.AdminPanel;
import model.Candidate;
import model.VotingTimeModel;
import model.CandidateModel;
import model.ScoreModel;

public class AdminPanelController implements ActionListener {

    private AdminPanel view;
    private CandidateModel candidateModel;
    private VotingTimeModel votingTimeModel;
    private ScoreModel scoreModel;

    public AdminPanelController() {
        view = new AdminPanel();
        candidateModel = new CandidateModel();
        votingTimeModel = new VotingTimeModel();
        scoreModel = new ScoreModel();

        view.setVisible(true);
        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        view.getAddLeaderBtn().addActionListener(this);
        view.getSetTimeBtn().addActionListener(this);

        String[] votingTime = votingTimeModel.get().split("/");
        view.getSetTimeTextField().setText(votingTime[0]);

        //show all candidate
        ArrayList<Candidate> candidate = candidateModel.getCandidateList();
        renderTable(candidate);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(view.getAddLeaderBtn())) {
            new ModalLeaderController();
            view.dispose();
        } else if (ae.getSource().equals(view.getSetTimeBtn())) {
            if (votingTimeModel.update(view.getSetTimeTextField().getText())) {
                System.out.println("Time was set.");
            } else {
                System.out.println("Set time failed.");
            }
        }
    }

    public void renderTable(ArrayList<Candidate> candidate) {
        DefaultTableModel table = (DefaultTableModel) view.getCandidateTable().getModel();
        
//        for (int i =0; i < scoreModel.getScore().size(); i++) {
//            
//        }
        
        for (int i = 0; i < candidate.size(); i++) {
            table.addRow(new Object[0]);
            table.setValueAt(i + 1, i, 0);
            table.setValueAt(candidate.get(i).getStudentId(), i, 1);
            table.setValueAt(candidate.get(i).getName(), i, 2);
            table.setValueAt(candidate.get(i).getPolicy(), i, 3);
            table.setValueAt(0, i, 4);
        }
    }

}

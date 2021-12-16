package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JFrame;
import model.Candidate;
import model.CandidateModel;
import model.ScoreModel;
import view.Final;

public class FinalController implements ActionListener {

    private Final view;
    private ScoreModel scoreModel;
    private CandidateModel candidateModel;

    public FinalController() {
        view = new Final();
        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        view.setVisible(true);
        view.getLogoutBtn().addActionListener(this);

        candidateModel = new CandidateModel();
        scoreModel = new ScoreModel();

        ArrayList<Candidate> candidate = candidateModel.getCandidateList();
        ArrayList score = new ArrayList();
        for (int i = 0; i < candidate.size(); i++) {
            int count = 0;
            for (int j = 0; j < scoreModel.getScore().size(); j++) {
                if ((int) scoreModel.getScore().get(j) == (i + 1)) {
                    count++;
                }
            }
            score.add(count);
        }

        int max = (int) Collections.max(score);
        int getIndex = score.indexOf(max);
        
        Candidate c = candidateModel.readWinner(getIndex);
        view.getNameBlock().setText(c.getName());
        view.getStdBlock().setText(c.getStudentId());

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(view.getLogoutBtn())) {
            System.exit(0);
        }
    }

}

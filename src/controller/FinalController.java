package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import model.ScoreModel;
import view.Final;

public class FinalController implements ActionListener {
    private Final view;
    private ScoreModel scoreModel;

    public FinalController() {
        view = new Final();
        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        view.setVisible(true);
        view.getLogoutBtn().addActionListener(this);
        
        scoreModel = new ScoreModel();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(view.getLogoutBtn())) {
            view.dispose();
        }
    }
    
}

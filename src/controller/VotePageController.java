package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import view.VotePage;

public class VotePageController implements ActionListener {
    private VotePage view;
    
    public VotePageController() {
        view = new VotePage();
        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        view.setVisible(true);
        view.getConfirmBtn().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(view.getConfirmBtn())) {
            System.out.println("Confirmed");
        }
    }
}

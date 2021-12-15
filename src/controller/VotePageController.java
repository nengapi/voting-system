package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import model.BlockModel;
import model.User;
import view.VotePage;

public class VotePageController implements ActionListener {
    private VotePage view;
    private BlockModel block;

    public VotePageController(User user) {
        view = new VotePage();
        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        view.setVisible(true);
        view.getConfirmBtn().addActionListener(this);
        
        block = new BlockModel(user);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(view.getConfirmBtn())) {
            System.out.println("Confirmed");
            block.insertBlock();
        }
    }
}

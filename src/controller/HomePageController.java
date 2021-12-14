package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.HomePage;

public class HomePageController implements ActionListener {
    
    private HomePage view;
    
    public HomePageController() {
        view = new HomePage();
        view.setVisible(true);
        view.getDesciptionBtn().addActionListener(this);
        view.getProfileBtn().addActionListener(this);
        view.getVotingBtn().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(view.getDesciptionBtn())) {
            new DescriptionController();
        } else if (e.getSource().equals(view.getProfileBtn())) {
            new ProfileController();
        } else if (e.getSource().equals(view.getVotingBtn())) {
            new VotePageController();
        }
    }
}

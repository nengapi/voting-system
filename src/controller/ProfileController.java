package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import view.Profile;

public class ProfileController implements ActionListener {
    private Profile view;
    
    public ProfileController() {
        view = new Profile();
        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        view.setVisible(true);
        
        view.getCloseBtn().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(view.getCloseBtn())) {
            view.dispose();
        }
    }
}

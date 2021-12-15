package controller;

import java.awt.event.*;
import javax.swing.JFrame;
import view.Description;

public class DescriptionController implements ActionListener {
    private Description view;
    
    public DescriptionController() {
        view = new Description();
        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        view.getBackBtn().addActionListener(this);
        view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(view.getBackBtn())) {
            view.dispose();
        }
    }
}

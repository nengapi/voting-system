
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.UserModel;
import view.LoginPage;


public class LoginController implements ActionListener{
    private UserModel model;
    private LoginPage view;

    public LoginController() {
        view = new LoginPage();
        view.setVisible(true);
        
        model = new UserModel();
        
        //when user click login button
        view.getLoginBtn().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(view.getLoginBtn())) {
            String username = view.getUsernameTextField().getText();
            String password = view.getPasswordTextField().getText();
            model.checkUser(username, password);
        }
    }
    
}

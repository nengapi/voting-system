package controller;

import java.awt.event.*;
import javax.swing.JOptionPane;
import model.UserModel;
import view.LoginPage;

public class LoginController implements ActionListener {

    private UserModel model;
    private LoginPage view;

    public LoginController() {
        view = new LoginPage();
        view.setVisible(true);

        model = new UserModel();

        //when user click login button
        view.getLoginBtn().addActionListener(this);

        view.getRegisterBtn().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(view.getLoginBtn())) {
            String username = view.getUsernameTextField().getText();
            String password = view.getPasswordTextField().getText();

            if (model.checkUser(username, password)) {
                view.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "ชื่อผู้ใช้หรือรหัสผ่านไม่ถูกต้อง", "Failed", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource().equals(view.getRegisterBtn())) {
            //go to register page
            new RegisterController();
        }
    }

}

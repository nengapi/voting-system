package controller;

import java.awt.event.*;
import javax.swing.JFrame;
import model.UserModel;
import view.RegisterPage;

public class RegisterController implements ActionListener {

    private UserModel model;
    private RegisterPage view;

    public RegisterController() {
        view = new RegisterPage();
        view.setVisible(true);
        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        model = new UserModel();

        view.getSubmitBtn().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(view.getSubmitBtn())) {
            String studentId = view.getStudentIdTextField().getText();
            String password = view.getPasswordTextField().getText();
            String fullName = view.getFullNameTextField().getText();

            if (model.insertUser(studentId, password, fullName)) {
                System.out.println("insert data successful");
                view.dispose();
            }

        }
    }
}

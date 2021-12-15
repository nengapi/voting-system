package controller;

import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
        view.getBackBtn().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(view.getSubmitBtn())) {
            String fullName = view.getFullNameTextField().getText();
            String studentId = view.getStudentIdTextField().getText();
            String password = view.getPasswordTextField().getText();
            
            try {
                if(fullName.equals("")) {
                    throw new Exception("fullName");
                }
                if(studentId.equals("")) {
                    throw new Exception("studentId");
                }
                if(password.length() < 8) {
                    throw new Exception("password");
                }
                
                Integer.parseInt(studentId);

                model.insertUser(studentId, password, fullName);
                view.dispose();
                JOptionPane.showMessageDialog(null, "สมัครสมาชิกสำเร็จ", "Successfully", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "กรุณากรอกรหัสนักศึกษาเป็นตัวเลขเท่านั้น", "Error", JOptionPane.ERROR_MESSAGE);
            } catch(Exception ex) {
                if(ex.getMessage().equals("fullName")) {
                    JOptionPane.showMessageDialog(null, "กรุณากรอกชื่อ-นามสกุล", "Error", JOptionPane.ERROR_MESSAGE);
                } else if(ex.getMessage().equals("password")) {
                    JOptionPane.showMessageDialog(null, "กรุณากรอกรหัสผ่านอย่างน้อย 8 หลัก", "Error", JOptionPane.ERROR_MESSAGE);
                } else if(ex.getMessage().equals("studentId")) {
                    JOptionPane.showMessageDialog(null, "กรุณากรอกรหัสนักศึกษา", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        } else if (e.getSource().equals(view.getBackBtn())) {
            view.dispose();
        }
    }
}

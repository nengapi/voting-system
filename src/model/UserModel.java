package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.HomePage;

public class UserModel {

    private User user;
    private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement pst = null;

    public UserModel() {
        user = new User("", "", "");
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean checkUser(String username, String password) {
        con = Connect.ConnectDB();
        String sql = "SELECT student_id, password FROM users WHERE student_id=? AND password=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);

            rs = pst.executeQuery();
            if (rs.next()) {
                System.out.println("login successful");
                HomePage hp = new HomePage();
                hp.setVisible(true);
                return true;
            } else {
                System.out.println("your username or password are wrong");
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}

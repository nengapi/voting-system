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
    private final Connection con = Connect.ConnectDB();
    private ResultSet rs = null;
    private PreparedStatement check = null, insert = null;
    private String sql;

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
        sql = "SELECT student_id, password FROM users WHERE student_id=? AND password=?";
        try {
            check = con.prepareStatement(sql);
            check.setString(1, username);
            check.setString(2, password);

            rs = check.executeQuery();
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

    public boolean insertUser(String studentId, String password, String fullName) {
        sql = "INSERT INTO users (student_id, password, fullName, created_at) VALUES (?, ?, ?, ?)";
        try {

            insert = con.prepareStatement(sql);

            insert.setInt(1, Integer.parseInt(studentId));
            insert.setString(2, password);
            insert.setString(3, fullName);
            insert.setTimestamp(4, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));

            insert.executeUpdate();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}

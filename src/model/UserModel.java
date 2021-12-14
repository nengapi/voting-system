package model;

import controller.HomePageController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.AdminPanel;

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
        sql = "SELECT student_id, password, isAdmin FROM users WHERE student_id=? AND password=?";
        user = new User(username, password);
        try {
            check = con.prepareStatement(sql);
            check.setString(1, user.getStudentId());
            check.setString(2, new Password(user.getPassword()).getHashPassword());

            rs = check.executeQuery();

            if (rs != null && rs.next()) {
                System.out.println("login successful");
                if (check.getResultSet().getBoolean("isAdmin")) {
                    AdminPanel ad = new AdminPanel();
                    ad.setVisible(true);
                    System.out.println("admin");
                } else {
                    new HomePageController();
                    System.out.println("user");
                }
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
        user = new User(studentId, password, fullName);
        try {

            insert = con.prepareStatement(sql);

            insert.setInt(1, user.getStudentIdToInt());
            insert.setString(2, new Password(user.getPassword()).getHashPassword());
            insert.setString(3, user.getFullName());
            insert.setTimestamp(4, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));

            insert.executeUpdate();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class
                    .getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}

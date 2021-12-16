package model;

import controller.HomePageController;
import controller.AdminPanelController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserModel {

    private User user;
    private final Connection con = Connect.ConnectDB();
    private ResultSet rs = null;
    private PreparedStatement check = null, insert = null;
    private String sql;

    public UserModel() {
        user = new User(0, "", "", "");
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean checkUser(String username, String password) {
        sql = "SELECT student_id, password, isAdmin FROM users WHERE student_id=? AND password=?";
        try {
            check = con.prepareStatement(sql);
            check.setString(1, username);
            check.setString(2, new HashInput(password).getHashInput());

            rs = check.executeQuery();

            if (rs != null && rs.next()) {
                System.out.println("login successful");
                readUserSQL(username);
                if (check.getResultSet().getBoolean("isAdmin")) {
                    new AdminPanelController();
                    System.out.println("admin");
                } else {
                    new HomePageController(user);
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
        try {

            insert = con.prepareStatement(sql);

            insert.setInt(1, Integer.parseInt(studentId));
            insert.setString(2, new HashInput(password).getHashInput());
            insert.setString(3, fullName);
            insert.setTimestamp(4, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));

            insert.executeUpdate();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class
                    .getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public void readUserSQL(String username) {
        sql = "SELECT * FROM users WHERE student_id=?";
        try {
            check = con.prepareStatement(sql);
            check.setString(1, username);

            rs = check.executeQuery();

            if (rs != null && rs.next()) {
                user.setId(rs.getInt("id"));
                user.setStudentId(rs.getString("student_id"));
                user.setFullName(rs.getString("fullName"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean isVoted() {
        sql = "SELECT BlockID FROM block WHERE voterID = ?";
        try {
            System.out.println("Check isVoted");
            check = con.prepareStatement(sql);
            check.setInt(1, user.getId());
            rs = check.executeQuery();
            if(rs != null && rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}

package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VotingTimeModel {
    
    private final Connection CONNECT = Connect.ConnectDB();
    private ResultSet result = null;
    private PreparedStatement stmt = null;
    
    public String get() {
        String sql = "SELECT voting_time, update_at FROM setting WHERE id = 1";
        try {
            stmt = CONNECT.prepareStatement(sql);
            result = stmt.executeQuery();
            result.next();
            String voting_time = result.getString("voting_time")+"/"+result.getString("update_at");
            return voting_time;
        } catch(SQLException e) {
            System.out.println(e);
            return "00:00:00/"+java.sql.Timestamp.valueOf(java.time.LocalDateTime.now());
        }
    }
    
    public boolean update(String time) {
        String sql = "UPDATE setting SET voting_time = ?, update_at = ? WHERE id = 1";
        try {
            stmt = CONNECT.prepareStatement(sql);
            stmt.setString(1, time);
            stmt.setTimestamp(2, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
            stmt.executeUpdate();
            return true;
        } catch(SQLException e) {
            return false;
        }
    }
}

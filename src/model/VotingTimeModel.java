package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VotingTimeModel {
    
    private final Connection CONNECT = Connect.ConnectDB();
    private ResultSet result = null;
    private PreparedStatement stmt = null;
    
    public boolean update(String time) {
        String sql = "UPDATE setting SET voting_time = ? WHERE id = 1";
        try {
            stmt = CONNECT.prepareStatement(sql);
            stmt.setString(1, time);
            stmt.executeUpdate();
            return true;
        } catch(SQLException e) {
            return false;
        }
    }
}

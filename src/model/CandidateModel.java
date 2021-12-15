package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CandidateModel {
//    private Candidate candidate;
    private final Connection CONNECT = Connect.ConnectDB();
    private ResultSet result = null;
    private PreparedStatement stmt = null;
    
    public boolean add(String student_id, String name) {
        String sql = "INSERT INTO Candidate (student_id, name, create_at) VALUES (?, ?, ?)";
        try {
            stmt = CONNECT.prepareStatement(sql);
            stmt.setString(1, student_id);
            stmt.setString(2, name);
            stmt.setTimestamp(3, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
            stmt.executeUpdate();
            return true;
        } catch(SQLException e) {
            return false;
        }
    }
    
    public ArrayList<Candidate> getAll() {
        String sql = "SELECT * FROM candidate";

        try {
            stmt = CONNECT.prepareStatement(sql);
            result = stmt.executeQuery();
            
            ArrayList<Candidate> candidate = new ArrayList<Candidate>();
            
            while(result.next()) {
                candidate.add(new Candidate(result.getString("student_id"), result.getString("name")));
            }
            
            return candidate;
        } catch(SQLException e) {
            return null;
        }
                
    }
}

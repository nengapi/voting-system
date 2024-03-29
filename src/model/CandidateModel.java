package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CandidateModel {

    private Candidate candidate;
    private ArrayList<Candidate> candidateList;
    private final Connection CONNECT = Connect.ConnectDB();
    private PreparedStatement stmt = null;
    private ResultSet result = null;

    public CandidateModel() {
        candidateList = new ArrayList<Candidate>();
        readCandidate();
    }

    public ArrayList<Candidate> getCandidateList() {
        return candidateList;
    }

    public void setCandidateList(ArrayList<Candidate> candidateList) {
        this.candidateList = candidateList;
    }

    public boolean insert(String student_id, String name, String policy) {
        String sql = "INSERT INTO Candidate (student_id, name, policy, create_at) VALUES (?, ?, ?, ?)";
        try {
            stmt = CONNECT.prepareStatement(sql);
            stmt.setString(1, student_id);
            stmt.setString(2, name);
            stmt.setString(3, policy);
            stmt.setTimestamp(4, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void readCandidate() {
        String sql = "SELECT * FROM candidate";
        try {
            stmt = CONNECT.prepareStatement(sql);
            result = stmt.executeQuery();
            while (result != null && result.next()) {
                candidate = new Candidate();
                candidate.setStudentId(result.getString("student_id"));
                candidate.setName(result.getString("name"));
                candidate.setPolicy(result.getString("policy"));
                candidateList.add(candidate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Candidate readWinner(int id) {
        String sql = "SELECT * FROM candidate WHERE id=?";
        try {
            stmt = CONNECT.prepareStatement(sql);
            stmt.setInt(1, id + 1);
            result = stmt.executeQuery();
            if (result != null && result.next()) {
                candidate = new Candidate();
                candidate.setStudentId(result.getString("student_id"));
                candidate.setName(result.getString("name"));
                candidate.setPolicy(result.getString("policy"));
            }
            return candidate;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}

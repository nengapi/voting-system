package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BlockModel {

    private ArrayList<Block> block;
    private final Connection con = Connect.ConnectDB();
    private ResultSet rs = null;
    private PreparedStatement check = null, insert = null;
    private String sql;
    private User user;

    public BlockModel(User u) {
        user = u;

        block = new ArrayList<>();
    }

    public void readBlock() {

    }

    public void insertBlock() {
        sql = "INSERT INTO `block`(`prevBlockID`, `voterID`, `candidate`, `created_at`, `messageHash`, `messagePrevHash`) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try {

            insert = con.prepareStatement(sql);

            insert.setNull(1, 1);
            insert.setInt(2, user.getId());
            insert.setInt(3, 1);
            insert.setTimestamp(4, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
            insert.setString(5, new HashInput("0").getHashInput());
            insert.setNull(6, 6);

            insert.executeUpdate();
            System.out.println("complete");

        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
}

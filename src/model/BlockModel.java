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
    private Block singleBlock;
    private final Connection con = Connect.ConnectDB();
    private ResultSet rs = null;
    private PreparedStatement check = null, insert = null;
    private String sql;
    private User user;

    public BlockModel() {
        block = new ArrayList<Block>();
        readBlock(false);
    }

    public BlockModel(User u) {
        this();
        user = u;
    }

    public ArrayList<Block> getBlock() {
        return block;
    }

    public void setBlock(ArrayList<Block> block) {
        this.block = block;
    }

    public void readBlock(boolean single) {
        if (single) {
            sql = "SELECT * FROM block ORDER BY BlockID DESC LIMIT 1";
        } else {
            sql = "SELECT * FROM block";
        }
        try {
            check = con.prepareStatement(sql);

            rs = check.executeQuery();

            while (rs != null && rs.next()) {
                singleBlock = new Block();
                singleBlock.setBlockID(rs.getInt("BlockID"));
                singleBlock.setPrevBlockID(rs.getInt("prevBlockID"));
                singleBlock.setVoterID(rs.getInt("voterID"));
                singleBlock.setCandidate(rs.getInt("candidate"));
                singleBlock.setTimeStamp(rs.getTimestamp("created_at"));
                singleBlock.setMessageHash(rs.getString("messageHash"));
                singleBlock.setMessagePrevHash(rs.getString("messagePrevHash"));
                block.add(singleBlock);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean insertBlock(int candidate) {
        readBlock(true);
        sql = "INSERT INTO `block`(`prevBlockID`, `voterID`, `candidate`, `created_at`, `messageHash`, `messagePrevHash`) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        
        try {
            insert = con.prepareStatement(sql);
            insert.setInt(1, singleBlock.getBlockID());
            insert.setInt(2, user.getId());
            insert.setInt(3, candidate + 1);
            insert.setTimestamp(4, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
            insert.setString(5, new HashInput(singleBlock.getMessageHash()).getHashInput());
            insert.setString(6, singleBlock.getMessageHash());

            insert.executeUpdate();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}

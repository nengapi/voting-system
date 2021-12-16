
package model;

import java.util.Date;

public class Block {
    private int blockID;
    private int prevBlockID;
    private int voterID;
    private int candidate;
    private Date timeStamp;
    private String messageHash;
    private String messagePrevHash;

    public Block() {
        this(0, 0, 0, 0, null, "", "");
    }

    public Block(int blockID, int prevBlockID, int voterID, int candidate, Date timeStamp, String messageHash, String messagePrevHash) {
        this.blockID = blockID;
        this.prevBlockID = prevBlockID;
        this.voterID = voterID;
        this.candidate = candidate;
        this.timeStamp = timeStamp;
        this.messageHash = messageHash;
        this.messagePrevHash = messagePrevHash;
    }

    public int getBlockID() {
        return blockID;
    }

    public void setBlockID(int blockID) {
        this.blockID = blockID;
    }

    public int getPrevBlockID() {
        return prevBlockID;
    }

    public void setPrevBlockID(int prevBlockID) {
        this.prevBlockID = prevBlockID;
    }

    public int getVoterID() {
        return voterID;
    }

    public void setVoterID(int voterID) {
        this.voterID = voterID;
    }

    public int getCandidate() {
        return candidate;
    }

    public void setCandidate(int candidate) {
        this.candidate = candidate;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessageHash() {
        return messageHash;
    }

    public void setMessageHash(String messageHash) {
        this.messageHash = messageHash;
    }

    public String getMessagePrevHash() {
        return messagePrevHash;
    }

    public void setMessagePrevHash(String messagePrevHash) {
        this.messagePrevHash = messagePrevHash;
    }

    @Override
    public String toString() {
        return "Block{" + "blockID=" + blockID + ", prevBlockID=" + prevBlockID + ", voterID=" + voterID + ", candidate=" + candidate + ", timeStamp=" + timeStamp + ", messageHash=" + messageHash + ", messagePrevHash=" + messagePrevHash + '}';
    }
    
    
    
}

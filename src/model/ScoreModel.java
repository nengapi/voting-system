package model;

import java.util.ArrayList;

public class ScoreModel {

    private ArrayList score;
    private int count = 0;

    public ScoreModel() {
        BlockModel blockModel = new BlockModel();
        ArrayList<Block> block = blockModel.getBlock();
        score = new ArrayList();
        readScore(block);
    }

    public ArrayList getScore() {
        return score;
    }

    public void setScore(ArrayList score) {
        this.score = score;
    }

    public void readScore(ArrayList<Block> block) {
        for (int i = 0; i < block.size(); i++) {
            score.add(block.get(i).getCandidate());
        }
    }
}

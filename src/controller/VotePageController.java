package controller;

import java.awt.event.*;
import java.text.*;
import java.time.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.*;
import javax.swing.*;
import view.VotePage;
import model.User;
import model.BlockModel;
import model.Candidate;
import model.CandidateModel;
import model.UserModel;
import model.VotingTimeModel;
import view.HomePage;

public class VotePageController implements ActionListener {

    private VotePage view;
    private BlockModel block;
    private VotingTimeModel votingTimeModel;
    private CandidateModel candidateModel;
    private HomePage homePageView;
    private UserModel userModel;

    public VotePageController(User user, HomePage homePage) {
        view = new VotePage();
        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        view.setVisible(true);

        view.getConfirmBtn().addActionListener(this);
        view.getUnAcceptBtn().addActionListener(this);

        votingTimeModel = new VotingTimeModel();
        candidateModel = new CandidateModel();
        homePageView = homePage;
        
        userModel = new UserModel();
        userModel.setUser(user);

        block = new BlockModel(user);

        //show all candidate
        ArrayList<Candidate> candidate = candidateModel.getCandidateList();
        System.out.println(candidate.size());
        renderList(candidate);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(view.getConfirmBtn())) {

            String[] votingTime = votingTimeModel.get().split("/");

            long voting_time = 0, update_at = 0, unixTime;

            try {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = format.parse(votingTime[1]);
                update_at = date.getTime() / 1000L;

                DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                Date reference = dateFormat.parse("00:00:00");
                date = dateFormat.parse(votingTime[0]);
                voting_time = (date.getTime() - reference.getTime()) / 1000L;
            } catch (ParseException ex) {
                Logger.getLogger(VotePageController.class.getName()).log(Level.SEVERE, null, ex);
            }

            unixTime = Instant.now().getEpochSecond();

            if (unixTime - update_at <= voting_time && !userModel.isVoted() && view.getCandidateList().getSelectedIndex() > -1) {
                if(block.insertBlock(view.getCandidateList().getSelectedIndex())) {
                    homePageView.getVotingBtn().setEnabled(false);
                    view.dispose();
                    JOptionPane.showMessageDialog(null, "ลงคะแนนเสียงสำเร็จ", "Successfully", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "ลงคะแนนเสียงไม่สำเร็จ", "Successfully", JOptionPane.ERROR_MESSAGE);
                }
            } else if (unixTime - update_at > voting_time) {
                view.dispose();
                JOptionPane.showMessageDialog(null, "หมดเวลาลงคะแนน", "Alert", JOptionPane.ERROR_MESSAGE);
            } else if (userModel.isVoted()) {
                view.dispose();
                JOptionPane.showMessageDialog(null, "บัญชีนี้มีการลงคะแนนไปแล้ว", "Alert", JOptionPane.ERROR_MESSAGE);
            } else if (view.getCandidateList().getSelectedIndex() < 0) {
                JOptionPane.showMessageDialog(null, "กรุณาเลือกผู้สมัครที่ต้องการลงคะแนน", "Alert", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "ข้อผิดพลาดที่ไม่รู้จัก", "Alert", JOptionPane.ERROR_MESSAGE);
            }
        } else if (ae.getSource().equals(view.getUnAcceptBtn())) {
            
            String[] votingTime = votingTimeModel.get().split("/");

            long voting_time = 0, update_at = 0, unixTime;

            try {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = format.parse(votingTime[1]);
                update_at = date.getTime() / 1000L;

                DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                Date reference = dateFormat.parse("00:00:00");
                date = dateFormat.parse(votingTime[0]);
                voting_time = (date.getTime() - reference.getTime()) / 1000L;
            } catch (ParseException ex) {
                Logger.getLogger(VotePageController.class.getName()).log(Level.SEVERE, null, ex);
            }

            unixTime = Instant.now().getEpochSecond();

            if (unixTime - update_at <= voting_time && !userModel.isVoted()) {
                if(block.insertBlock(-1)) {
                    homePageView.getVotingBtn().setEnabled(false);
                    view.dispose();
                    JOptionPane.showMessageDialog(null, "บันทึกรายการไม่ประสงค์ลงคะแนนสำเร็จ", "Successfully", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "บันทึกรายการไม่ประสงค์ลงคะแนนไม่สำเร็จ", "Successfully", JOptionPane.ERROR_MESSAGE);
                }
            } else if (unixTime - update_at > voting_time) {
                view.dispose();
                JOptionPane.showMessageDialog(null, "หมดเวลาลงคะแนน", "Alert", JOptionPane.ERROR_MESSAGE);
            } else if (userModel.isVoted()) {
                view.dispose();
                JOptionPane.showMessageDialog(null, "บัญชีนี้มีการลงคะแนนไปแล้ว", "Alert", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "ข้อผิดพลาดที่ไม่รู้จัก", "Alert", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void renderList(ArrayList<Candidate> candidate) {
        String listData[] = new String[candidate.size()];
        for (int i = 0; i < candidate.size(); i++) {
            listData[i] = "หมายเลข " + (i+1) + " " + candidate.get(i).toString();
        }
        view.getCandidateList().setListData(listData);

    }
}

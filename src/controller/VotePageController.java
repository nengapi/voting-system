package controller;

import java.awt.event.*;
import java.text.*;
import java.time.*;
import java.util.Date;
import java.util.logging.*;
import javax.swing.*;
import view.VotePage;
import model.User;
import model.BlockModel;
import model.VotingTimeModel;

public class VotePageController implements ActionListener {
    private VotePage view;
    private BlockModel block;
    private VotingTimeModel votingTimeModel;

    public VotePageController(User user) {
        view = new VotePage();
        votingTimeModel = new VotingTimeModel();
        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        view.setVisible(true);
        view.getConfirmBtn().addActionListener(this);
        
        block = new BlockModel(user);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(view.getConfirmBtn())) {
            
            String[] votingTime = votingTimeModel.get().split("/");
            
            long voting_time = 0, update_at = 0, unixTime;
            
            try {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = format.parse(votingTime[1]);
                update_at = date.getTime()/1000L;
                
                DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                Date reference = dateFormat.parse("00:00:00");
                date = dateFormat.parse(votingTime[0]);
                voting_time = (date.getTime() - reference.getTime()) / 1000L;
            } catch (ParseException ex) {
                Logger.getLogger(VotePageController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            unixTime = Instant.now().getEpochSecond();
            
            if(unixTime-update_at <= voting_time){
                block.insertBlock();
            } else {
                JOptionPane.showMessageDialog(null, "Time out", "Alert", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

package controller;

import java.awt.event.*;
import java.text.*;
import java.time.Instant;
import java.util.Date;
import java.util.logging.*;
import view.HomePage;
import model.User;
import model.VotingTimeModel;

public class HomePageController implements ActionListener {
    
    private HomePage view;
    private User user;
    private VotingTimeModel votingTimeModel;
    
    public HomePageController(User u) {
        votingTimeModel = new VotingTimeModel();
        user = u;
        view = new HomePage();
        view.setVisible(true);
        view.getDesciptionBtn().addActionListener(this);
        view.getProfileBtn().addActionListener(this);
        view.getVotingBtn().addActionListener(this);
            
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
            
            if(unixTime-update_at > voting_time){
                view.getVotingBtn().setEnabled(false);
            }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(view.getDesciptionBtn())) {
            new DescriptionController();
        } else if (e.getSource().equals(view.getProfileBtn())) {
            new ProfileController();
        } else if (e.getSource().equals(view.getVotingBtn())) {
            new VotePageController(user);
        }
    }
}

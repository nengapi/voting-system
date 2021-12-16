package controller;

import java.awt.event.*;
import java.text.*;
import java.time.Instant;
import java.util.Date;
import java.util.logging.*;
import view.HomePage;
import model.User;
import model.UserModel;
import model.VotingTimeModel;

public class HomePageController implements ActionListener {
    
    private HomePage view;
    private User user;
    private VotingTimeModel votingTimeModel;
    private UserModel userModel;
    
    public HomePageController(User u) {
        votingTimeModel = new VotingTimeModel();
        user = u;
        userModel = new UserModel();
        userModel.setUser(user);
        view = new HomePage();
        view.setVisible(true);
        view.getDesciptionBtn().addActionListener(this);
        view.getVotingBtn().addActionListener(this);
        view.getLogoutBtn().addActionListener(this);
        
        view.getStudentName().setText(u.getFullName());
        view.getStudentId().setText(u.getStudentId());
            
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

        if(unixTime-update_at > voting_time || userModel.isVoted()){
            view.getVotingBtn().setEnabled(false);
        }
        
        System.out.println(u.getStudentId());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(view.getDesciptionBtn())) {
            System.out.println("desciption");
            new DescriptionController();
        } else if (e.getSource().equals(view.getVotingBtn())) {
            new VotePageController(user, view);
        } else if (e.getSource().equals(view.getLogoutBtn())) {
            System.exit(0);
        }
    }
}

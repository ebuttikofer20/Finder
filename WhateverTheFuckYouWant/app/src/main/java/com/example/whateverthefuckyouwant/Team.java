package com.example.whateverthefuckyouwant;

/**
 * Created by ebuttikofer20 on 1/28/17.
 */

//Enables the choosing of the correct answer by creating a class
public class Team {
    String teamNumber;
    String teamName;
    //something logo

    //Returns the team number
    public String getTeamNumber() {

        return teamNumber;
    }
    //Returns name of team
    public String getTeamName() {

        return teamName;
    }
    //Calls class
    public Team(String number, String name){
        teamNumber = number;
        teamName = name;
    }
    //Starting Card/"screen"
    public Team() {
        teamName = "Ready to play?";
        teamNumber = "Yes";
    }
    //checks if teamNumber is equal to the teamNumber in the API
    public boolean checkAnswer(Team answer) {
        return teamNumber.equals(answer.getTeamNumber()) && teamName.equals(answer.getTeamName());
    }
    public boolean checkAnswer(String answer) {
        return teamNumber.equals(answer) || teamName.equals(answer);
    }

}

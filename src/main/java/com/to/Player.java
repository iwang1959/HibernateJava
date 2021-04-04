package com.to;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity

@Table(name = "Player_Table")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int playerId;
    @Column(nullable = false, name = "Name")
    private String playerName;
   // @OneToOne
   // private Team team;
    @OneToMany
    List<Team> teamList = new ArrayList<>();


    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }

    private int age;

    /*public Player(String playerName, Team team, int age){
        super();
        this.playerName = playerName;
        this.team = team;
        this.age = age;
    }*/


    /*public Team getTeam(){
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }*/



    public Player() {

    }


    public int getPlayerId() {
        return playerId;
    }


    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }


    public String getPlayerName() {
        return playerName;
    }


    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }


    /*public String getTeamName() {
        return teamName;
    }


    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }*/


    public int getAge() {
        return age;
    }


    /*public Player(int playerId, String playerName, Team team, int age) {
        super();
        this.playerId = playerId;
        this.playerName = playerName;
        this.team = team;
        this.age = age;
    }*/


    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Player [playerId=" + playerId + ", playerName=" + playerName + ", teamDetails=" + teamList + ", age=" + age
                + "]";
    }

}

package com.runar;

/**
 * Created by rsverrisson on 09-07-2018.
 */
public class Main {

    public static void main(String[] args) {
        League<FootballTeam> premierLeague = new League<>("Premier League");

        FootballTeam manU = new FootballTeam("Manchester United");
        FootballTeam ars = new FootballTeam("Arsenal");
        FootballTeam che = new FootballTeam("Chelsea");
        FootballTeam tott = new FootballTeam("Tottenham");

        premierLeague.addTeam(manU).addTeam(ars).addTeam(che).addTeam(tott);
        manU.addResult(ars, 1, 0);
        che.addResult(tott, 2,2);
        premierLeague.printLeague();
    }
}

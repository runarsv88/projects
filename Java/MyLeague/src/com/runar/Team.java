package com.runar;

/**
 * Created by rsverrisson on 09-07-2018.
 */
public abstract class Team implements Comparable<Team> {
    private String name;
    private int won = 0;
    private int lost = 0;
    private int drawn = 0;

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addResult(Team team, int scored, int conceded) {
        System.out.print(this.getName());
        String message;
        if (scored > conceded) {
            message = " won against ";
            won++;
        } else if (scored == conceded) {
            message = " drew against ";
            drawn++;
        } else {
            message = " lost against ";
            lost++;
        }

        if (team != null) {
            System.out.print(message);
            team.addResult(null, conceded, scored);
        } else {
            System.out.println("");
        }
    }

    public int getPoints() {
        return 3 * won + drawn;
    }

    public int compareTo(Team team) {
        if (getPoints() > team.getPoints()) {
            return 1;
        } else if (getPoints() == team.getPoints()) {
            return 0;
        } else {
            return -1;
        }
    }
}

package com.runar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by rsverrisson on 09-07-2018.
 */
public class League<T extends Team> {
    String name;
    List<T> teams;

    public League(String name) {
        this.name = name;
        this.teams = new ArrayList<T>();
    }

    public League addTeam(T team) {
        teams.add(team);
        return this;
    }

    public void printLeague() {
        System.out.println(name + " rankings:");
        Collections.sort(teams);
        Collections.reverse(teams);
        int counter = 1;
        for (T team : teams) {
            System.out.println(counter + ". " + team.getName() + " with " + team.getPoints() + " points.");
            counter++;
        }
    }

}

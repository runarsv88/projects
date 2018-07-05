package com.runar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rsverrisson on 04-07-2018.
 */
public class Player implements ISaveable {
    private String name;
    private int hp;
    private int strength;
    private String weapon;

    public Player(String name, int hp, int strength, String weapon) {
        this.name = name;
        this.hp = hp;
        this.strength = strength;
        this.weapon = weapon;
    }

    @Override
    public List<String> write() {
        List<String> values = new ArrayList<String>();
        values.add(0, name);
        values.add(1, ""+ hp);
        values.add(2,""+strength);
        values.add(3, weapon);
        return values;
    }

    @Override
    public void read(List<String> values) {
        if (values != null && values.size()>3) {
            name = values.get(0);
            hp = Integer.parseInt(values.get(1));
            strength = Integer.parseInt(values.get(2));
            weapon = values.get(3);
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", strength=" + strength +
                ", weapon='" + weapon + '\'' +
                '}';
    }
}

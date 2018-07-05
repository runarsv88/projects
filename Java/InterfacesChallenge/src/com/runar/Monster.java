package com.runar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rsverrisson on 04-07-2018.
 */
public class Monster implements ISaveable {
    private String type;
    private int hp;
    private int strength;
    private String weapon;

    public Monster(String type, int hp, int strength, String weapon) {
        this.type = type;
        this.hp = hp;
        this.strength = strength;
        this.weapon = weapon;
    }

    @Override
    public List<String> write() {
        List<String> values = new ArrayList<String>();
        values.add(0, type);
        values.add(1, ""+ hp);
        values.add(2,""+strength);
        values.add(3, weapon);
        return values;
    }

    @Override
    public void read(List<String> values) {
        if (values != null && values.size()>3) {
            type = values.get(0);
            hp = Integer.parseInt(values.get(1));
            strength = Integer.parseInt(values.get(2));
            weapon = values.get(3);
        }
    }

    @Override
    public String toString() {
        return "Monster{" +
                "type='" + type + '\'' +
                ", hp=" + hp +
                ", strength=" + strength +
                ", weapon='" + weapon + '\'' +
                '}';
    }
}

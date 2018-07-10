package com.runar.adventure;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rsverrisson on 10-07-2018.
 */
public class Location {
    private String description;
    private Map<Direction, Integer> exits;

    public Location(String description) {
        this.description = description;
        this.exits = new HashMap<>();
        this.exits.put(Direction.QUIT, 0);
    }

    public String getDescription() {
        return description;
    }

    public HashMap<Direction, Integer> getExits() {
        return new HashMap<>(exits);
    }

    public Location addExit(Direction direction, int id) {
        exits.put(direction, id);
        return this;
    }
}

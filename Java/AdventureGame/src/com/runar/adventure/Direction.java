package com.runar.adventure;

import java.util.HashMap;

/**
 * Created by rsverrisson on 10-07-2018.
 */
public enum Direction {
    NORTH,
    SOUTH,
    WEST,
    EAST,
    QUIT;

    public static HashMap<String, Direction> maps = new HashMap<>();
    public static HashMap<String, Direction> getMap() {
        maps.put("north", NORTH);
        maps.put("n", NORTH);
        maps.put("south", SOUTH);
        maps.put("s", SOUTH);
        maps.put("west", WEST);
        maps.put("w", WEST);
        maps.put("east", EAST);
        maps.put("e", EAST);
        maps.put("q", QUIT);
        maps.put("quit", QUIT);
        return maps;
    }
}

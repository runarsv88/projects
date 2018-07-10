package com.runar.adventure;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static com.runar.adventure.Direction.*;

public class Main {

    public static Map<Integer, Location> locations = new HashMap<>();
    public static Location currentLoc;

    public static void main(String[] args) {
        locations.put(0, new Location("Quitting game..."));
        locations.put(1, new Location("House").addExit(NORTH, 2).addExit(SOUTH, 3).addExit(WEST, 4).addExit(EAST, 5));
        locations.put(2, new Location("Hill").addExit(SOUTH, 1));
        locations.put(3, new Location("Lake").addExit(NORTH, 1).addExit(WEST, 4).addExit(EAST, 5));
        locations.put(4, new Location("Town").addExit(NORTH, 2).addExit(SOUTH, 3).addExit(EAST, 1));
        locations.put(5, new Location("Market").addExit(WEST, 1));

        HashMap<String, Direction> maps = Direction.getMap();

        Scanner scanner = new Scanner(System.in);
        currentLoc = locations.get(1);
        Direction direction = NORTH;
        while (direction != QUIT) {
            System.out.println("You are at: " + currentLoc.getDescription());
            System.out.println("Where to move? You can go " + currentLoc.getExits().keySet() + ". Now choose! ");
            String input = scanner.next();
            String[] splitInput = input.split(" ");
            for (String word : splitInput) {
                word = word.toLowerCase();
                if (maps.keySet().contains(word)){
                    direction = maps.get(word);
                    break;
                }
            }
            if (currentLoc.getExits().containsKey(direction)) {
                currentLoc = locations.get(currentLoc.getExits().get(direction));
            } else {
                System.out.println("Cannot move in that direction!");
            }

        }
    }
}

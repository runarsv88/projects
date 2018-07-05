package com.runar;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by rsverrisson on 04-07-2018.
 */
public class main {
    public static void main(String[] args) {
        Player player = new Player("Runar", 100, 25, "Hammer");
        Monster skrimsli = new Monster("Orc", 1000, 213, "Axe");

        player.write();
        ISaveable thisThing = readValues();
        for (String str : thisThing.write()) {
            System.out.println(str);
        }
    }

    private static ISaveable readValues() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What to create?");
        System.out.println("1. Player");
        System.out.println("2. Monster");
        int selection = scanner.nextInt();
        ArrayList<String> values = new ArrayList<>();
        ISaveable fromUser;
        switch (selection) {
            case 1:
                System.out.println("Name: ");
                values.add(scanner.next());
                System.out.println("HP: ");
                values.add(scanner.next());
                System.out.println("Strength: ");
                values.add(scanner.next());
                System.out.println("Weapon: ");
                values.add(scanner.next());
                fromUser = new Player("",1, 1, "");
                fromUser.read(values);
                break;
            case 2:
                System.out.println("Type: ");
                values.add(scanner.next());
                System.out.println("HP: ");
                values.add(scanner.next());
                System.out.println("Strength: ");
                values.add(scanner.next());
                System.out.println("Weapon: ");
                values.add(scanner.next());
                fromUser = new Monster("", 1 , 1, "");
                fromUser.read(values);
                break;
            default :
                System.out.println("Not a valid option, try again");
                return readValues();
        }
       return fromUser;
    }
}

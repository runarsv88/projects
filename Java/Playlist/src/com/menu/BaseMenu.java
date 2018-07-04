package com.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by rsverrisson on 28-06-2018.
 */
public abstract class BaseMenu {

    Scanner scanner;
    List<MenuEntry> menuEntries;

    final String seperator = "###################################";
    final int MAX_WRONG_TRIES = 3;
    int retryCounter = 0 ;
    MenuEntry selectedEntry;

    protected BaseMenu(Scanner scanner) {
        this.scanner = scanner;
        menuEntries = new ArrayList<>();
    }

    public void printMenu() {
        System.out.println(seperator);
        for (int i = 1; i <= menuEntries.size(); i++) {
            System.out.println(i + ". " + menuEntries.get(i-1).toString());
        }
        System.out.println(seperator);
    }

    public void getUserAction() {
        try {
            selectedEntry = menuEntries.get(scanner.nextInt()-1);
        } catch (ArrayIndexOutOfBoundsException e) {
            retryCounter++;
            if (retryCounter > MAX_WRONG_TRIES){
                System.out.println("Maxium number of retries exceeded. Quitting...");
                selectedEntry = MenuEntry.QUIT;
            } else {
                System.out.println("Invalid choice. Try again.");
                getUserAction();
            }
        }
    }

    abstract public void execute();

    public MenuEntry getSelectedEntry() {
        return selectedEntry;
    }
}

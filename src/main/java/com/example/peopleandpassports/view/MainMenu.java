package com.example.peopleandpassports.view;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class MainMenu {
    private static void printMenu(Scanner sc) {
        System.out.println("+--------------------------------+");
        System.out.println("|" + StringUtils.center("AVAILABLE OPTIONS", 32) + "|");
        System.out.println(("|") + ("-".repeat(32)) + ("|"));
        System.out.println("""
                | - ADD PERSON (pe)              |
                | - SEARCH PERSON (spe)          |
                | - LIST OF EVERY PERSON (lpe)   |
                | - DELETE PERSON (dpe)          |
                | - ADD PASSPORT (pa)            |
                | - SEARCH PASSPORT (spa)        |
                | - LIST OF EVERY PASSPORT (lpa) |
                | - DELETE PERSON (dpa)          |
                |                                |
                | - QUIT (q)                     |""");
        System.out.println("+--------------------------------+");
        System.out.println("Option: ");
    }
}

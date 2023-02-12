package com.example.peopleandpassports.view;

import com.example.peopleandpassports.controller.Controller;
import com.example.peopleandpassports.controller.PassportDao;
import com.example.peopleandpassports.model.Passport;
import com.example.peopleandpassports.model.People;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;


@Component
public class Menu {

    private final Scanner sc;
    private final Controller controller;
    private final PassportDao passportDao;

    public Menu(Controller controller,
                PassportDao passportDao) {
        this.controller = controller;
        this.sc = new Scanner(System.in);
        this.passportDao = passportDao;
    }

    private void printMenu() {
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


    @EventListener(ApplicationReadyEvent.class)
    public void mainMenu() {
        try (sc) {
            String s;

            System.out.println("*".repeat(34));
            System.out.println("*" + StringUtils.center("P and P project", 32) + "*");
            System.out.println("*".repeat(34) + "\n");
            this.printMenu();
            while (!(s = sc.nextLine()).equalsIgnoreCase("q")) {
                switch (s.toLowerCase()) {
                    case "pe" -> addPeople();
                    case "spe" -> searchPeople();
                    case "lpe" -> listPeople();
                    case "dpe" -> removePeopleById();
                    case "pa" -> addPassport();
                    case "lpa" -> listPassports();
                    case "q" -> System.exit(0);
                    default -> System.out.println("-UNKNOWN OPTION-\n");
                }
                this.printMenu();
            }
        }
    }

    private void addPeople() {
        People p = new People();
        System.out.println("\n\t Add a new person: ");
        System.out.println("Name: ");
        p.setName(sc.nextLine());
        System.out.println("Date of birth: ");
        p.setDop(sc.nextLine());
        controller.addPeople(p);
    }

    private void listPeople() {
        Iterable<People> allC = controller.getAllPeople();

        printPeople(allC);
    }



    private void removePeopleById() {
        System.out.println("Type in the Id of the person that you would like to remove: ");
        Long id;
        try {
            id = sc.nextLong();
        } catch (InputMismatchException e) {
            System.out.println("There is no matching Id with yours!");
            return;
        }
        controller.removePeopleById(id); // here was a generated deleteById method
    }


    private static void printPeople(Iterable<People> allP) {
        int hasItems = 0;
        People first = null;

        for (People p : allP) {
            if (hasItems == 0) {
                first = p;
            }

            System.out.println(p);
            System.out.println();

            hasItems += 1;
        }

        if (hasItems == 0) {
            System.out.println("* NO RECORDS");
        }
        System.out.println();
    }

        private void searchPeople() {
            System.out.println("Who are you looking for? ");
            String text = sc.nextLine();
            Optional<String> st = Optional.empty();
            if (!text.isEmpty()) {
                st = Optional.of(text);
            }

            printPeople(controller.searchPeople(st));
        }

    private void addPassport() {
        Passport passport = new Passport();
        System.out.println("\n\t Add a new passport: ");
        System.out.println("Passport number: ");
        passport.setPn(sc.nextLine());
        System.out.println("Date of expiry: ");
        passport.setDateOfExpiry(LocalDate.parse(sc.nextLine()));
        System.out.println("Nationality: ");
        passport.setNationality(sc.nextLine());
        System.out.println("Date of birth: ");
        passport.setDateOfBirth(LocalDate
                .parse(sc.nextLine()));
        System.out.println("Type (P): ");
        passport.setType(sc.nextLine());
        System.out.println("ISO3166-1 alpha 2('__'): ");
        passport.setCode(sc.nextLine());
        System.out.println("Sex: ");
        passport.setSex(sc.nextLine());
        System.out.println("Place of birth: ");
        passport.setPlaceOfBrith(sc.nextLine());
        System.out.println("Authority: ");
        passport.setAuthority(sc.nextLine());
        System.out.println("Holders signature: ");
        passport.setHoldersSignature(sc.nextLine());
        passportDao.addPassports(passport);
    }

    private void listPassports() {
        Iterable<Passport> allPassports = passportDao.getAllPassports();

        printPassports(allPassports);
    }

    private void printPassports(Iterable<Passport> allPassports) {
        int hasItems = 0;

        for (Passport passport : allPassports) {

            System.out.println(passport);
            System.out.println();

            hasItems += 1;
        }

        if (hasItems == 0) {
            System.out.println("* NO RECORDS");
        }
        System.out.println();
    }
}
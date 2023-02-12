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
            while (!(s = sc.nextLine()).equalsIgnoreCase("Q")) {
                switch (s.toLowerCase()) {
                    case "pe" -> addPeople();
                    //   case "s" -> searchContacts();
                    case "lpe" -> listContacts();
                    //   case "t" -> deleteContactByID();
                    case "pa" -> addPassport();
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

    // TODO: 2023. 02. 11.
    private void listContacts() {
        Iterable<People> allC = controller.getAllPeople();

        printPeople(allC);
    }


    // TODO: 2023. 02. 11.
        /*
        private void deleteContactByID() {
            System.out.println("Melyik kapcsolatot szeretned torolni, mi az azonositoja: ");
            Long id;
            try {
                id = sc.nextLong();
            } catch (InputMismatchException e) {
                System.out.println("Nem megfelelo azonositot adtal meg");
                return;
            }
            controller.deleteById(id);
        }

         */

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
            System.out.println("** There is no any person yet.");
        }
//        if (hasItems == 1) {
//            printModifyMenu(first);
//        }
        System.out.println();
    }

    // TODO: 2023. 02. 11. write the searchPeople method
      /*
        private void searchContacts() {
            System.out.println("\n\tMit keresunk? ");
            String text = sc.nextLine();
            Optional<String> st = Optional.empty();
            if (!text.isEmpty()) {
                st = Optional.of(text);
            }

            printContacts(controller.searchPeople(st));
        }

       */
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
        passport.setDateOfBirth(LocalDate.parse(sc.nextLine()));
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
}
package com.example.peopleandpassports.view;

import com.example.peopleandpassports.controller.Controller;
import com.example.peopleandpassports.model.People;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


import java.util.Scanner;


    @Component
    public class Menu {

        private final Scanner sc;
        private final Controller controller;

        public Menu(Controller controller) {
            this.controller = controller;
            this.sc = new Scanner(System.in);
        }

        private void printMenu() {
            System.out.println("n - new Person");
          //  System.out.println("s - search Person");
           System.out.println("l - list of people");
         //   System.out.println("t - Kapcsolat törlése");
            System.out.println("q - quit");
        }

        @EventListener(ApplicationReadyEvent.class)
        public void mainMenu() {
            try (sc) {
                System.out.println("*".repeat(30));
                System.out.println("*" + StringUtils.center("P and P project", 28) + "*");
                System.out.println("*".repeat(30) + "\n");

                String s;
                this.printMenu();
                while (!(s = sc.nextLine()).equalsIgnoreCase("q")) {
                    switch (s.toLowerCase()) {
                        case "n" -> addPeople();
                     //   case "s" -> searchContacts();
                        case "l" -> listContacts();
                     //   case "t" -> deleteContactByID();
                        default -> System.out.println("Ilyen menuelem nincs, kerem valasszon ujra.\n");
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
    }



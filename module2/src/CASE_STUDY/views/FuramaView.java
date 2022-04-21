package CASE_STUDY.views;

import CASE_STUDY.controllers.FuramaController;

import java.util.Scanner;

public class FuramaView {
    static Scanner scanner = new Scanner(System.in);
    private static FuramaController furamaController = new FuramaController();
    private static final String[] listMainMenu = {"1. Employee Management", "2. Customer Management",
            "3. Facility Management", "4. Booking Management",
            "5. Promotion Management", "6. Exit"
    };
    private static int choice;

    private static void displayMainMenu() {
        do {
            System.out.println("Furama Resort Management Application");
            for (String li : listMainMenu) {
                System.out.println(li);
            }
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    break;
                default:
                    System.out.println("No choice");

            }
        } while (choice < 1 || choice > 6);
    }

    public static void main(String[] args) {
        displayMainMenu();
    }

}

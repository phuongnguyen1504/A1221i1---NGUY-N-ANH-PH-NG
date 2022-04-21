package CASE_STUDY.views;

import CASE_STUDY.controllers.BookingController;

import java.util.Scanner;

public class BookingView {
    private static BookingController bookingController=new BookingController();
    static Scanner scanner=new Scanner(System.in);
    private static final String[] listBookingFunction={"1. Add new booking","2. Display list booking","3. Create new constracts","4. Display list contracts","5. Edit contracts","6. Return main menu"};
    private static int choice;
    public static void displayMainMenu() {
        do{
            System.out.println("Booking Management Application");
            for (String li:listBookingFunction){
                System.out.println(li);
            }
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    FuramaView.displayMainMenu();
                    break;
                default:
                    System.out.println("No choice");
            }
        }
        while (choice<1||choice>4);
    }
}

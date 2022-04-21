package CASE_STUDY.views;

import CASE_STUDY.controllers.BookingController;
import CASE_STUDY.controllers.PromotionController;

import java.util.Scanner;

public class PromotionView {
    private static PromotionController promotionController=new PromotionController();
    static Scanner scanner=new Scanner(System.in);
    private static final String[] listPromotionFunction={"1. Display list customers use service","2. Display list customers get voucher","3. Return main menu"};
    private static int choice;
    public static void displayMainMenu() {
        do{
            System.out.println("Promotion Management Application");
            for (String li:listPromotionFunction){
                System.out.println(li);
            }
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    FuramaView.displayMainMenu();
                    break;
                default:
                    System.out.println("No choice");
            }
        }
        while (choice<1||choice>4);
    }
}

package EXAM_MODULE2.view;

import EXAM_MODULE2.exception.NotFoundException;
import EXAM_MODULE2.model.Account;
import EXAM_MODULE2.model.PaymentAccount;
import EXAM_MODULE2.model.SavingAccount;
import EXAM_MODULE2.service.BankingService;
import EXAM_MODULE2.util.ConstantUtil;
import EXAM_MODULE2.util.ValidationUtil;

import java.util.List;
import java.util.Scanner;

public class BankingView {
    private static BankingService bankingService = new BankingService();
    private static Scanner sc = new Scanner(System.in);
    private static ValidationUtil validate = new ValidationUtil();

    public static void main(String[] args) {
        displayHomeMenu();
    }

    public static void displayHomeMenu() {
        String tmp = "";
        int choice = 0;
        do {
            System.out.println("----- BANKING ACCOUNT MANAGEMENT APP -----");
            for(String e: ConstantUtil.LIST_MENU){
                System.out.println(e);
            }
            System.out.print(tmp.isEmpty() ? "Input your choice: " : "Please just input number from 1 to 5: ");
            tmp = sc.nextLine();
            if (validate.isNumber(tmp)) choice = Integer.parseInt(tmp);
        }
        while (choice <= 0 || choice > 6);

        switch (choice) {
            case 1:
                create();
                break;
            case 2:
                delete();
                break;
            case 3:
                display();
                break;
            case 4:
                searchByName();
                break;
            case 5:
                System.exit(0);
        }

        displayHomeMenu();
    }

    private static void create() {
        Account account;
        String tmp = "";
        int choice = 0;
        do {
            System.out.println("Choice type of Account to create:");
            for(String e:ConstantUtil.LIST_ACCOUNT){
                System.out.println(e);
            }
            System.out.print(tmp.isEmpty() ? "Input your choice: " : "Please just input number from 1 to 2: ");
            tmp = sc.nextLine();
            if (validate.isNumber(tmp)) choice = Integer.parseInt(tmp);
        }
        while (choice <= 0 || choice > 2);

        System.out.print("1. Account code:");
        String code = inputWithoutEmpty("Account code");
        System.out.print("2. Name:");
        String name = inputWithoutEmpty("Name");
        System.out.print("3. Date create account :");
        String opendate = inputWithoutEmpty("Date create account");
        while (!validate.checkValidDate(opendate)) {
            System.out.print("Invalid date. Try again!");
            opendate = inputWithoutEmpty("Date create account");

        }
        if (choice == 1) {
            System.out.print("4. Amount of Saving:");
            String amount = inputWithoutEmpty("Amount of Saving");
            while (!validate.isDouble(amount)){
                System.out.print("Invalid amount. Try again!");
                amount = inputWithoutEmpty("Amount of Saving");
            }
            System.out.print("5. Date of Saving:");
            String dateSaving = inputWithoutEmpty("Date of Saving");
            while (!validate.checkValidDate(dateSaving)){
                System.out.print("Invalid date. Try again!");
                dateSaving = inputWithoutEmpty("Date of Saving");
            }
            System.out.print("6. Interest rate:");
            String rate = inputWithoutEmpty("Interest rate");
            while (!validate.isDouble(rate)){
                System.out.print("Invalid amount. Try again!");
                rate = inputWithoutEmpty("Interest rate");
            }
            System.out.print("7. Saving term:");
            String term = inputWithoutEmpty("Saving term");
            while (!validate.isNumber(term)){
                System.out.print("Invalid term. Please input number:");
                term = inputWithoutEmpty("Saving term");
            }
            account = new SavingAccount(0, code, name, opendate, Double.parseDouble(amount), dateSaving, Double.parseDouble(rate), Integer.parseInt(term));
        } else {
            System.out.print("4. Card number:");
            String cardNo = inputWithoutEmpty("Card number");
            System.out.print("5. Money in card:");
            String cash = inputWithoutEmpty("Money in card");
            while (!validate.isDouble(cash)){
                System.out.print("Invalid amount. Try again!");
                cash = inputWithoutEmpty("Money in card");
            }
            account = new PaymentAccount(0, code, name, opendate, cardNo, Double.parseDouble(cash));
        }
        bankingService.create(account);
        System.out.println("Created successfully");
    }


    private static String inputWithoutEmpty(String fieldName){
        String result;
        do{
            result = sc.nextLine();
            System.out.print(result.isEmpty() ? fieldName.toUpperCase() + " cannot empty. Input again:" : "");
        }
        while (result.isEmpty());

        return result;
    }

    private static void display() {
        List<Account> accounts = bankingService.findAll();
        display(accounts);
    }

    private static void display(List<Account> accounts) {
        if (accounts.size() > 0) {
            System.out.printf("%-20s%-5s%-12s%-20s%-15s%-12s%-12s%-15s%-10s%s","Name of Account","ID","Code","Name","Open Date","CardNumber","Amount","Date Saving","Rate","Term");
            System.out.println();
            for (Account p : accounts) {
                if (p instanceof PaymentAccount) {

                    System.out.printf("%-20s%-5s%-12s%-20s%-15s%-12s%-12s%-15s%-10s%s\n","Payment Account"
                            , p.getId(), p.getCode(), p.getName(), p.getDateOpen(), ((PaymentAccount) p).getCardNumber(), ((PaymentAccount) p).getCash(),"-","-","-");

                } else {
                    System.out.printf("%-20s%-5s%-12s%-20s%-15s%-12s%-12s%-15s%-10s%s\n","Saving Account"
                            , p.getId(), p.getCode(), p.getName(), p.getDateOpen(),"-", ((SavingAccount) p).getAmount(), ((SavingAccount) p).getDateSaving(),
                            ((SavingAccount) p).getRate(), ((SavingAccount) p).getTerm());

                }
            }
            /*for (Account p : accounts) {
                if (p instanceof PaymentAccount) {
                    System.out.printf("Payment account: id = %s, name = %s, price = %s, manufacturer=%s, granteeByYear=%s\n"
                            , p.getId(), p.getCode(), p.getName(), p.getDateOpen(), ((PaymentAccount) p).getCardNumber(), ((PaymentAccount) p).getCash());
                } else {
                    System.out.printf("Hand Product: id = %s, name = %s, price = %s, manufacturer=%s, country=%s, status=%s\n"
                            , p.getId(), p.getCode(), p.getName(), p.getDateOpen(), ((SavingAccount) p).getAmount(), ((SavingAccount) p).getDateSaving(),
                            ((SavingAccount) p).getRate(), ((SavingAccount) p).getTerm());
                }
            }*/
        } else {
            System.out.println("Account List is empty");
        }
    }

    private static void delete(){
        display();
        /*List<Account> accounts = bankingService.findAll();
        String input;
        int id;
        do{
            System.out.print("Enter id to delete:");
            input = sc.nextLine();
            while (!validate.isNumber(input)){
                System.out.print("Please just input number:");
                input = sc.nextLine();
            }
            id=Integer.parseInt(input);
            try{

                new CheckId(id,accounts);
            } catch (NotFoundException e) {
                System.out.println(e.getMessage());
            }

        }
        while (!validate.isExistsId(id,accounts));
        bankingService.delete(id);*/
        System.out.print("Enter id to delete:");

        boolean isExist;
        do{
            try{
                String id=inputWithoutEmpty("ID");
                while (!validate.isNumber(id)){
                    System.out.print("Invalid id. Try again!");
                    id=inputWithoutEmpty("ID");
                }
                bankingService.delete(Integer.parseInt(id));
                System.out.println("Deleted successfully");
                isExist = false;
            }
            catch( NotFoundException e){
                System.out.print(e.getMessage() + "Please input again:");
                isExist = true;
            }
        }while(isExist);

    }
    private static void searchByName(){
        System.out.print("Enter name to search:");
        boolean isExist;
        do{
            try{
                String name = inputWithoutEmpty("Name");
                List<Account> accounts = bankingService.searchByName(name);
                display(accounts);
                isExist = false;
            }
            catch( NotFoundException e){
                System.out.print(e.getMessage() + "Please input again:");
                isExist = true;
            }
        }while(isExist);

    }

    /*private static void backToHomeMenu() {
        System.out.print("Do you back to main menu (Y/N): ");
        if (CommonUtil.getScanner().nextLine().equalsIgnoreCase("y")) displayHomeMenu();
        else System.exit(0);
    }*/
}


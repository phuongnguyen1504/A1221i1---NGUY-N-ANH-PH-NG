package EXAM_MODULE2.view;

import EXAM_MODULE2.exception.NotFoundException;
import EXAM_MODULE2.model.Product;
import EXAM_MODULE2.model.ImportProduct;
import EXAM_MODULE2.model.ExportProduct;
import EXAM_MODULE2.service.ProductService;
import EXAM_MODULE2.util.ConstantUtil;
import EXAM_MODULE2.util.ValidationUtil;

import java.util.List;
import java.util.Scanner;

public class ProductView {
    private static ProductService bankingService = new ProductService();
    private static Scanner sc = new Scanner(System.in);
    private static ValidationUtil validate = new ValidationUtil();

    public static void main(String[] args) {
        displayHomeMenu();
    }

    public static void displayHomeMenu() {
        String tmp = "";
        int choice = 0;
        do {
            System.out.println("----- PRODUCT MANAGEMENT APP -----");
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
                search();
                break;
            case 5:
                System.exit(0);
        }

        displayHomeMenu();
    }

    private static void create() {
        Product product;
        String tmp = "";
        int choice = 0;
        do {
            System.out.println("Choice type of Product to create:");
            for(String e:ConstantUtil.LIST_PRODUCT){
                System.out.println(e);
            }
            System.out.print(tmp.isEmpty() ? "Input your choice: " : "Please just input number from 1 to 2: ");
            tmp = sc.nextLine();
            if (validate.isNumber(tmp)) choice = Integer.parseInt(tmp);
        }
        while (choice <= 0 || choice > 2);

        System.out.print("1. Product code:");
        String code = inputWithoutEmpty("Product code");
        System.out.print("2. Name Product:");
        String name = inputWithoutEmpty("Name Product");
        System.out.print("3. Product Price :");
        String price = inputWithoutEmpty("Product Price");
        while (!validate.isDouble(price)) {
            System.out.print("Invalid price. Try again!:");
            price = inputWithoutEmpty("Product Price");
        }
        System.out.print("4. Quantity :");
        String quantity = inputWithoutEmpty("Quantity");
        while (!validate.isNumber(price)) {
            System.out.print("Invalid quantity. Try again!:");
            quantity = inputWithoutEmpty("Quantity");
        }
        System.out.print("5. Name Of Manufacturer :");
        String nameFacturer = inputWithoutEmpty("Name Of Manufacturer");
        if (choice == 1) {
            System.out.print("6. Import Price:");
            String importPrice = inputWithoutEmpty("Import Price");
            while (!validate.isDouble(importPrice)){
                System.out.print("Invalid Import Price. Try again!:");
                importPrice = inputWithoutEmpty("Import Price");
            }
            System.out.print("7. Import Country:");
            String importCountry = inputWithoutEmpty("Import Country");
            System.out.print("8. Import Tax:");
            String importTax= inputWithoutEmpty("Import Tax");
            while (!validate.isDouble(importTax)){
                System.out.print("Invalid Import Tax. Try again!:");
                importTax = inputWithoutEmpty("Import Tax");
            }

            product = new ImportProduct(0, code,name,Double.parseDouble(price),Integer.parseInt(quantity),nameFacturer,Double.parseDouble(importPrice),importCountry,Double.parseDouble(importTax));
        } else {
            System.out.print("6. Export Price:");
            String exportPrice = inputWithoutEmpty("Export Price");
            while (!validate.isDouble(exportPrice)){
                System.out.print("Invalid Export Price. Try again!:");
                exportPrice = inputWithoutEmpty("Export Price");
            }
            System.out.print("7. Export Country:");
            String exportCountry = inputWithoutEmpty("Export Country");
            product = new ExportProduct(0, code, name, Double.parseDouble(price),Integer.parseInt(quantity),nameFacturer,Double.parseDouble(exportPrice),exportCountry);
        }
        bankingService.create(product);
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
        List<Product> accounts = bankingService.findAll();
        display(accounts);
    }

    private static void display(List<Product> accounts) {
        if (accounts.size() > 0) {
            System.out.printf("%-17s%-5s%-12s%-20s%-15s%-12s%-15s%-15s%-15s%-15s%s","Name of Product","ID","Code","Name","Price","Quantity","Manufacturer","Import Price","Export Price","Country","Import Tax");
            System.out.println();
            for (Product p : accounts) {
                if (p instanceof ImportProduct) {

                    System.out.printf("%-17s%-5s%-12s%-20s%-15s%-12s%-15s%-15s%-15s%-15s%s\n","Import Product"
                            , p.getId(), p.getCode(), p.getName(), p.getPrice(), p.getQuantity(),p.getManufacture(), ((ImportProduct) p).getImportPrice(),"-",((ImportProduct) p).getCountry(),((ImportProduct) p).getImportTax());

                } else {
                    System.out.printf("%-17s%-5s%-12s%-20s%-15s%-12s%-15s%-15s%-15s%-15s%s\n","Export Product"
                            , p.getId(), p.getCode(), p.getName(), p.getPrice(), p.getQuantity(),p.getManufacture(),"-",((ExportProduct) p).getExportPrice(), ((ExportProduct) p).getCountry(),"-");

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
    private static void search(){
        String tmp = "";
        int choice = 0;
        do {
            System.out.println("Choice type to search:");
            for(String e:ConstantUtil.LIST_SEARCH){
                System.out.println(e);
            }
            System.out.print(tmp.isEmpty() ? "Input your choice: " : "Please just input number from 1 to 2: ");
            tmp = sc.nextLine();
            if (validate.isNumber(tmp)) choice = Integer.parseInt(tmp);
        }
        while (choice <= 0 || choice > 2);
        switch (choice){
            case 1:
                searchByID();
                break;
            case 2:
                searchByName();
                break;
        }
    }

    private static void searchByID() {
        System.out.print("Enter id to search:");
        boolean isExist;
        do {
            try {
                String id=inputWithoutEmpty("ID");
                while (!validate.isNumber(id)){
                    System.out.print("Invalid id. Try again!");
                    id=inputWithoutEmpty("ID");
                }
                List<Product> accounts = bankingService.searchByID(Integer.parseInt(id));
                display(accounts);
                isExist = false;
            } catch (NotFoundException e) {
                System.out.print(e.getMessage() + "Please input again:");
                isExist = true;
            }
        } while (isExist);
    }

    private static void searchByName() {
        System.out.print("Enter name to search:");
        boolean isExist;
        do {
            try {
                String name = inputWithoutEmpty("Name");
                List<Product> accounts = bankingService.searchByName(name);
                display(accounts);
                isExist = false;
            } catch (NotFoundException e) {
                System.out.print(e.getMessage() + "Please input again:");
                isExist = true;
            }
        } while (isExist);
    }

    /*private static void backToHomeMenu() {
        System.out.print("Do you back to main menu (Y/N): ");
        if (CommonUtil.getScanner().nextLine().equalsIgnoreCase("y")) displayHomeMenu();
        else System.exit(0);
    }*/
}


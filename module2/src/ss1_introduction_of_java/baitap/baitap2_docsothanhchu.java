package ss1_introduction_of_java.baitap;

import java.util.Scanner;

public class baitap2_docsothanhchu {
    public static void main(String[] args) {
        System.out.println("Enter number:");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (number >= 0 && number < 10) {
            switch (number) {
                case 1:
                    System.out.println("one");
                    break;
                case 2:
                    System.out.println("two");
                    break;
                case 3:
                    System.out.println("three");
                    break;
                case 4:
                    System.out.println("four");
                    break;
                case 5:
                    System.out.println("five");
                    break;
                case 6:
                    System.out.println("six");
                    break;
                case 7:
                    System.out.println("seven");
                    break;
                case 8:
                    System.out.println("eight");
                    break;
                case 9:
                    System.out.println("nine");
                    break;
                default:
                    System.out.println("out of ability");
            }
        } else if (number < 20) {
            int donvi = number % 10;
            switch (donvi) {
                case 0:
                    System.out.println("ten");
                    break;
                case 1:
                    System.out.println("eleven");
                    break;
                case 2:
                    System.out.println("twelve");
                    break;
                case 3:
                    System.out.println("thirteen");
                    break;
                case 4:
                    System.out.println("fourteen");
                    break;
                case 5:
                    System.out.println("fifteen");
                    break;
                case 6:
                    System.out.println("sixteen");
                    break;
                case 7:
                    System.out.println("seventeen");
                    break;
                case 8:
                    System.out.println("eighteen");
                    break;
                case 9:
                    System.out.println("nineteen");
                    break;
            }
        } else if (number < 100) {
            int chuc = number / 10;
            int donvi = number % 10;
            String result = "";
            switch (chuc) {
                case 2:
                    result += "twenty ";
                    break;
                case 3:
                    result += "thirty ";
                    break;
                case 4:
                    result += "fourty ";
                    break;
                case 5:
                    result += "fifty ";
                    break;
                case 6:
                    result += "sixty ";
                    break;
                case 7:
                    result += "seventy ";
                    break;
                case 8:
                    result += "eighty ";
                    break;
                case 9:
                    result += "ninety ";
            }
            switch (donvi) {
                case 1:
                    result += "one";
                    break;
                case 2:
                    result += "two";
                    break;
                case 3:
                    result += "three";
                    break;
                case 4:
                    result += "four";
                    break;
                case 5:
                    result += "five";
                    break;
                case 6:
                    result += "six";
                    break;
                case 7:
                    result += "seven";
                    break;
                case 8:
                    result += "eight";
                    break;
                case 9:
                    result += "nine";
                    break;
            }
            System.out.println(result);
        }
        else if(number<1000){
            int tram=number/100;
            int chuc=(number%100)/10;
            int donvi=(number%100)%10;
            String result="";
            switch (tram){
                case 1:
                    result+="one hundred ";
                    break;
                case 2:
                    result+="two hundred ";
                    break;
                case 3:
                    result+="three hundred ";
                    break;
                case 4:
                    result+="four hundred ";
                    break;
                case 5:
                    result+="five hundred ";
                    break;
                case 6:
                    result+="six hundred ";
                    break;
                case 7:
                    result+="seven hundred ";
                    break;
                case 8:
                    result+="eight hundred ";
                    break;
                case 9:
                    result+="nine hundred ";
                    break;
            }
            switch (chuc) {
                case 2:
                    result += "and twenty ";
                    break;
                case 3:
                    result += "and thirty ";
                    break;
                case 4:
                    result += "and fourty ";
                    break;
                case 5:
                    result += "and fifty ";
                    break;
                case 6:
                    result += "and sixty ";
                    break;
                case 7:
                    result += "and seventy ";
                    break;
                case 8:
                    result += "and eighty ";
                    break;
                case 9:
                    result += "and ninety ";
            }
            switch (donvi) {
                case 1:
                    result += "one";
                    break;
                case 2:
                    result += "two";
                    break;
                case 3:
                    result += "three";
                    break;
                case 4:
                    result += "four";
                    break;
                case 5:
                    result += "five";
                    break;
                case 6:
                    result += "six";
                    break;
                case 7:
                    result += "seven";
                    break;
                case 8:
                    result += "eight";
                    break;
                case 9:
                    result += "nine";
                    break;
            }
            System.out.println(result);
        }
    }
}

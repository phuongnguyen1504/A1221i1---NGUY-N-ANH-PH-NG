package CASE_STUDY.views;

import CASE_STUDY.controllers.BookingController;
import CASE_STUDY.repository.impl.CustomerRepository;
import CASE_STUDY.repository.impl.FacilityRepository;

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
            choice= Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    //CustomerRepository.displayBooking();
                    int index=inputIndexOfCustomer();
                    FacilityRepository.displayBooking();
                    int select=0;
                    do{
                        try{
                            System.out.println("Bạn muốn đặt phòng nào. 1. House, 2. Room, 3.Villa");
                            select= Integer.parseInt(scanner.nextLine());
                            switch (select){
                                case 1:
                                    System.out.println("Bạn đặt căn House. Nhập số phòng muốn chọn");
                                    break;
                                case 2:
                                    System.out.println("Bạn đặt căn Room. Nhập số phòng muốn chọn");
                                    break;
                                case 3:
                                    System.out.println("Bạn đặt căn Villa. Nhập số phòng muốn chọn");
                                    break;
                                default:
                                    System.out.println("Bạn nhập không đúng rồi. Chọn từ 1 đến 3");
                            }
                        }
                        catch (Exception e){
                            System.out.println("Bạn nhập sai rồi. Nhập lại");
                        }
                    }
                    while (select>3);
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

    private static int inputIndexOfCustomer() {
        int index;
        do{
            System.out.println("Mời bạn nhập mã khách hàng");
            try{
                String id= scanner.nextLine();
                index=CustomerRepository.checkId(id);
                if(index!=-1){
                    break;
                }
                else {
                    System.out.println("Không tìm thấy mã khách hàng. Yêu cầu nhập lại");
                }
            }
            catch (Exception e){
                System.out.println("Nhập vào không hợp lệ");
            }

        }
        while (true);
        return index;
    }
}

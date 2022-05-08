package bai_tap_may_tinh.service.impl;


import bai_tap_may_tinh.model.Authentic;
import bai_tap_may_tinh.repository.ProductRepository;
import bai_tap_may_tinh.repository.impl.ProductRepositoryImpl;
import bai_tap_may_tinh.service.ProductService;
import bai_tap_may_tinh.utils.CheckId;
import bai_tap_may_tinh.utils.NotFoundProductException;
import bai_tap_may_tinh.view.ProductView;

import java.util.List;
import java.util.Scanner;

import static bai_tap_may_tinh.utils.Validate.getSize;
import static bai_tap_may_tinh.utils.Validate.isExistsId;

public class ProductServiceImpl implements ProductService {
    private static Scanner sc=new Scanner(System.in);
    private static int choice;
    private static final String[] listChoice={"1. Xóa hàng chính hãng","2. Xóa hàng xách tay","3. Xóa cả 2","4. Về màn hình chỉnh"};
    private static ProductView productView=new ProductView();
    ProductRepository productRepository=new ProductRepositoryImpl();
    @Override
    public void add(String name) {
        String[] list=new String[4];
        System.out.print("Mời nhập tên sản phẩm:");
        list[0]= sc.nextLine();
        System.out.print("Mời nhập giá sản phẩm:");
        list[1]= sc.nextLine();
        System.out.print("Mời nhập tên nhà sản xuất:");
        list[2]= sc.nextLine();
        if(name.equals("CHINHHANG")){
            System.out.print("Mời nhập thời gian bảo hành");
            list[3]= sc.nextLine();
            String value=new Authentic(String.valueOf(getSize("CHINHHANG")+1),list[0],list[1],list[2],list[3]).toString();
            productRepository.add(value,"CHINHHANG");

        }
        else if(name.equals("XACHTAY")){
            System.out.print("Mời nhập quốc gia xách tay:");
            list[3]=sc.nextLine();
            String value=new Authentic(String.valueOf(getSize("XACHTAY")+1),list[0],list[1],list[2],list[3]).toString();
            productRepository.add(value,"XACHTAY");
        }


    }

    @Override
    public List<String> getAll(String name) {
        return productRepository.getAll(name);
    }

    @Override
    public void display() {
        productRepository.displayProduct();
    }

    @Override
    public void delete() {
        String id="";
        do {
            System.out.println("Mời bạn nhập id cần xóa:");
            id= sc.nextLine();
            if (id.equals("")) {
                System.out.println("Quay về màn hình chính!");
                productView.displayMenu();
            }
            try {
                new CheckId(id);
                if(isExistsId(id,"CHINHHANG")&&isExistsId(id,"XACHTAY")){
                    System.out.println("Tìm thấy id ở hàng chính hãng và xách tay!. Bạn muốn xóa ?");
                    for (String li:listChoice){
                        System.out.println(li);
                    }
                    choice= Integer.parseInt(sc.nextLine());
                    switch (choice){
                        case 1:
                            productRepository.delete(id,"CHINHHANG");
                            productView.displayMenu();
                        case 2:
                            productRepository.delete(id,"XACHTAY");
                            productView.displayMenu();
                        case 3:
                            productRepository.delete(id,"CHINHHANG");
                            productRepository.delete(id,"XACHTAY");
                            productView.displayMenu();
                        case 4:
                            productView.displayMenu();
                    }
                }
                if(isExistsId(id,"CHINHHANG")){
                    System.out.println("Tìm thấy id ở hàng chính hãng!. Bạn muốn xóa không. Điền Có hoặc không");
                    confirmDelete(id,"CHINHHANG");

                }
                if(isExistsId(id,"XACHTAY")){
                    System.out.println("Tìm thấy id ở hàng xách tay!. Bạn muốn xóa không. Điền Có hoặc không");
                    confirmDelete(id,"XACHTAY");
                }

            } catch (NotFoundProductException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    private void confirmDelete(String id,String name) {
        if (sc.nextLine().equals("Có")||sc.nextLine().equals("có")){
            productRepository.delete(id,name);
        }
        else {
            productView.displayMenu();
        }
    }

}

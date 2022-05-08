package bai_tap_may_tinh.repository.impl;

import bai_tap_may_tinh.model.Authentic;
import bai_tap_may_tinh.repository.ProductRepository;
import bai_tap_may_tinh.utils.ConstantUtils;
import bai_tap_may_tinh.utils.IOFile;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    private static IOFile ioFile=new IOFile();
    private static List<String> listProduct=new ArrayList<>();
    private static List<String> listAfterDel=new ArrayList<>();
    public List<String> getAll(String name){
        List<String> list;
        list=ioFile.read(ConstantUtils.PATH.getPATH(name));
        return list;
    }

    @Override
    public void add(String value, String PATH) {
        ioFile.write(value,ConstantUtils.PATH.getPATH(PATH),true);
        System.out.println("Đã thêm sản phẩm");
    }
    public void displayProduct(){
        listProduct= ioFile.read(ConstantUtils.PATH.CHINHHANG);
        displayAuthentic(listProduct);
        listProduct= ioFile.read(ConstantUtils.PATH.XACHTAY);
        displayHandGoods(listProduct);
    }

    @Override
    public void delete(String id, String name) {
        listProduct= getAll(name);
        for (String li:listProduct){
            if (!li.split(",")[0].equals(id)){
                listAfterDel.add(li);
            }
        }
        ioFile.write(listAfterDel,ConstantUtils.PATH.getPATH(name));
        listAfterDel.clear();
    }

    private void displayHandGoods(List<String> listProduct) {
        System.out.println("Danh sách hàng xách tay");
        int i=1;
        System.out.printf("%-7s%-10s%-20s%-12s%-20s%s", "STT","ID","Tên sản phẩm","Giá","Nhà sản xuất","Quốc gia xách tay\n");
        for (String li : listProduct) {
            String[] temp=li.split(",");
            System.out.printf("");
            System.out.printf("%-7s%-10s%-20s%-12s%-20s%s", (i),temp[0],temp[1],temp[2],temp[3],temp[4]);
            System.out.println();
            i++;
        }
    }

    private void displayAuthentic(List<String> listProduct) {
        System.out.println("Danh sách hàng chính hãng");
        int i=1;
        System.out.printf("%-7s%-10s%-20s%-12s%-20s%s", "STT","ID","Tên sản phẩm","Giá","Nhà sản xuất","Thời gian bảo hành\n");
        for (String li : listProduct) {
            String[] temp=li.split(",");
            System.out.printf("");
            System.out.printf("%-7s%-10s%-20s%-12s%-20s%s", (i),temp[0],temp[1],temp[2],temp[3],temp[4]);
            System.out.println();
            i++;
        }
    }

}

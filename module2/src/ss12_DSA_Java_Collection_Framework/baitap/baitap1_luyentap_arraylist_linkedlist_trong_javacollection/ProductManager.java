package ss12_DSA_Java_Collection_Framework.baitap.baitap1_luyentap_arraylist_linkedlist_trong_javacollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductManager {
    private static List<Product> listProduct=new ArrayList<>();

    public ProductManager(ArrayList listProduct) {
        this.listProduct = listProduct;
    }

    public ProductManager() {
    }

    public static List<Product> getListProduct() {
        return listProduct;
    }

    public static void setListProduct(List<Product> listProduct) {
        ProductManager.listProduct = listProduct;
    }

    public void add(Product product){
        listProduct.add(product);
    }
    public void replace(int id,Product product){
        int index=-1;
        for (int i=0;i< listProduct.size();i++){
            if (listProduct.get(i).getId()==(id)){
                index=i;
                break;
            }
        }
        if (index!=-1){
            listProduct.add(index,product);
            listProduct.remove(index+1);
        }
    }
    public void delete(int id){
        int index=-1;
        for (int i=0;i< listProduct.size();i++){
            Product search= listProduct.get(i);
            if (search.getId()==(id)){
                index=i;
                break;
            }
        }
        if (index!=-1){
            listProduct.remove(index);
        }
    }
    public void displayProduct(){
        System.out.printf("%-12s%-12s%-12s%s","STT", "Id","Name","Price\n");
        for (int i=0;i< listProduct.size();i++){
            Product search= (Product) listProduct.get(i);
            System.out.printf("%-12s%-12s%-12s%s",(i+1),search.getId(),search.getNameProduct(),search.getPrice());
            System.out.println();
        }
    }
    public void findProductByName(String name){
        int index=-1;
        for (int i=0;i< listProduct.size();i++){
            Product search= listProduct.get(i);
            if (search.getNameProduct().equals(name)){
                index=i;
                break;
            }
        }
        if(index!=-1){
            System.out.println("Thông tin sản phẩm cần tìm:");
            System.out.printf("%-12s%-15s%s","Id","Name Product","Price\n");
            System.out.printf("%-12s%-15s%s",listProduct.get(index).getId(),listProduct.get(index).getNameProduct(),listProduct.get(index).getPrice());
            System.out.println();
        }
        else {
            System.out.println("Không có sản phẩm trong kho!");
        }
    }
    public void sort(int value){
        PriceComparator priceComparator=new PriceComparator();
        if (value==1){
            Collections.sort(listProduct,priceComparator);
        }
        else if (value==2){
            Collections.sort(listProduct,priceComparator.reversed());
        }
        System.out.println("List Product after sort");
        displayProduct();
    }
}

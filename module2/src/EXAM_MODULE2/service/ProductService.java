package EXAM_MODULE2.service;

import EXAM_MODULE2.exception.NotFoundException;
import EXAM_MODULE2.model.Product;
import EXAM_MODULE2.model.ImportProduct;
import EXAM_MODULE2.model.ExportProduct;
import EXAM_MODULE2.util.ConstantUtil;
import EXAM_MODULE2.util.FileHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static EXAM_MODULE2.view.ProductView.displayHomeMenu;

public class ProductService {
    private List<Product> products;
    private FileHelper fileHelper = new FileHelper();
    private static Scanner sc=new Scanner(System.in);
    public ProductService(){
        products =mapToAccount();
    }

    public void create(Product product) {
        //region get lastId
        int lastId = 0;
        if(products.size() > 0){
            lastId = products.get(products.size() - 1).getId();
        }
        //endregion

        product.setId(lastId + 1);
        products.add(product);
        fileHelper.write(ConstantUtil.path, Collections.singletonList(product), true);
    }
    private List mapToAccount() {
        List result = new ArrayList();

        List<String> lines = fileHelper.read(ConstantUtil.path);
        for (String line : lines){
            String[] tmp = line.split(",");
            int id = Integer.parseInt(tmp[0]);
            String code = tmp[1];
            String name=tmp[2];
            Double price=Double.parseDouble(tmp[3]);
            int quantity=Integer.parseInt(tmp[4]);
            String manufacture=tmp[5];

            if(tmp.length == 8){
                Double exportPrice = Double.parseDouble(tmp[6]);
                String country = tmp[7];
                result.add(new ExportProduct(id,code,name,price,quantity,manufacture,exportPrice,country));
            }
            else {
                Double importPrice=Double.parseDouble(tmp[6]);
                String country=tmp[7];
                Double importTax = Double.parseDouble(tmp[8]);
                result.add(new ImportProduct(id,code,name,price,quantity,manufacture,importPrice,country,importTax));
            }
        }

        return result;
    }

    public List<Product> findAll() {
        return products;
    }

    public void delete(int id) throws NotFoundException {
        /*for (int i = 0; i < accounts.size(); i++) {
            if(accounts.get(i).getId() == id){
                accounts.remove(i);
                fileHelper.write(ConstantUtil.path, accounts, false);
                return;
            }
        }*/
        /*if(!products.removeIf(e-> e.getId() == id)){
            throw new NotFoundException("ID " + id + " cound not found. ");
        }*/
        if (products.stream().anyMatch(e->e.getId()==id)){
            System.out.print("Do you want to delete (Y/N): ");
            if (sc.nextLine().equalsIgnoreCase("y")) {
                products.removeIf(e-> e.getId() == id);
            }
            else {
                displayHomeMenu();
            };
        }
        else {
            throw new NotFoundException("ID " + id + " cound not found. ");
        }
        fileHelper.write(ConstantUtil.path, products, false);
    }

    public List <Product> searchByName(String name) throws NotFoundException{
        List <Product> result = new ArrayList();
        if(!products.stream().anyMatch(e->e.getName().contains(name))){
            throw new NotFoundException("Name: " + name + " cound not found. ");
        }
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getName().contains(name)){
                result.add(products.get(i));
            }
        }

        return result;
    }

    public List<Product> searchByID(int id) throws NotFoundException{
        List <Product> result = new ArrayList();
        if(!products.stream().anyMatch(e->e.getId()==id)){
            throw new NotFoundException("ID: " + id + " cound not found. ");
        }
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getId()==id){
                result.add(products.get(i));
            }
        }

        return result;
    }
}

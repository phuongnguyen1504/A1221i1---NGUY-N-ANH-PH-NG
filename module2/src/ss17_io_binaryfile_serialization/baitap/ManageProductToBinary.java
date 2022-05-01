package ss17_io_binaryfile_serialization.baitap;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ManageProductToBinary {
    private static final String path="src/ss17_io_binaryfile_serialization/baitap/product.txt";

    public static void main(String[] args) {
        Product product=new Product(1, "iPhone","Apple", 1999,"ABC");
        //tạo field và dùng getClass trả về tên class đó và getDeclaredFields là trả về các trường k bao gồm trường kế thừa
        //phương thức getName() ở đây là phương thức lấy tên các trường trong class đó
        /*Field[] f=product.getClass().getDeclaredFields();
        for (int i = 0; i < f.length; i++) {
            System.out.println(f[i].getName());
        }*/
        try{
            addProductToBinary(new Product(3,"new","new",1234,"BCD"));
            readProductFromBinary();
            System.out.println(searchProductByName("iPhone"));
            System.out.println(searchProductByName("X"));
            System.out.println(searchProductByName("Apple"));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static void addProductToBinary(Product product) throws IOException {
        if (!Files.exists(Paths.get(path))){
            Files.createFile(Paths.get(path));
        }
        ProductDAO dao=ProductDAO.getInstance();
        dao.add(product);
        FileOutputStream fileOutputStream=new FileOutputStream(path);
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(dao.listAll());
        objectOutputStream.close();
    }
    private static void readProductFromBinary() throws IOException,ClassNotFoundException {
        FileInputStream fis=new FileInputStream(path);
        ObjectInputStream ois=new ObjectInputStream(fis);
        List<Product> li= (List<Product>) ois.readObject();
        li.stream().forEach(product -> {
            System.out.println(product.getName());
        });
    }
    private static boolean searchProductByName(String name){
        ProductDAO dao=ProductDAO.getInstance();
        return dao.searchByName(name);
    }
}
class Product implements Serializable{
    private int id;
    private String name;
    private String brand;
    private int price;
    private String describe;

    public Product() {
    }

    public Product(int id, String name, String brand, int price, String describe) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.describe = describe;
    }

    public Product(int id) {
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
class ProductDAO {
    private static ProductDAO instance;
    private static List<Product> data=new ArrayList<>();
    static {
        data.add(new Product(1, "iPhone X","Apple", 999,"Mô tả"));
        data.add(new Product(2, "XBOX 360", "Microsoft",400,"Diễn tả"));
    }

    public static ProductDAO getInstance() {
        if (instance==null){
            instance=new ProductDAO();
        }
        return instance;
    }

    public static void setInstance(ProductDAO instance) {
        ProductDAO.instance = instance;
    }

    public ProductDAO() {
    }
    public List<Product> listAll() {
        return new ArrayList<Product>(data);
    }
    public int add(Product product){
        int newId= data.size()+1;
        product.setId(newId);
        data.add(product);
        return newId;
    }
    public Product get(int id){
        Product productFind=new Product(id);
        int index=data.indexOf(productFind);
        if (index>=0){
            return data.get(index);
        }
        return null;
    }
    public boolean searchByName(String name){
        return data.stream().anyMatch(p -> p.getName().contains(name));
    }
    public boolean delete(int id){
        Product productFind=new Product(id);
        int index=data.indexOf(productFind);
        if(index>=0){
            data.remove(index);
            return true;
        }
        return false;
    }
    public boolean update(Product product){
        int index=data.indexOf(product);
        if (index>=0){
            data.set(index,product);
            return true;
        }
        return false;
    }
}

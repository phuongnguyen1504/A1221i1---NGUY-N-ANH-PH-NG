package ss12_DSA_Java_Collection_Framework.baitap.baitap1_luyentap_arraylist_linkedlist_trong_javacollection;

import java.util.Comparator;

public class PriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        if (o1.getPrice()>o2.getPrice()){
            return 1;
        }
        else if (o1.getPrice()==o2.getPrice()){
            return 0;
        }
        else {
            return -1;
        }
    }

    @Override
    public Comparator<Product> reversed() {
        return Comparator.super.reversed();
    }
}

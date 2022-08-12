package com.book.model;


import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Integer, Book> books = new HashMap<>();

    public Cart(Map<Integer, Book> books) {
        this.books = books;
    }

    public Cart() {
    }

    public Map<Integer, Book> getBooks() {
        return books;
    }

    public void setBooks(Map<Integer, Book> books) {
        this.books = books;
    }

    private int checkDuplicateValue() {
        int code = (int) Math.floor(((Math.random() * 89999) + 10000));
        for (Map.Entry<Integer, Book> entry : books.entrySet()) {
            if (entry.getKey().equals(code)) {
                checkDuplicateValue();
            }
        }
        return code;
    }

    private Book selectItemInCart(Book book) {
        if (book.getQuantity() > 0) {
            return book;
        }
        return null;
    }

    public void addBook(Book book) {
        if (selectItemInCart(book) != null) {
            books.put(checkDuplicateValue(),book);
        }
    }
    public boolean backBook(int code){
        for (Map.Entry<Integer,Book> entry:books.entrySet()){
            if (entry.getKey().equals(code)){
                books.remove(code);
                return true;
            }
        }
        return false;
    }
}

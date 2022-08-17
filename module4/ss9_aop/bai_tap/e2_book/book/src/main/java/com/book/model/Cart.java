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

    public Book getBookObject(int code) {
        for (Map.Entry<Integer, Book> entry : books.entrySet()) {
            if (entry.getKey().equals(code)) {
                return entry.getValue();
            }
        }
        return null;
    }


    public void addBook(Book book) {
//        if (selectItemInCart(book) != null) {
//            books.put(checkDuplicateValue(),book);
//        }
            int code=-1;
            int nextSize=books.size()+1;
            while (books.size()<nextSize){
                code=(int) Math.floor(((Math.random() * 89999) + 10000));
                books.put(code,book);
            }
    }
    public void backBook(int code){
        for (Map.Entry<Integer,Book> entry:books.entrySet()){
            if (entry.getKey().equals(code)){
                books.remove(code);
                break;
            }
        }
    }
}

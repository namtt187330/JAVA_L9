/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.util.ArrayList;
import model.DTO.Book;

/**
 *
 * @author nam57
 */
public class DAO {

    ArrayList<Book> library = new ArrayList<>();

    public DAO() {
        Book defaultBook = new Book("Book A", 1000);
        library.add(defaultBook);
    }

    

    public String getData() {
        return "HelloWorld";
    }

     //To change body of generated methods, choose Tools | Templates.

    

    public ArrayList<Book> getAllBooks() {
        return library;
    }

    public boolean addBooks(Book book) {
        
        try {
            library.add(book);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isExistBook(String nameOfBook) {
        for (int i = 0; i < library.size(); i++) {
            if (library.get(i).getName().equals(nameOfBook)) {
                return true;
            }
        }
        return false;
    }
    public int deleteBook(String nameBook) {
        Book book = new Book();
        boolean isBookExist = false;
        for (int i = 0; i < library.size(); i++) {
            if (library.get(i).getName().equals(nameBook)) {
                book = library.get(i);
                isBookExist = true;
            }
        }
        if (isBookExist) {
            boolean response = library.remove(book);
            if (response) {
                return 1;
            } else {
                return -1;
            }
        } else {
            return 0;
        }
    }
    public boolean updateBook(String oldBookName, Book newBook) {
        int indexOfBook = -1;
        for (int i = 0; i < library.size(); i++) {
            if (library.get(i).toString().equals(oldBookName)) {
                indexOfBook = i;
            }
        }
        if (indexOfBook == -1) {
            return false;
        } else {
            library.set(indexOfBook, newBook);
            return true;
        }

    }
}

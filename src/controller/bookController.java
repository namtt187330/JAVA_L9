/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.DAO.DAO;
import model.DTO.Book;

/**
 *
 * @author nam57
 */
public class bookController {

    DAO bookDAO = new DAO();
    Book book = new Book();
    

    public String helloWorld() {
        return bookDAO.getData();
    }

    public ArrayList<Book> getAllBooks(){
        return bookDAO.getAllBooks();
    }
    public boolean addBooks(Book book){
        return bookDAO.addBooks(book);
    }
    public int deleteValue(String nameBook){
        return bookDAO.deleteBook(nameBook);
    }
    public boolean updateBook(String oldBookName,Book newbook){
        return bookDAO.updateBook(oldBookName, newbook);
    }
    public boolean isExistBook(String nameOfBook){
        return bookDAO.isExistBook(nameOfBook);
    }

}

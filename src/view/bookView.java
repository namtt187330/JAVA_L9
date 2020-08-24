/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.bookController;
import java.util.ArrayList;
import java.util.Scanner;
import model.DTO.Book;

/**
 *
 * @author nam57
 */
public class bookView {

    bookController bookController = new bookController();
//    public void execute(){
//        System.out.println(bookController.helloWorld());
//    }

    public void execute() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1.Show");
            System.out.println("2.Add");
            System.out.println("3.Delete");
            System.out.println("4.Update");
            System.out.println("0.Exit");
            int inputUser = sc.nextInt();
            sc.nextLine();
            switch (inputUser) {
                case 1:
                    ArrayList<Book> allBooks = bookController.getAllBooks();
                    for (int i = 0; i < allBooks.size(); i++) {
                        System.out.println(allBooks.get(i).toString());
                    }
                    break;
                case 2:
                    System.out.println("Name:");
                    String name = sc.nextLine();
                    System.out.println("Price:");
                    int price = sc.nextInt();
                    sc.nextLine();

                    Book book = new Book(name, price);
                    boolean check = bookController.addBooks(book);
                    if (check) {
                        System.out.println("Done");
                    } else {
                        System.out.println("Fail");
                    }
                    break;
                case 3:
                    System.out.println("Nhap vao ten sach muon xoa:");
                    String nameBook = sc.nextLine();
                    int deleteValue = bookController.deleteValue(nameBook);
                    switch (deleteValue) {
                        case 1:
                            System.out.println("Done");
                        case -1:
                            System.out.println("Fail");
                        case 0:
                            System.out.println("Null");
                    }
                    break;
                case 4:
                    System.out.println("Nhap ten sach muon cap nhat:");
                    String bookUpdateName = sc.nextLine();
                    if (bookController.isExistBook(bookUpdateName)) {
                        System.out.println("Name:");
                        String newName = sc.nextLine();
                        System.out.println("Price:");
                        int newPrice = sc.nextInt();
                        sc.nextLine();
                        Book newBook = new Book(newName, newPrice);
                        bookController.updateBook(newName, newBook);

                    } else {
                        System.out.println("Khong tim thay sach!!!");
                    }
                    break;

            }
            //To change body of generated methods, choose Tools | Templates.
        }
    }
}

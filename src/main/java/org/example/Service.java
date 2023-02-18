package org.example;

import java.util.ArrayList;
import java.util.List;

// this is the book service implementation class
public class Service implements ServiceInterface {
    public static final String RED="\u001B[31m";
    public static final String RESET="\u001B[0m";
    public static final String GREEN="\u001B[32m";
    public static final String CYAN="\u001B[36m";
    LibraryValidator libraryValidator = new LibraryValidator();
    List<SingelBook> singelBooks = new ArrayList<>();

    @Override
    public void addBook() {// the logic of adding book
        String book_id = libraryValidator.validateId();
        String Author = libraryValidator.validateAuthorTitle("Author");
        String Title = libraryValidator.validateAuthorTitle("Title");
        String year = libraryValidator.validatePublishYear();
        SingelBook singelBook = new SingelBook(book_id, Author, Title, year, "Available");
        singelBooks.add(singelBook);
        System.out.println(GREEN+"Book Added Successfully!" + RESET);
    }

    @Override
    public void showAllBooks() {  // the logic of showing all books.
        boolean flag=false;
        System.out.println("\n----------------------------------------------------------------------------------------------");
        System.out.format(CYAN+"%s%15s%15s%15s%15s","| ID","| TITLE","| AUTHOR","| PUBLISH YEAR","| STATUS"+RESET);
        System.out.println("\n----------------------------------------------------------------------------------------------");

        for (SingelBook singelBook : singelBooks){
            System.out.format("%s%15s%15s%15s%15s", singelBook.getId(), singelBook.getTitle(), singelBook.getAuthor(), singelBook.getPublished_Year(), singelBook.getStatus());
            System.out.println();
            flag=true;
        }
        System.out.println("\n----------------------------------------------------------------------------------------------");
        if(flag==false)
            System.out.println(RED+"There are no Books in Library"+RESET);
    }
    @Override
    public void showAllAvailableBooks() {
        boolean flag=false;
        System.out.println("\n----------------------------------------------------------------------------------------------");
        System.out.format(CYAN+"%s%15s%15s%15s%15s","| ID","| TITLE","| AUTHOR","| PUBLISH YEAR","| STATUS"+RESET);
        System.out.println("\n----------------------------------------------------------------------------------------------");

        if(singelBooks.size()>0){
            for (SingelBook singelBook : singelBooks){
                if(singelBook.getStatus()=="Available"){ // if books are available then shown these books only
                    System.out.format("%s%15s%15s%15s%15s", singelBook.getId(), singelBook.getTitle(), singelBook.getAuthor(), singelBook.getPublished_Year(), singelBook.getStatus());
                    System.out.println();
                    flag=true;
                }
            }
        }
        else{
            System.out.println(RED+"No Books Available in the library"+RESET);
        }
        System.out.println("\n----------------------------------------------------------------------------------------------");
        if(flag==false)
            System.out.println(RED+"There are no books with status Available"+RESET);

    }

    @Override
    public void borrowBook() {
        String book_id = libraryValidator.validateId();
        boolean flag = false;
        for (SingelBook singelBook : singelBooks){ // I should check, Entered book id is AVAILABLE in the library or not
            if (singelBook.getId().equals(book_id) && singelBook.getStatus().equals("Available")){
                flag=true;
                System.out.println(GREEN+"Book Borrowed Successfully!!! " + RESET);
                singelBook.setStatus("Not Available");
                System.out.println("Borrowed Book Details: "+ singelBook);
            }
        }
        if (flag == false){
            System.out.println(RED+"This book is not available to borrow"+RESET);
        }
    }

    @Override
    public void returnBook() {
        boolean flag=false;
        String book_id= libraryValidator.validateId();
        for(SingelBook singelBook : singelBooks){
            if(singelBook.getId().equals(book_id) && singelBook.getStatus().equals("Not Available")){
                flag=true;
                System.out.println(GREEN+"Book Returned Successfully !!!"+RESET);
                singelBook.setStatus("Available");
                System.out.println("Returned Book Details: "+ singelBook);
            }
        }
        if(flag==false){
            System.out.println(RED + "We can not return this book" + RESET);
        }
    }
}


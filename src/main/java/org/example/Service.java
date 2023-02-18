package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class Service implements ServiceInterface {
    public static final String RED="\u001B[91m";
    public static final String RESET="\u001B[0m";
    public static final String GREEN="\u001B[92m";
    public static final String CYAN="\u001B[96m";
    LibraryValidator libraryValidator = new LibraryValidator();
    List<SingleBook> singleBooks = new ArrayList<>();

    @Override
    public void addBook() {
        Set<String> usedIds = singleBooks.stream()
                .map(SingleBook::getId)
                .collect(Collectors.toSet());
        String book_id = libraryValidator.validateId(usedIds);
        String author = libraryValidator.validateAuthorTitle("Author");
        String title = libraryValidator.validateAuthorTitle("Title");
        String year = libraryValidator.validatePublishYear();
        SingleBook singleBook = new SingleBook(book_id, author, title, year, "Available");
        singleBooks.add(singleBook);
        System.out.println(GREEN + "Book added successfully!" + RESET);
    }

    @Override
    public void showAllBooks() {
        boolean flag=false;
        System.out.println("\n----------------------------------------------------------------------------------------------");
        System.out.format(CYAN+"%s%20s%20s%20s%20s","| ID","| TITLE","| AUTHOR","| PUBLISH YEAR","| STATUS"+RESET);
        System.out.println("\n----------------------------------------------------------------------------------------------");

        for (SingleBook singleBook : singleBooks){
            System.out.format("%s%20s%20s%20s%20s", singleBook.getId(), singleBook.getTitle(), singleBook.getAuthor(), singleBook.getPublished_Year(), singleBook.getStatus());
            System.out.println();
            flag=true;
        }
        System.out.println("\n----------------------------------------------------------------------------------------------");
        if(flag==false)
            System.out.println(RED+"There are no Books in Library :("+RESET);
    }
    @Override
    public void showAllAvailableBooks() {
        boolean flag=false;
        System.out.println("\n----------------------------------------------------------------------------------------------");
        System.out.format(CYAN+"%s%20s%20s%20s%20s","| ID","| TITLE","| AUTHOR","| PUBLISH YEAR","| STATUS"+RESET);
        System.out.println("\n----------------------------------------------------------------------------------------------");

        if(singleBooks.size()>0){
            for (SingleBook singleBook : singleBooks){
                if(singleBook.getStatus()=="Available"){
                    System.out.format("%s%20s%20s%20s%20s", singleBook.getId(), singleBook.getTitle(), singleBook.getAuthor(), singleBook.getPublished_Year(), singleBook.getStatus());
                    System.out.println();
                    flag=true;
                }
            }
        }
        else{
            System.out.println(RED+"No Books Available in the library, Sorry for that :("+RESET);
        }
        System.out.println("\n----------------------------------------------------------------------------------------------");
        if(flag==false)
            System.out.println(RED+"There are no books with status Available"+RESET);

    }

    @Override
    public void borrowBook() {
        Set<String> usedIds = new HashSet<>();
        String book_id = libraryValidator.validateId(usedIds);
        boolean flag = false;
        for (SingleBook singleBook : singleBooks){
            if (singleBook.getId().equals(book_id) && singleBook.getStatus().equals("Available")){
                flag=true;
                System.out.println(GREEN+"Book Borrowed Successfully!!! " + RESET);
                singleBook.setStatus("Not Available!!!");
                System.out.println("Borrowed Book Details: "+ singleBook);
            }
        }
        if (flag == false){
            System.out.println(RED+"This book is not available to borrow! :("+RESET);
        }
    }

    @Override
    public void returnBook() {
        boolean flag=false;
        Set<String> usedIds = new HashSet<>();
        String book_id= libraryValidator.validateId(usedIds);
        for(SingleBook singleBook : singleBooks){
            if(singleBook.getId().equals(book_id) && singleBook.getStatus().equals("Not Available")){
                flag=true;
                System.out.println(GREEN+"Book Returned Successfully !!!"+RESET);
                singleBook.setStatus("Available");
                System.out.println("Returned Book Details: "+ singleBook);
            }
        }
        if(flag==false){
            System.out.println(RED + "We can not return this book" + RESET);
        }
    }
}


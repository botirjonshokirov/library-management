package org.example;

import java.util.Scanner;
import java.util.regex.Pattern;

public class LibraryValidator {
    public static final String RED="\u001B[31m";
    public static final String RESET="\u001B[0m";
    private static Pattern PATTERN_ID = Pattern.compile("^\\d{1,4}$");
    private static Pattern Pattern_AuthorTitle=Pattern.compile("^[a-zA-Z ]+$");
    private static Pattern Pattern_PublishedYear=Pattern.compile("^\\d{4}$");
    Scanner sc = new Scanner(System.in);

    public String validateId(){
        String book_id;
        while (true){
            System.out.println("Enter Book ID: ");
            book_id = sc.nextLine();
            if (!PATTERN_ID.matcher(book_id).matches()){
                System.out.println(RED+"SORRY ! PLEASE ENTER VALID BOOK ID !!! "+RESET);
            }else {
                break;
            }
        }
        return book_id;
    }

    public String validateAuthorTitle(String input){
        String result;
        while (true){
            if(input=="Title"){
                System.out.println("Enter Title: ");
            }else{
                System.out.println("Enter Author: ");
            }
            result=sc.nextLine();
            if(!Pattern_AuthorTitle.matcher(result).matches()){
                System.out.println(RED+"Please Enter Valid "+input+RESET);
            }
            else{
                break;
            }
        }
        return result;
    }

    public String validatePublishYear(){
        String year;
        while(true){
            System.out.println("Enter Published Year of the Book: ");
            year=sc.nextLine();
            if(!Pattern_PublishedYear.matcher(year).matches()){
                System.out.println(RED+"Enter valid Published Year"+RESET);
            }
            else{
                break;
            }
        }
        return year;
    }
}

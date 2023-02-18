package org.example;

import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class LibraryValidator {
    public static final String RED="\u001B[31m";
    public static final String RESET="\u001B[0m";
    private static Pattern PATTERN_ID = Pattern.compile("^\\d{1,4}$");
    private static Pattern Pattern_AuthorTitle=Pattern.compile("^[a-zA-Z ]+$");
    private static Pattern Pattern_PublishedYear=Pattern.compile("^\\d{4}$");
    Scanner sc = new Scanner(System.in);

    public String validateId(Set<String> usedIds){
        String book_id;
        while (true){
            System.out.println("Enter Book ID: ");
            book_id = sc.nextLine();
            if (!PATTERN_ID.matcher(book_id).matches()){
                System.out.println(RED+"SORRY ! PLEASE ENTER VALID BOOK ID !!! "+RESET);
            }else if (usedIds.contains(book_id)) {
                System.out.println(RED+"SORRY ! BOOK ID ALREADY EXISTS !!! "+RESET);
            } else {
                usedIds.add(book_id);
                break;
            }
        }
        return book_id;
    }

    public String validateAuthorTitle(String input) {
        String result;
        String prompt = input.equals("Title") ? "Enter Title: " : "Enter Author: ";
        while (true) {
            System.out.println(prompt);
            result = sc.nextLine();
            if (!Pattern_AuthorTitle.matcher(result).matches()) {
                System.out.println(RED + "The input you provided is invalid. Please enter a valid choice " + input + RESET);
            } else {
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
                System.out.println(RED+"The input you provided is invalid. Please enter a valid Published Year"+RESET);
            }
            else{
                break;
            }
        }
        return year;
    }
}

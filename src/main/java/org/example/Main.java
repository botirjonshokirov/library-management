package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ServiceInterface service = new Service();


        do{
            System.out.println("Greetings and welcome to the Book Management Application!\n"
);
            System.out.println("The following options are available in this program: \n");
            System.out.println(
                    "1. Add a book (If no books exist, choose this option)\n" +
                    "2. Show all books\n"+
                    "3. Show available books\n" +
                    "4. Borrow a book\n" +
                    "5. Return a book\n" +
                    "6. Exit or quit the program.\n"
            );

            System.out.println("Enter Your Choice! ");
            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    service.addBook();
                    break;
                case 2:
                    service.showAllBooks();
                    break;
                case 3:
                    service.showAllAvailableBooks();
                    break;
                case 4:
                    service.borrowBook();
                    break;
                case 5:
                    service.returnBook();
                    break;
                case 6:
                    System.out.println("We appreciate your use of our library and thank you for using our services.");
                    System.out.println("Creator: Botirjon Shokirov");
                    System.exit(0);
                    break;
                default:
                    System.out.println("The input you provided is invalid. Please enter a valid choice!!!");
            }
        }
        while (true);
    }
}

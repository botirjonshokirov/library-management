package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ServiceInterface service = new Service();


        do{
            System.out.println("Welcome to Book Management Application!");
            System.out.println(
                    "1. Add Book\n" +
                    "2. Show all Books\n"+
                    "3. Show Available Books\n" +
                    "4. Borrow Book\n" +
                    "5. Return Book\n" +
                    "6. Exit\n"
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
                    System.out.println("Thank you for using Our Library!!!");
                    System.out.println("Creator: Botirjon Shokirov");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please Enter Valid Choice!!!");
            }
        }
        while (true);
    }
}

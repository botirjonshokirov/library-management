# library-management

![picture alt](https://github.com/botirjonshokirov/library-management/blob/main/src/test-images/app.png)

## Main

Main class of the book management application.

It presents a menu to the user and gets their choice. Based on their choice, it calls the corresponding method of the `Service` class which implements the `ServiceInterface` interface.

The do-while loop ensures that the user can keep using the application until they choose to exit. The Scanner class is used to get input from the user.

Overall, the main class provides a simple and easy-to-use interface for managing a library of books.

## ServiceInterface

The class has implemented all the methods of the `ServiceInterface` interface, including adding a book to the library, showing `all` books in the library, showing only `available` books, `borrowing` a book from the library, and `returning` a book to the library.

###

The class uses an `ArrayList` to store the book details and provides a command-line interface to interact with the library.

It also uses the `LibraryValidator` class to validate user input.

In addition, the class uses some `ANSI` escape codes to display colored output in the console.

It defines four static final strings `RED`, `RESET`, `GREEN`, and `CYAN` to format the console output.

## Service

`Service` which implements the interface `ServiceInterface`.
The class has the following properties and methods:

- `RED`, `RESET`, `GREEN`, and `CYAN` are constants defined as strings with `ANSI` color codes, used for console output formatting.

- `libraryValidator` is an instance of the LibraryValidator class used to validate book details.
- `singleBooks` is an instance of the List class used to store instances of SingleBook objects.
- `addBook()` method allows the user to add a new book to the `singleBooks` list. It prompts the user to input the book's details and validates them using the LibraryValidator object, creates a new `SingleBook` object with the given details and adds it to the list. It prints a message to the console to indicate that the book has been successfully added.
- `showAllBooks()` method prints all the books in the `singleBooks` list to the console. It uses a loop to iterate through the list, formatting and printing each book's details in a table-like format. If the list is empty, it prints a message to the console to indicate that there are no books in the library.
- `showAllAvailableBooks()` method prints all the available books in the `singleBooks` list to the console. It uses a loop to iterate through the list, checks the status of each book, and prints only the `available books'` details in a table-like format. If no books are available, it prints a message to the console to indicate that there are no available books.
- `borrowBook()` method allows the user to borrow a book from the `singleBooks` list. It prompts the user to input the `book ID`, checks if the book is available in the list, and changes the book's status to `Not Available`. It then prints a message to the console to indicate that the book has been successfully borrowed and displays the book's details. If the book is not available, it prints a message to the console to indicate that the book cannot be borrowed.
- `returnBook()` method allows the user to return a borrowed book to the `singleBooks` list. It prompts the user to input the `book ID`, checks if the book is borrowed and changes its status back to `Available`. It then prints a message to the console to indicate that the book has been successfully returned and displays the book's details. If the book cannot be returned, it prints a message to the console to indicate that the book cannot be returned.

## Book

`Book` which has `five` private fields: `id`, `title`, `author`, `published_Year`, and `status`.

It provides two constructors for creating instances of this class - a default constructor and a parameter-based constructor.

Overall, this code provides a simple model for representing a book with its relevant details. It follows good `OOP` principles of encapsulation and abstraction by using private fields and providing `getter` and `setter` methods to access them.

## Useful

- Code will checks ids existance

here is first book:

![picture alt](https://github.com/botirjonshokirov/library-management/blob/main/src/test-images/first-book.png)

and here we are creating a book with the same ID:

![picture alt](https://github.com/botirjonshokirov/library-management/blob/main/src/test-images/id-exist.png)

## Conclusion

This library management application have `basic functionality` and could be `useful` for small libraries or personal book collections.

## Creator

Botirjon Shokirov

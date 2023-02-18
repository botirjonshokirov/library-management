# library-management

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


## Book

`Book` which has `five` private fields: `id`, `title`, `author`, `published_Year`, and `status`. 

It provides two constructors for creating instances of this class - a default constructor and a parameter-based constructor.

Overall, this code provides a simple model for representing a book with its relevant details. It follows good `OOP` principles of encapsulation and abstraction by using private fields and providing `getter` and `setter` methods to access them. 

### Conclusion

This library management application seems to have `basic functionality` and could be `useful` for small libraries or personal book collections.


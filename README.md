# Cinema Room Manager

This project is a simple console application in Java for managing seats in a cinema hall. It allows the user to define the layout of the hall, reserve seats, and view basic sales statistics. The project was created to practice the fundamentals of object-oriented programming (OOP) in Java.

## Technologies Used

* **Java**

## Features

The application offers the following features:

1.  **Displaying the Hall Layout:** After entering the desired number of rows and seats in each row, the current layout of the hall is displayed. The first row indicates the column numbers, and each subsequent row indicates the row number. Free seats are marked with the letter "S".

    Example for 4 rows and 4 seats:
    ```
      1 2 3 4
    1 S S S S
    2 S S S S
    3 S S S S
    4 S S S S
    ```

2.  **Buying a Ticket:** The user can enter the row number and seat number they wish to purchase.
    * **Ticket Price:**
        * If the total number of seats in the hall is less than 60, the price of each ticket is $10.
        * If the total number of seats is 60 or more, tickets in the first half of the rows cost $10, and tickets in the second half of the rows cost $8.
    * If the selected seat is already reserved, the user is notified.
    * The application validates user inputs to prevent entering non-existent row or seat numbers, or non-numeric/negative values.

3.  **Displaying Statistics:** The following information is displayed:
    * The number of purchased tickets.
    * The percentage of purchased tickets relative to the total number of seats.
    * The current income from purchased tickets.
    * The potential total income if all tickets were sold.

4.  **Exiting:** Terminates the manager application.

## Project Structure

The project is divided into three main classes:

* **`Cinema`:** The main class of the application. It contains a `Scanner` object for user input, a `UserUI` object, and starts the interaction with the user by calling the `userUI.start()` method.
* **`SeatLayout`:** This class manages the layout of the seats in the cinema hall. Its main tasks are:
    * Creating a 2D array representing the hall.
    * Displaying the current layout of the hall.
    * Updating the layout after a ticket is purchased (changing "S" to "B" if the seat is available).
* **`UserUI`:** This class is responsible for the user interface and managing the application flow.
    * Displays the menu of options to the user.
    * Accepts and validates all user inputs (number of rows, seats, menu selection, row and seat number for ticket purchase).
    * Contains an object of the `SeatLayout` class and calls its methods to manipulate the hall layout.
    * Implements the logic for calculating ticket prices and displaying statistics.
    * Includes mechanisms for handling exceptions to prevent the program from crashing due to invalid user input.

## How to Run

1.  Ensure that you have the Java Development Kit (JDK) installed on your system.
2.  Compile the Java source files. Assuming the main class is `Cinema.java`, you can use the command:
    ```
    javac Cinema.java SeatLayout.java UserUI.java
    ```
3.  Run the application using the command:
    ```
    java Cinema
    ```

## Learned Concepts

During the development of this project, I acquired and deepened my knowledge in the following areas:

* Working with class methods.
* Creating objects of one class within another class and calling their methods.
* Validating user input to ensure the correct functionality of the application.
* Working with two-dimensional arrays (2D arrays) to represent data.
* Managing and handling exceptions for a more robust program.
* Principles of object-oriented programming (OOP).

This project successfully passed all tests on the Hyperskill platform and was completed in its current form.

/*
    Class taking care of user UI. It stores all the variables needed for
    cinema seat layout creator and all methods needed to display, purchase seats
 */


package cinema;

import java.util.Scanner;

public class UserUI {
    private Scanner sc;
    private int numOfRows;
    private int numOfSeatsInRow;
    private int rowNumberOfChosenSeat;
    private int seatNumberOfChosenSeat;
    private int totalSeats;
    private int ticketPrice;
    private int totalPrice;
    private int purchasedTickets;
    private int currentIncome;
    private SeatLayout seatLayout;

    public UserUI(Scanner sc) {
        this.sc = sc;
        this.numOfRows = 0;
        this.numOfSeatsInRow = 0;
        this.totalSeats = 0;
        this.ticketPrice = 0;
        this.totalPrice = 0;
        this.rowNumberOfChosenSeat = 0;
        this.seatNumberOfChosenSeat = 0;
        this.purchasedTickets = 0;
        this.currentIncome = 0;
        this.seatLayout = new SeatLayout();
    }

    public void start() {
        setNumberOfRows();
        setNumberOfSeatsInRow();
        setSeatLayout();

        while (true) {
            int menuChoice = printMenu();
            if (menuChoice == 0) {
                break;
            }
            if (menuChoice == 1) {
                printSeats();
            }
            if (menuChoice == 2) {

                updateSeatLayout();
                countTicketPrice();
            }

            if (menuChoice == 3) {
                statistics();
            }
        }
    }


    // printing seats layout

    public void printSeats() {
        System.out.println("Cinema: ");
        this.seatLayout.printLayout();
    }


    //set number of rows for layout

    public void setNumberOfRows() {
        this.numOfRows = validateNumericInput("Enter the number of rows:", 1, 20);
    }

    // set number of seats in rows for layout

    public void setNumberOfSeatsInRow() {
        this.numOfSeatsInRow = validateNumericInput("Enter the number of seats in each row:", 1, 20);
    }

    // set row number of chosen seat

    public void setRowNumberOfChosenSeat() {
        System.out.println();
        this.rowNumberOfChosenSeat = validateNumericInput("Enter a row number:", 1, this.numOfRows);
    }

    // set seat number of chosen seat

    public void setSeatNumberOfChosenSeat() {
        this.seatNumberOfChosenSeat = validateNumericInput("Enter a seat number in that row:", 1, this.numOfSeatsInRow);
    }

    // creating new seatLayout

    public void setSeatLayout() {
        this.seatLayout.setLayout(new String[this.numOfRows + 1][this.numOfSeatsInRow + 1]);
        this.seatLayout.createLayoutArr();
    }

    // updating seat layout based on user input of row and number of seat in that row that
    // he wants to buy and checking if that set is available or has been already purchased

    public void updateSeatLayout() {

        while (true) {
            setRowNumberOfChosenSeat();
            setSeatNumberOfChosenSeat();
            if (this.seatLayout.checkAndUpdateSeatsLayout(this.rowNumberOfChosenSeat, this.seatNumberOfChosenSeat)) {
                this.purchasedTickets += 1;
                break;
            } else {
                System.out.println();
                System.out.println("That ticket has already been purchased!");
            }
        }
    }

    // counting the price of ticket based on position
    // in small cinema (less than 60 seats) ticket price is $10
    // in larger cinema first half of rows costs $10 per seat second half costs 8$ per seat

    public void countTicketPrice() {
        this.totalSeats = this.numOfSeatsInRow * this.numOfRows;
        if (this.totalSeats < 60) {
            this.ticketPrice = 10;
            System.out.printf("%nTicket price: $%d%n", this.ticketPrice);
            System.out.println();
        } else {
            this.ticketPrice = (this.rowNumberOfChosenSeat <= (numOfRows / 2)
                    ? 10 : 8);
            System.out.printf("%nTicket price: $%d%n", this.ticketPrice);
            System.out.println();
        }
        this.currentIncome += ticketPrice;
    }

    // calculating total possible income based on size of cinema


    public int countTotalIncome() {
        this.totalSeats = this.numOfSeatsInRow * this.numOfRows;
        if (this.totalSeats < 60) {
            this.totalPrice = 10 * this.totalSeats;
        } else {
            this.totalPrice = (this.numOfRows / 2) * this.numOfSeatsInRow * 10
                    + (this.numOfRows - this.numOfRows / 2) * this.numOfSeatsInRow * 8;
        }
        return  totalPrice;
    }

    // menu for choosing action return the value of chosen action
    // check validity of that value before returning it

    public int printMenu() {
        System.out.print("\n1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit");
        return validateNumericInput("", 0, 4);
    }

    // validating user inputs, @min included, @max excluded

    public int validateNumericInput(String firstLine, int min, int max) {
        int numToValidate = 0;
        String errorMessage = "Wrong input!";
        while (true) {
            System.out.println(firstLine);
            try {
                numToValidate = Integer.parseInt(sc.nextLine());
                if (numToValidate < min || numToValidate > max) {
                    System.out.println(errorMessage);
                } else {
                    break;
                }

            } catch (Exception e) {
                System.out.println(errorMessage);
            }
        }
        return numToValidate;
    }


    // count percentage of already sold tickets

    public double purchasedTicketsPercentage() {
        return this.purchasedTickets == 0
                ? 0
                : 100.0 / this.totalSeats * purchasedTickets;
    }

    // printing statistics of cinema

    public void statistics() {
        System.out.printf("%nNumber of purchased tickets: %d%n", this.purchasedTickets);

        System.out.printf("Percentage: %.2f%%%n", purchasedTicketsPercentage());

        System.out.printf("Current income: $%d%n", this.currentIncome);

        System.out.printf("Total income: $%d%n", this.countTotalIncome());
        System.out.println();
    }
}


/**
 The Driver class represents the main program that handles interactions with the user.
 It displays a menu of options to the user and processes their input to perform various actions.
 */
package q1;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    private ArrayList<Product> products;
    private CashRegister register;

    /**
     * Constructor that initializes the list of available products and the cash
     * register with starting cash of $100.
     */
    public Driver() {
        // Initialize products
        products = new ArrayList<>();
        products.add(new Product("Milk", 2.99));
        products.add(new Product("Bread", 1.99));
        products.add(new Product("Eggs", 0.99));

        // Initialize cash register with $100 starting cash
        register = new CashRegister(100.0);
    }

    /**
     * Prints out the currently available products in the store.
     */
    public void printProducts() {
        System.out.print("Currently available in-store:\n");
        for (int i = 0; i < products.size(); i++) {
            System.out
                    .println("#" + (i + 1) + " | " + products.get(i).getLabel() + " - $" + products.get(i).getPrice());
        }
    }

    /*
     * This method executes the code
     */
    public void run() {
        // Create a scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Main loop
        while (true) {
            // Print menu options
            System.out.println("1. Add product to bill");
            System.out.println("2. Get bill total");
            System.out.println("3. Receive payment");
            System.out.println("4. Get current cash in register");
            System.out.println("5. Get amount of items in bill");
            System.out.println("6. Exit");

            // Read user input
            int choice = scanner.nextInt();

            // Process user input
            switch (choice) {
                case 1:
                    printProducts();
                    System.out.println("Enter product number (1-3): ");
                    int productNumber = scanner.nextInt();
                    if (productNumber >= 1 && productNumber <= products.size()) {
                        System.out.println("Enter quantity: ");
                        int quantity = scanner.nextInt();
                        Product product = products.get(productNumber - 1);
                        register.addProductToBill(product, quantity);// Add product to bill
                    } else {
                        System.out.println("Invalid product number!");
                    }
                    break;
                case 2:
                    // Get bill total
                    System.out.println(register.getBill());
                    break;
                case 3:
                    // Receive payment
                    double payment = 0;
                    if (register.getAmountOfItems() == 0) {// no items
                        System.out.println("You have no items in cart.");
                    } else {
                        System.out.println("Your total bill is:\n" + register.getBill());
                        while (payment <= register.getTotalBill()) { // checks if amount of money is enough
                            System.out.println("Enter payment amount: ");
                            payment = scanner.nextDouble();
                            if (payment <= register.getTotalBill()) {
                                double missingCash = register.getTotalBill() - payment;
                                System.out.println("Insufficient amount of money, " + missingCash + "$ is missing.");
                            }
                        }
                        register.receivePayment(payment);
                        System.out.println("Your change is: " + register.getChange());
                    }
                    break;
                case 4:
                    // Get current cash in register
                    System.out.println("Current cash in register: " + register.getCurrentCashInRegister());
                    break;
                case 5:
                    // Get amount of items in bill
                    System.out.println("Amount of items: " + register.getAmountOfItems());
                    break;
                case 6:
                    // Exit program
                    return;
                default:
                    // Invalid input
                    System.out.println("Invalid choice!");
            }
        }
    }
}

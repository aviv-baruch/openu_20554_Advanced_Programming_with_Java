// The following code defines a CashRegister class that allows adding products to a bill, receiving payments and calculating change, and keeping track of the total amount of cash in the register.

package q1;

import java.util.ArrayList;

public class CashRegister {
    // Declare instance variables
    private double currentCashInRegister;
    private double totalBill;
    private double change;
    private ArrayList<ChargeLine> chargeLines;

    // Constructor for creating an empty register
    public CashRegister() {
        this.currentCashInRegister = 0.0;
        this.totalBill = 0.0;
        this.change = 0.0;
        this.chargeLines = new ArrayList<ChargeLine>();
    }

    // Constructor for creating a CashRegister object with a predefined amount of
    // cash
    public CashRegister(double startingAmountOfCash) {
        this.currentCashInRegister = startingAmountOfCash;
        this.totalBill = 0.0;
        this.change = 0.0;
        this.chargeLines = new ArrayList<ChargeLine>();
    }

    // Method for adding a product to the bill
    public void addProductToBill(Product product, int amount) {
        ChargeLine chargeLine = new ChargeLine(product, amount);
        this.chargeLines.add(chargeLine);
        this.totalBill += chargeLine.getTotalPrice();
    }

    // Method for generating a bill
    public String getBill() {
        StringBuilder bill = new StringBuilder("Product\tAmount\tPrice\n");

        for (ChargeLine chargeLine : chargeLines) {
            bill.append(chargeLine.getProduct().getLabel()).append("\t");
            bill.append(chargeLine.getAmount()).append("\t");
            bill.append(chargeLine.getTotalPrice()).append("\n");
        }

        bill.append("\nTotal bill: ").append(getTotalBill());
        bill.append("\n-------------------------\n");
        return bill.toString();
    }

    // Getter method for the total bill
    public double getTotalBill() {
        return this.totalBill;
    }

    // Method for receiving payment and calculating change
    public void receivePayment(double payment) {
        this.change = payment - this.totalBill;
        this.currentCashInRegister += this.totalBill;
        this.chargeLines.clear();
        this.totalBill = 0.0;
    }

    // Getter method for the change
    public double getChange() {
        return this.change;
    }

    // Getter method for the current cash in the register
    public double getCurrentCashInRegister() {
        return this.currentCashInRegister;
    }

    // Method for getting the total amount of items on the bill
    public int getAmountOfItems() {
        int totalAmount = 0;
        for (ChargeLine chargeLine : this.chargeLines) {
            totalAmount += chargeLine.getAmount();
        }
        return totalAmount;
    }

    // Getter method for the list of ChargeLine objects on the bill
    public ArrayList<ChargeLine> getChargeLines() {
        return this.chargeLines;
    }
}

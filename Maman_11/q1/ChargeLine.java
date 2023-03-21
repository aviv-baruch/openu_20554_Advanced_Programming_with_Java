package q1;

// ChargeLine class represents a single product and its associated charge in a bill
public class ChargeLine {
    private Product product; // The product being charged
    private int amount; // The quantity of the product being charged
    private double totalPrice; // The total price of the product and its quantity

    // Constructor that sets the product, quantity, and total price of the charge
    // line
    public ChargeLine(Product product, int amount) {
        this.product = product;
        this.amount = amount;
        this.totalPrice = product.getPrice() * amount;
    }

    // Getters for the fields of ChargeLine
    public Product getProduct() {
        return product;
    }

    public int getAmount() {
        return amount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

}

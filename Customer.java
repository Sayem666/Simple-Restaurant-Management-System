public abstract class Customer {
    String name;

    public Customer(String name) {
        this.name = name;
    }

    // Abstract method for calculating discount
    public abstract double calculateDiscount(double totalPrice);
}

public class RegularCustomer extends Customer {
    public RegularCustomer(String name) {
        super(name);
    }

    @Override
    public double calculateDiscount(double totalPrice) {
        return totalPrice; // No discount
    }
}

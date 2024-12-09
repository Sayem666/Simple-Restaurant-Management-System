public class Student extends Customer {
    public Student(String name) {
        super(name);
    }

    @Override
    public double calculateDiscount(double totalPrice) {
        return totalPrice * 0.9; // 10% discount
    }
}

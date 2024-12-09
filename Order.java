import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    private ArrayList<Food> foodList;

    public Order(ArrayList<Food> foodList) {
        this.foodList = foodList;
    }

    public double placeOrder(Customer customer) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Food> selectedItems = new ArrayList<>();
        ArrayList<Integer> quantities = new ArrayList<>();

        if (foodList.isEmpty()) {
            System.out.println("No food items available to order.");
            return 0;
        }

        System.out.println("Available Food Items:");
        for (Food food : foodList) {
            System.out.println(food);
        }

        double totalPrice = 0;
        while (true) {
            System.out.print("Enter Food ID to select (or 0 to finish): ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid Food ID.");
                scanner.next(); // Clear invalid input
                continue;
            }

            int foodId = scanner.nextInt();
            if (foodId == 0) {
                break;
            }

            Food selectedFood = null;
            for (Food food : foodList) {
                if (food.id == foodId) {
                    selectedFood = food;
                    break;
                }
            }

            if (selectedFood == null) {
                System.out.println("Invalid Food ID. Please try again.");
                continue;
            }

            System.out.print("Enter quantity: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid quantity.");
                scanner.next(); // Clear invalid input
                continue;
            }

            int quantity = scanner.nextInt();
            if (quantity <= 0) {
                System.out.println("Quantity must be greater than zero.");
                continue;
            }

            selectedItems.add(selectedFood);
            quantities.add(quantity);
            totalPrice += selectedFood.price * quantity;
        }

        // Display Order Summary
        if (selectedItems.isEmpty()) {
            System.out.println("\nNo items selected. Order canceled.");
            return 0;
        }

        System.out.println("\nOrder Summary:");
        for (int i = 0; i < selectedItems.size(); i++) {
            Food food = selectedItems.get(i);
            int quantity = quantities.get(i);
            System.out.println(food.name + " x " + quantity + " = " + (food.price * quantity));
        }

        // Use polymorphism to calculate the discount
        double finalPrice = customer.calculateDiscount(totalPrice);

        System.out.println("\nTotal Price after discount: " + finalPrice);
        return finalPrice;
    }
}

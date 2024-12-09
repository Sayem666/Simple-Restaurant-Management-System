import java.util.ArrayList;
import java.util.Scanner;

public class Menubar implements MenuAbs {
    private ArrayList<Food> foodList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void addFood() {
        System.out.print("Enter Food ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Food Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Food Price: ");
        double price = scanner.nextDouble();
        foodList.add(new Food(id, name, price));
        System.out.println("Food added successfully!");
    }

    @Override
    public void updateFood() {
        System.out.print("Enter Food ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        for (Food food : foodList) {
            if (food.id == id) {
                System.out.print("Enter new name: ");
                food.name = scanner.nextLine();
                System.out.print("Enter new price: ");
                food.price = scanner.nextDouble();
                System.out.println("Food updated successfully!");
                return;
            }
        }
        System.out.println("Food not found!");
    }

    @Override
    public void deleteFood() {
        System.out.print("Enter Food ID to delete: ");
        int id = scanner.nextInt();
        if (foodList.removeIf(food -> food.id == id)) {
            System.out.println("Food deleted successfully!");
        } else {
            System.out.println("Food not found!");
        }
    }

    @Override
    public void displayFoods() {
        if (foodList.isEmpty()) {
            System.out.println("No food items available.");
        } else {
            System.out.println("Food List:");
            for (Food food : foodList) {
                System.out.println(food);
            }
        }
    }

    @Override
    public ArrayList<Food> getFoodList() {
        return foodList;
    }
}

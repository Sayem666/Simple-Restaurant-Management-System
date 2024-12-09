import java.util.ArrayList;

public interface MenuAbs {
    void addFood();
    void updateFood();
    void deleteFood();
    void displayFoods();

    // Method to retrieve the food list
    ArrayList<Food> getFoodList();
}

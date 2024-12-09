import java.util.Scanner;

public class StaffConfirmation extends PayBill {

    // Method for staff to confirm the bill
    public void confirmBill(String customerName, double amount) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nBill Payment Confirmation");
        System.out.println("Customer: " + customerName);
        System.out.println("Amount to Confirm: " + amount);
        System.out.print("Staff, confirm payment? (yes/no): ");
        String confirmation = scanner.nextLine();

        if (confirmation.equalsIgnoreCase("yes")) {
            isBillPaid = true;
            System.out.println("Payment confirmed! " + customerName + " has paid the bill.");
        } else {
            System.out.println("Payment not confirmed. Please retry.");
        }
    }
}

import java.util.Scanner;
import java.util.InputMismatchException;

public class TemperatureAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Initialize scanner
        int numDays = 0;

        // 1. Take an input from the user (eg. 5 for the number of days)
        while (true) {
            try {
                System.out.print("Enter the number of days for temperature input: ");
                numDays = scanner.nextInt();
                if (numDays <= 0) {
                    System.out.println("Please enter a positive number for the days.");
                } else {
                    break; // Exit loop if input is valid
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Clear the invalid input
            }
        }

        System.out.println("Number of days entered: " + numDays); // Temporary output

        // Scanner closing will be added later
    }
}
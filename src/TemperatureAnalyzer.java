import java.util.Scanner;
import java.util.InputMismatchException;

public class TemperatureAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userChoiceToContinue; // Renamed

        do {
            int numDays = 0;

            // 1. Take an input from the user (e.g., 5 for the number of days)
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
            scanner.nextLine(); // Consume the newline character left by nextInt()

            double[] temperatures = new double[numDays];
            double sumOfTemperatures = 0;

            // 2. Prompt the user to enter all the numbers (temperature values)
            System.out.println("Enter the temperature for each day:");
            for (int i = 0; i < numDays; i++) {
                while (true) {
                    try {
                        System.out.print("Temperature for day " + (i + 1) + ": ");
                        temperatures[i] = scanner.nextDouble();
                        sumOfTemperatures += temperatures[i];
                        scanner.nextLine(); // Consume the newline character left by nextDouble()
                        break; // Exit inner loop if input is valid
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a numeric temperature value.");
                        scanner.next(); // Clear the invalid input
                        scanner.nextLine(); // Consume the rest of the line
                    }
                }
            }

            // 3. Calculate the average temperature
            double averageTemperature = 0;
            if (numDays > 0) {
                averageTemperature = sumOfTemperatures / numDays;
            }

            System.out.printf("Average temperature: %.2f\n", averageTemperature);

            // 4. Given the average temperature, how many of the numbers are above the average temperature?
            int daysAboveAverage = 0;
            for (int i = 0; i < numDays; i++) {
                if (temperatures[i] > averageTemperature) {
                    daysAboveAverage++;
                }
            }

            System.out.println("Number of days with temperature above average: " + daysAboveAverage);
            // --- Core Temperature Analysis Logic ---

            // Ask user if they want to process another request
            while (true) {
                System.out.print("\nDo you want to process another request? (Y/n): ");
                String userInput = scanner.nextLine().trim(); // Read whole line and trim

                if (userInput.equalsIgnoreCase("y") || userInput.isEmpty()) { // 'Y', 'y', or just Enter (default to Yes)
                    userChoiceToContinue = "y";
                    break;
                } else if (userInput.equalsIgnoreCase("n")) { // 'N' or 'n'
                    userChoiceToContinue = "n";
                    break;
                } else {
                    System.out.println("Invalid input. Please type 'Y' or 'n' (or press Enter for Y).");
                }
            }

        } while (userChoiceToContinue.equals("y")); // Continue loop if user chose 'y' (or default)

        System.out.println("\nExiting Temperature Analyzer. Goodbye!");
        scanner.close();
    }
}
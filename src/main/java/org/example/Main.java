package org.example;

import java.util.Scanner;

import org.example.math.FunctionSystemCalculator;

public class Main {
    public static void main(String[] args) {
        double a;
        double b;
        double step;
        double epsilon;
        FunctionSystemCalculator calculator = new FunctionSystemCalculator();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter left border value:");
            a = Double.parseDouble(scanner.nextLine());
            System.out.println("Enter right border value:");
            b = Double.parseDouble(scanner.nextLine());
            System.out.println("Enter step value:");
            step = Double.parseDouble(scanner.nextLine());
            System.out.println("Enter epsilon value (leave empty for default epsilon=0.001):");
            String epsilonInput = scanner.nextLine();
            epsilon = epsilonInput.isEmpty() ? 0.001 : Double.parseDouble(epsilonInput);

            for (double x = a; x <= b; x += step) {
                calculator.calculate(x, epsilon);
            }

            System.out.println("Calculation completed. Results are available in '/output/result_log.csv'.");
        } catch (NumberFormatException e) {
            System.err.println("Invalid input. Please enter valid numbers for a, b, step, and epsilon.");
        }
    }
}

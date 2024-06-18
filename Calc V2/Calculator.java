import java.util.Scanner;
import java.text.DecimalFormat;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        boolean continueCalculating = true;

        while (continueCalculating) { //Needed to allow repeated calc.
            System.out.println("Enter 1st number:");
            double num1 = scanner.nextDouble();

            System.out.println("Enter an operator (+, -, *, or /):");
            char operator = scanner.next().charAt(0);

            System.out.println("Enter the 2nd number:");
            double num2 = scanner.nextDouble();

            double result;

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        System.out.println("Bruh, Division by zero!");
                        continue;
                    }
                    break;
                default:
                    System.out.println("Error! Invalid operator");
                    continue;
            } //Inside the loop

            System.out.println("The result is: " + decimalFormat.format(result));

            System.out.println("Do you want to perform another calculation? (y/no)");
            String response = scanner.next();

            if (!response.equalsIgnoreCase("y")) {
                continueCalculating = false;
            }
        }

        System.out.println("By: PradaFit");
        scanner.close();
    }
}

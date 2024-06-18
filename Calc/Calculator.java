import java.util.Scanner;
import java.text.DecimalFormat;;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat decimalformat = new DecimalFormat("#,##0.00");

        System.out.println("Enter 1st number:");
        double num1 = scanner.nextDouble();

        System.out.println("Enter an operator (+, -, *, or /):");
        char operator = scanner.next().charAt(0);

        System.out.println("Enter the 2nd #");
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
                if (num2 !=0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Bruh, Division by zero!");
                    return;
                }
                break;

            default:
            System.out.println("Error! Invalid operator");
            return;

        }
        System.out.println("The result is: " + decimalformat.format(result));
    }
}

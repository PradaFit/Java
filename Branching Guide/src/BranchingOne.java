
/**
 *
 * This program performs branching ops. using if-else statements
 *
 * @author PradaFit
 *
 *
 */
import java.util.Scanner;

public class BranchingOne {

    public static void main(String[] args) {
        // TO DO 1
        try (Scanner keyboard = new Scanner(System.in)) {
            // TO DO 1
            System.out.println("Enter the # of To Do 1: ");
            int number = keyboard.nextInt();
            if (number < 0) {
                System.out.println("The # is neg.");
            }

            // TO DO 2: Checking if # is zero
            System.out.println("Enter a 2nd #: ");
            number = keyboard.nextInt();
            if (number == 0) {
                System.out.println("The # is zero :(");
            }

            // TO DO 3: Checks if class avg. = passing grade
            System.out.println("Enter a 3rd number, a double, for class avg: ");
            double average = keyboard.nextDouble();
            if (average >= 65) {
                System.out.println("A passing grade");
            } else {
                System.out.println("FAILED! // Not a passing grade :(");
            }

            // TO DO 4 & 5: Boolean value is true/false
            System.out.println("Is the answer the user reported true? Enter a Boolean value: ");
            boolean answer = keyboard.nextBoolean();
            if (answer) {
                System.out.println("The value is true");
            } else {
                System.out.println("The value was false");
            }

            // TO DO 6: Check if the # is even or odd
            System.out.println("Enter a # for #6: ");
            number = keyboard.nextInt();
            if (number % 2 == 0) {
                System.out.println("The # is even");
            } else {
                System.out.println("The # is odd");
            }

            // TO DO 7
            System.out.println("Enter a grade (float value) for #7: ");
            float grade = keyboard.nextFloat();
            if (grade >= 90) {
                System.out.println("The grade is above an A");
            }

            // TO DO 8
            if (grade >= 80 && grade < 90) {
                System.out.print("The grade is in the B range");
            }

            // TO DO 9
            System.out.println("Enter a temp. (dbl value) for #8: ");
            double temperature = keyboard.nextDouble();
            if (temperature > 78) {
                System.out.println("The temp is higher than 78 degrees");
            } else {
                System.out.println("The temp is less than or equal to 78 degrees");
            }

            // T0 DO 10
            if ((temperature > 0 && temperature % 2 != 0) || (temperature == 0 && temperature % 2 == 0)) {
                System.out.println("Yes; pos. & odd, or zero and even.");
            } else {
                System.out.println("No! Not pos. & odd.");
            }

            /**
             * I had to do a switch statement to determine the letter grade
             * entered by the user. A switch statement is used here instead of
             * multiple if-else statements for these reasons: 
             * 1. Readability: The switch statement provides a clear and concise way to handle
             *    multiple. Also, the code easier to read and maintain. 
             * 2. Efficiency: The switch statement can be more efficient than multiple if-else
             *    statements, especially when dealing w/ a large number of
             *    possible values, as it can be optimized by the compiler. 
             * 3. Ease of Modification: Adding/modifying cases in a switch statement
             *    is straightforward and doesn't require altering the structure of
             *    the code, unlike nested if-else statements. Plus, VSCode
             *    recognized the multi if-else statement as a problem.
             *
             */
            // TO DO 11: The letter grade and using multi-way if statement
            System.out.println("Enter a letter grade: ");
            char letterGrade = keyboard.next().charAt(0);
            switch (letterGrade) {
                case 'A' ->
                    System.out.println("The grade is an A");
                case 'B' ->
                    System.out.println("The grade is a B");
                case 'C' ->
                    System.out.println("The grade is a C");
                case 'D' ->
                    System.out.println("The grade is a D");
                case 'F' ->
                    System.out.println("The grade is an F");
                default ->
                    System.out.println("Non-existent grade entered");
            }

            // TO DO 13: Prompt for two ints. and rpeort largest and smallest using max method
            System.out.println("Enter 2 integers for To Do 13: ");
            int num1 = keyboard.nextInt();
            int num2 = keyboard.nextInt();
            int largest = max(num1, num2);
            int smallest = (num1 == largest) ? num2 : num1;
            System.out.println("Largest is " + largest);
            System.out.println("Smallest is " + smallest);

            System.out.print("By: PradaFit");
        }
    }

    // TO DO 12: Going to define max method to return larger of two integers
    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }

}

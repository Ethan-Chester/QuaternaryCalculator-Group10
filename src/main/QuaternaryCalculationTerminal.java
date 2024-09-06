// YOU DON'T NEED TO WRITE TEST OR USE THIS IS JUST HERE FOR MODEL. TO SHOW THAT THE QUATERNARY UTIL  IS FLEXIBLE AND WILL RUN IN TERMINAL AND FOR GUI.
//THIS CLASS IS ONLY TERMINAL IT HAS NOTHING TO DO WITH QUATERNARY CALCULATOR GUI. Its completely separate :) it will use Quaternary Util  the same way the Quaternary Calculator Gui uses the Util.
// This is just here for reference
package main;

import java.util.Scanner;

public class QuaternaryCalculationTerminal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first quaternary number: ");
        String number1 = scanner.nextLine();

        System.out.println("Enter operator (+, -, *, /, ^ for square, & for square root): ");
        String operator = scanner.nextLine();

        String number2 = "";
        if (!operator.equals("^") && !operator.equals("&")) {
            System.out.println("Enter second quaternary number: ");
            number2 = scanner.nextLine();
        }

        try {
            int base10Int1 = QuaternaryUtils.parseQuaternary(number1);
            int base10Int2 = 0;
            if (!number2.isEmpty()) {
                base10Int2 = QuaternaryUtils.parseQuaternary(number2);
            }

            int result = 0;
            switch (operator) {
                case "+":
                    result = base10Int1 + base10Int2;
                    break;
                case "-":
                    result = base10Int1 - base10Int2;
                    break;
                case "*":
                    result = base10Int1 * base10Int2;
                    break;
                case "/":
                    if (base10Int2 == 0) throw new ArithmeticException("Divide by zero");
                    result = base10Int1 / base10Int2;
                    break;
                case "^":
                    result = QuaternaryUtils.square(base10Int1);
                    break;
                case "&":
                    result = QuaternaryUtils.squareRoot(base10Int1);
                    break;
                default:
                    System.out.println("Error: Invalid operator");
                    return;
            }

            printResults(result);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void printResults(int result) {
        System.out.println("Result (Decimal): " + result);
        System.out.println("Result (Quaternary): " + QuaternaryUtils.toQuaternary(result));
    }
}

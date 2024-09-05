package main;

public class QuaternaryCalculation {

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: <number1> <operator> <number2>");
            return;
        }

        String number1 = args[0];
        String operator = args[1];
        String number2 = args[2];

        try {
            int base10Int1 = QuaternaryUtils.parseQuaternary(number1);
            int base10Int2 = QuaternaryUtils.parseQuaternary(number2);

            switch (operator) {
                case "+":
                    printResults(base10Int1 + base10Int2);
                    break;
                case "-":
                    printResults(base10Int1 - base10Int2);
                    break;
                case "*":
                    printResults(base10Int1 * base10Int2);
                    break;
                case "/":
                    if (base10Int2 == 0) throw new ArithmeticException("Divide by zero");
                    printResults(base10Int1 / base10Int2);
                    break;
                case "^":
                    printResults(QuaternaryUtils.square(base10Int1));
                    break;
                case "&":
                    printResults(QuaternaryUtils.squareRoot(base10Int1));
                    break;
                default:
                    System.out.println("Error: Invalid operator");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void printResults(int result) {
        System.out.println("Result (Decimal): " + result);
        System.out.println("Result (Quaternary): " + QuaternaryUtils.toQuaternary(result));
    }
}


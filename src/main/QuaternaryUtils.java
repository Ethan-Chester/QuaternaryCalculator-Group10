package  main;


public class QuaternaryUtils {

    // Convert quaternary string to decimal integer
    public static int parseQuaternary(String number) {
        int base10Int = 0;
        for (int i = 0; i < number.length(); i++) {
            char digitChar = number.charAt(i);
            int qNumber = Character.getNumericValue(digitChar);
            base10Int += qNumber * power(4, number.length() - 1 - i);
        }
        return base10Int;
    }

    // Convert decimal integer to quaternary string
    public static String toQuaternary(int number) {
        if (number == 0) return "0";
        StringBuilder stringBuilder = new StringBuilder();
        while (number > 0) {
            int remainder = number % 4;
            stringBuilder.append(remainder);
            number = number / 4;
        }
        return stringBuilder.reverse().toString();
    }

    // Calculate square of a number
    public static int square(int number) {
        return number * number;
    }

    // Calculate square root of a number
    public static int squareRoot(int number) {
        return (int) Math.round(Math.sqrt(number));
    }

    // Calculate power of a number
    public static int power(int number, int exponent) {
        if (exponent == 0) {
            return 1;
        } else {
            return number * power(number, exponent - 1);
        }
    }
    // Check if the input string is quaternary (only contains digits 0-3)
    public static boolean isQuaternary(String input) {
        for (char c : input.toCharArray()) {
            if (c < '0' || c > '3') {
                return false;  // If a digit is not in the range 0-3, it's not quaternary
            }
        }
        return true;
    }

    //  This will convert input to decimal if it's quaternary, otherwise return as decimal
    public static String toggleConversion(String input, boolean isCurrentlyQuaternary) {
        if (isCurrentlyQuaternary && isQuaternary(input)) {
            // Convert quaternary to decimal
            int decimalValue = parseQuaternary(input);
            return String.valueOf(decimalValue);
        } else if (!isCurrentlyQuaternary) {
            // Convert decimal to quaternary
            int decimalValue = Integer.parseInt(input);
            return toQuaternary(decimalValue);
        } else {
            return input;  // Return unchanged if the input doesn't match conditions
        }
    }
}
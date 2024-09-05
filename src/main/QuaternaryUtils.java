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
}
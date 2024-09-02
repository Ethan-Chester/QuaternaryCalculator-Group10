public class QuaternaryCalculation {
    public static void main(String[] args){
//        + ADD, - SUBTRACT, * MULTIPLY, / DIVIDE, ^ SQ, & SQRT

        String[] numbers = args[0].split("%");
        String operator = args[1];

        String number1 = numbers[0];
        String number2 = numbers[1];

        int base10Int1 = 0;
        int base10Int2 = 0;

        String base10Result = "";
        String base4Result = "";

        for (int i = number1.length() - 1; i > 0; i--){
            char digitChar = number1.charAt(i);
            int qNumber = Character.getNumericValue(digitChar);

            base10Int1 += qNumber*power(4, i);
        }
        if (!number2.isEmpty()) {
            for (int i = number2.length() - 1; i > 0; i--) {
                char digitChar = number2.charAt(i);
                int qNumber = Character.getNumericValue(digitChar);

                base10Int2 += qNumber * power(4, i);
            }
        }

        try{
            switch (operator) {
                case "+":
                    System.out.println(base10Int1+base10Int2);
                    break;
                case "-":
                    System.out.println(base10Int1-base10Int2);
                    break;
                case "*":
                    System.out.println(base10Int1*base10Int2);
                    break;
                case "/":
                    System.out.println(base10Int1/base10Int2);
                    break;
                case "^":
//                  Squared
                    System.out.println(power(base10Int1, 2));
                    break;
                case "&":
//                  Square Root
                    break;
                default:
                    return;
            }
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static int power(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        } else {
            return base * power(base, exponent - 1);
        }
    }
}

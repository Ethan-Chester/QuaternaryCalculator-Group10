public class QuaternaryCalculation {
    public static void main(String[] args){
        // + ADD, - SUBTRACT, * MULTIPLY, / DIVIDE, ^ SQ, & SQRT

        String operator = args[1];

        String number1 = args[0];
        String number2 = args[2];


        int base10Int1 = 0;
        int base10Int2 = 0;

        for (int i = 0; i < number1.length(); i++){

            //        if (Integer.parseInt(i) > 3{
            //            //Throw an out of bounds error here
            //        }

            char digitChar = number1.charAt(i);
            int qNumber = Character.getNumericValue(digitChar);
            base10Int1 += qNumber*power(4, number1.length() - 1 - i);
        }
        if (!number2.equals("$")) {
            for (int i = 0; i < number2.length(); i++) {

                //        if (Integer.parseInt(i) > 3{
                //            //Throw an out of bounds error here
                //        }

                char digitChar = number2.charAt(i);
                int qNumber = Character.getNumericValue(digitChar);

                base10Int2 += qNumber * power(4, number2.length() - 1 - i);
            }
        }


        try{
            switch (operator) {
                case "+":
                    System.out.println(base10Int1+base10Int2);
                    //return base10 and base4 in each switch case using base4 conversion function
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
                    System.out.println(squareRoot(base10Int1));
                    break;
                default:
                    // Return Type Error (Enter a valid operator)
            }
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    //add Base10 to Base4 Conversion Function

    public static int squareRoot(int base){
        return (int) Math.round(Math.sqrt(base));
    }

    public static int power(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        } else {
            return base * power(base, exponent - 1);
        }
    }
}

package main;


import javax.swing.*;
import java.awt.event.ActionEvent;

public class QuaternaryCalculatorGUI {
    private JFrame frame;
    private JTextField display;
    private enum DisplayState { QUATERNARY, DECIMAL } // this tracks the current stage to see if its in decimal or in quaternary.
    private DisplayState currentState = DisplayState.QUATERNARY;  //  sets Default to quaternary


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new QuaternaryCalculatorGUI().createAndShowGUI());
    }

    private void createAndShowGUI() {
        frame = new JFrame("Quaternary Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new java.awt.GridLayout(5, 4));

        display = new JTextField();
        frame.add(display);

        // Create buttons
        JButton[] buttons = new JButton[13];
        String[] buttonLabels = {
                "0", "1", "2", "3", "+", "-", "*", "/", "C", "=", "x²", "√", "Toggle"
        };

        for (int i = 0; i < buttonLabels.length; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].addActionListener(this::handleButtonPress);
            frame.add(buttons[i]);
        }

        frame.setVisible(true);
    }

    private void handleButtonPress(ActionEvent event) {
        String buttonText = ((JButton) event.getSource()).getText();
        String currentText = display.getText();

        switch (buttonText) {
            case "C" -> display.setText("");  // Clear the display
            case "=" -> calculateResult();
            case "x²" -> squareNumber();
            case "√" -> squareRootNumber();
            case "Toggle" -> toggleDisplay();
            case "+", "-", "*", "/" -> display.setText(currentText + " " + buttonText + " ");
            case null, default -> display.setText(currentText + buttonText);
        }
    }

    private void calculateResult() {
        try {
            String input = display.getText();
            String result = evaluateQuaternaryExpression(input);
            display.setText(result);
        } catch (Exception e) {
            display.setText("Error");
        }
    }

    private void squareNumber() {
        try {
            String input = display.getText();
            int number = QuaternaryUtils.parseQuaternary(input);  // Convert quaternary to decimal
            int result = QuaternaryUtils.square(number);
            display.setText(QuaternaryUtils.toQuaternary(result));  // Convert back to quaternary
        } catch (Exception e) {
            display.setText("Error");
        }
    }

    private void squareRootNumber() {
        try {
            String input = display.getText();
            int number = QuaternaryUtils.parseQuaternary(input);  // Convert quaternary to decimal
            int result = QuaternaryUtils.squareRoot(number);
            display.setText(QuaternaryUtils.toQuaternary(result));  // Convert back to quaternary
        } catch (Exception e) {
            display.setText("Error");
        }
    }

    private void toggleDisplay() {
        try {
            String input = display.getText();
            int number;

            switch (currentState) {
                case QUATERNARY -> {
                    number = QuaternaryUtils.parseQuaternary(input);  // Converts quaternary to decimal
                    display.setText(String.valueOf(number));
                    currentState = DisplayState.DECIMAL;
                }
                case DECIMAL -> {
                    number = Integer.parseInt(input);  // Read as decimal
                    String quaternary = QuaternaryUtils.toQuaternary(number);  // Convert decimal to quaternary
                    display.setText(quaternary); // Show in quaternary
                    currentState = DisplayState.QUATERNARY;
                }
            }
        } catch (Exception e) {
            display.setText("Error");
            currentState = DisplayState.QUATERNARY;  // Reset to quaternary if there's an error
        }
    }

    private String evaluateQuaternaryExpression(String input) {
        // Simplified evaluation logic for quaternary arithmetic operations
        String[] parts = input.split(" ");
        if (parts.length < 3) return "Error";


        int num1 = QuaternaryUtils.parseQuaternary(parts[0]);  // Convert from quaternary to decimal
        int num2 = QuaternaryUtils.parseQuaternary(parts[2]);
        int result = 0;

        switch (parts[1]) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) throw new ArithmeticException("Divide by zero");
                result = num1 / num2;
                break;
            default:
                return "Error";
        }

        return QuaternaryUtils.toQuaternary(result);  // Convert back to quaternary
    }
}

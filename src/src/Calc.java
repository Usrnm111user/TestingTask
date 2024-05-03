import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Calc {
    public static void main(String[] args) {
        System.out.println("Enter expression : ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] parts = input.split(" ");
        String operator = parts[1];
        int a , b ;
        int result;

        if (isRoman(parts[0])) {
            if ((isRoman(parts[0]) && !isRoman(parts[2])) || (!isRoman(parts[0]) && isRoman(parts[2]))) {
                throw new IllegalArgumentException("Numbers should be either all roman or all arabic");
            }
            result = calculate(convertRomanToInteger(parts[0]), convertRomanToInteger(parts[2])  , operator);
            System.out.println(convertIntegerToRoman(result));
        } else {
            try {
                a = Integer.parseInt(parts[0]);
                b  = Integer.parseInt(parts[2]);
                if (( a < 1 || a > 10) || ( b < 1 || b > 10)) {
                    throw new IllegalArgumentException("Numbers should be between 1 and 10");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid numbers");
            }
            result = calculate( a , b , operator);
            System.out.println(result);
        }
    }

    public static int calculate(int num1, int num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }

    public static boolean isRoman(String input) {
        String romanPattern = "^[IVXLCDM]+$";
        return input.matches(romanPattern);
    }

    public static int convertRomanToInteger(String input) {
        switch (input) {
            case "I":
                return 1;
            case "II":
                return 2;
            case "III":
                return 3;
            case "IV":
                return 4;
            case "V":
                return 5;
            case "VI":
                return 6;
            case "VII":
                return 7;
            case "VIII":
                return 8;
            case "IX":
                return 9;
            case "X":
                return 10;
            default:
                throw new IllegalArgumentException("Invalid roman number");
        }
    }

    public static String convertIntegerToRoman(int num) {
        if (num < 1) {
            throw new IllegalArgumentException("Roman numbers can't be negative or zero");
        }

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                result.append(symbols[i]);
                num -= values[i];
            }
        }

        return result.toString();
    }}
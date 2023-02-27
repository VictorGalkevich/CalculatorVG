
import java.util.Stack;

public class Calculus {
    public static String calculator(String expression) {
        try {
            return Body(expression).toString();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "error";
        }
    }

    public static Double Body(String expression) throws ParseException {
        try {
            Stack<Token> numbers = new Stack<>();
            Stack<Token> operands = new Stack<>();
            String number = "";
            for (int i = 0; i < expression.length(); i++) {
                if (expression.charAt(i) != '+' && expression.charAt(i) != '-' && expression.charAt(i) != '/' && expression.charAt(i) != '*') {
                    number += expression.charAt(i);
                } else {
                    Utility.addNumber(Utility.parse(number), numbers);
                    if (operands.isEmpty()) {
                        Utility.addCharacter(expression.charAt(i), operands);
                    } else if (!operands.isEmpty() && Utility.getPrior(operands.peek().getCh()) < Utility.getPrior(expression.charAt(i))) {
                        Utility.addCharacter(expression.charAt(i), operands);
                    } else if (!operands.isEmpty() && Utility.getPrior(operands.peek().getCh()) >= Utility.getPrior(expression.charAt(i))) {
                        MathsFunctions.maths(numbers, operands);
                        Utility.addCharacter(expression.charAt(i), operands);
                    }
                    number = "";
                }
            }
            Utility.addNumber(Utility.parse(number), numbers);
            while (!operands.isEmpty()) {
                MathsFunctions.maths(numbers, operands);
            }
            return numbers.peek().getValue();
        } catch (Exception e) {
            throw new ParseException("Calculation error");
        }
    }

}
import java.util.Stack;

public class MathsFunctions {

    public static void maths(Stack<Token> numbers, Stack<Token> operands) {
        double a = numbers.pop().getValue();
        double b = numbers.pop().getValue();
        char operand = operands.pop().getCh();
        switch (operand) {
            case '+' -> sum(a, b, numbers);
            case '-' -> subtraction(a, b, numbers);
            case '/' -> division(a, b, numbers);
            case '*' -> multiplication(a, b, numbers);
        }
    }

    public static void sum(Double a, Double b, Stack<Token> numbers) {
        Token t2 = new Token();
        t2.setCh('0');
        t2.setValue(a + b);
        numbers.push(t2);
    }

    public static void subtraction(Double a, Double b, Stack<Token> numbers) {
        Token t2 = new Token();
        t2.setCh('0');
        t2.setValue(b - a);
        numbers.push(t2);
    }

    public static void multiplication(Double a, Double b, Stack<Token> numbers) {
        Token t2 = new Token();
        t2.setCh('0');
        t2.setValue(a * b);
        numbers.push(t2);
    }

    public static void division(Double a, Double b, Stack<Token> numbers) {
        Token t2 = new Token();
        t2.setCh('0');
        t2.setValue(b / a);
        numbers.push(t2);
    }
}
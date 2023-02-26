import java.util.Stack;

public final class Utility {

    public static Double parse(String str) throws ParseException {
        try {
            return Double.parseDouble(str);
        } catch (Exception e) {
            throw new ParseException("Invalid number");
        }
    }

    public static int getPrior(Character ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        } else if (ch == '*' || ch == '/') {
            return 2;
        } else {
            return 0;
        }
    }

    public static void addCharacter(Character ch, Stack<Token> operands) {
        Token t1 = new Token();
        t1.setCh(ch);
        t1.setValue(0.0);
        operands.push(t1);
    }

    public static void addNumber(Double dbl, Stack<Token> numbers) {
        Token t1 = new Token();
        t1.setCh('0');
        t1.setValue(dbl);
        numbers.push(t1);
    }

}
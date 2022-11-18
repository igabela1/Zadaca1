package ba.unsa.etf.rpr;
import java.util.Stack;


public class ExpressionEvaluator {


    // Stack for numbers: 'values'
    private static Stack<String> ops;

    // Stack for Operators: 'ops'
    private static Stack<Double> values;
    private static final RuntimeException arg = new RuntimeException("Argument error");


    private static int space(String s, int first) {
        for (int i = first; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                return i;
            }
        }
        return s.length();
    }

    public static Double evaluate(String str) throws RuntimeException {
        ops = new Stack<>();
        values = new Stack<>();
        int number_of_braces = 0;
        int number_of_spaces = 0;
        for (int i = 0; i < str.length();) {

            // Current token is a whitespace, skip it
            if (str.charAt(i) == ' ') {
                if (number_of_spaces++ > 0) {
                    throw arg;
                }
                ++i;
                continue;
            } else {
                number_of_spaces = 0;
            }
            int i1 = i;
            String symbol = str.substring(i1, i = space(str, i1));

            // Current token is an opening brace,push it to 'ops'
            if (symbol.equals("(")) number_of_braces++;


            // Current token is an operator.
            else if (symbol.equals("+"))
                ops.push("+");
            else if (symbol.equals("-"))
                ops.push("-");
            else if (symbol.equals("*"))
                ops.push("*");
            else if (symbol.equals("/"))
                ops.push("/");
            else if (symbol.equals("sqrt"))
                ops.push("sqrt");
                // Closing brace encountered,solve entire brace
            else if (symbol.equals(")")){
                number_of_braces--;

                String op = ops.pop();
                double val = values.pop();

                if (op.equals("+"))
                    val = val + values.pop();
                else if (op.equals("-"))
                    val = values.pop() - val;
                else if (op.equals("*"))
                    val = val * values.pop();
                else if (op.equals("/"))
                    val = values.pop() / val;
                else if (op.equals("sqrt"))
                    val = Math.sqrt(val);

                values.push(val);
            } else try {

                values.push(Double.parseDouble(symbol));
            } catch (NumberFormatException e) {
                throw arg;
            }
        }
        if (number_of_braces != 0) throw arg;
        return values.peek();
    }
}

   /* private static int applyOp(char op,
                              int b, int a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new
                            UnsupportedOperationException(
                            "Cannot divide by zero");
                return a / b;
        }
        return 0;
    }
}*/

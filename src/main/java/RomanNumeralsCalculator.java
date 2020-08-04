import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Stack;

public class RomanNumeralsCalculator {

  /**
   * The calculate method uses the Shunting-yard algorithm
   * (https://en.wikipedia.org/wiki/Shunting-yard_algorithm)
   * to perform calculations on Roman Numerals
   * @param line The input line string
   * @return Roman Numeral calculation
   */
  public static String calculate(String line) {
    char[] tokens = line.toCharArray();
    int length = tokens.length;
    Stack<Double> outputs = new Stack<>();
    Stack<Character> operators = new Stack<>();

    // Read all tokens
    for (int i = 0; i < length; i++) {
      // Read token - skip if the token contains whitespace
      if (tokens[i] != ' ') {
        // If the token contains a roman numeral, convert it to a number
        // and push it onto the outputs stack
        if (RomanNumerals.isValid(tokens[i])) {
          StringBuilder sb = new StringBuilder();
          while (i < tokens.length && RomanNumerals.isValid(tokens[i])) {
            sb.append(tokens[i++]);
          }
          outputs.push((double) RomanNumerals.parse(sb.toString()));
        }
        // If the token is an operator
        else if (tokens[i] == '+' || tokens[i] == '-' ||
          tokens[i] == '*' || tokens[i] == '/') {
          // While there's an operator at the top of the operators stack
          // and the operator at the top of the operators stack has greater precedence
          // or the operator at the top of the operators stack has equal precedence
          // and the operator at the top of the operators stack is not a left parenthesis
          while (!operators.empty() && (hasGreaterPrecedence(tokens[i], operators.peek()) ||
            (hasEqualPrecedence(tokens[i], operators.peek()))) && (operators.peek() != '(')) {
            // Pop operators from the operators stack onto the outputs stack
            outputs.push(applyOperator(operators.pop(), outputs.pop(), outputs.pop()));
          }
          // Push it onto the operators stack
          operators.push(tokens[i]);
        }
        // Else if the token is a left parenthesis
        else if (tokens[i] == '(') {
          // Push it onto the operators stack
          operators.push(tokens[i]);
        }
        // Else if the token is a right parenthesis
        else if (tokens[i] == ')') {
          // While the operator at the top of the operators stack is not a left parenthesis
          while (!operators.empty() && operators.peek() != '(') {
            // Pop the operator from the operators stack onto the outputs stack
            outputs.push(applyOperator(operators.pop(), outputs.pop(), outputs.pop()));
          }
          // If there is a left parenthesis at the top of the operators stack
          if (!operators.empty() && operators.peek() == '(') {
            /// Pop the operator from the operators stack
            operators.pop();
          }
        }
      }
    }
    // No more tokens to read
    // While the operators stack is not empty, pop everything onto the outputs stack
    while (!operators.empty()) {
      outputs.push(applyOperator(operators.pop(), outputs.pop(), outputs.pop()));
    }

    return formatResult(outputs.pop());
  }

  private static String formatResult(double value) {
    DecimalFormat decimalFormat = new DecimalFormat("#.###");
    decimalFormat.setRoundingMode(RoundingMode.DOWN);

    return decimalFormat.format(value);
  }

  private static boolean hasEqualPrecedence(char opToken, char opStack) {
    return ((opToken == '+' || opToken == '-') && (opStack == '+' || opStack == '-') ||
      (opToken == '*' || opToken == '/') && (opStack == '*' || opStack == '/'));
  }

  private static boolean hasGreaterPrecedence(char opToken, char opStack) {
    return ((opToken == '+' || opToken == '-') && (opStack == '*' || opStack == '/'));
  }

  private static double applyOperator(char operator, double b, double a) {
    switch (operator) {
      case '+':
        return a + b;
      case '-':
        return a - b;
      case '*':
        return a * b;
      case '/':
        return a / b;
    }
    return 0;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      System.out.print("> ");
      String line = reader.readLine();
      if (line.length() == 0) {
        System.out.println("No input entered");
        break;
      }

      System.out.println(calculate(line));
      System.out.println();
    }
  }
}

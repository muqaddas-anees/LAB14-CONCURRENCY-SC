package recursion;

public class ExpressionParser {
    // Method to evaluate a mathematical expression
    public static double evaluateExpression(String expression) {
        expression = expression.replaceAll("\\s", ""); // Remove spaces
        return evaluateAdditionSubtraction(expression);
    }

    private static double evaluateAdditionSubtraction(String expression) {
        int index = expression.lastIndexOf("+");
        if (index == -1) index = expression.lastIndexOf("-");
        if (index == -1) return evaluateMultiplicationDivision(expression);

        String left = expression.substring(0, index);
        String right = expression.substring(index + 1);

        double leftValue = evaluateAdditionSubtraction(left);
        double rightValue = evaluateMultiplicationDivision(right);

        if (expression.charAt(index) == '+') return leftValue + rightValue;
        return leftValue - rightValue;
    }

    private static double evaluateMultiplicationDivision(String expression) {
        int index = expression.lastIndexOf("*");
        if (index == -1) index = expression.lastIndexOf("/");
        if (index == -1) return Double.parseDouble(expression);

        String left = expression.substring(0, index);
        String right = expression.substring(index + 1);

        double leftValue = evaluateMultiplicationDivision(left);
        double rightValue = Double.parseDouble(right);

        if (expression.charAt(index) == '*') return leftValue * rightValue;
        return leftValue / rightValue;
    }

    public static void main(String[] args) {
        String expression = "3 + 5 * 2";
        System.out.println("Result: " + evaluateExpression(expression));
    }
}

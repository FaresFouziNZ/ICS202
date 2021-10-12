import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        System.out.println("Enter the expression");
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        sc.close();

        if (isBalanced(expression))
            System.out.println("Expression is balanced");
        else
            System.out.println("Expression is not balanced");
    }

    private static boolean isBalanced(String expression) {
        LabStack<Character> stack = new LabStack<>();
        char check;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '{' || expression.charAt(i) == '[' || expression.charAt(i) == '(') {
                stack.push(expression.charAt(i));
            } else if (expression.charAt(i) == '}' || expression.charAt(i) == ']' || expression.charAt(i) == ')') {// close
                                                                                                                   // found
                check = stack.topEl();
                if ((check == '{' && expression.charAt(i) == '}') || (check == '[' && expression.charAt(i) == ']')
                        || (check == '(' && expression.charAt(i) == ')')) {// match
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

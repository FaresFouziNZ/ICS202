import java.util.Scanner;

public class PostfixCalculator {
    public static void main(String[] args) {
        System.out.println("Enter your postfix expresion:");
        Scanner sc = new Scanner(System.in);
        String postfix = sc.nextLine();
        sc.close();
        Scanner rd = new Scanner(postfix);
        String kk = "[";
        while (rd.hasNext()) {
            kk += rd.next() + ", ";
        }
        kk += "]";
        System.out.println(kk);
        char expr;
        double bot;
        double top;

        rd.close();
        LabStack<Double> stack = new LabStack<Double>();
        Scanner rd2 = new Scanner(postfix);
        try {
        while (rd2.hasNext()) {
            while (rd2.hasNextInt()) {
                stack.push(rd2.nextDouble());
            }
            expr = rd2.next().charAt(0);
            top = stack.pop();
            bot = stack.pop();
            if (expr == '+') {
                stack.push(bot+top);
            } else if (expr == '-') {
                stack.push(bot-top);
            }else if (expr == '*') {
                stack.push(bot*top);
            }else if (expr == '/') {
                stack.push(bot/top);
            }
            System.out.println("Currently, the stack is>> "+stack.toString());
            
        }
        double result = stack.pop();
        System.out.println(postfix +" = "+result);
        rd2.close();
    }catch(Exception e){
        System.out.println("Your postfix expression is not valid");
    }
    }
}

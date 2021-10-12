import java.util.Scanner;

public class ReverseQ {
    public static void main(String[] args) {
        System.out.println("Enter your input");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Scanner sc2 = new Scanner(input);
        LabStack<String> stack = new LabStack<String>();
        while (sc2.hasNextInt()) {
            stack.push(sc2.next());
        }
        System.out.println("The stack now is >> " + stack.toString());
        LabQueue<String> queue = new LabQueue<String>();
        while (!stack.isEmpty()) {
            queue.enqueue(stack.pop());
        }
        while(!queue.isEmpty()){
            stack.push(queue.dequeue());
        }
        sc.close();
        System.out.println("The stack now is >> " + stack.toString());
    }
}

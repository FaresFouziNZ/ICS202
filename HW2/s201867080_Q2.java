import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class s201867080_Q2 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Stack<Integer> stack = new Stack<Integer>();
        LinkedList<Integer> list = new LinkedList<>();
        Scanner sc = new Scanner(new File(args[0]));
        FileWriter wr = new FileWriter(new File(args[1]));
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            list.add(sc.nextInt());
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                stack.push(list.get(i));
            } else {
                if (!stack.isEmpty()) {
                    for (int k = stack.size(); !stack.isEmpty(); k--) {
                        list.set(i - k, stack.pop());
                    }

                }
            }
        }
        if (!stack.isEmpty()) {
            for (int k = stack.size(); !stack.isEmpty(); k--) {
                list.set(num - k, stack.pop());
            }
        }
        wr.write(list.toString());
        wr.close();
    }
}
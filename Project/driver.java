import java.util.Scanner;

public class driver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a;
        while (true) {
            System.out.println("Trie Project: Enter your choice");
            System.out.println(
                    "1) Create an empty trie\n2) Create a trie with initial letters\n3) Insert a word\n4) Delete a word\n5) List all words that begin with a prefix\n6) Size of the trie\n7) End");
             a = sc.nextInt();
            if (a == 1) {
                System.out.println("Empty trie created");
            } else if (a == 2) {
            } else if (a == 3) {
            } else if (a == 4) {
            } else if (a == 5) {
            } else if (a == 6) {
                System.out.println();
            } else if (a == 7) {
                System.exit(0);
            } else {
                System.out.println("Wrong input. Try again");
            }
        }
    }

}

import java.io.FileNotFoundException;
import java.util.Scanner;

public class driver {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        int a;
        Trie te=new Trie();
        int s = 'A';
        System.out.println(s);
        while (true) {
            System.out.println("Trie Project: Enter your choice");
            System.out.println(
                    "1) Create an empty trie\n2) Create a trie with initial letters\n3) Insert a word\n4) Delete a word\n5) List all words that begin with a prefix\n6) Size of the trie\n7) End");
            a = sc.nextInt();
            if (a == 1) {
                te = new Trie();
                System.out.println("Empty trie created");
            } else if (a == 2) {
                System.err.println("Enter your set");
                String wwww = sc.nextLine();
                String[] words = te.permutations(sc.next());
                for (int i = 0; i < words.length; i++) {
                    System.out.println(words[i]);
                }
                System.out.println();
            } else if (a == 3) {
                System.out.println("Enter a word to insert");
                te.insert(sc.next());
            } else if (a == 4) {
                System.out.println("Enter a word delete");
                te.delete(sc.next());
            } else if (a == 5) {
                System.out.println("Enter a prefix");
                String[] words = te.allWordsPrefix(sc.next());
                for (int i = 0; i < words.length; i++) {
                    System.out.println(words[i]);
                }
            } else if (a == 6) {
                System.out.println(te.size());
            } else if (a == 7) {
                System.exit(0);
            } else {
                System.out.println("Wrong input. Try again");
            }
            sc.nextLine();
        }
    }


} 
import java.io.FileNotFoundException;
import java.util.Scanner;

public class driver {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        int a;
        Trie MyTree = new Trie();
        while (true) {
            System.out.println("Trie Project: Enter your choice");
            System.out.println(
                    "1) Create an empty trie\n2) Create a trie with initial letters\n3) Insert a word\n4) Delete a word\n5) List all words that begin with a prefix\n6) Size of the trie\n7) End");
            a = sc.nextInt();
            if (a == 1) {
                MyTree = new Trie();
                System.out.println("Empty trie created");
            } else if (a == 2) {
                MyTree = new Trie();
                System.err.println("Enter your set");
                String theWord = sc.next();
                String[] words = MyTree.permutations(theWord);
                for (int i = 0; i < words.length; i++) {
                    MyTree.insert(words[i]);
                }
                System.out.println("Tree created");
            } else if (a == 3) {
                System.out.println("Enter a word to insert");
                MyTree.insert(sc.next());
                System.out.println("Word inserted");
            } else if (a == 4) {
                System.out.println("Enter a word delete");
                MyTree.delete(sc.next());
                System.out.println("Word deleted");
            } else if (a == 5) {
                System.out.println("Enter a prefix");
                String[] words = MyTree.allWordsPrefix(sc.next());
                for (int i = 0; i < words.length; i++) {
                    System.out.println(words[i]);
                }
            } else if (a == 6) {
                System.out.println(MyTree.size());
            } else if (a == 7) {
                System.exit(0);
            } else {
                System.out.println("Wrong input. Try again");
            }
            sc.nextLine();
        }
    }

}
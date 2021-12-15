import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Trie {
    protected TrieNode root;

    public Trie() {
        root = new TrieNode('\0');
    }

    boolean contains(String s) {
        TrieNode tmp = root;
        char tmpC;
        for (int i = 0; i < s.length(); i++) {
            tmpC = s.charAt(i);
            if (tmp.child[tmpC - 'A'] == null) {
                return false;
            } else {
                tmp = tmp.child[tmpC - 'A'];
            }
        }
        return tmp.isWord;

    }

    boolean isPrefix(String p) {
        TrieNode tmp = root;
        char tmpC;
        for (int i = 0; i < p.length(); i++) {
            tmpC = p.charAt(i);
            if (tmp.child[tmpC - 'A'] == null) {
                return false;
            } else {
                tmp = tmp.child[tmpC - 'A'];
            }
        }
        return true;
    }

    void insert(String s) {
        s = s.toUpperCase();
        TrieNode tmp = root;
        for (int i = 0; i < s.length(); i++) {
            char tmpC = s.charAt(i);
            if (tmp.child[tmpC - 'A'] == null)
                tmp.child[tmpC - 'A'] = new TrieNode(tmpC, tmp);
            tmp = tmp.child[tmpC - 'A'];
        }
        tmp.isWord = true;
    }

    void delete(String s) {
        if (!contains(s)) {
            System.out.println("the word does not exist");
            return;
        }
        Stack<TrieNode> stack = new Stack<>();
        TrieNode tmp = root;
        char tmpC;
        for (int i = 0; i < s.length(); i++) {
            tmpC = s.charAt(i);
            tmp = tmp.child[tmpC - 'A'];
            stack.push(tmp);

        }
        boolean deleteAble;
        int letterNum = 0;
        while (!stack.isEmpty()) {
            tmp = stack.pop();
            letterNum++;
            deleteAble = true;
            for (int i = 0; i < 26; i++) {
                if (tmp.child[i] != null) {
                    deleteAble = false;
                }
            }
            if (!deleteAble && letterNum == 1) {
                tmp.isWord = false;
            }
            if (letterNum > 1) {
                if (tmp.isWord)
                    deleteAble = false;
            }
            if (deleteAble) {
                tmp = null;
            } else {
                break;
            }
        }
        System.out.println("Done!");
    }

    boolean isEmpty() {
        TrieNode tmp = root;

        for (int i = 0; i < 26; i++) {
            if (tmp.child[i] != null)
                return false;
        }
        return true;

    }

    void clear() {
        root = new TrieNode('\0');
    }

    String[] allWordsPrefix(String p) {
        p = p.toUpperCase();
        if (!isPrefix(p)) {
            System.out.println("No word contains this prefix");
            return null;
        }
        ArrayList<String> words = new ArrayList<>();
        TrieNode tmp = root;
        char tmpC;

        for (int i = 0; i < p.length(); i++) {
            tmpC = p.charAt(i);
            tmp = tmp.child[tmpC - 'A'];
        }
        TrieNode startP = tmp;
        ArrayList<TrieNode> allWords = getWordsNodes(startP);
        for (int i = 0; i < allWords.size(); i++) {
            words.add(toWord(allWords.get(i)));
        }
        return words.toArray(new String[words.size()]);

    }

    String toWord(TrieNode node) {
        String word = "";
        Stack<Character> st = new Stack<>();
        while (node.prev != null) {
            st.push(node.info);
            node = node.prev;
        }
        while (!st.isEmpty()) {
            word += st.pop();
        }
        return word;
    }

    ArrayList<TrieNode> getWordsNodes(TrieNode node) {
        ArrayList<TrieNode> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (node.child[i] != null) {
                list.addAll(getWordsNodes(node.child[i]));
            }
        }
        if (node.isWord) {
            list.add(node);
        }
        return list;

    }

    int size() {
        return size(root);
    }

    int size(TrieNode node) {
        int size = 1;
        for (int i = 0; i < 26; i++) {
            if (node.child[i] != null) {
                size = size + size(node.child[i]);
            }
        }

        return size;
    }

    String[] permutations(String s) throws FileNotFoundException {
        s = s.toUpperCase();
        File inputFile = new File("Project/dictionary.txt");
        ArrayList<String> words = new ArrayList<>();
        Scanner sc = new Scanner(inputFile);
        String unwanted = "";
        String currentWord;
        for (int i = 0; i < 26; i++) {
            if (!s.contains(Character.toString((char) (65 + i))))
                unwanted += (char) (65 + i);
        }
        char[] unwantedChar = unwanted.toCharArray();
        boolean goodWord = true;
        while (sc.hasNextLine()) {
            currentWord = sc.nextLine();
            goodWord = true;
            for (int i = 0; i < unwantedChar.length; i++) {
                if (currentWord.contains(Character.toString(unwantedChar[i]))) {
                    goodWord = false;
                    break;
                }
            }
            if (currentWord.length() <= s.length() && goodWord)
                words.add(currentWord);
        }
        // for (int i = 0; i < 26; i++) {
        // if(!s.contains(Character.toString((char) (65 + i))))
        // unwantedChar[i] = (char) (65 + i);
        // }
        sc.close();
        return words.toArray(new String[words.size()]);
    }

}

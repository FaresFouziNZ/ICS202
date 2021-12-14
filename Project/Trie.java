import java.util.ArrayList;
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
        TrieNode tmp = root;
        for (int i = 0; i < s.length(); i++) {
            char tmpC = s.charAt(i);
            if (tmp.child[tmpC - 'A'] == null)
                tmp.child[tmpC - 'A'] = new TrieNode(tmpC);
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
        if (!isPrefix(p)) {
            System.out.println("No word contains this prefix");
            return null;
        }
        ArrayList<String> words;
        TrieNode tmp = root;
        char tmpC;

        for (int i = 0; i < p.length(); i++) {
            tmpC = p.charAt(i);
            tmp = tmp.child[tmpC - 'A'];
        }
        TrieNode startP = tmp;

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
}

public class TrieNode {
    char info;
    TrieNode[] child;
    TrieNode prev;
    boolean isWord = false;

    public TrieNode() {
        child = new TrieNode[26];
    }

    public TrieNode(char el) {
        info = el;
        child = new TrieNode[26];
    }
    public TrieNode(char el, TrieNode prev){
        info = el;
        child = new TrieNode[26];
        this.prev = prev;
    }

}

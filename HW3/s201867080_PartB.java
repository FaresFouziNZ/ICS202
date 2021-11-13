import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class s201867080_PartB {
     public static void main(String[] args) throws IOException {
          File in = new File(args[0]);
          File out = new File(args[1]);
          Scanner sc = new Scanner(in);
          FileWriter wr = new FileWriter(out);
          BST<Integer> x = new BST<>();

          while (sc.hasNextInt()) {
               x.insert(sc.nextInt());
          }
          wr.write("(a) " + x.leafCount() + "  (b) " + x.leftChildCounter() + "  (c)  " + x.rightChildCounter()
                    + "  (d)  " + x.inOrder() + "       (e)       ");
          x.mirror();
          wr.write(x.breadthFirst());
          wr.close();
          sc.close();

     }
}

class Queue<T> {
     private java.util.LinkedList<T> list = new java.util.LinkedList<T>();

     public Queue() {
     }

     public void clear() {
          list.clear();
     }

     public boolean isEmpty() {
          return list.isEmpty();
     }

     public T firstEl() {
          return list.getFirst();
     }

     public T dequeue() {
          return list.removeFirst();
     }

     public void enqueue(T el) {
          list.addLast(el);
     }

     public String toString() {
          return list.toString();
     }
}

class BSTNode<T extends Comparable<? super T>> {
     protected T el;
     protected BSTNode<T> left, right;

     public BSTNode() {
          left = right = null;
     }

     public BSTNode(T el) {
          this(el, null, null);
     }

     public BSTNode(T el, BSTNode<T> lt, BSTNode<T> rt) {
          this.el = el;
          left = lt;
          right = rt;
     }
}

class BST<T extends Comparable<? super T>> {
     protected BSTNode<T> root = null;

     public BST() {
     }

     public void clear() {
          root = null;
     }

     public boolean isEmpty() {
          return root == null;
     }

     public void insert(T el) {
          BSTNode<T> p = root, prev = null;
          while (p != null) { // find a place for inserting new node;
               prev = p;
               if (el.compareTo(p.el) < 0)
                    p = p.left;
               else
                    p = p.right;
          }
          if (root == null) // tree is empty;
               root = new BSTNode<T>(el);
          else if (el.compareTo(prev.el) < 0)
               prev.left = new BSTNode<T>(el);
          else
               prev.right = new BSTNode<T>(el);
     }

     public void recInsert(T el) {
          root = recInsert(root, el);
     }

     protected BSTNode<T> recInsert(BSTNode<T> p, T el) {
          if (p == null)
               p = new BSTNode<T>(el);
          else if (el.compareTo(p.el) < 0)
               p.left = recInsert(p.left, el);
          else
               p.right = recInsert(p.right, el);
          return p;
     }

     public boolean isInTree(T el) {
          return search(el) != null;
     }

     protected T search(T el) {
          BSTNode<T> p = root;
          while (p != null)
               if (el.equals(p.el))
                    return p.el;
               else if (el.compareTo(p.el) < 0)
                    p = p.left;
               else
                    p = p.right;
          return null;
     }

     public String inOrder() {
          return inOrder(root);
     }

     protected String visit(BSTNode<T> p) {
          return p.el + " ";
     }

     protected String inOrder(BSTNode<T> p) {
          String str = "";
          if (p != null) {
               str += inOrder(p.left);
               str += visit(p);
               str += inOrder(p.right);
          }
          return str;
     }

     public String breadthFirst() {
          String str = "";
          BSTNode<T> p = root;
          Queue<BSTNode<T>> queue = new Queue<BSTNode<T>>();
          if (p != null) {
               queue.enqueue(p);
               while (!queue.isEmpty()) {
                    p = queue.dequeue();
                    str += visit(p);
                    if (p.left != null)
                         queue.enqueue(p.left);
                    if (p.right != null)
                         queue.enqueue(p.right);
               }
          }
          return str;
     }

     public boolean isLeaf(BSTNode<T> node) {
          if (node.left == null && node.right == null)
               return true;
          return false;
     }

     public int leafCount() {
          return leafCount(root);
     }

     public int leafCount(BSTNode<T> x) {
          int count = 0;
          if (isLeaf(x)) {
               return 1;
          } else {
               if (x.right != null) {
                    count += leafCount(x.right);
               }
               if (x.left != null) {
                    count += leafCount(x.left);
               }
          }
          return count;

     }

     public int leftChildCounter() {
          return leftChildCounter(root);
     }

     public int leftChildCounter(BSTNode<T> x) {
          int count = 0;
          if (x.right != null) {
               count += leftChildCounter(x.right);
          }
          if (x.left != null) {
               count++;
               count += leftChildCounter(x.left);
          }

          return count;
     }

     public int rightChildCounter() {
          return rightChildCounter(root);
     }

     public int rightChildCounter(BSTNode<T> x) {
          int count = 0;
          if (x.right != null) {
               count += rightChildCounter(x.right);
          }
          if (x.left != null) {
               count++;
               count += rightChildCounter(x.left);
          }

          return count;
     }

     public void mirror() {
          mirror(root);
     }

     public void mirror(BSTNode<T> x) {
          BSTNode<T> tmp = x.right;
          x.right = x.left;
          x.left = tmp;
          mirror(x.right);
          mirror(x.left);
     }
}

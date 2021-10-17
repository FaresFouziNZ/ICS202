import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class s201867080_Q1 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner sc = new Scanner(new File(args[0]));
        FileWriter wr = new FileWriter(new File(args[1]));
        SLL<Integer> nums = new SLL<Integer>();
        while (sc.hasNextInt()) {
            int data = sc.nextInt();
            nums.addToTail(data);
        }
        nums.printAll();
        nums.deleteFromTail();
        nums.printAll();
        while (sc.hasNextLine()) {
            String data = sc.next();
            if (data.equals("ia")) {
                int num1 = sc.nextInt();
                int num2 = sc.nextInt();
                if (!nums.isInList(num2))
                    wr.write(-1 + System.lineSeparator());
                else {
                    nums.insertAfter(num1, num2);
                    wr.write(nums.printStr() + System.lineSeparator());
                }
            } else if (data.equals("ib")) {
                int num1 = sc.nextInt();
                int num2 = sc.nextInt();
                if (!nums.isInList(num2)) {
                    wr.write(-1 + System.lineSeparator());
                } else {
                    nums.insertBefore(num1, num2);
                    wr.write(nums.printStr() + System.lineSeparator());
                }
            } else {
                int num1 = sc.nextInt();
                if (!nums.isInList(num1))
                    wr.write(-1 + System.lineSeparator());
                else {
                    nums.deleteBefore(num1);
                    wr.write(nums.printStr() + System.lineSeparator());
                }
            }
        }
        sc.close();
        wr.close();

    }

}

class SLL<T> {
    protected SLLNode<T> head, tail;

    public SLL() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addToHead(T el) {
        head = new SLLNode<T>(el, head);
        if (tail == null)
            tail = head;
    }

    public void addToTail(T el) {
        if (!isEmpty()) {
            tail.next = new SLLNode<T>(el);
            tail = tail.next;
        } else
            head = tail = new SLLNode<T>(el);
    }

    public T deleteFromHead() { // delete the head and return its info;
        if (isEmpty())
            return null;
        T el = head.info;
        if (head == tail) // if only one node on the list;
            head = tail = null;
        else
            head = head.next;
        return el;
    }

    public T deleteFromTail() { // delete the tail and return its info;
        if (isEmpty())
            return null;
        T el = tail.info;
        if (head == tail) // if only one node in the list;
            head = tail = null;
        else { // if more than one node in the list,
            SLLNode<T> tmp; // find the predecessor of tail;
            for (tmp = head; tmp.next != tail; tmp = tmp.next)
                ;
            tail = tmp; // the predecessor of tail becomes tail;
            tail.next = null;
        }
        return el;
    }

    public void delete(T el) { // delete the node with an element el;
        if (!isEmpty())
            if (head == tail && el.equals(head.info)) // if only one
                head = tail = null; // node on the list;
            else if (el.equals(head.info)) // if more than one node on the list;
                head = head.next; // and el is in the head node;
            else { // if more than one node in the list
                SLLNode<T> pred, tmp;// and el is in a non-head node;
                for (pred = head, tmp = head.next; tmp != null
                        && !tmp.info.equals(el); pred = pred.next, tmp = tmp.next)
                    ;
                if (tmp != null) { // if el was found;
                    pred.next = tmp.next;
                    if (tmp == tail) // if el is in the last node;
                        tail = pred;
                }
            }
    }

    public void printAll() {
        for (SLLNode<T> tmp = head; tmp != null; tmp = tmp.next)
            System.out.print(tmp.info + " ");
        System.out.println();
    }

    public boolean isInList(T el) {
        SLLNode<T> tmp;
        for (tmp = head; tmp != null && !tmp.info.equals(el); tmp = tmp.next)
            ;
        return tmp != null;
    }

    public int length() {
        int num = 0;
        for (SLLNode<T> tmp = head; tmp != null; tmp = tmp.next) {
            num++;
        }
        return num;
    }

    public void insertAfter(T newElem, T existingElem) {
        if (!isInList(existingElem)) { // check if it in list
            System.out.println("Element: " + existingElem + " does not exist in the linked list. Insertion failed.");
        } else if (tail.info.equals(existingElem)) { // if the Elem was the tail
            addToTail(newElem);
        } else {
            SLLNode<T> tmp = head;
            boolean done = false;
            while (!done) {
                if (tmp.info.equals(existingElem)) {// founded
                    SLLNode<T> newN = new SLLNode<T>();
                    newN.info = newElem;
                    newN.next = tmp.next;
                    tmp.next = newN;
                    System.out.print("After inserting " + newElem + ", the list is>> ");
                    printAll();
                    done = true;
                } else {
                    tmp = tmp.next;
                }
            }
        }

    }

    public void insertBefore(T newElem, T existingElem) {
        if (!isInList(existingElem)) { // check if it in list
            System.out.println("Element: " + existingElem + " does not exist in the linked list. Insertion failed.");

        } else if (head.info.equals(existingElem)) { // if the Elem was the tail
            addToHead(newElem);
        } else {
            SLLNode<T> tmp = head;
            boolean done = false;
            while (!done) {
                if (tmp.next.info.equals(existingElem)) {// founded
                    SLLNode<T> newN = new SLLNode<T>();
                    newN.info = newElem;
                    newN.next = tmp.next;
                    tmp.next = newN;
                    System.out.print("After inserting " + newElem + ", the list is>> ");
                    printAll();
                    done = true;
                } else {
                    tmp = tmp.next;
                }
            }
        }
    }

    public void deleteBefore(T existingElem) {
        if (!isInList(existingElem)) { // check if it in list
            System.out.println("Element: " + existingElem + " does not exist in the linked list. delete failed.");
        } else if (head.info.equals(existingElem)) { // good
            System.out.println("No element before the head");
        } else {
            SLLNode<T> tmp = head;
            boolean done = false;
            if (tmp.next.info.equals(existingElem)) {// good
                deleteFromHead();
            } else {
                while (!done) {
                    if (tmp.next.next.info.equals(existingElem)) {
                        tmp.next = tmp.next.next;
                        System.out.print("After deleting the item before " + existingElem + ", the list is>> ");
                        printAll();
                        done = true;
                    } else {
                        tmp = tmp.next;
                    }
                }
            }
        }
    }

    public String printStr() {
        String str = "";
        for (SLLNode<T> tmp = head; tmp != null; tmp = tmp.next)
            str += tmp.info + " ";
        return str;
    }
}

class SLLNode<T> {
    public T info;
    public SLLNode<T> next;

    public SLLNode() {
        this(null, null);
    }

    public SLLNode(T el) {
        this(el, null);
    }

    public SLLNode(T el, SLLNode<T> ptr) {
        info = el;
        next = ptr;
    }

}

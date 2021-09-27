
//                  generic doubly linked list class

public class DLL<T> {
    private DLLNode<T> head, tail;

    public DLL() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void setToNull() {
        head = tail = null;
    }

    public T firstEl() {
        if (head != null)
            return head.info;
        else
            return null;
    }

    public void addToHead(T el) {
        if (head != null) {
            head = new DLLNode<T>(el, head, null);
            head.next.prev = head;
        } else
            head = tail = new DLLNode<T>(el);
    }

    public void addToTail(T el) {
        if (tail != null) {
            tail = new DLLNode<T>(el, null, tail);
            tail.prev.next = tail;
        } else
            head = tail = new DLLNode<T>(el);
    }

    public T deleteFromHead() {
        if (isEmpty())
            return null;
        T el = head.info;
        if (head == tail) // if only one node on the list;
            head = tail = null;
        else { // if more than one node in the list;
            head = head.next;
            head.prev = null;
        }
        return el;
    }

    public T deleteFromTail() {
        if (isEmpty())
            return null;
        T el = tail.info;
        if (head == tail) // if only one node on the list;
            head = tail = null;
        else { // if more than one node in the list;
            tail = tail.prev;
            tail.next = null;
        }
        return el;
    }

    public void printAll() {
        for (DLLNode<T> tmp = head; tmp != null; tmp = tmp.next)
            System.out.print(tmp.info + " ");
        System.out.println();
    }

    public T find(T el) {
        DLLNode<T> tmp;
        for (tmp = head; tmp != null && !tmp.info.equals(el); tmp = tmp.next)
            ;
        if (tmp == null)
            return null;
        else
            return tmp.info;
    }

    public void printReversed() {
        DLLNode<T> tmp = head;
        while (tmp.next != null) {// get the last elm
            tmp = tmp.next;
        }
        while (tmp.prev != null) {
            System.out.print(tmp.info + " ");
            tmp = tmp.prev;
        }
        System.out.print(tmp.info);
    }

    void deleteNode(DLLNode<T> tmp) {
        tmp = tmp.prev;
        tmp.next = tmp.next.next;
        tmp = tmp.next;
        tmp.prev = tmp.prev.prev;
    }

    public void delete7() {
        DLLNode<T> tmp = head;
        int number = 1;
        boolean deleted = false;
        if (isEmpty()) {
            System.out.println("The list is empty");
            deleted = true;
        }
        while (!deleted) {
            if (tmp.next == null && tmp.prev == null) {// only one elm
                deleteFromHead();
                deleted = true;
                break;
            }
            while (tmp.next != null) {
                tmp = tmp.next;
                number++;
                if (number == 7) {
                    if (tmp == tail) {
                        deleteFromTail();
                        deleted = true;
                        break;
                    } else {
                        deleteNode(tmp);
                        deleted = true;
                        break;
                    }
                }
            }
            while (tmp.prev != null) {
                tmp = tmp.prev;
                number++;
                if (number == 7) {
                    if (tmp == head) {
                        deleteFromHead();
                        deleted = true;
                        break;
                    } else {
                        deleteNode(tmp);
                        deleted = true;
                        break;
                    }
                }
            }

        }

    }
    public void insertAlternate(DLL<T> newList) {
        DLLNode<T> tmp = head;
        DLLNode<T> tmp2 = head;
    }
}
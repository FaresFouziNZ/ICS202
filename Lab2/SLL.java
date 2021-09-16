//**************************  SLL.java  *********************************
//           a generic singly linked list class 

public class SLL<T> {
    protected SLLNode<T> head, tail;
    public SLL() {
        head = tail = null;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public void addToHead(T el) {
        head = new SLLNode<T>(el,head);
        if (tail == null)
            tail = head;
    }
    public void addToTail(T el) {
        if (!isEmpty()) {
            tail.next = new SLLNode<T>(el);
            tail = tail.next;
        }
        else head = tail = new SLLNode<T>(el);
    }
    public T deleteFromHead() { // delete the head and return its info; 
        if (isEmpty()) 
             return null;
        T el = head.info;
        if (head == tail)       // if only one node on the list;
             head = tail = null;
        else head = head.next;
        return el;
    }
    public T deleteFromTail() { // delete the tail and return its info;
        if (isEmpty()) 
             return null;
        T el = tail.info;
        if (head == tail)       // if only one node in the list;
             head = tail = null;
        else {                  // if more than one node in the list,
             SLLNode<T> tmp;    // find the predecessor of tail;
             for (tmp = head; tmp.next != tail; tmp = tmp.next);
             tail = tmp;        // the predecessor of tail becomes tail;
             tail.next = null;
        }
        return el;
    }
    public void delete(T el) {  // delete the node with an element el;
        if (!isEmpty())
            if (head == tail && el.equals(head.info)) // if only one
                 head = tail = null;       // node on the list;
            else if (el.equals(head.info)) // if more than one node on the list;
                 head = head.next;    // and el is in the head node;
            else {                    // if more than one node in the list
                 SLLNode<T> pred, tmp;// and el is in a non-head node;
                 for (pred = head, tmp = head.next;  
                      tmp != null && !tmp.info.equals(el); 
                      pred = pred.next, tmp = tmp.next);
                 if (tmp != null) {   // if el was found;
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
        for (tmp = head; tmp != null && !tmp.info.equals(el); tmp = tmp.next);
        return tmp != null;
    }
    public int length(){
        int num=0;
      for(SLLNode<T> tmp = head; tmp != null; tmp = tmp.next){
          num++;
      }
      return num;
    }
    public void insertAfter(T newElem, T existingElem){
        if(!isInList(existingElem)){                            //check if it in list
            System.out.println("Element: "+existingElem+" does not exist in the linked list. Insertion failed.");
        }else if(tail.info.equals(existingElem)){     //if the Elem was the tail
            addToTail(newElem);
        }else{  
        SLLNode<T> tmp = head;
        boolean done = false;
        while(!done){
        if(tmp.info.equals(existingElem)){// founded
            SLLNode<T> newN = new SLLNode<T>();
            newN.info = newElem;
            newN.next = tmp.next;
            tmp.next = newN;
            done = true;
        }else{
            tmp = tmp.next;
        }}
        }
        
    }
    public void insertBefore(T newElem, T existingElem){
        if(!isInList(existingElem)){                            //check if it in list
            System.out.println("Element: "+existingElem+" does not exist in the linked list. Insertion failed.");
        }else if(head.info.equals(existingElem)){     //if the Elem was the tail
            addToHead(newElem);
        }else{
            SLLNode<T> tmp = head;
            boolean done = false;
            while(!done){
            if(tmp.next.info.equals(existingElem)){// founded
                SLLNode<T> newN = new SLLNode<T>();
                newN.info = newElem;
                newN.next = tmp.next;
                tmp.next = newN;
                done = true;
            }else{
                tmp = tmp.next;
            }}
        }
    }
    public void deleteBefore(T existingElem){
        if(!isInList(existingElem)){                            //check if it in list
            System.out.println("Element: "+existingElem+" does not exist in the linked list. delete failed.");
        }else if(){
            
        }
    }
    public void deleteAfter(T existingElem){}
}

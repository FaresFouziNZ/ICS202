public class testing {
    public static void main(String[] args) {
        BST<Integer> x = new BST<>();
        for (int i = 1; i < 10; i++) {
            x.insert(i);
        }
        
      System.out.println(  x.count());
   System.out.println(x.height());
        
    }
}

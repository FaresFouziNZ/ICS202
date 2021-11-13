import java.util.*;

public class TestAVL {
	public static void main(String[] args) {
		// Example which works with Left Rotation
		AVLTree<String> t = new AVLTree<String>();
		for (int i = 1; i <= 5; i++) {
			t.insertAVL("a" + i);
			System.out.print("After inserting the element a" + i + ", bfs is>> ");
			t.breadthFirst();
			System.out.println("\n====================");
		}

		System.out.print("Finally, bfs is>> ");
		t.breadthFirst();
		System.out.println("\n====================");
		
		// Exercise 2
		System.out.println("Exercise 2");
		int[] values = { 8, 14, 12, 18, 23, 20, 15, 13, 7, 16 };
		// TODO Complete the code here to solve exercise 2 in a similar fashion as the code above 
		// you should print the result of BFS of the AVL tree after each insertion
		
		
		
		// TODO Now delete the following elements: 15 16 13, and print BFS after each deletion
		
		
		System.out.println("Exercise 3");
		// TODO read the text file, insert unique words into the AVL tree and print its
		// inorder traversal


	}
}
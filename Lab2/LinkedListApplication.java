public class LinkedListApplication {
	public static void main(String[] args) {
		// SLL<String> myList = new SLL<String>();
		// for(int i = 0; i < 5; i++)
		// 	myList.addToHead("A" + i);
		// myList.printAll();
		// System.out.print(myList.length());
		SLL<Integer> myl = new SLL<Integer>();
		myl.addToHead(9);
		myl.addToHead(2);
		myl.addToHead(4);
		myl.addToHead(5);
		myl.addToHead(3);
		myl.printAll();
		myl.insertAfter(5, 2);
		myl.printAll();
		myl.insertBefore(1, 5);
		myl.printAll();
	}
}
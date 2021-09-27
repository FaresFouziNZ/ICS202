public class LinkedListApplication {
	public static void main(String[] args) {
		// SLL<String> myList = new SLL<String>();
		// for(int i = 0; i < 5; i++)
		// 	myList.addToHead("A" + i);
		// myList.printAll();
		// System.out.print(myList.length());
		SLL<String> myl = new SLL<String>();
		myl.addToHead("Mango");
		myl.addToTail("Avocado");
		myl.addToTail("Lime");
		myl.addToTail("Peach");
		myl.addToTail("Apple");
		myl.insertBefore("Fruits", "Apple");
		myl.insertAfter("Watermelon", "Lime");
	}
}
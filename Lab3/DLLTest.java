
public class DLLTest {
	public static void main(String[] args) {
		DLL<Integer> myl = new DLL<Integer>();
		myl.addToHead(1);
		myl.addToTail(2);
		myl.addToTail(3);
		myl.addToTail(4);
		DLL<Integer> myl2 = new DLL<Integer>();
		myl2.addToHead(5);
		myl2.addToTail(6);
		myl2.addToTail(7);
		myl2.addToTail(8);
		myl.insertAlternate(myl2);
		myl.printAll();
		}
}
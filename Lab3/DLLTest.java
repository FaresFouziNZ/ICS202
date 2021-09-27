
public class DLLTest {
	public static void main(String[] args) {
		DLL<String> test = new DLL<String>();
		for(int i = 0; i < 5; i++)
			test.addToTail("a" + i);
		//test.printAll();
		//test.printReversed();
		for(int i =0; i<2;i++){
		test.delete7();
		test.printAll();
	}}
}
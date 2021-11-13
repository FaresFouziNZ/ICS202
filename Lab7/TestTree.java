public class TestTree
{
	public static void main(String[] args) {
		BST<String> tree = new BST<String>();
		tree.insert("D");
		tree.insert("B");
		tree.insert("A");
		tree.insert("C");
		tree.insert("F");
		tree.insert("H");
		

		System.out.println(tree.getPath("C"));
		System.err.println(tree.getRightLeafCount());
		System.out.println(tree.rangeCounter("A", "D"));

		//Likewise test all other methods.

}}

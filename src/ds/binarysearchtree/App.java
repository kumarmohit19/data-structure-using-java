package ds.binarysearchtree;

public class App {

	public static void main(String[] args) {
		BST tree = new BST();
		
		tree.insert(60, "Sixty");
		tree.insert(100, "Hundered");
		tree.insert(140, "HunderedForty");
		tree.insert(160, "HunderedSixty");
		tree.insert(80, "Eighty");
		tree.insert(20, "Twenty");
		tree.insert(30, "Thirty");
		tree.insert(40, "Fourty");
		
		//System.out.println(tree.findMin());
		//System.out.println(tree.findMax());
		
		//System.out.println(tree.remove(10));
		//System.out.println(tree.findMin());
		
		//System.out.println(tree.getDepth(60));
		//System.out.println(tree.getDepth(100));
		//System.out.println(tree.getDepth(15));
		
		//System.out.println(tree.searchNode(15));
		
		
		tree.displayTree();
		//System.out.println(tree);
	}

}

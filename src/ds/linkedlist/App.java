package ds.linkedlist;

public class App {

	public static void main(String[] args) {
		Node nodeA = new Node();
		nodeA.data = 4;
		
		Node nodeB = new Node();
		nodeB.data = 4;
		
		Node nodeC = new Node();
		nodeC.data = 9;
		
		Node nodeD = new Node();
		nodeD.data = 7;
		
		nodeA.next = nodeB;
		nodeB.next = nodeC;
		nodeC.next = nodeD;
		System.out.println(listLength(nodeA));
		System.out.println(listLength(nodeB));
	}
	
	public static int listLength(Node node){
		int len = 0;
		while(node != null){
			len++;
			node = node.next;
		}
			
		return len;
	}

}

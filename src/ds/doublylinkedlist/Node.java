package ds.doublylinkedlist;

public class Node {
	public int data;
	public Node next;
	public Node prev;
	
	public void display(){
		System.out.println("{ ( "+(prev == null ? "empty": prev.data)+" ) <-- "+data+" --> ( "+(next == null ? "empty": next.data)+" ) }");
	}
}

package ds.singlylinkedlist;

public class SinglyLinkedList {
	private Node first;
	private Node last;
	
	public SinglyLinkedList(){
		
	}
	
	public boolean isEmpty(){
		return (first == null);
	}
	
	// used to insert at the beginning of the list
	public void insertFirst(int data){
		Node newNode = new Node();
		newNode.data = data;
		if(first == null)
			last = newNode;
		newNode.next = first;
		first = newNode;
	}
	
	public Node deleteFirst(){
		Node temp = first;
		first = first.next;
		return temp;
	}
	
	public void diplayList(){
		System.out.println("List (first --> last");
		Node current = first;
		while(current != null){
			current.displayNode();
			current = current.next;
		}
	}
	
	public void insertLast(int data){
//		Node current = last;
//		while(current.next != null){
//			current= current.next;// we'll loop until current.next is null
//		}
		Node newNode = new Node();
		newNode.data = data;
		last.next = newNode;
		last = newNode;
	}
}

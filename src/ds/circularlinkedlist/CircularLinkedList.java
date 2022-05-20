package ds.circularlinkedlist;

import ds.singlylinkedlist.Node;

public class CircularLinkedList {
	private Node first;
	private Node last;

	public CircularLinkedList() {
		first = null;
		last = null;
	}

	private boolean isEmpty() {
		return (first == null);
	}

	public void insertFirst(int data) {
		Node newNode = new Node();
		newNode.data = data;

		if (isEmpty()) {
			last = newNode;
		}
		newNode.next = first; // newNode --> old first
		first = newNode; // first place
	}
	
	public void insertLast(int data){
		Node newNode = new Node();
		newNode.data = data;
		if(isEmpty()){
			first = newNode;
			last = newNode;
		} else{
			last.next = newNode;// the next value of last node will point to new node
			last = newNode;// we make the new node we created as the last node in the list
		}
	}
	
	public int deleteFirst(){
		int temp = first.data;
		if(first.next == null){
			last = null;
		}
		
		first = first.next;// first will point to old's next
		return temp;
	}
	
	public void displayList(){
		System.out.println("List (first --> last");
		Node current = first;
		while(current != null){
			current.displayNode();
			current = current.next;
		}
	}

}

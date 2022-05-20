package ds.doublylinkedlist;

public class DoublyLinkedList {
	private Node first;
	private Node last;
	
	public DoublyLinkedList(){
		this.first = null;
		this.last = null;
	}
	
	public boolean isEmpty(){
		return (first == null);
	}
	
	public void insertFirst(int data){
		Node newNode = new Node();
		newNode.data = data;
		
		if(isEmpty()){
			last = newNode; // if the list is empty last will point to the new node being created 
		} else{
			first.prev = newNode;
		}
		
		newNode.next = first; // new node next next file will point to old first
		this.first = newNode;
	}
	
	public void insertLast(int data){
		Node newNode = new Node();
		newNode.data = data;
		
		if(isEmpty()){
			first = newNode;
		} else{
			last.next = newNode;// assigning old last to new node
		}
		
		newNode.prev = last; // old last will be the new node
		last = newNode;
	}
	
	public void diplayForward(){
		System.out.println("List first --> last");
		Node current = first;
		while(current != null){
			current.display();
			current = current.next;
		}
	}
	
	public void diplayBackward(){
		System.out.println("List last --> first");
		Node current = last;
		while(current != null){
			current.display();
			current = current.prev;
		}
	}
	
	// assume non-empty list
	public Node deleteFirst(){
		Node temp = first;
		if(first.next == null){// there is only one item in the list
			last = null;
		} else{
			first.next.prev = null; // modified list first node should point to null
		}
		first = first.next; // we are assigning the reference of the node following the old first node to the first field in the linked list object 
		return temp;// return the deleted first node
	}
	
	// assume non-empty list
	public Node deleteLast(){
		Node temp = last;
		if(last.prev == null){// when we only have one node in the list
			first = null;
		} else{
			last.prev.next = null; // modified list last node should point to null
		}
		last = last.prev;
		return temp;
	}
	
	// assume non-empty list
	public boolean insertAfter(int key, int data){
		Node current = first; // we start from the beginning of the loop
		while(current.data != key){ // as long as we have not found the key in a particular node
			current = current.next;
			if(current == null){
				return false;
			}
		}
		
		Node newNode = new Node();
		newNode.data = data;
		if(current == last){
			current.next = null;
			last = newNode;
		} else{
			newNode.next = current.next; // new node next field should point to the node ahead of the current one
			current.next.prev = newNode; // the node ahead of current, its previous field should point to new node 
		}
		
		newNode.prev = current;
		current.next = newNode;
		
		return true;
	}
	
	// assume a non-empty list
	public Node deleteKey(int key){
		Node current = first; // we start from the beginning of the loop
		while(current.data != key){ // as long as we have not found the key in a particular node
			current = current.next;
			if(current == null){
				return null;
			}
		}
		
		Node temp = current;
		if(current == last){
			return deleteLast();
		}
		else if(current == first){
			return deleteFirst();
		} 
		else {
			current.prev.next = current.next;
			current.next.prev = current.prev;
			return temp;	
		}
	}
	
}

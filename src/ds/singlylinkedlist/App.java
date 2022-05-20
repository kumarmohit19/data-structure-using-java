package ds.singlylinkedlist;

public class App {

	public static void main(String[] args) {
		SinglyLinkedList myList = new SinglyLinkedList();
		myList.insertFirst(90);
		myList.insertFirst(45);
		myList.insertFirst(70);
		myList.insertFirst(78);
		myList.insertFirst(5);
		
		myList.insertLast(99999);
		myList.insertLast(55555);
		
		myList.diplayList();
	}

}

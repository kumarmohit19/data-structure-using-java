package ds.circularlinkedlist;

public class App {

	public static void main(String[] args) {
		CircularLinkedList myList = new CircularLinkedList();
		myList.insertLast(90);
		myList.insertFirst(45);
		myList.insertFirst(70);
		myList.insertFirst(78);
		myList.insertFirst(5);
		myList.displayList();
		myList.insertLast(99999);
		myList.insertLast(55555);
		
		myList.displayList();

	}

}

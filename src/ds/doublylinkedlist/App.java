package ds.doublylinkedlist;

public class App {

	public static void main(String[] args) {
		DoublyLinkedList myList = new DoublyLinkedList();
		
		myList.insertFirst(45);
		myList.diplayForward();
		myList.insertFirst(70);		
		myList.insertLast(90000);
		myList.insertFirst(78);
		myList.insertFirst(5);
		myList.insertLast(99999);
		myList.insertLast(55555);
		myList.diplayForward();
		System.out.println(myList.deleteKey(78).data);
		myList.diplayForward();
		
//		System.out.println(myList.deleteLast().data);
//		myList.diplayList();

	}

}

package ds.queue;

public class App {

	public static void main(String[] args) {
		Queue myQueue = new Queue(5);
		myQueue.insert(10);
		myQueue.insert(7);
		myQueue.insert(987);
		myQueue.insert(78);
		myQueue.insert(6);
		myQueue.insert(9);
		myQueue.view();

	}

}

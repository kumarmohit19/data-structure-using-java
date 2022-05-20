package ds.queue;

public class Queue {
	private int maxSize; // initializes the set number of slots
	private long[] queArray; // slots to maintain the data
	private int front; // index position of the elements in the front
	private int rear; // index position for the element at the back
	private int nItems; // counter to maintain the items in the queue

	public Queue(int size) {
		this.maxSize = size;
		this.queArray = new long[maxSize];
		front = 0; // index position of the first slot of the array
		rear = -1; // there is no item in the array yet to be considered as the
					// last item
		nItems = 0; // we don't have elements in the array yet
	}

	public void insert(long j) {
		if (rear == maxSize - 1) {
			rear = -1;
		}
		rear++;
		queArray[rear] = j;
		nItems++;

	}

	public long remove() { // remove item from the front of the queue
		long temp = queArray[front];
		front++;
		if (front == maxSize) {
			front = 0; // we can set front back to 0th index so that we can
						// utilize the entire array again
		}
		nItems--;
		return temp;

	}

	public long peakFront() {
		return queArray[front];
	}

	public boolean isEmpty() {
		return (nItems == 0);
	}

	public boolean isFull() {
		return (nItems == maxSize);
	}

	public void view() {
		System.out.print("[ ");
		for (long i : queArray) {
			System.out.print(i + " ");
		}
		System.out.print("] ");
	}

}

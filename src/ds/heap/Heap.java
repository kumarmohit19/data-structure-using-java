package ds.heap;

public class Heap {
	private Node[] heapArray;
	private int maxSize; // size of the array
	private int currentSize; // number of nodes in the array

	public Heap(int size) {
		this.maxSize = size;
		currentSize = 0;
		heapArray = new Node[size]; // actually created the array
	}

	public int getSize() {
		return currentSize;
	}

	public boolean isEmpty() {
		return (currentSize == 0);
	}

	public boolean insert(int key) {
		if (currentSize == maxSize)
			return false; // array is full

		Node newNode = new Node(key);
		heapArray[currentSize] = newNode;

		trickleUp(currentSize);
		currentSize++;

		return true;
	}

	private void trickleUp(int idx) {
		int parentIdx = (idx - 1) / 2;
		Node nodeToInsert = heapArray[idx];

		// loop as long as we haven't reached the root and key of nodeToInsert's parent is less than new node
		while (idx > 0 && heapArray[parentIdx].getKey() < nodeToInsert.getKey()) {
			heapArray[idx] = heapArray[parentIdx]; // move the parent down
			idx = parentIdx;
			parentIdx = (parentIdx - 1) / 2; // move up
		}
		
		heapArray[idx] = nodeToInsert;

	}
	
	public Node remove(){
		Node root = heapArray[0];
		
		currentSize--;
		heapArray[0] = heapArray[currentSize];
		
		trickleDown(0);
		
		return root;
	}

	private void trickleDown(int idx) {
		int largerChildIdx;
		Node top = heapArray[idx]; // save last node into top variable
		
		// will run as long as idx is not on the bottom row (at least 1 child)
		while(idx < currentSize/2){
			int leftChild = 2*idx + 1; // left child idx position
			int rightChild= leftChild + 1; // right child idx position
			
			// figure out which child is larger
			if(rightChild < currentSize &&
					heapArray[leftChild].getKey() < heapArray[rightChild].getKey()){
				largerChildIdx= rightChild;
			} else {
				largerChildIdx= leftChild;
			}
			
			if(top.getKey() >= heapArray[largerChildIdx].getKey()){
				// successfully made root the largest key
				break;
			}
			
			heapArray[idx] = heapArray[largerChildIdx];
			idx= largerChildIdx; // go down
				
		}
		
		heapArray[idx] = top;
		
	}

}

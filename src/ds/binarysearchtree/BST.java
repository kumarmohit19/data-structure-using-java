package ds.binarysearchtree;

import java.util.Arrays;

import ds.stack.Stack;

public class BST {

	private Node root;

	public void insert(int key, String value) {

		Node newNode = new Node(key, value);

		if (root == null) {
			root = newNode;
		} else {
			Node current = root;
			Node parent;

			while (true) {
				parent = current;
				if (key < current.key) {
					current = current.leftChild;
					if (current == null) {// It's parent is the left node
						parent.leftChild = newNode;
						return;
					}
				} else {
					current = current.rightChild;
					if (current == null) {// It's parent is the right node
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}

	public Node findMin() {
		Node current = root;
		Node last = null;

		while (current != null) {
			last = current;
			current = current.leftChild;
		}
		return last;
	}

	public Node findMax() {
		Node current = root;
		Node last = null;

		while (current != null) {
			last = current;
			current = current.rightChild;
		}
		return last;
	}

	private void getTree(Node startNode, int n, int[] arr,boolean leftNode) {
		if(startNode == null) 
			return;
		else if (startNode == root){
			arr[n] = root.key;
			//System.out.println(Arrays.toString(arr));
			getTree(startNode.leftChild, n, arr, true);
			getTree(startNode.rightChild, n, arr, false);
		}
		else if(leftNode){
			int temp = 2*n + 1;
			arr[temp]= startNode.key;
			//System.out.println(Arrays.toString(arr));
			getTree(startNode.leftChild, temp, arr, true);
			getTree(startNode.rightChild, temp, arr, false);
		} 
		else{
			int temp = 2*n + 2;
			arr[temp]= startNode.key;
			//System.out.println(Arrays.toString(arr));
			getTree(startNode.leftChild, temp, arr, true);
			getTree(startNode.rightChild, temp, arr, false);
		}
	}

	public void displayTree() {
		int depth = calcDepth(root);
		int[] arr = new int[(int) Math.pow(2, depth)-1];
		Arrays.fill(arr, -1);
		getTree(root, 0, arr, true);
		
		int counter= 0;
		int level=0;
		while(depth>0){
			int size = (int) Math.pow(2, counter);
			for(int i=level; i < size+level; i++){
				if(depth==1 && i< size+level)System.out.print(getSpaces(2*(depth-1)+2)+getValue(arr[i]));
				else System.out.print(getSpaces(2*(depth-1)+1)+getValue(arr[i]));
				
			}
			
			depth--;
			level+=size;
			counter++;
			System.out.println("");
		}
	}
	
	private String getValue(int key){
		if(key == -1) return "--";
		else return key+"";
	}

	private void getTreeStructure(Node startNode, int count) {
		if (startNode == null) {
			System.out.print("--");
			System.out.print("\n");
			return;
		}
		getTreeStructure(startNode.leftChild, count - 1);
		System.out.print(getSpaces(count) + (startNode.key) + getSpaces(count));
		getTreeStructure(startNode.rightChild, count - 1);
		// System.out.print("\n");
	}

	private String getSpaces(int count) {
		StringBuilder str = new StringBuilder("");
		while (0 < count--) {
			str.append("\t");
		}
		return str.toString();
	}

	public String toString() {
		return getTreeData(root);
	}

	private String getTreeData(Node startNode) {
		if (startNode == null)
			return "--";
		else
			return startNode.key + " = ( " + getTreeData(startNode.leftChild) + " , "
					+ getTreeData(startNode.rightChild) + " )";
	}

	public boolean remove(int key) {

		Node currentNode = root;
		Node parentNode = root;

		boolean isLeftChild = false;

		// searching to find the node with the key to delete
		while (currentNode.key != key) {
			parentNode = currentNode;
			if (key < currentNode.key) {
				isLeftChild = true;
				currentNode = currentNode.leftChild;
			} else {
				currentNode = currentNode.rightChild;
				isLeftChild = false;
			}

			if (currentNode == null)
				return false;
		}

		// found the node
		Node nodeToDelete = currentNode;

		// if node is a leaf
		if (nodeToDelete.leftChild == null && nodeToDelete.rightChild == null) {
			// to check if the node to delete is the root node
			if (nodeToDelete == root) {
				root = null;
			} else if (isLeftChild) {
				parentNode.leftChild = null;
			} else {
				parentNode.rightChild = null;
			}
		}
		// if node has one child that is on the left
		else if (nodeToDelete.rightChild == null) {
			// to check if the node to delete is the root node
			if (nodeToDelete == root) {
				root = nodeToDelete.leftChild;
			} else if (isLeftChild) {
				parentNode.leftChild = nodeToDelete.leftChild;
			} else {
				parentNode.rightChild = nodeToDelete.leftChild;
			}
		}
		// if node has one child that is on the right
		else if (nodeToDelete.leftChild == null) {
			// to check if the node to delete is the root node
			if (nodeToDelete == root) {
				root = nodeToDelete.rightChild;
			} else if (isLeftChild) {
				parentNode.leftChild = nodeToDelete.rightChild;
			} else {
				parentNode.rightChild = nodeToDelete.rightChild;
			}
		}
		// if node has 2 children (tricky)
		else {
			Node successor = getSuccesor(nodeToDelete);

			// connect parent of nodeToDelete to successor instead
			if (nodeToDelete == root) {
				root = successor;
			} else if (isLeftChild) {
				parentNode.leftChild = successor;
			} else {
				parentNode.rightChild = successor;
			}

			successor.leftChild = nodeToDelete.leftChild;
		}
		return true;
	}

	private Node getSuccesor(Node nodeToDelete) {
		Node successorParent = nodeToDelete;
		Node successor = nodeToDelete;

		Node current = nodeToDelete.rightChild;// go to right child
		while (current != null) {// start going left down the tree until node
									// has no left child
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}

		// if successor not a right child
		if (successor != nodeToDelete.rightChild) {
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = nodeToDelete.rightChild;
		}
		return successor;
	}

	public int getDepth(int key) {
		if (root == null)
			return -1;
		else if (root.key == key)
			return calcDepth(root);
		else
			return searchNode(key) == null ? -1 : calcDepth(searchNode(key));
	}

	private int calcDepth(Node startNode) {
		if (startNode == null)
			return 0;
		else
			return Math.max(calcDepth(startNode.leftChild), calcDepth(startNode.rightChild)) + 1;
	}

	public Node searchNode(int key) {
		Node nodeToSearch = root;
		while (nodeToSearch != null) {
			if (nodeToSearch.key == key)
				return nodeToSearch;
			else if (nodeToSearch.key < key)
				nodeToSearch = nodeToSearch.rightChild;
			else
				nodeToSearch = nodeToSearch.leftChild;
		}
		return null;

	}
	
	/*public void displayTreeTutor() {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("......................................................");
        
        while(isRowEmpty==false) {
            Stack localStack = new Stack();
            isRowEmpty = true;
            for(int j=0; j<nBlanks; j++) {
                System.out.print(" ");
            }
                
            while(globalStack.isEmpty()==false) {
                Node temp = (Node)globalStack.pop(); 
                if(temp != null) {
                    System.out.print(temp.key); 
                    localStack.push(temp.leftChild); 
                    localStack.push(temp.rightChild);
                    if(temp.leftChild != null || temp.rightChild != null) {
                        isRowEmpty = false; 
                    }
                } else {
                    System.out.print("--"); 
                    localStack.push(null); 
                    localStack.push(null);
                }
                
                for(int j=0; j<nBlanks*2-2; j++) {
                    System.out.print(" ");
                }
            }
            
            System.out.println();
            nBlanks = nBlanks/2;
            
            while(localStack.isEmpty()==false)
                globalStack.push( localStack.pop() ); 
            }
        System.out.println( "......................................................");
 
 }*/

}

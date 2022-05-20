package ds.grapth;

public class BetterGraph {
	
	private Vertex[] arrayOfLists;
	private int indexCounter= 0;
	private boolean undirected= true;
	
	class Node {
		public int vertedIdx;
		public Node next;

		public Node(int vertedIdx, Node aNode) {
			this.vertedIdx = vertedIdx;
			next = aNode;
		}

	}
	
	class Vertex {
		String name;
		Node adjList;

		Vertex(String name, Node aNode) {
			this.name = name;
			adjList = aNode;
		}
	}
	
	
	public BetterGraph(int vCount, String graphType) {
		
		if(graphType.equals("directed")) undirected = false;
		
		arrayOfLists = new Vertex[vCount];
		
	}

	public void addVertex(String vertexName) {
		arrayOfLists[indexCounter] = new Vertex(vertexName, null);
		indexCounter++;		
	}

	public void addEdge(String srcVertexName, String destVertexName) {
		int v1Idx = indexForName(srcVertexName);
		int v2Idx = indexForName(destVertexName);
		
		arrayOfLists[v1Idx].adjList = new Node(v2Idx, arrayOfLists[v1Idx].adjList);
		if(undirected)
			arrayOfLists[v2Idx].adjList = new Node(v1Idx, arrayOfLists[v2Idx].adjList);
		
	}

	private int indexForName(String srcVertexName) {
		for(int v = 0; v < arrayOfLists.length; v++){
			if(arrayOfLists[v].name.equals(srcVertexName))
				return v;
		}
		return -1;
	}

	public void print() {
		System.out.println();
		for(int v =  0; v < arrayOfLists.length; v++){
			System.out.print(arrayOfLists[v].name);
			for(Node aNode = arrayOfLists[v].adjList; aNode != null; aNode= aNode.next){
				System.out.print(" ---> " + arrayOfLists[aNode.vertedIdx].name);
			}
			System.out.println("\n");
		}
		
	}
	
}

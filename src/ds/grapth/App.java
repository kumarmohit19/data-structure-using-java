package ds.grapth;

public class App {

	public static void main(String[] args) {
//		runSimpleGraph();
		runBetterGraph();
		
	}
	
	public static void runSimpleGraph(){
		Graph myGraph = new Graph(5);
		myGraph.addEdge(0, 1);
		myGraph.addEdge(0, 3);
		myGraph.addEdge(0, 4);
		myGraph.addEdge(1, 2);
		myGraph.addEdge(1, 4);
		myGraph.addEdge(2, 3);
		myGraph.addEdge(3, 1);
		myGraph.addEdge(4, 0);
		myGraph.addEdge(4, 3);
		
		Object[] values= myGraph.adj(0);
		for(Object val : values){
			System.out.println(val);
		}
	}
	
	public static void runBetterGraph(){
		BetterGraph myGraph = new BetterGraph(5, "directed");
		
		myGraph.addVertex("State");
		myGraph.addVertex("Avanel");
		myGraph.addVertex("Elm");
		myGraph.addVertex("Pocono");
		myGraph.addVertex("William");
		
		
		myGraph.addEdge("State", "Avanel");
		myGraph.addEdge("State", "Elm");
		myGraph.addEdge("Elm", "Avanel");
		myGraph.addEdge("Elm", "William");
		myGraph.addEdge("William", "State");
		myGraph.addEdge("William", "Pocono");
		myGraph.addEdge("Avanel", "Pocono");
		myGraph.addEdge("Pocono", "Elm");
		
		myGraph.print();
	}
	
}

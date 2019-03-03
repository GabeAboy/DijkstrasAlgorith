
public class Dijkstras {
	public static void main(String[] args) {
		System.out.println("hello world");
    	// Create Graph object
    	Graph AdjGraph = new Graph(9);
    	
    	// Add all edges
    	AdjGraph.addEdge(1, 2);
    	AdjGraph.addEdge(1, 3);
    	AdjGraph.addEdge(2, 3);
    	AdjGraph.addEdge(2, 4);
    	AdjGraph.addEdge(2, 5);
    	AdjGraph.addEdge(3, 7);
    	AdjGraph.addEdge(3, 5);
  
    	AdjGraph.addEdge(3, 8);
    	AdjGraph.addEdge(4, 5);
    	AdjGraph.addEdge(5, 6);
    	AdjGraph.addEdge(7, 8);
    	
    	// Print Graph
    	AdjGraph.printGraph();
	
	}
	
}

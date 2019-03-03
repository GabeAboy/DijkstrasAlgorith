import java.util.LinkedList;

public class DirectedGraph {
	// Size
	private int vertices;
	private LinkedList<Node> adjacencyList[]; 
	DirectedGraph(int vertices){
		this.vertices = vertices;
		adjacencyList = new LinkedList[vertices]; 
        
        // Create a new list number of vertices
        for(int i = 0; i < vertices ; i++){ 
        	adjacencyList[i] = new LinkedList<>(); 
        } 
	}
	  // Adds an edge to an undirected graph 
    public void addEdge( int vertices, int node, int weight) 
    { 
    	 // Since graph is directed, every node vertices points to a node
    	
    	// After init the graph invariants are infinity
    	Node x  = new Node(node, weight, Double.POSITIVE_INFINITY);
        this.adjacencyList[vertices].add(x); 
      
    }
    public void printGraph() 
    {        
        for(int v = 0; v < this.vertices; v++) 
        { 
            System.out.println("Node "+ v +" connects to"); 
            System.out.print("Linked list nodes, Head"); 
            for(Node node: this.adjacencyList[v]){ 
                System.out.println(" -> "  );
                node.printNode();
            } 
            System.out.println("\n"); 
        } 
    } 

}

import java.util.LinkedList;

public class DirectedGraph {
	int vertices;
	LinkedList<Integer> adjacencyList[]; 
	DirectedGraph(int vertices){
		this.vertices = vertices;
		adjacencyList = new LinkedList[vertices]; 
        
        // Create a new list number of vertices
        for(int i = 0; i < vertices ; i++){ 
        	adjacencyList[i] = new LinkedList<>(); 
        } 
	}
	  // Adds an edge to an undirected graph 
    void addEdge( int vertices, int node, int weight) 
    { 
    	 // Since graph is directed, every node vertices points to a node
    	// TODO we need to add an object node not a int node
        this.adjacencyList[vertices].add(node); 
      
    }
    void printGraph() 
    {        
        for(int v = 0; v < this.vertices; v++) 
        { 
            System.out.println("Node "+ v +" connects to"); 
            System.out.print("Linked list nodes, Head"); 
            for(Integer node: this.adjacencyList[v]){ 
                System.out.print(" -> " + node); 
            } 
            System.out.println("\n"); 
        } 
    } 

}

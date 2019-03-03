import java.util.LinkedList;

public class Graph {
	int vertices;
	LinkedList<Integer> adjacencyList[]; 
	Graph(int vertices){
		this.vertices = vertices;
		adjacencyList = new LinkedList[vertices]; 
        
        // Create a new list number of vertices
        for(int i = 0; i < vertices ; i++){ 
        	adjacencyList[i] = new LinkedList<>(); 
        } 
	}
	  // Adds an edge to an undirected graph 
    void addEdge( int vertices, int node) 
    { 
    	 // Since graph is undirected, add an edge from and forth vertices and node
        this.adjacencyList[vertices].add(node); 
        this.adjacencyList[node].add(vertices); 
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

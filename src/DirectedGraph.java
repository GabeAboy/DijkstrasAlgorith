import java.util.*;
public class DirectedGraph {
	// Size
	private int vertices;
	LinkedList<Node> adjacencyList[]; 
	HashMap nodeInfo;
	DirectedGraph(int vertices){
		this.vertices = vertices;
		adjacencyList = new LinkedList[vertices];
		nodeInfo = new HashMap();
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
    	Node x  = new Node(node, weight, Integer.MAX_VALUE, vertices);
    	nodeInfo.put(vertices,Integer.MAX_VALUE);
        nodeInfo.put(node,Integer.MAX_VALUE);
    	this.adjacencyList[vertices].add(x); 
      
    }
    public int getSize() {
    	return this.vertices;
    }
    public void printHashMap() {
    	for (Object i : this.nodeInfo.keySet()) {
    		  System.out.println("key: " + i + " value: " + nodeInfo.get(i));
    		}
    }
    public int getInvarient(int node) {   
    	int solution =  (int) nodeInfo.get(node);
//    	System.out.println(solution);
//    	System.out.println(solution==(int)Integer.MAX_VALUE);
    	if(solution == (int)Integer.MAX_VALUE) {
    		return 0;
    	}
    	return solution;
//    	return solution==Integer.MAX_VALUE ? 0 : solution;
    }
    public void setInvarient(int node, int distance) {
    	nodeInfo.put(node,distance);
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

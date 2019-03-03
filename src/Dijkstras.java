import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstras {
	public static void main(String[] args) {
		System.out.println("hello world");
    	// Create Graph object
    	DirectedGraph DirectedGraph = new DirectedGraph(9);
    	
    	// Add all 15 edges
    	DirectedGraph.addEdge(1, 2, 9);
    	DirectedGraph.addEdge(1, 6, 14);
    	DirectedGraph.addEdge(1, 7, 15);    	
    	DirectedGraph.addEdge(2, 3, 23);   	
    	DirectedGraph.addEdge(3, 8, 19);
    	DirectedGraph.addEdge(3, 5, 2);  	
    	DirectedGraph.addEdge(4, 8, 6);
    	DirectedGraph.addEdge(4, 3, 6);  	
    	DirectedGraph.addEdge(5, 4, 11);
    	DirectedGraph.addEdge(5, 8, 16);    	
    	DirectedGraph.addEdge(6, 7, 5);
    	DirectedGraph.addEdge(6, 5, 30);
    	DirectedGraph.addEdge(6, 3, 18);
    	DirectedGraph.addEdge(7, 5, 20);
    	DirectedGraph.addEdge(7, 8, 44);

		Comparator<Node> LectureStartTimeComparator = new Comparator<Node>() {
            public int compare(Node one, Node two) {
                return one.getShortestPath() - two.getShortestPath();
            }
        };
        PriorityQueue<Node> LecturePriorityQueue = new PriorityQueue<>(LectureStartTimeComparator);     
		
        for(int i = 0; i<DirectedGraph.getSize(); i++) {
        	for( Node x : DirectedGraph.adjacencyList[i]) {
        		x.printNode();
        	}
        }
    	
    	// Print Graph
//    	DirectedGraph.printGraph();
    	
//    	Node x = new Node(1, 14);
//    	x.printNode();
    	
    	
    	Dijkstra(1,2);
	}
	public static void Dijkstra(int g, int s) {

		// get invariant of s = 0
		
		//Initialize Q of V with pi(v) <- infinity for each node v in V
		
		//S <- {}, pi(s) <- 0
		//while (Q is not empty){
			//v = ExtractMin(Q)
			//Add v to S
			// for each edge e=(v,w) such that w does not exist in S{
				// if(pi(v) + Ie < pi(w)){
					//pi(w)=pi(v)+Ie
					//ChangeKey(Q,w,pi(w))
				//}
			//}
		//}
	}
	
}

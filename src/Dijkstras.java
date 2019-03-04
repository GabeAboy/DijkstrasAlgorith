import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
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

//		DirectedGraph.printHashMap();
		

    	// Print Graph
//    	DirectedGraph.printGraph();
    	
//    	Node x = new Node(1, 14);
//    	x.printNode();
    	
    	
    	Dijkstra(DirectedGraph, 1);
	}
	public static void Dijkstra(DirectedGraph G, int s) {
		 
		// get invariant of s = 0
		G.getInvarient(s);
		G.setInvarient(s, 0);
		for (Object i : G.nodeInfo.keySet()) {
			  System.out.println("key: " + i + " value: " + G.nodeInfo.get(i));
			}
		G.getInvarient(s);
		G.getInvarient(2);
		//Initialize Q of V with pi(v) <- infinity for each node v in V
		Comparator<Vert> LectureStartTimeComparator = new Comparator<Vert>() {
            public int compare(Vert one, Vert two) {
                return one.getInvarient() - two.getInvarient();
            }
        };
        PriorityQueue<Vert> LocationNodePriorityQueue = new PriorityQueue<>(LectureStartTimeComparator);   
        
        System.out.println("Inserting to Graph");
        //Initialize Priority Queue
        for(int i = 1; i<G.getSize()+1; i++) {
        	Vert n;
        	n = i==s ? new Vert(i,0) : new Vert(i,(int)Integer.MAX_VALUE); 
        	LocationNodePriorityQueue.add(n);
        }
       
        while(!LocationNodePriorityQueue.isEmpty()) {
        	Vert NodeWithMin = LocationNodePriorityQueue.poll();
        	System.out.println(NodeWithMin.getid());
        }
		//S <- {},
        ArrayList<Node> Visited = new ArrayList<Node>();
        //pi(s) <- 0
        System.out.println("\n Reading From Queue");
//		while (!LocationNodePriorityQueue.isEmpty()){
//			//v = ExtractMin(Q)
//			Node NodeWithMinInvarient = LocationNodePriorityQueue.poll();
//			//Add v to S
////			NodeWithMinInvarient.printNode();
//			Visited.add(NodeWithMinInvarient);
//			
//			// for each edge e=(v,w) 
//			for( Node n : G.adjacencyList[NodeWithMinInvarient.getId()] ) {
//				//such that w does not exist in S{
//				if(Visited.contains(n)) {
//					continue;
//				}
//				//pi(v) + Ie < pi(w)
//				n.printNode();
//				int x = n.getDistance();
//				int y =G.getInvarient(NodeWithMinInvarient.getPredecesor());
//				for (Object i : G.nodeInfo.keySet()) {
//					  System.out.println("key: " + i + " value: " + G.nodeInfo.get(i));
//					}
//				int distanceFromPredecesor = G.getInvarient(NodeWithMinInvarient.getId())
//											+ G.getInvarient(NodeWithMinInvarient.getPredecesor());
//				System.out.println("Distance "+ x +"plus"+y);
//				System.out.println(distanceFromPredecesor < G.getInvarient(n.getId()));
//				 if(distanceFromPredecesor < G.getInvarient(n.getId())){
//					//pi(w)=pi(v)+Ie
//					 G.setInvarient(n.getId(), distanceFromPredecesor);
//	
//					 //ChangeKey(Q,w,pi(w))
//					 LocationNodePriorityQueue.remove(n);
//					 n.setShortestPath(distanceFromPredecesor);
//					 LocationNodePriorityQueue.add(n);
//				}
//			}
//		}
		System.out.println("Visited");
		for(Node p : Visited) {
			System.out.println(p.getPredecesor());
		}
	}
	
}

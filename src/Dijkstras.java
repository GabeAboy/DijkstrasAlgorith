import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
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
       
    		Map<Integer, Vert> map = new HashMap<Integer, Vert>();
        //Initialize Priority Queue
        for(int i = 1; i<G.getSize()+1; i++) {
        	Vert n;
        	//pi(s) <- 0
        	n = i==s ? new Vert(i,0) : new Vert(i,(int)Integer.MAX_VALUE); 
        	map.put(n.NodeID,n);
        	LocationNodePriorityQueue.add(n);
        }
		//S <- {},
        ArrayList<Integer> Visited = new ArrayList<Integer>();
        
        System.out.println("\n Reading From Queue");
		while (!LocationNodePriorityQueue.isEmpty()){
			//v = ExtractMin(Q)
			Vert NodeWithMinInvarient = LocationNodePriorityQueue.poll();
			//Add v to S
			Visited.add(NodeWithMinInvarient.getid());
			
			// for each edge e=(v,w) 
			for( Node n : G.adjacencyList[NodeWithMinInvarient.getid()] ) {
				//such that w does not exist in S{
				if(Visited.contains(n)) {
					continue;
				}
				//pi(v) + Ie < pi(w)
				n.printNode();
				int x = n.getDistance();
				int y = NodeWithMinInvarient.getInvarient();
				for (Object i : G.nodeInfo.keySet()) {
					  System.out.println("key: " + i + " value: " + G.nodeInfo.get(i));
					}
				int distanceFromPredecesor = x+y;
				System.out.println("Distance "+ x +"plus"+y);
				System.out.println(distanceFromPredecesor < G.getInvarient(n.getId()));
				 if(distanceFromPredecesor < map.get(n.getId()).getInvarient()){

					 LocationNodePriorityQueue.remove(map.get(n.getId()));
					 //pi(w)=pi(v)+Ie
					 map.get(n.getId()).setInvarient(distanceFromPredecesor);
					 //ChangeKey(Q,w,pi(w))
					 LocationNodePriorityQueue.add(map.get(n.getId()));
					
					 n.setShortestPath(distanceFromPredecesor);
				}
			}
		}
		System.out.println("Visited");
		for(Integer p : Visited) {
			System.out.println(p);
		}
	}
	
}

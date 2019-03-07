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
    	//Using pqueue
    	//hashmap
    	
    	
    	Dijkstra(DirectedGraph, 1);
	}
	public static void Dijkstra(DirectedGraph G, int s) {
		 
		// get invariant of s = 0
//		G.getInvarient(s);
//		G.setInvarient(s, 0);
//		for (Object i : G.nodeInfo.keySet()) {
//			  System.out.println("key: " + i + " value: " + G.nodeInfo.get(i));
//			}
//		G.getInvarient(s);
//		G.getInvarient(2);
		//Initialize Q of V with pi(v) <- infinity for each node v in V
		Comparator<Node> LectureStartTimeComparator = new Comparator<Node>() {
            public int compare(Node one, Node two) {
                return one.getInvarient() - two.getInvarient();
            }
        };
        //Holds Min invariant 
        PriorityQueue<Node> LocationNodePriorityQueue = new PriorityQueue<>(LectureStartTimeComparator);   
        //Holds the node values
    	Map<Integer, Vert> map = new HashMap<Integer, Vert>();
        //Initialize Priority Queue and Hashmap
    		// I use both because the pqueue does not have a find method
    		// By leveraging the hashmap, I can extract from the queue 
    	//pi(s) <- 0
        for(int i = 0; i<G.getSize(); i++) {
        	
        	for(Node n: G.adjacencyList[i]) {
        		System.out.println("HERE yay"+n.getId()+" "+s);
        		if(n.getId()==s) {
        			System.out.println("Made it");
        			n.setInvarient(0);
        		}
        		LocationNodePriorityQueue.add(n);
        	}
        }
        System.out.println("STARTED TO PRINT");
        while(!LocationNodePriorityQueue.isEmpty()) {
        	System.out.println(LocationNodePriorityQueue.poll().getId());
        }
		//S <- {},ddd
        ArrayList<Integer> Visited = new ArrayList<Integer>();
        
        System.out.println("\n Reading From Queue");
		while (!LocationNodePriorityQueue.isEmpty()){
			//v = ExtractMin(Q)
			Node NodeWithMinInvarient = LocationNodePriorityQueue.poll();
			System.out.println("\nExtract min Node "+NodeWithMinInvarient.getid());
			//Add v to S
			Visited.add(NodeWithMinInvarient.getid());
			// for each edge e=(v,w) 
			for( Node n : G.adjacencyList[NodeWithMinInvarient.getid()] ) {
				//such that w does not exist in S{
				if(Visited.contains(n)) {
					continue;
				}
				//pi(v) + Ie < pi(w)
				int x = n.getDistance();
				int y = NodeWithMinInvarient.getInvarient();
				for (Object i : map.keySet()) {
					  System.out.println("key: " + i + " value: " + map.get(i).getInvarient());
					}
				int distanceFromPredecesor = x+y;
				System.out.println("Distance "+ x +" plus parent "+y);
				 if(distanceFromPredecesor < map.get(n.getId()).getInvarient()){
					 LocationNodePriorityQueue.remove(map.get(n.getId()));
					 //pi(w)=pi(v)+Ie
					 map.get(n.getId()).setInvarient(distanceFromPredecesor);
					 //set pred
					 n.addPredecesor(NodeWithMinInvarient.getid());
					 //ChangeKey(Q,w,pi(w))
					 LocationNodePriorityQueue.add(map.get(n.getId()));
				
					 n.setShortestPath(distanceFromPredecesor);
				}
			}
			System.out.print("Visited = ");
			System.out.print("{");
			for(Integer p : Visited) {
				System.out.print(p+", ");
			}
			System.out.print("}\n\n");
		}
		for(LinkedList<Node> t : G.adjacencyList) {
			for(Node p: t) {
				p.printPred();
			}
		}

	}
	
}

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstras {
	public static void main(String[] args) {
		System.out.println("I've used an adjacency list!");
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
		// Using pqueue
		// hashmap

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
		// Initialize Q of V with pi(v) <- infinity for each node v in V
		Comparator<Vert> LectureStartTimeComparator = new Comparator<Vert>() {
			public int compare(Vert one, Vert two) {
				return one.getInvarient() - two.getInvarient();
			}
		};
		PriorityQueue<Vert> LocationNodePriorityQueue = new PriorityQueue<>(LectureStartTimeComparator);

		System.out.println("Inserting to Graph");

		Map<Integer, Vert> map = new HashMap<Integer, Vert>();
		Map<Integer, Vert> shortestPath = new HashMap<Integer, Vert>();
		// Initialize Priority Queue
		for (int i = 1; i < G.getSize(); i++) {
			Vert n;
			// pi(s) <- 0
			n = i == s ? new Vert(i, 0) : new Vert(i, (int) Integer.MAX_VALUE);
			map.put(n.NodeID, n);
			LocationNodePriorityQueue.add(n);
		}
		// S <- {},
		ArrayList<Integer> Visited = new ArrayList<Integer>();

		System.out.println("\n Reading From Queue");
		while (!LocationNodePriorityQueue.isEmpty()) {
			// v = ExtractMin(Q)
			Vert NodeWithMinInvarient = LocationNodePriorityQueue.poll();
//			System.out.println("Using " + NodeWithMinInvarient.getid());
			// Add v to S
			Visited.add(NodeWithMinInvarient.getid());

//			System.out.println("Searching " + NodeWithMinInvarient.getid());
			// for each edge e=(v,w)
			for (Node n : G.adjacencyList[NodeWithMinInvarient.getid()]) {
				// such that w does not exist in S{
				if (Visited.contains(n)) {
					continue;
				}
				// pi(v) + Ie < pi(w)
//				n.printNode();
				System.out.println(n.getPredecesor() + "->" + n.getId());
//				String putCommand = shortestPath.get(n.getId()) != null ? 
//									shortestPath.get(n.getId())+n.getPredecesor() :
//										Integer.toString(n.getPredecesor());
//				System.out.println("Path "+putCommand);
//				Node pred = n;
//				String total = null;
//				while(pred.getId()!=1) {
//					total+=Integer.toString(pred.getPredecesor());
//					pred = LocationNodePriorityQueue.remap.get(pred.getPredecesor());
//				}
//				System.out.println("no idea "+ total);
//				
//				shortestPath.put(n.getId(), putCommand);
				int x = n.getDistance();
				
				int y = NodeWithMinInvarient.getInvarient();
//				for (Object i : map.keySet()) {
//					System.out.println("key: " + i + " value: " + map.get(i).getInvarient());
//				}
				int distanceFromPredecesor = x + y;
//				System.out.println("Distance " + x + "plus" + y);
//				System.out.println(distanceFromPredecesor < G.getInvarient(n.getId()));
				if (distanceFromPredecesor < map.get(n.getId()).getInvarient()) {
					// When I hit this point I need to back track
					
					//have every node contain their shortest predecesor 
//					System.out.print("pred" + n.getId());
//					String putCommand = shortestPath.get(n.getId()) != null ? 
//							shortestPath.get(n.getId())+n.getPredecesor() :
//								Integer.toString(n.getPredecesor());
//		System.out.println("Path "+putCommand);
					LocationNodePriorityQueue.remove(map.get(n.getId()));
					// pi(w)=pi(v)+Ie
					System.out.println(distanceFromPredecesor);
					map.get(n.getId()).setInvarient(distanceFromPredecesor);
					// ChangeKey(Q,w,pi(w))
					LocationNodePriorityQueue.add(map.get(n.getId()));
					String pathID = n.getPredecesor() + "->" + n.getId();
					
					Vert pathContainer = new Vert(pathID,distanceFromPredecesor);
//					shortestPath.remo;
					shortestPath.put(n.getId(), pathContainer);
					n.setShortestPath(distanceFromPredecesor);
				}
			}
		}
		for (Object i : shortestPath.keySet()) {
			System.out.println("key: " + i + " path: " + shortestPath.get(i).getPath()+" at pi of "+ shortestPath.get(i).getInvarient());
		}
		System.out.println("Visited");
		for (Integer p : Visited) {
			System.out.println(p);
		}
	}

}

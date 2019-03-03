
public class Node {
	private int idInt;
	private int distance;
	private int shortestPath;
	private String predecesor;

	// TODO the ID for any Node should be an optional between string and int
	Node(int idInt, int distance, int shortestPath) {
		this.idInt = idInt;
		this.distance = distance;
		this.shortestPath = shortestPath;
		this.predecesor = "X";
	}

	public int getId() {
		return this.idInt;
	}

	public int getDistance() {
		return this.distance;
	}
	public int getShortestPath() {
		return this.shortestPath;
	}
	public void setShortestPath(int shortestPath) {
		this.shortestPath=shortestPath;
	}
	public void setPredecesor(int i) {
		String x = "";
		this.predecesor = x;
	}


	public void printNode() {
		System.out.println("Node: ID("+this.getId() + ")\tDistance(" + this.getDistance()+")");
	}

}


public class Node {
	private int idInt;
	private int distance;
	private int shortestPath;
	private int predecesor;

	// TODO the ID for any Node should be an optional between string and int
	Node(int idInt, int distance, int shortestPath, int predecesor) {
		this.idInt = idInt;
		this.distance = distance;
		this.shortestPath = shortestPath;
		this.predecesor = predecesor;
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
//		String x = "";
		this.predecesor = i;
	}
	public int getPredecesor() {
		return this.predecesor;
	}


	public void printNode() {
		System.out.println("Node: ID("+this.getId() + ") comes from("+this.getPredecesor()+") Distance(" + this.getShortestPath()+")");
	}

}

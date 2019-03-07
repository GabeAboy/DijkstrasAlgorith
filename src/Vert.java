
public class Vert {
	int NodeID;
	String path;
	int Invarient;

	Vert(int NodeID, int Invarient) {
		this.NodeID = NodeID;
		this.Invarient = Invarient;
	}

	Vert(String path, int Invarient) {
		this.path = path;
		this.Invarient = Invarient;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getPath() {
		return this.path;
	}
	public int getInvarient() {
		return this.Invarient;
	}

	public int getid() {
		return this.NodeID;
	}

	public void setInvarient(int x) {
		this.Invarient = x;
	}
}

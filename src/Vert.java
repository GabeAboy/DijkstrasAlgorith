
public class Vert {
	int NodeID;
	int Invarient;
	
	Vert(int NodeID, int Invarient){
		this.NodeID = NodeID;
		this.Invarient = Invarient;
	}
	
	public int getInvarient(){
		return this.Invarient;
	}
	public int getid(){
		return this.NodeID;
	}
	public void setInvarient(int x){
		this.Invarient = x;
	}
}

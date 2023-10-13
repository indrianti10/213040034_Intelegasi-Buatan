package bfs;

import java.util.ArrayList;
import java.util.List;

import main.node;
public class solusi {
	private List<node> nodes;
	private node node;
	
	public solusi() {
		nodes = new ArrayList<>();
	}
	
	public void setNode(node node) {
		this.node = node;
	}
	
	public node getNode() {
		return node;
	}
	
	public void setNodes(List<node> nodes) {
		this.nodes = new ArrayList<>(nodes);
	}
	
	public List<node> getNodes() {
		return nodes;
		
	}

}

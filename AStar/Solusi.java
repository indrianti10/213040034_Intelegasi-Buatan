package AStar;

import java.util.ArrayList;
import java.util.List;

public class Solusi {
	private List<nodeUCS> nodes;
	private nodeUCS node;
	
	public Solusi() {
		nodes = new ArrayList<>();
	}
	
	public void setNode(nodeUCS node) {
		this.node = node;
	}
	
	public nodeUCS getNode() {
		return node;
	}
	
	public void setNode(List<nodeUCS> node) {
		this.nodes = new ArrayList<>(nodes);
	}
	
	public void setNodes(List<nodeUCS> nodes) {
		this.nodes = new ArrayList<>(nodes);
	}
	
	public List<nodeUCS> getNodes() {
		return nodes;
	}



}

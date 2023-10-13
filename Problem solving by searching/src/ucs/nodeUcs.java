package ucs;

import java.util.ArrayList;
import java.util.List;

import main.node;

public class nodeUcs {
	
	private String nilai;
	private int cost;
	
	private List<nodeUcs> tetangga;
	public nodeUcs(node node, int cost) {
		this.nilai = node.getNilai();
		this.cost = cost;
		tetangga = new ArrayList<>();
	}
	
	public String getNilai() {
		return nilai;	
	}
	
	public void setNilai(String nilai) {
		this.nilai = nilai;
	}
	
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public int getCost() {
		return cost;	
	}
	
	public void setTetangga(List<nodeUcs> tetangga) {
		this.tetangga = tetangga;
	}
	
	public List<nodeUcs> getTetangga() {
		return tetangga;
	}
	
	public void addTetangga(nodeUcs node) {
		tetangga.add(node);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof nodeUcs) {
			return ((nodeUcs) obj).nilai.equals(this.nilai);
		}
		return false;
	}

}

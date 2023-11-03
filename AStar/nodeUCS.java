package AStar;

import java.util.ArrayList;
import java.util.List;

public class nodeUCS {
	private String nilai;
	private int cost;
	public boolean isVisited;
	
	private List<nodeUCS> tetangga;
	private List<Integer> tetanggaCost;
	
	public nodeUCS(node node, int cost) {
		this.nilai = node.getNilai();
		this.cost = cost;
		tetangga = new ArrayList<>();
		tetanggaCost = new ArrayList<>();
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
	
	public void setTetangga(List<nodeUCS> tetangga, List<Integer> tetanggaCost) {
		this.tetangga = tetangga;
		this.tetanggaCost = tetanggaCost;
	}
	
	public List<nodeUCS> getTetangga() {
		return tetangga;
	}
	
	public List<Integer> getTetanggaCost() {
		return tetanggaCost;
	}
	
	public void addTetangga(nodeUCS node, int cost) {
		tetangga.add(node);
		tetanggaCost.add(cost);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof nodeUCS) {
			return ((nodeUCS) obj).nilai.equals(this.nilai);
		}
		return false;
	}


}

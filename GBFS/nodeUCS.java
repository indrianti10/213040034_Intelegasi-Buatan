package GBFS;

import java.util.ArrayList;
import java.util.List;

public class nodeUCS {
	private String nilai;
	private int cost;
	private List<nodeUCS> tetangga;
	
	public nodeUCS(node node, int cost) {
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
	
	public void setTetangga(List<nodeUCS> tetangga, List<Integer> tetanggaCost) {
		this.tetangga = tetangga;
	}
	
	public List<nodeUCS> getTetangga() {
		return tetangga;
	}
	
	public void addTetangga(nodeUCS node) {
		tetangga.add(node);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof nodeUCS) {
			return ((nodeUCS) obj).nilai.equals(this.nilai);
		}
		return false;
	}


}

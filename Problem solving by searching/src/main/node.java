package main;

import java.util.ArrayList;
import java.util.List;
public class node {
	
	private String nilai;
	private List<node> tetangga;
	
	public node(String nilai) {
		tetangga = new ArrayList<>();
		this.nilai = nilai;
	}
	
	public void setNilai(String nilai) {
		this.nilai = nilai;
	}
	
	public String getNilai() {
		return nilai;
		
	}
	
	public void setTetangga(List<node> tetangga) {
		this.tetangga = tetangga;
	}
	
	public List<node> getTetangga() {
		return tetangga;
	}
	
	public void addTetangga(node node) {
		tetangga.add(node);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof node) {
			return ((node) obj).nilai.equals(this.nilai);
		}
		return false;
	}

}

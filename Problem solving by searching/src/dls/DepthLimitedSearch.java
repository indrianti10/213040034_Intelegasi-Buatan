package dls;

import main.node;

public class DepthLimitedSearch {
	private int limit;
	
	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	public int getLimit() {
		return limit;	
	}
	
	public void search(node start, node goal) {
		System.out.println("Mencari solusi dari "+start.getNilai()+" ke "+goal.getNilai());
		node eval = start;
		for (int i = 0; i < limit; i++) {
			System.out.println("Level "+i+" Evaluasi: "+eval.getNilai());
			if (eval.equals(goal)) {
				System.out.println("Solusi diTemukan ");
				break;
			}
			
			if(!eval.getTetangga().isEmpty()) {
				eval = eval.getTetangga().get(0);
			}else {
				break;
			}
		}
		
	}

}

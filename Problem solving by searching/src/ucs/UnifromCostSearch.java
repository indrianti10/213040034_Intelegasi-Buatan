package ucs;

import java.util.ArrayList;
import java.util.List;

public class UnifromCostSearch {
	public void search(nodeUcs start, nodeUcs goal) {
		System.out.println("Mencari solusi dari "+start.getNilai()+" ke "+goal.getNilai());
		nodeUcs eval = start;
		boolean done = false;
		List<nodeUcs> solusi = new ArrayList<>();
		while (!done) {
			System.out.println("Evalusi : "+eval.getNilai()+" denagn cost "+eval.getCost());
			solusi.add(eval);
			if (eval.equals(goal)) {
				System.out.println("Solusi diTemukan ");
				done = true;
			}
			
			if (!eval.getTetangga().isEmpty()) {
				nodeUcs best = null;
				int min = Integer.MAX_VALUE;
				System.out.println();
				for (nodeUcs node: eval.getTetangga()) {
					System.out.println(node.getNilai()+ " ("+node.getCost()+"), ");
					if (min > node.getCost()) {
						min = node.getCost();
						best = node;
					}
				}
				
				System.out.println();
				System.out.println("Node terpilih: "+best.getNilai()+" ("+min+")");
				eval = best;
			}else {
				done = true;
			}
		}
		
		System.out.println();
		System.out.println("Solusi diTemukan: ");
		for (nodeUcs node: solusi) {
			System.out.println(node.getNilai()+" ("+node.getCost()+")");
		}
	}

}

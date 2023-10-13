package bfs;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import main.node;

public class BreadthFirstSearch {
	
	public void search(node start, node goal) {
			Queue<solusi> queue = new LinkedBlockingQueue<>();
			solusi solusiStart = new solusi();
			solusiStart.setNode(start);
			queue.add(solusiStart);
			System.out.println("Mencari solusi dari"+start.getNilai()+" ke "+goal.getNilai());
			
			while(!queue.isEmpty()) {
				solusi eval = queue.poll();
				System.out.println("Evaluasi : "+eval.getNode().getNilai());
				
				if (eval.getNode().equals(goal)) {
					System.out.println("Solusi diTemukan : ");
					for(node node: eval.getNodes()) {
						System.out.print(node.getNilai()+" -> ");
					}
					System.out.println(eval.getNode().getNilai());
					break;
				}else {
					System.out.println("Suksesor "+eval.getNode().getNilai());
					for (node succesor: eval.getNode().getTetangga()) {
						System.out.println(succesor.getNilai()+" ");
						solusi solusiSuksesor = new solusi();
						solusiSuksesor.setNode(succesor);
						solusiSuksesor.setNodes(eval.getNodes());
						solusiSuksesor.getNodes().add(eval.getNode());
						
						queue.offer(solusiSuksesor);
					}
					
					System.out.println();
					System.out.println();
				}
			}
		
	}

}

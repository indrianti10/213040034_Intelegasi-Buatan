package GBFS;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Gbfs {
	// fungsi untuk mencari solusi dari start ke goal
	public void search(nodeUCS start, nodeUCS goal) {
		Queue<Solusi> queue = new LinkedBlockingQueue<>();
		Solusi solusiStart =  new Solusi();
		solusiStart.setNode(start);
		queue.add(solusiStart);
		int costAll = 0;
		System.out.println("Mencari solusi dari " + start.getNilai() 
		+ " ke " + goal.getNilai());
		
		// Iterasi selama queue tidak kosong
		while (!queue.isEmpty()) {
			Solusi eval = queue.poll();// eval untuk menyimpan node yang akan dievaluasi
			System.out.println("Evaluasi: " + eval.getNode().getNilai());
			
			// Pengkondisian jika eval bernilai tujuan/goal, maka semua node tetangga dari
			if (eval.getNode().equals(goal)) {
				System.out.println("Solusi ditemukan: ");
				
				for(nodeUCS node : eval.getNodes()) {
					System.out.print(node.getNilai() + " -> ");
				}
				System.out.print(eval.getNode().getNilai());
				break;
			}
			else {
				System.out.println("Suksesor  " +eval.getNode().getNilai() + " : ");
				// solusiSuksesor untuk menyimpan semua nilai suksesor dari eval
				Solusi solusiSuksesor = new Solusi();
				
				nodeUCS best = null;// best untuk menyimpan node terbaik dari eval
				int min = Integer.MAX_VALUE; // min untuk menyimpan nilai cost terkecil dari eval
				int depth = 0;// depth untuk menyimpan kedalaman dari eval
				
				// Iterasi seluruh node tetangga dari eval
				for (nodeUCS node : eval.getNode().getTetangga()) {
					 if (depth < 5 ) {// Pengkondisian jika depth kurang dari 5
						 System.out.print(node.getNilai() + " (" + node.getCost() + "), ");
						 
						 //pengkondisiaan  cara untuk memilih node terbaik berdasarkan biaya heuristik 
						 if (min >node.getCost()) {
							 min = node.getCost();
							 best = node;	
						 }
					 }
					 else {
						 return;
					 }
					 depth++;
				}
				
				//angkah-langkah untuk membangun jalur terpendek dengan memperbarui 
				//informasi jalur saat pencarian berlanjut.
				nodeUCS successor = best;
				solusiSuksesor.setNode(successor);
				solusiSuksesor.setNodes(eval.getNodes());
				solusiSuksesor.getNodes().add(eval.getNode());
				
				System.out.println();
				System.out.println("Node Terpilih: " + best.getNilai() + "(" + min +")");
				
				// solusiSuksesor dimasukan ke dalam queue
				queue.offer(solusiSuksesor);
				System.out.println();
				
			}
			
		} 
	}


}

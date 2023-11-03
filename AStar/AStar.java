package AStar;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class AStar {
	
	public void search(nodeUCS start, nodeUCS goal) {
		// queue untuk menyimpan node yang akan dievaluasi
		Queue<Solusi> queue = new LinkedBlockingQueue<>();
		// solusiStart untuk menyimpan start node dengan tipe data bentukan Solusi
		Solusi solusiStart =  new Solusi();
		// node start dimasukan ke solusiStart
		solusiStart.setNode(start);
		queue.add(solusiStart);
		// costAll untuk menghitung total biaya jalur yang ditempuh
		int costAll = 0;
		System.out.println("Mencari solusi dari " + start.getNilai() 
		+ " ke " + goal.getNilai());
		
		// Iterasi selama queue tidak kosong
		while (!queue.isEmpty()) {
			Solusi eval = queue.poll();
			System.out.println("Evaluasi: " + eval.getNode().getNilai());
			
			// Pengkondisian jika eval bernilai tujuan/goal, maka semua node tetangga dari
            // eval
            // yang mengacu ke goal ditampilkan lalu iterasi berakhir
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
				eval.getNode().isVisited = true;
				
				nodeUCS best = null;
				int min = Integer.MAX_VALUE;
				int cost = 0;
				// inisiasi i dengan 0, i untuk variabel yang mengukur jumlah iterasi pada
                // iterasi cost
                // dari node tetangga
				int i = 0;
				
				// iterasi tetangga dari eval
				for (nodeUCS node : eval.getNode().getTetangga()) {
					// jika i kurang dari banyaknya elemen cost tetangga dari node,
                    // maka akan dilakukan pengecekan apakah node itu telah dilalui
                    // dan apakah jarak dari node itu ke goal ditambah jarak antar nodenya
                    // kurang dari nilai min
					int costTetangga = eval.getNode().getTetanggaCost().get(i);
					 if (eval.getNode().getTetanggaCost().size() > i) {
						 int apakahMin = node.getCost() + costTetangga + costAll;
						 System.out.print(node.getNilai() + " (" + node.getCost() + " + " +
			                        costTetangga + " + " + costAll + "), = " + apakahMin + "\n");
						 if (node.isVisited == true) {
			                    System.out.println(node.getNilai() + " sudah dikunjungi.\n");
			                }
						 // jika nilai min kurang dari nilai apakahMin dan node itu belum dilalui,
	                        // maka min diberikan nilai apakahMin, best diberikan nilai node, dan
	                        // cost diberikan nilai i. lalu node tersebut diberi tanda bahwa telah dilalui
						 if (min > apakahMin && node.isVisited == false) {
							 min = apakahMin;
							 best = node;	
							 cost = i;
							 node.isVisited = true;
						 }
					 }
					 else {
						 return;
					 }
					 i++;
				}
				//angkah-langkah untuk membangun jalur terpendek dengan memperbarui 
				//informasi jalur saat pencarian berlanjut.
				nodeUCS successor = best;
				solusiSuksesor.setNode(successor);
				solusiSuksesor.setNodes(eval.getNodes());
				solusiSuksesor.getNodes().add(eval.getNode());
				
				System.out.println();
				System.out.println("Node Terpilih: " + best.getNilai() + "(" + min +")");
				
				costAll += eval.getNode().getTetanggaCost().get(cost);
				// solusiSuksesor dimasukan ke dalam queue
				queue.offer(solusiSuksesor);
				System.out.println();
				
			}
			
		} 
	}

}

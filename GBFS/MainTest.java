package GBFS;

public class MainTest {
	public static void main(String[] args) {
		//inisialisasi node-node yang ada
		node kotaA = new node("KotaA");
		node kotaB = new node("KotaB");
		node kotaC = new node("KotaC");
		node kotaD = new node("KotaD");
		node kotaE = new node("KotaE");
		
		//inisialisasi node-node yang ada dengan costnya
		nodeUCS kotaAUCS = new nodeUCS(kotaA, 22);
		nodeUCS kotaBUCS = new nodeUCS(kotaB, 17);
		nodeUCS kotaCUCS = new nodeUCS(kotaC, 0);
		nodeUCS kotaDUCS = new nodeUCS(kotaD, 10);
		nodeUCS kotaEUCS = new nodeUCS(kotaE, 23);
		
		kotaAUCS.addTetangga(kotaBUCS);
		kotaAUCS.addTetangga(kotaEUCS);
		
		kotaBUCS.addTetangga(kotaAUCS);
		kotaBUCS.addTetangga(kotaEUCS);
		kotaBUCS.addTetangga(kotaDUCS);
		
		kotaCUCS.addTetangga(kotaDUCS);
		
		kotaDUCS.addTetangga(kotaBUCS);
		kotaDUCS.addTetangga(kotaCUCS);
		
		kotaEUCS.addTetangga(kotaAUCS);
		kotaEUCS.addTetangga(kotaBUCS);
		
		// menampilkan hasil dari algoritma Greedy Best First Search
		System.out.println("Greedt BFS*");
		Gbfs  bfs = new Gbfs();
		bfs.search(kotaEUCS, kotaCUCS);
		System.out.println();
		
	}

}

package AStar;

public class MainTest {
	//inisialisasi node-node yang ada
	public static void main(String[] args) {
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
		
		kotaAUCS.addTetangga(kotaBUCS,17);
		kotaAUCS.addTetangga(kotaEUCS,23);
		
		kotaBUCS.addTetangga(kotaAUCS,22);
		kotaBUCS.addTetangga(kotaEUCS,23);
		kotaBUCS.addTetangga(kotaDUCS,10);
		
		kotaCUCS.addTetangga(kotaDUCS,10);
		
		kotaDUCS.addTetangga(kotaBUCS,17);
		kotaDUCS.addTetangga(kotaCUCS,0);
		
		kotaEUCS.addTetangga(kotaAUCS,22);
		kotaEUCS.addTetangga(kotaBUCS,17);
		
		
		
		// menampilkan hasil dari algoritma Greedy Best First Search
		System.out.println("A*");
		AStar  aStar = new AStar();
		aStar.search(kotaEUCS, kotaCUCS);
		System.out.println();
		
		
	}

}

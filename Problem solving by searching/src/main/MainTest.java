package main;

import bfs.BreadthFirstSearch;
import dls.DepthLimitedSearch;
import ucs.UnifromCostSearch;
import ucs.nodeUcs;

public class MainTest {
	public static void main(String[] args) {
		node kotaA = new node("KotaA");
		node kotaB = new node("KotaB");
		node kotaC = new node("KotaC");
		node kotaD = new node("KotaD");
		node kotaE = new node("KotaE");
		
		kotaA.addTetangga(kotaB);
		kotaA.addTetangga(kotaE);
		
		kotaB.addTetangga(kotaA);
		kotaB.addTetangga(kotaE);
		kotaB.addTetangga(kotaD);
		
		kotaC.addTetangga(kotaD);
		
		kotaD.addTetangga(kotaB);
		kotaD.addTetangga(kotaC);
		
		kotaE.addTetangga(kotaA);
		kotaE.addTetangga(kotaB);
		
		System.out.println("BFS");
		BreadthFirstSearch bfs = new BreadthFirstSearch();
		bfs.search(kotaE, kotaC);
		System.out.println();
		
		System.out.println("DLS");
		DepthLimitedSearch dls = new DepthLimitedSearch();
		dls.setLimit(5);
		dls.search(kotaE, kotaC);
		System.out.println();
		
		nodeUcs kotaAUcs = new nodeUcs(kotaA, 22);
		nodeUcs kotaBUcs = new nodeUcs(kotaB, 17);
		nodeUcs kotaCUcs = new nodeUcs(kotaC, 0);
		nodeUcs kotaDUcs = new nodeUcs(kotaD, 10);
		nodeUcs kotaEUcs = new nodeUcs(kotaE, 23);
		
		kotaAUcs.addTetangga(kotaBUcs);
		kotaAUcs.addTetangga(kotaEUcs);
		
		kotaBUcs.addTetangga(kotaAUcs);
		kotaBUcs.addTetangga(kotaEUcs);
		kotaBUcs.addTetangga(kotaDUcs);
		
		kotaCUcs.addTetangga(kotaDUcs);
		
		kotaDUcs.addTetangga(kotaBUcs);
		kotaDUcs.addTetangga(kotaCUcs);
		
		kotaEUcs.addTetangga(kotaAUcs);
		kotaEUcs.addTetangga(kotaBUcs);
		
		
		
		
		System.out.println("UCS");
		UnifromCostSearch ucs = new UnifromCostSearch();
		ucs.search(kotaEUcs, kotaCUcs);
		System.out.println();
		
		
	}

}

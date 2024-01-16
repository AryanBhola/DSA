package dsa;

import java.util.Collections;
import java.util.Arrays;

public class ChocolaProblem {

	public static void main(String[] args) {
		Integer costVer[] = {2,1,3,1,4};
		Integer costHoz[] = {4,1,2};
		int cost = 0;
		
		//1. Sort the 2 arrays 
		Arrays.sort(costVer,Collections.reverseOrder());
		Arrays.sort(costHoz,Collections.reverseOrder());
		
		// vertical and horizontal pieces count
		int hp = 1; int vp = 1;
		// which cuts are being done here 
		int ver = 0; int hoz = 0;
		
		
		while( hoz < costHoz.length && ver < costVer.length) {
			//Horizontal Cost
			if(costVer[ver] <= costHoz[hoz]) {
				cost += (costHoz[hoz] * vp);
				hp++;
				hoz++;
			}
			else {
				cost += (costVer[ver] * hp);
				vp++;
				ver++;
			}
		}
			
			//now if some cuts are left loops for that
			while(hoz < costHoz.length) {
				cost += (costHoz[hoz] * vp);
				hp++;
				hoz++;
			}
			
			while(ver < costVer.length) {
				cost += (costVer[ver] * hp);
				vp++;
				ver++;
			}
			
			
		
		System.out.println("Min Cost for Cuts : " + cost);
	}

}

package dsa;

public class TilingProblem {
	public static int tiling(int n) {
		//2 x n floor size
		//base case
		if(n==0 ||n==1){
			return 1;
		}
		//vertical choice
		int verticaltiles = tiling(n-1);
		
		//horizontal choice
		int horizontalTiles = tiling(n-2);
		
		int totalWays = verticaltiles + horizontalTiles;
		return totalWays;
	}
			
	
	public static void main(String[] args) {
		System.out.print(25);

	}

}

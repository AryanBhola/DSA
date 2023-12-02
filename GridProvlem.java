package dsa;

public class GridProvlem {

	
	public static void main(String[] args) {
		System.out.print(grid(0,0,3,3));
	}
	
	public static int grid(int i, int j , int n, int m) {
		if(i==n-1 && j==m-1) {
			return 1;
		}
		else if(i==n || j==m) {
			return 0;
		}
		
		int downways = grid(i+1,j,n,m);
		int rightways = grid(i,j+1,n,m);
		int totWays = downways + rightways;
		return totWays;
	}
}

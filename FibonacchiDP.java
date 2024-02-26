package dsa;

public class FibonacchiDP {
	public static int fibMemoization(int n, int f[]) {
		if(n == 0 || n ==1) {
			
			return n;
		}
		if(f[n] != 0) {
			
			return f[n];
		}
		else {
			f[n] = fibMemoization(n-1,f) + fibMemoization(n-2,f);
		
			return f[n];
		}
	}
	
	public static int fibTabulation(int n) {
		int tab[] = new int[n+1];
		tab[0] = 0;
		tab[1] = 1;
		for(int i=2;i<tab.length;i++) {
			tab[i] = tab[i-1] + tab[i-2];
		}
		return tab[tab.length-1];
	}
	public static void main(String[] args) {
		int n = 6;
		System.out.println("FibMemoization : "+fibMemoization(n,new int[n+1]));
		System.out.println("FibTabulation : "+fibTabulation(n));

	}

}

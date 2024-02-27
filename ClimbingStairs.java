package dsa;

import java.util.Arrays;

public class ClimbingStairs {
	
	public static int recursion(int n) {
		// O(2^n)
		if(n == 0) {
			return 1;
		}
		else if(n<0) {
			return 0;
		}
		return recursion(n-1) + recursion(n-2);
		
	}
	public static int memoization(int n,int way[]) {
		//O(n)
		if(n == 0) {
			return 1;
		}
		else if(n<0) {
			return 0;
		}
		else if(way[n] != -1){
			return way[n];
		}
		way[n] = memoization(n-1,way) + memoization(n-2,way);
		
		return way[n];
	}
	public static int tabulation(int n) {
		int ways[] = new int[n+1];
		ways[0] = 1;
		ways[1] = 1;
		for(int i=2;i<=n;i++) {
			ways[i] = ways[i-1] + ways[i-2];
		}
		return ways[n];
	}
	
	public static void main(String[] args) {
		int n = 5;
		System.out.println("Simple Recursion : " + recursion(n));
		int arr[] = new int[n+1];
		Arrays.fill(arr, -1);
		System.out.println("Memoization : " + memoization(n,arr));
		System.out.println("Tabulation : " + tabulation(n));

	}

}

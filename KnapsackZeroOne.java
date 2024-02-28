package dsa;
import java.util.*;
public class KnapsackZeroOne {

	public static int recursion(int val[], int wt[], int W, int n) {		
		if(W == 0 || n == 0) {
			return 0;
		}
		
		if(wt[n-1] <= W) {//valid 
			//include 
			int ans1 = val[n-1] + recursion(val,wt,W-wt[n-1],n-1);
			//exclude
			int ans2 = recursion(val,wt,W,n-1);
			return Math.max(ans1, ans2);
		}
		else {//not valid 
			//exclude
			return recursion(val,wt,W,n-1);			
		}	
	
	}
	
	public static int memoization(int val[], int wt[], int W, int n,int dp[][]) {
		if(W == 0 || n == 0) {
			return 0;
		}
		
		if(dp[n][W] != -1) {
			return dp[n][W];
		}
		if(wt[n-1] <= W) {
			//valid 
			//include 
			int ans1 = val[n-1] + memoization(val,wt,W-wt[n-1],n-1,dp);
			//exclude
			int ans2 = memoization(val,wt,W,n-1,dp);
			
			dp[n][W] = Math.max(ans1, ans2);
			return dp[n][W];
		}
		else {
			//not valid 
			//exclude
			dp[n][W] =  memoization(val,wt,W,n-1,dp);			
			return dp[n][W];
		}	
		
	}
	
	public static int tabulation(int val[], int wt[], int W) {
		int n = val.length;
		int dp[][] = new int[n+1][W+1];
		for(int i=0;i<dp.length;i++) {
			dp[i][0] = 0;
		}
		for(int j=0;j<dp[0].length;j++) {
			dp[0][j] = 0;	
		}
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<W+1;j++) {
				// val[i-1] = value of the i'th item 
				int value = val[i-1];
				// wt[i-1] = weight of the  i'th item
				int weight = wt[i-1];
				//valid
				if(weight <= j) {
				//valid_Include
					int incProfit = value + dp[i-1][j-weight];
				//valid_Exclude
					int excProfit = dp[i-1][j];
					dp[i][j] = Math.max(incProfit, excProfit);
					
				}else {
				//Invalid
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		print2D(dp);
		return dp[n][W];
	}
	public static void print2D(int dp[][]) {
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int val[] = {15,14,10,45,30};
		int wt[] = {2,5,1,3,4};
		int W = 28;
		int dp[][] = new int[val.length+1][W+1];
		for(int i=0;i<dp.length;i++) {
		Arrays.fill(dp[i],-1);
		}
		System.out.println("RECURSION KNAPSACK WITH TC=O(2^n): " + recursion(val,wt,W,val.length));
		System.out.println("MEMOIZATION KNAPSACK WITH TC=O(VAL.LENGTH(n)*W): " + memoization(val,wt,W,val.length,dp));
		System.out.println("TABULATION KNAPSACK WITH TC=O(VAL.LENGTH(n)*W): " + tabulation(val,wt,W));

	}

}

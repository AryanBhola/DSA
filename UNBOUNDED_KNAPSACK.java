package dsa;

import java.util.Arrays;

public class UNBOUNDED_KNAPSACK {
	public static int unbounded(int val[], int wt[], int W) {
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
				//VALID max(include,exclude)
				if(wt[i-1] <= j) {
					dp[i][j] = Math.max(val[i-1] + dp[i][j-wt[i-1]], dp[i-1][j]);
					}
				//INVALID
				else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}print2D(dp);
		return dp[n][W];
	}public static void print2D(int dp[][]) {
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
	}
	public int cutRod(int price[], int n) {
        int dp[][] = new int[n][n];
        for(int i=0;i<n;i++){
            dp[i][0] = 0;
        }
        for(int j=0;j<n;j++){
            dp[0][j] = 0;
        }
      for(int i=1;i<n;i++){
           for(int j=1;j<n;j++){
               //include
               dp[i][j] = price[i] + dp[i-1][j-i];
               //Exclude
               dp[i][j] = dp[i-1][j];
           }
           
      }
      return dp[n][n];
    }
	public static void main(String[] args) {
		int val[] = {15,14,10,45,30};
		int wt[] = {2,5,1,3,4};
		int W = 7;		
		System.out.print(unbounded(val,wt,W));
	}
}

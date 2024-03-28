package dsa;

public class MatricChainMultiplication {
	public static int recursion(int arr[], int i, int j) {
		if(i == j) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		for(int k = i;k<=j-1;k++) {
			int cost1 = recursion(arr,i,k);
			int cost2 = recursion(arr,k+1,j);
			int cost3 = arr[i-1]*arr[k]*arr[j];
			int cost = cost1+cost2+cost3;
			min = Math.min(min, cost);
		}
		return min;
	}
	public static int memoization(int arr[], int i, int j,int dp[][]) {
		if(i == j) {
			return 0;
		}
		if(dp[i][j] != 0) {
			return dp[i][j];
		}
		int min = Integer.MAX_VALUE;
		for(int k = i;k<=j-1;k++) {
			int cost1 = recursion(arr,i,k);
			int cost2 = recursion(arr,k+1,j);
			int cost3 = arr[i-1]*arr[k]*arr[j];
			int cost = cost1+cost2+cost3;
			min = Math.min(min, cost);
		}
		return min;
	}
	public static int tabulation(int arr[]) {
		int n = arr.length;
		int dp[][] = new int[n+1][n+1];
		
		for(int i=1;i<n+1;i++) {
			dp[i][i] = 0;
		}
		for(int len=2;len<=n-1;len++) {
			for(int i=1;i<=n-len;i++) {
				int j = i + len -1;
				dp[i][j] = Integer.MAX_VALUE;
				for(int k=i;k<=j-1;k++) {
					int cost1 = dp[i][k];;
					int cost2 = dp[k+1][j];
					int cost3 = arr[i-1]*arr[k]*arr[j];
					int cost = cost1+cost2+cost3;
					dp[i][j] = Math.min(dp[i][j], cost);
				}
					
				
			}			
		}
		return dp[1][n-1];
	}
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,3};
		int minCost = recursion(arr,1,arr.length-1);
		System.out.println("Minimum Cost = " + minCost);
		int dp[][] = new int[arr.length+1][arr.length+1];
		System.out.println(memoization(arr,1,arr.length-1,dp));
		System.out.println(tabulation(arr));
	}

}

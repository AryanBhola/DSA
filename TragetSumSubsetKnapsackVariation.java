package dsa;

public class TragetSumSubsetKnapsackVariation {
// TC = O( no fo elements * target)
	public static boolean targetSubset(int nums[], int target) {
		boolean dp[][] = new boolean[nums.length+1][target+1];
		for(int i=0;i<nums.length+1;i++) {
			dp[i][0] = true;
		}
		
		for(int i=1;i<nums.length+1;i++) {
			for(int j=1;j<target+1;j++) {
				int v = nums[i-1];
					//include
					if(v <= j && dp[i-1][j-v] == true) {
						dp[i][j] = true;
					}
					//exclude
					else if(dp[i-1][j] == true) {
						dp[i][j] = true;
					}
			}
		}
		print2D(dp);
		System.out.print("Does a subset sum upto the target in th egiven array of elements ? -> ");
		return dp[nums.length][target];
	}
	public static void print2D(boolean dp[][]) {
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				System.out.print(dp[i][j] + "  ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int num[] = {4,2,7,1,3};
		int targetSum = 10;
		
		System.out.println(targetSubset(num,targetSum));
	}

}

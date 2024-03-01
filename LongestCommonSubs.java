package dsa;
import java.util.*;
public class LongestCommonSubs {
	
	public static int recursion(String s1, String s2, int n, int m) {
		if(n == 0 || m==0) {
			return 0;
		}
		if(s1.charAt(n-1) == s2.charAt(m-1)) {
			return recursion(s1,s2,n-1,m-1) + 1;
			
		}
		else {
			return Math.max(recursion(s1,s2,n-1,m), recursion(s1,s2,n,m-1));
		}
		
	}
	public static int memoization(String s1, String s2 ,int n, int m,int dp[][]) {
		if(n == 0 || m==0) {
			return 0;
		}
        if(dp[n][m] != -1){
            return  dp[n][m];
        }
		if(s1.charAt(n-1) == s2.charAt(m-1)) {
            dp[n][m] = memoization(s1,s2,n-1,m-1,dp) + 1;
				
            }
		else {
			 dp[n][m]= Math.max(memoization(s1,s2,n-1,m,dp),memoization(s1,s2,n,m-1,dp));
		}
		return dp[n][m];
	}
	public static int tabulation(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();
		int dp[][] = new int[s1.length()+1][s2.length()+1];
        
        
        for(int i=1;i<dp.length;i++) {
        	 for(int j=1;j<dp[0].length;j++) {
        		 if(s1.charAt(i-1) == s2.charAt(j-1)) {
        			 
        	            dp[i][j] = dp[i-1][j-1] + 1;				
        	            }
        			else {
        				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        			}
        	 }
        }
		
		print2D(dp);
	return dp[n][m];
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
		String s1 = "abcde";
		String s2 = "ace";
		System.out.println("LCS RECURSION : " + recursion(s1,s2,s1.length(),s2.length()));
		int dp[][] = new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println("LCS MEMOIZATION : " + memoization(s1,s2,s1.length(),s2.length(),dp));
        System.out.println("LCS TABULATION : " + tabulation(s1,s2));
	}

}

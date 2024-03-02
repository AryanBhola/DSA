package dsa;

public class LongestCommonSubstring {
	public static int tabulation(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();
		int dp[][] = new int[s1.length()+1][s2.length()+1];
        int maxLen = 0;
        
        for(int i=1;i<dp.length;i++) {
        	 for(int j=1;j<dp[0].length;j++) {
        		 if(s1.charAt(i-1) == s2.charAt(j-1)) {        			 
        	            dp[i][j] = dp[i-1][j-1] + 1;
        	            maxLen = Math.max(maxLen,dp[i][j]);
        	            }
        			else {
        				dp[i][j] = 0;
        				
        			}
        	 }
        }
		
		print2D(dp);
	return maxLen;
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
		String s2 = "abgce";
		System.out.println("LCS Tabulation : " + tabulation(s1,s2));

	}

}

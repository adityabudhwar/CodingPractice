package DP;

public class longestcommonSubSequence {
	public int longestCommonSubSeq(String s, String t) {
		int [][] dp = new int[s.length()+1][t.length()+1];
		int m = s.length();
		int n = t.length();
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(i==0||j==0) {
					dp[i][j] =0;
				}
				else if(s.charAt(i)==t.charAt(j)) {
					dp[i][j]=dp[i-1][j-1]+1;
				}
				else {
					dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}
		return dp[m][n];
	}
}

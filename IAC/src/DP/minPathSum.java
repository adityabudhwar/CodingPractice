package DP;

public class minPathSum {
	public int minPathSum(int[][] mat) {
		if(mat==null||mat.length == 0) {
			return 0;
		}
		int r = mat.length;
		int c = mat[0].length;
		int [][] dp = new int[r+1][c+1];
		
		for(int i=0;i<r;i++) {
			dp[i][0] = mat[i][0];
		}
		for(int j=0;j<c;j++) {
			dp[0][j] = mat[0][j];
		}
		
		for(int i=1; i<r;i++) {
			for(int j=1;j<c;j++) {
				dp[i][j]= Math.min(dp[i-1][j], dp[i][j-1]) + dp[i][j];
			}
		}
		
		return dp[r-1][c-1];
	}
}

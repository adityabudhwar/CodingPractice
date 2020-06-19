package DP;

public class longestPalindromic {

	public String longestPalindromicSubSequence(String str) {
		if(str==null || str.length()==0) {
			return str;
		}
		int len = str.length();
		Boolean[][] dp = new Boolean[len][len];
		int maxlen = 1;
		String maxStr = null;
		
		for(int l=0; l<len; l++) {
			for(int i=0; i<len; i++) {
				int j=i+l;
				if((str.charAt(i)==str.charAt(j)) && (j-i<=2 || dp[i][j])) {
					dp[i][j] = true;
				}
				if(j-i+1>maxlen) {
					maxlen = j-i+1;
					maxStr = str.substring(i, j+1);
				}
				
			}
		}
		
		return maxStr;
	}
	
	// min cuts in string to get all substrings as palindrome
	public int mincuts(String str) {
		if(str==null || str.length()==0) {
			return 0;
		}
		int n = str.length();		
		boolean[][] dp = new boolean[n][n];
		int[] cut = new int[n];
		
		for(int j=0; j<n; j++) {
			cut[j]=j;
			for(int i=0;i<=j;i++) {
				if(str.charAt(i)==str.charAt(j)&&(j-i<=1||dp[i+1][j-1])) {
					dp[i][j] = true;
				}
				if(i>0) {
					cut[j]=Math.min(cut[j], cut[j-1]+1);
				}
				else {
					cut[j]=0;
				}
			}
		}
		return cut[n-1];
	}
	
}

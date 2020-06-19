
package DP;

public class editDistance {

	public int minEditDistance(String s1, String s2) {
		int len1 = s1.length();
		int len2 = s2.length();
		
		if(len1==0&&len2==0) {
			return 0;
		}else if(len1==0) {
			return len2;
		}else if(len2==0) {
			return len1;
		}
		
		int[][] dp = new int[len1+1][len2+1];
		
		for(int i=0; i<=len1; i++) {
			dp[i][0] = i;
		}
		
		for(int j=0; j<=len1; j++) {
			dp[0][j] = j;
		}
		
		for(int i=0;i<len1;i++) {
			char c1 = s1.charAt(i);
			for(int j=0; j<len2; j++) {
				char c2 = s2.charAt(j);
				if(c1==c2) {
					dp[i+1][j+1]=dp[i][j];
				}
				else {
					int insert  = dp[i][j+1]+1; 
					int delete  = dp[i+1][j]+1;
					int replace = dp[i+1][j+1]+1;
					int min = insert>delete?insert:delete;
					min = min>replace?min:replace;
					dp[i+1][j+1] = min;
				}
			}
		}
		return dp[len1][len2];
	}
	
}

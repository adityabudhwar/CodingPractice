package DP;

import java.util.Arrays;
import java.util.Set;

public class wordBreak1 {

	//iterate over Dictionary and check. O(length of string* size of dict)
	public boolean wordbreakD(String s, Set<String> dict) {
		if(s==null || dict.size() ==0) {
			return true;
		}
		
		boolean dp[] = new boolean [s.length()+1];
		dp[0] = true;
		
		for(int i=0; i<s.length();i ++) {
			if(!dp[i]) {
				continue;
			}
			
			for(String a: dict) {
				int len = a.length();
				int end = i+len;
				if(end > s.length()) {
					continue;
				}
				if(s.substring(i,end).equals(a)) {
					dp[end] = true;
				}
			}			
		}
		return dp[s.length()];		
	}
	
	// dictionary too big
	public boolean wordBreakS(String s, Set<String> dict) {
		if(s==null||dict.size()==0) {
			return true;
		}
		int[] dp = new int[s.length()+1];
		Arrays.fill(dp, -1);
		
		dp[0]=0;
		for(int i = 0; i<s.length();i++) {
			if(dp[i]!=-1) {
				for(int j=i+1; j<=s.length();j++) {
					String subStr = s.substring(i, j);
					if(dict.contains(subStr)) {
						dp[j] = i;
					}
				}
			}
		}
		return dp[s.length()+1]!=-1;
	}
}

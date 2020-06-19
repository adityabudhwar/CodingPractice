package DP;

import java.util.ArrayList;
import java.util.Set;

public class wordBreak2 {

	public ArrayList<String> wordBreakS(String str, Set<String> dict){
		ArrayList<String>[] pos = new ArrayList[str.length()+1];
		pos[0] = new ArrayList<String>();
		
		for(int i=0; i<str.length();i++) {
			if(pos[i]!=null) {
				for(int j=i+1; j<=str.length();j++) {
					String sub = str.substring(i, j);
					if(dict.contains(sub)) {
						if(pos[j]==null) {
							pos[j] = new ArrayList<String>();
							pos[j].add(sub);
						}
						else {
							pos[j].add(sub);
						}
					}
				}
			}
		}
		
		if(pos[str.length()]==null) {
			return new ArrayList<String>();
		}
		else {
			ArrayList<String> result = new ArrayList<String>();
			dfs(pos,result,"",str.length());
			return result;
		}
	}
	
	public void dfs(ArrayList<String>[] pos, ArrayList<String> result, String curr, int i) {
		if(i==0) {
			result.add(curr.trim());
			return;
		}
		for(String d: pos[i]) {
			String combined = d + " " + curr;
			dfs(pos, result, combined, i-d.length());
		}
	}
}

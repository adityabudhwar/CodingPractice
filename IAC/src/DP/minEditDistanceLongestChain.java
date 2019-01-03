// Given a Dictionary of words. Find the longest chain of words in the dictionary 
// that are at one character insertion distance

package DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class minEditDistanceLongestChain {
	
	ArrayList<ArrayList<String>> result;
    
	// main utility to be called from outside
	public ArrayList<String> minDistanceChain(ArrayList<String> dict){
		ArrayList<String> al = new ArrayList<String>();
		if(dict==null||dict.size()==0) {
			return al;
		}
		HashMap<String,ArrayList<String>> hm = new HashMap<String,ArrayList<String>>();
		for(int i=0;i<dict.size()-1;i++) {
			String str1 = dict.get(i);
			String str2 = dict.get(i+1);
			// calculate insertion distance between two strings
			int dist = minInsertDistance(str1,str2);
			if(dist==1) {
				int len1 = str1.length();
				int len2 = str2.length();
				// update the hash map with key as small string and value as list of strings 
				// one insertion distance apart.
				String key = len1>len2?str2:str1;
				String val = key==str1?str2:str1;
				if(!hm.containsKey(key)){
					ArrayList<String> all = new ArrayList<String>();
					all.add(val);
					hm.put(key, all);
				}
				else {
					hm.get(key).add(val);
				}
			}
		}
 
		// iterate over hashmap keys and generate list of list of strings which are one
		// distance apart
		ArrayList<String> temp=null;
		for(String s: hm.keySet()) {
			result = generate(s,temp, hm);
		}
		
		int max=0;
		
		// calculate which list is the longest, return that list
		for(ArrayList<String> test: result) {
			if(max<test.size()) {
				if(al.isEmpty()) {
					al=test;
				}
				else {
					al.clear();
					al=test;
				}
			}
		}
		
		return al;
	}
	
	public ArrayList<ArrayList<String>> generate(String s, ArrayList<String> t, HashMap<String,ArrayList<String>> hm){
		if(hm.containsKey(s)) {
			t = new ArrayList<String>();
			t.add(s);
			for(String m:hm.get(s)) {
				generate(m,t,hm);
			}
		}
		else {
			t.add(s);
			result.add(t);
		}
		return result;
	}
	
	public int minInsertDistance(String s1, String s2) {
		int len1 = s1.length();
		int len2 = s2.length();
		
		if(len1==0&&len2==0) {
			return 0;
		}else if(len1==0) {
			return 0;
		}else if(len2==0) {
			return 0;
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
					dp[i+1][j+1] = insert;
				}
			}
		}
		if(dp[len1][len2]==1) {
			return 1;
		}
		else{
			return 0;
		}
	}
	
	
}

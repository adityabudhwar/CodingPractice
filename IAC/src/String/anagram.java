package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class anagram {

	public ArrayList<ArrayList<String>> groupAnagrams(String[] strs){
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
		for(String str: strs) {
			char[] arr = new char[26];
			for(int i=0;i<str.length();i++) {
				int j = str.charAt(i)-'a';
				arr[j]++;
			}
			String ns = new String(arr);
			
			if(hm.containsKey(ns)) {
				hm.get(ns).add(str);
			}
			else {
				ArrayList<String> al = new ArrayList<String>();
				al.add(str);
				hm.put(ns, al);
			}
		}
		result.addAll(hm.values());
		return result;
	}
	
}

package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class topKfrequentElements {

	public class Pair{
		int num;
		int count;
		public Pair(int num, int count) {
			this.num=num;
			this.count=count;
		}
	}
	
	public ArrayList<Integer> frequentElements(int[] numbers, int k){
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(numbers ==null|| numbers.length==0) {
			return result;
		}
		
		// create hash map
		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
		for(int num: numbers) {
			if(hm.containsKey(num)) {
				hm.put(num, hm.get(num)+1);
			}
			else {
				hm.put(num, 1);
			}
		}
		
		// define min heap
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>() {
			public int compare(Pair a, Pair b) {
				return a.count-b.count;
			}
		});
		
		
		// create min heap
		for(Map.Entry<Integer, Integer> entry: hm.entrySet()) {
			Pair P = new Pair(entry.getKey(),entry.getValue());
			pq.offer(P);
			if(pq.size()>k) {
				pq.poll();
			}
		}
		
		// populate the result list
		while(!pq.isEmpty()) {
			Pair m = pq.poll();
			result.add(m.num);
		}
		
		Collections.reverse(result);
		
		return result;		
	}
}

package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class minmeetingrooms {

	public int minmeetingroom(Interval[] intervals) {
		if(intervals==null|| intervals.length==0) {
			return 0;
		}
		Arrays.sort(intervals,new Comparator<Interval>() {
				public int compare(Interval l1, Interval l2) {
				return l1.start -l2.start;
		}});
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int count =1;
		pq.offer(intervals[0].end);
		
		for(int i=1; i<intervals.length;i++) {
			if(intervals[i].start<pq.peek()) {
				count++;
			}
			else {
				pq.poll();
			}
			pq.offer(intervals[i].end);
		}
		return count;
		
	}
	
}

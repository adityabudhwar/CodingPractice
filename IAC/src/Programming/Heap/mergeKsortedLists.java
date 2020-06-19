package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class mergeKsortedLists {
	
	class ListNode{
		int val;
		ListNode next;
		
		public ListNode(int x) {
			this.val=x;
		}
	}
	
	public ListNode ksortedlist(ListNode[] lists) {
		if(lists==null||lists.length==0) {
			return null;
		}
		
		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
			public int compare(ListNode l1, ListNode l2) {
				return l1.val - l2.val;
			}});
		
		ListNode head = new ListNode(0);
		ListNode p = head;
		
		for(ListNode list:lists) {
			if(list!=null)
				pq.offer(list);
		}
		
		while(!pq.isEmpty()) {
			ListNode q= pq.poll();
			p.next = q;
			p = p.next;
			if(q.next!= null)
				pq.offer(q.next);
		}	
		return head.next;
	}
}

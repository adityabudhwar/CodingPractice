package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class clonegraph {
	class UndirectedGraphNode{
		int label;
		ArrayList<UndirectedGraphNode> neighbours;
		UndirectedGraphNode(int x){
			label=x;
			neighbours = new ArrayList<UndirectedGraphNode>();
		}
	}
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode head) {
		if(head==null) {
			return null;
		}
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		HashMap<UndirectedGraphNode,UndirectedGraphNode> hm = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
		UndirectedGraphNode newHead = new UndirectedGraphNode(head.label);
		queue.add(head);
		hm.put(head, newHead);
		
		while(!queue.isEmpty()){
			UndirectedGraphNode curr = queue.remove();
			for(UndirectedGraphNode aneighbour:curr.neighbours) {
				if(!hm.containsKey(aneighbour)) {
					UndirectedGraphNode copy = new UndirectedGraphNode(aneighbour.label);
					hm.put(aneighbour, copy);
					hm.get(curr).neighbours.add(copy);
					queue.add(aneighbour);
				}
				else {
					hm.get(curr).neighbours.add(hm.get(aneighbour));
				}
			}
		}
		return newHead;
	}
}

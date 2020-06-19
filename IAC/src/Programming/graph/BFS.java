package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BFS {

	private Queue<Node> queue;
	static ArrayList<Node> nodes = new ArrayList<Node>();
	
	static class Node {
		int data;
		boolean visited;
		ArrayList<Node> neighbours;
		
		Node(int data){
			this.data = data;
			this.neighbours= new ArrayList<Node>();
		}
	}
	
	public void bfs(Node node) {
		queue.add(node);
		node.visited=true;
		while(!queue.isEmpty()) {
			Node element = queue.remove();
			ArrayList<Node> neighbours = element.neighbours;
			for(int i=0; i<neighbours.size();i++) {
				Node n = neighbours.get(i);
				if(n!=null && !n.visited) {
					queue.add(n);
					n.visited = true;
				}
			}
		}
	}
	
	public void dfs(Node node) {
		Stack<Node> stack = new Stack<Node>();
		stack.add(node);
		node.visited=true;
		while(!stack.isEmpty()) {
			Node element = stack.pop();
			ArrayList neighbours = element.neighbours;
			for(int i = 0; i<neighbours.size();i++) {
				Node n = (Node) neighbours.get(i);
				if(n!=null&&!n.visited) {
					stack.push(n);
					n.visited=true;
				}
			}
		}
	}
	
}

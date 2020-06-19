package Tree;

import java.util.LinkedList;

public class nextRightPointerTree {
	public void connect(TreeNode root) {
		if(root == null) {
			return;
		}
		
		LinkedList<TreeNode> nodeQueue = new LinkedList<TreeNode>();
		LinkedList<Integer> depthQueue = new LinkedList<Integer>();
		
		nodeQueue.offer(root);
		depthQueue.offer(1);
		
		while(!nodeQueue.isEmpty()) {
			TreeNode node = nodeQueue.poll();
			Integer depth = depthQueue.poll();
			
			if(depthQueue.isEmpty()) {
				node.right=null;
			}
			else if(depth < depthQueue.peek()) {
				node.right=null;
			}
			else {
				node.right = nodeQueue.peek();
			}
			
			if(node.left != null) {
				nodeQueue.offer(node.left);
				depthQueue.offer(depth+1);
			}
			
			if(node.right != null) {
				nodeQueue.offer(node.right);
				depthQueue.offer(depth+1);
			}			
		}
	} 

}

package Tree;

import java.util.Stack;

public class random {

	// sum root to leaf
	public int intsum(TreeNode root) {
		if(root==null)
			return 0;
		return dfs(root,0,0);
	}
	
	public int dfs(TreeNode node, int num, int sum) {
		if(node==null) {
			return sum;
		}
		
		num = num*10+node.val;
		
		if(node.left==null&&node.right==null) {
			sum=sum+num;
			return sum;
		}
		
		sum = dfs(node.left,num,sum)+dfs(node.right,num,sum);
		return sum;
	}
	
	public int closestBST(TreeNode root, int target) {
		if(root==null) {
			return -1;
		}
		int diff=Integer.MAX_VALUE;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p=root;
		int val=-1;
		while(!stack.isEmpty()||p!=null) {
			if(p!=null) {
				stack.push(p);
				p=p.left;
			}
			else {
				TreeNode top = stack.pop();
				int d = Math.abs(top.val-target);
				if(d<diff) {
					diff = Math.abs(top.val-target);
					val = top.val;
				}
				else {
					return val;
				}
				p=top.right;
			}				
		}
		return val;
	}		
}
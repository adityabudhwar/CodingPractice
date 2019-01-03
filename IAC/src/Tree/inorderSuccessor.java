package Tree;

import java.util.Stack;

public class inorderSuccessor {

	public TreeNode inorderNext(TreeNode root, TreeNode p) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if(root==null || p==null) {
			return null;
		}
		stack.push(root);
		boolean isNext = false;
		while(!stack.isEmpty()) {
			TreeNode top = stack.pop();
			if(top.left==null && top.right==null) {
				if(isNext) {
					return top;
				}
				else if(top.val==p.val) {
					isNext=true;
				}
				continue;
			}
			
			if(top.right!=null) {
				stack.push(top.right);
				top.right=null;
			}
			
			stack.push(top);
			
			if(top.left!=null) {
				stack.push(top.left);
				top.left=null;
			}
		}
		return null;	
	}
	
	public TreeNode inorderPrevious(TreeNode root, TreeNode p) {
		if(root==null|| p==null) {
			return null;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		boolean isPrevious = false;
	    stack.push(root);
	    
	    while(!stack.isEmpty()) {
	    	TreeNode top = stack.pop();
	    	if((top.left==null)&&(top.right==null)) {
	    		if(isPrevious) {
	    			return top;
	    		}
	    		if(top.val==p.val) {
	    			isPrevious=true; 
	    		}
	    		continue;
	    	}
	    	
	    	if(top.left!=null) {
	    		stack.push(top.left);
	    		top.left=null;
	    	}
	    	
	    	stack.push(top);
	    	
	    	if(top.right!=null) {
	    		stack.push(top.right);
	    		top.right=null;
	    	}
	    }
	    return null;
	}
	
		Stack<TreeNode> stack; 
		public void BSTIterator(TreeNode root) {
			stack = new Stack<TreeNode>();
			while(root!=null) {
				stack.push(root);
				root=root.left;
			}
		}
		
		public boolean hasNext() {
			return !stack.isEmpty();
		}
		
		public int next() {
			TreeNode node = stack.pop();
			int result = node.val;
			if(node.right!=null) {
				node=node.right;
				while(node!=null) {
						stack.push(node);
						node=node.left;
				}
			}
			return result;
		}
	
}



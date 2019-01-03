package Tree;

import java.util.ArrayList;
import java.util.Stack;

public class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	public Object next;
	TreeNode(int x){
		val = x;
	}
}

public class traversalTree {

	ArrayList<Integer> al = new ArrayList<Integer>();
	public ArrayList<Integer> traversal_inorder_iterative(TreeNode root){		
		if(root==null) {
			return al;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		
		while(!stack.isEmpty() || p==null){
			if(p!=null) {
				stack.push(p);
				p=p.left;
			}
			else {
				TreeNode t = stack.pop();
				al.add(t.val);
				p=t.right;
			}
		}
		return al;
	}
	
	public ArrayList<Integer> traversal_inorder_recursive(TreeNode root){
		if(root==null) {
			return al;
		}
		traversal_inorder_recursive(root.left);
		al.add(root.val);
		traversal_inorder_recursive(root.right);
		return al;
	}
	
	public ArrayList<Integer> traversal_postorder_iterative(TreeNode root){
		ArrayList<Integer> al = new ArrayList<Integer>();
		if(root==null) {
			return al;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode temp = stack.peek();
			if(temp.left==null && temp.right==null) {
				TreeNode t = stack.pop();
				al.add(t.val);
			}
			else {
				if(temp.right!=null) {
					stack.push(temp.right);
					temp.right=null;
				}
				if(temp.left!=null) {
					stack.push(temp.left);
					temp.right=null;
				}
			}
		}
	} 
	
	public ArrayList<Integer> traversal_preorder(TreeNode root){
		ArrayList<Integer> al = new ArrayList<Integer>();
		if(root == null) {
			return al;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		
		while(!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			al.add(temp.val);
			
			if(temp.right!=null) {
				stack.push(temp.right);
			}
			
			if(temp.left!=null) {
				stack.push(temp.left);
			}
		}
		return al;
	}
}

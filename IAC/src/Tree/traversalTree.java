package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class traversalTree {

	// INORDER
	ArrayList<Integer> al = new ArrayList<Integer>();
	public ArrayList<Integer> traversal_inorder_iterative(TreeNode root){
		Stack<TreeNode> stack = new Stack<>();

		TreeNode p = root;
		while(p!=null){
			stack.push(p);
			p=p.left;
		}

		while(!stack.isEmpty()){
			TreeNode t = stack.pop();
			al.add(t.val);

			t = t.right;
			while(t!=null){
				stack.push(t);
				t = t.left;
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

	// POSTORDER
	public ArrayList<Integer> traversal_postorder_iterative(TreeNode root){
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
		return al;
	} 

	// PREORDER
	public ArrayList<Integer> traversal_preorder(TreeNode root){
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

	// LEVEL ORDER
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> al = new ArrayList<>();
		if (root == null) {
			return al;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Queue<Integer> level = new LinkedList<Integer>();
		queue.add(root);
		level.add(1);
		List<Integer> temp = new LinkedList<Integer>();
		int lev = 1;
		while(!queue.isEmpty()){
			int l = level.poll();
			TreeNode t = queue.poll();
			if(lev == l){
				temp.add(t.val);
			}
			else{
				lev=l;
				al.add(temp);
				temp = new LinkedList<Integer>();
				temp.add(t.val);
			}
			if(t.left!=null){
				queue.add(t.left);
				level.add(l+1);
			}
			if(t.right!=null){
				queue.add(t.right);
				level.add(l+1);
			}
		}
		if(temp.size()!=0){
			al.add(temp);
		}
		return al;
	}

	// LEVEL ORDER 2
	public List<List<Integer>> levelOrder2(TreeNode root) {
		List<List<Integer>> al = new ArrayList<>();
		if (root == null) {
			return al;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Queue<Integer> level = new LinkedList<Integer>();
		queue.add(root);
		level.add(1);
		List<Integer> temp = new LinkedList<Integer>();
		int lev = 1;
		while(!queue.isEmpty()){
			int l = level.poll();
			TreeNode t = queue.poll();
			if(lev == l){
				temp.add(t.val);
			}
			else{
				lev=l;
				al.add(temp);
				temp = new LinkedList<Integer>();
				temp.add(t.val);
			}
			if(t.left!=null){
				queue.add(t.left);
				level.add(l+1);
			}
			if(t.right!=null){
				queue.add(t.right);
				level.add(l+1);
			}
		}
		if(temp.size()!=0){
			al.add(temp);
		}
		List<List<Integer>> reversedResult = new  ArrayList();
		for(int i=al.size()-1; i>=0; i--){
			reversedResult.add(al.get(i));
		}
		return reversedResult;
	}

}

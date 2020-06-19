package Tree;

import java.util.ArrayList;
import java.util.Stack;

public class zigzag {

	/**
	 * Definition for binary tree
	 * class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) {
	 *      val = x;
	 *      left=null;
	 *      right=null;
	 *     }
	 * }
	 */
	public class Solution {
	    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
	        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	        if(A == null){
	            return result;
	        }
	        
	        Stack<TreeNode> s1 = new Stack<TreeNode>();
	        Stack<TreeNode> s2 = new Stack<TreeNode>();
	        s1.push(A);
	        
	        while(!s1.isEmpty()||!s2.isEmpty()){
	            ArrayList<Integer> al = new ArrayList<Integer>();
	            while(!s1.isEmpty()){
	                TreeNode temp = s1.pop();
	                al.add(temp.val);
	                if(temp.left!=null){
	                    s2.push(temp.left);
	                }
	                if(temp.right!=null){
	                    s2.push(temp.right);
	                }
	            }
	            result.add(al);
	            al = new ArrayList<Integer>();
	            while(!s2.isEmpty()){
	                TreeNode temp = s2.pop();
	                al.add(temp.val);
	                if(temp.right!=null){
	                    s1.push(temp.right);
	                }
	                if(temp.left!=null){
	                    s1.push(temp.left);
	                }
	            }
	            result.add(al);
	        }
	        
	        return result;
	    }
	}

	
}

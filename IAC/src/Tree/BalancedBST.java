package Tree;


public class BalancedBST {

	public boolean isBalanced(TreeNode root) {
		return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public boolean helper(TreeNode head, int min, int max){
		if(head==null)
			return true;
		if(head.val<min || head.val>max)
			return  false;

		boolean left = helper(head.left, min, head.val);
		boolean right =  helper(head.right, head.val, max);

		if(!left ||  !right)
			return false;

		return true;
		// the  below statement  is  less efficient.
		//return helper(head.left, min, head.val) && helper(head.right, head.val, max);
	}
}
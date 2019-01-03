package Tree;


public class BalancedBST {

	public boolean isBalanced(TreeNode root) {
		return balancedBst(root) != Integer.MIN_VALUE;
	}
	
	public Integer balancedBst(TreeNode node) {
		if(node==null) {
			return -1;
		}
		int left = balancedBst(node.left);
		if(left==Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		int right = balancedBst(node.right);
		if(right==Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}

		int hight = left-right;
		if(Math.abs(hight)>1) {
			return Integer.MIN_VALUE;
		}
		else {
			return (Math.max(left, right) +1);
		}
	}	
}
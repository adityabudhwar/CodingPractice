package Tree;

public class ValidateBst {
	public boolean isValid(TreeNode root) {
		return check(root,Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public boolean check(TreeNode node, int min, int max) {
		if(node==null) {
			return true;
		}
		if(node.val<=min||node.val>=max) {
			return false;
		}
		
		return check(node.left,min,node.val) && check(node.right,node.val,max);
	}	
}
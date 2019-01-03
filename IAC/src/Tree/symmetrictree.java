package Tree;


public class symmetrictree {
	public boolean isSymmetric(TreeNode root) {
		if (root==null) {
			return true;
		}
		return checkSymmetric(root.left, root.right);
	}
	public boolean checkSymmetric(TreeNode left, TreeNode right) {
		if(left==null&&right==null) {
			return true;
		}
		else if(left==null||right ==null) {
			return false;
		}
	    if(left.val!=right.val) {
	    	return false;
	    }
	    if(!checkSymmetric(left.left,right.right))
	    	return false;
	    if(!checkSymmetric(left.right,right.left))
	    	return false;
	    
	    return true;
	}
}

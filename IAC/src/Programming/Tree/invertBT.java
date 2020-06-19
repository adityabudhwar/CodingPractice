package Tree;
public class invertBT {
	public TreeNode invertBT(TreeNode root) {
		if (root!=null)
			helper(root);
		return root;
	}

	public void helper(TreeNode t) {
		TreeNode temp = t.left;
		t.left = t.right;
		t.right = temp;
		
		if(t.left!=null) {
			helper(t.left);
		}
		if(t.right!=null) {
			helper(t.right);
		}
	}
}

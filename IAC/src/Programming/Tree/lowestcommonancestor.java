package Tree;

public class lowestcommonancestor {

	public TreeNode lowestancestorBST(TreeNode m, TreeNode P, TreeNode Q) {
		TreeNode root = m;
		if(P.val<root.val && Q.val>root.val) {
			return root;
		}
		else if(P.val>root.val && Q.val>root.val) {
			lowestancestorBST(root.right,P,Q);
		}
		else if(P.val<root.val && Q.val<root.val) {
			lowestancestorBST(root.left,P,Q);
		}
		return m;
	}
	
	public TreeNode lowestancestor(TreeNode root, TreeNode P, TreeNode Q) {
		if(root==null)
			return null;
		
		if(root==P||root==Q)
			return root;
		
		TreeNode l = lowestancestor(root.left,P,Q);
		TreeNode r = lowestancestor(root.right,P,Q);
		
		if(l!=null&&r!=null) {
			return root;
		}
		else if (l==null&&r==null) {
			return null;
		}
		else 
			return l==null?r:l;
	}
	
	
}

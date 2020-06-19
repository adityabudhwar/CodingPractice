package Tree;

public class balancedBT {
    public boolean isBalancedBT(TreeNode root){
        if(root==null)
            return true;
        if(helper(root) == -1){
            return false;
        }
        return true;
    }

    public int helper(TreeNode root){
        if(root==null)
            return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        if(left==-1 || right==-1)
            return  -1;
        if(Math.abs(left-right)>1)
            return -1;
        return Math.max(left,right)+1;
    }
}

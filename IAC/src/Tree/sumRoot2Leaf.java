package Tree;

public class sumRoot2Leaf {
    public int sum2leaf(TreeNode root){
      if(root==null)
          return 0;
      return helper(root, 0, 0);
    }

    public int helper(TreeNode head, int sum, int num){
        if (head == null){
            return sum;
        }
        num = num*10+head.val;

        if(head.left==null && head.right==null){
            sum=sum+num;
            return sum;
        }
        sum = helper(head.left, sum,num) + helper(head.right, sum,num);
        return sum;
    }
}

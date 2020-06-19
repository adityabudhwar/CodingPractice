package Tree;

import java.util.LinkedList;

public class mindepth {
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }

        LinkedList<TreeNode> list1 = new LinkedList<TreeNode>();
        LinkedList<Integer>  list2 = new LinkedList<Integer>();

        list1.add(root);
        list2.add(1);

        while(!list1.isEmpty()){
            TreeNode temp = list1.remove();
            int level = list2.remove();

            if(temp.left==null && temp.right==null){
                return level;
            }
            if(temp.left!=null){
                list1.add(temp.left);
                list2.add(level+1);
            }
            if(temp.right!=null){
                list1.add(temp.right);
                list2.add(level+1);
            }
        }
        return 0;
    }
}

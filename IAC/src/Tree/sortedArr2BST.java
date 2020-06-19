package Tree;

public class sortedArr2BST {
	public TreeNode generate(int array[]) {
		return createMinimalBST(array, 0, array.length-1);
	}
		
	public TreeNode createMinimalBST(int array[], int start, int end) {
		if(array.length==0) {
			return null;
		}
		
		int mid = (start+end)/2;
		TreeNode node = new TreeNode(array[mid]);
		node.left = createMinimalBST(array, 0, mid-1);
		node.right = createMinimalBST(array, mid+1, array.length-1);
		return node;
	}
}

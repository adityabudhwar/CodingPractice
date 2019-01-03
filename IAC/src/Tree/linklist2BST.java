package Tree;


class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int x){
		val=x;
	}
}

class ListNode{
	int val;
	ListNode next;
	
	ListNode(int x){
		val=x;
		next=null;
	}
}

public class linklist2BST {
	static ListNode l;
	
	public TreeNode sortedlist2BST(ListNode head) {
		if (head == null) {
			return null;
		}
		l = head;
		int len = lengthList(head);
		return sortedlist2BST(0, len-1);
	}
	
	public int lengthList(ListNode head){
		int count=0;
		ListNode temp = head;
		while(temp!=null) {
			count++;
			temp = temp.next;
		}
		return count;
	}
	
	public TreeNode sortedlist2BST(int start, int end) {
		if(start>end) {
			return null;
		}
		
		int mid = start + (end-start)/2;
		TreeNode left = sortedlist2BST(start, mid-1);
		TreeNode root = new TreeNode(l.val);
		l = l.next;
		TreeNode right = sortedlist2BST(mid+1, end);
		root.left = left;
		root.right = right;
		return root;
	}
}


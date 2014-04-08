/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
    	if(head==null)
    		return null;
        ListNode mid=getMid(head, null);
        TreeNode root = new TreeNode(mid.val);
        root.left=build(head, mid);
        root.right=build(mid.next, null);
        return root;
    }

    public TreeNode build(ListNode head, ListNode end){
    	ListNode mid=getMid(head, end);
    	if(mid==null)
    		return null;
        TreeNode root = new TreeNode(mid.val);
        root.left=build(head, mid);
        root.right=build(mid.next, end);
        return root;
    }

    public ListNode getMid(ListNode head, ListNode end){
    	if(head==end)
    		return null;
    	if(head.next==end)
    		return head;
    	ListNode slow=head, fast=head;
    	while((!fast.equals(end) && !fast.next.equals(end)) && fast.next!=null){
    		fast=fast.next.next;
    		slow=slow.next;
    	}
    	return slow;
    }
}
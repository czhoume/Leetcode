/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curNode = head, firstNode = head;
        if(head==null)
        	return head;
        while(curNode.next!=null){
        	if(curNode.next.val==firstNode.val){
        		curNode=curNode.next;
        	}else{
        		firstNode.next=curNode.next;
        		firstNode=curNode.next;
        		curNode=curNode.next;
        	}
        }
        if(curNode.val==firstNode.val)
        	firstNode.next=curNode.next;
        return head;
    }
}
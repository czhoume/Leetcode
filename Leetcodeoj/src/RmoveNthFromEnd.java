
public class RmoveNthFromEnd {
	
	  public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		     }
		  }
	  
	  public ListNode removeNthFromEnd(ListNode head, int n){
		  ListNode run1=head, run2=head, prv = head;
		  for(int i=0; i<n; i++)
			  run2=run2.next;
		  while(run2!=null){
			  prv=run1;
			  run1=run1.next;
			  run2=run2.next;
		  }
		  if(prv==run1){
			  head=run1.next;
		  }else{
			  prv.next=run1.next;  
		  }
		  
		  return head;
	  }
}

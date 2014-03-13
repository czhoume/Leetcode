import java.util.Stack;


public class TreeRecover {
	
	  TreeNode node1, node2;
	
	  public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	  
	  public void recoverTree(TreeNode root){
		  TreeNode prv=null, cur, swap1=null, swap2=null;
		  int hp;
		  Stack<TreeNode> s = new Stack<TreeNode>();
		  cur=root;
		  while(!s.isEmpty() || cur!=null){
			  if(cur!=null){
				  s.push(cur);
				  cur=cur.left;
			  }else{
				  cur=s.pop();
				  if(prv!=null&&cur.val<prv.val){
					  if(swap1==null){
						  swap1=prv;
						  swap2=cur;
						  prv=cur;
						  cur=cur.right;
					  }else{
						  swap2=cur;
						  prv=cur;
						  cur=cur.right;
					  }
				  }else{
					  prv=cur;
					  cur=cur.right;
				  }
			  }
		  }
		  hp=swap1.val;
		  swap1.val=swap2.val;
		  swap2.val=hp;
	  }
	  
	  public void print(TreeNode root){
		  TreeNode cur;
		  Stack<TreeNode> s = new Stack<TreeNode>();
		  cur=root;
		  while(!s.isEmpty() || cur!=null){
			  if(cur!=null){
				  s.push(cur);
				  cur=cur.left;
			  }else{
				  cur=s.pop();
				  System.out.print(cur.val+" ");
				  cur=cur.right;
			  }
		  }
	  }
	  
	  public static void main(String args[]){
		  TreeRecover tr=new TreeRecover();
		  TreeNode cur;
		  TreeNode root = tr.new TreeNode(0);
		  root.left=tr.new TreeNode(1);
		  root.right=tr.new TreeNode(4);
//		  root.right.left=tr.new TreeNode(1);
//		  root.right.right=tr.new TreeNode(5);
		  tr.print(root);
		  System.out.println();
		  tr.recoverTree(root);
		  tr.print(root);
	  }
}

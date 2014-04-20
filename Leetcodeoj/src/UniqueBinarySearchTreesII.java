import java.util.ArrayList;

public class UniqueBinarySearchTreesII {
	ArrayList<TreeNode>[][] sol;
	
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; left = null; right = null; }
	}
	
    public ArrayList<TreeNode> generateTrees(int n) {
    	sol=new ArrayList[n+1][n+1];
    	return buildTrees(1, n);
    }
    
    public ArrayList<TreeNode> buildTrees(int start, int end){
    	ArrayList<TreeNode> res=new ArrayList<TreeNode>();
    	if(start>end)
    		return res;
    	if(sol[start][end]!=null){
    		return sol[start][end];
    	}
    	if(start==end){
    		TreeNode root=new TreeNode(start);
    		res.add(root);
    		sol[start][end]=res;
    		return res;
    	}
    	for(int i=start; i<=end; i++){
    		ArrayList<TreeNode> ltrees=buildTrees(start, i-1);
    		ArrayList<TreeNode> rtrees=buildTrees(i+1, end);
    		ltrees.add(null);
    		rtrees.add(null);
    		for(TreeNode l: ltrees){
    			for(TreeNode r:rtrees){
    	    		TreeNode root=new TreeNode(start);
    				root.left=l;
    				root.right=r;
    				res.add(root);
    			}
    		}
    	}
    	sol[start][end]=res;
    	return res;
    }
    
    public static void main(String[] args){
    	UniqueBinarySearchTreesII u=new UniqueBinarySearchTreesII();
    	u.generateTrees(7);
    }
}

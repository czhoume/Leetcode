/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
    	if(root==null)
    		return true;
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode left, TreeNode right){
    	if(left==null && right==null)
    		return true;
    	else if((left == null && right !=null) || (left != null && right ==null))
    		return false;
    	else if(left.val!=right.val)
    		return false;
    	else
    		return(helper(left.left, right.right)&&helper(left.right, right.left));
    }
}
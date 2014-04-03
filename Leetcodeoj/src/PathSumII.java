
public class PathSumII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
    	ArrayList<ArrayList<Integer>> res =  new ArrayList<ArrayList<Integer>>();
    	HashMap<TreeNode, ArrayList<Integer>> m = new HashMap<TreeNode, ArrayList<Integer>>();
    	LinkedList<TreeNode> l = new LinkedList<TreeNode>();
    	ArrayList<Integer> t = new ArrayList<Integer>();
    	if(root==null){
    	    return res;
    	}
    	t.add(root.val);
    	t.add(root.val);
    	m.put(root, t);
    	l.add(root);
    	while(!l.isEmpty()){
    		TreeNode tmp = l.remove();
    		if(tmp.left!=null){
    			ArrayList<Integer> tmpArray = new ArrayList<Integer>(m.get(tmp));
    			tmpArray.add(tmp.left.val);
    			int tmpSum=tmpArray.get(0);
    			tmpSum+=tmp.left.val;
    			tmpArray.set(0, tmpSum);
    			m.put(tmp.left, tmpArray);	
    			l.add(tmp.left);
    		}
    		if(tmp.right!=null){
    			ArrayList<Integer> tmpArray = new ArrayList<Integer>(m.get(tmp));
    			tmpArray.add(tmp.right.val);
    			int tmpSum=tmpArray.get(0);
    			tmpSum+=tmp.right.val;
    			tmpArray.set(0, tmpSum);
    			m.put(tmp.right, tmpArray);	
    			l.add(tmp.right);
    		}
    		if(tmp.left==null && tmp.right==null){
    			ArrayList<Integer> tmpArray = m.get(tmp);
    			if(tmpArray.get(0)==sum){
    				tmpArray.remove(0);
    				res.add(tmpArray);
    			}
    		}
    	}
    	return res;
    }
}
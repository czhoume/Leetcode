import java.util.Set;


public class WordBreak {
	Node root;
	int[] sol;
	
	public class Node{
		boolean exist;
		Node[] next;
		
		public Node(){
			exist=false;
			next=new Node[27];
		}
	}
	
    public boolean wordBreak(String s, Set<String> dict) {
        root=buildTrie(dict);
        sol=new int[s.length()];
        for(int i=0; i<s.length(); i++)
        	sol[i]=-1;
        Node cur=root;
        for(int i=0; i<s.length(); i++){
        	cur=cur.next[s.charAt(i)-97];
        	if(cur==null)
        		return false;
        	if(cur.exist){
        		if(i==s.length()-1)
        			return true;
        		else if(sol[i+1]==1)
        			return true;
        		else if(helper(s, i+1)){
        			sol[i+1]=1;
        			return true;
        		}
        	}
        }
        return false;
    }
    
    private boolean helper(String word, int index) {
    	if(sol[index]==0)
    		return false;
        String s=word.substring(index);
        Node cur=root;
        for(int i=0; i<s.length(); i++){
        	cur=cur.next[s.charAt(i)-97];
        	if(cur==null){
        		sol[index]=0;
        		return false;
        	}
        	if(cur.exist){
        		if(i==s.length()-1)
        			return true;
        		else{
        			if(sol[i+1+index]==1)
        				return true;
        			else{
        				if(helper(word, i+1+index)){
        					sol[i+1+index]=1;
        					return true;
        				}
        			}
        			
        		}
        	}
        }
        return false;
	}

	public Node buildTrie(Set<String> dict){
    	Node root=new Node();
    	for(String word:dict){
    		Node cur=root;
    		for(int i=0; i<word.length(); i++){
    			if(cur.next[word.charAt(i)-97]==null){
    				cur.next[word.charAt(i)-97]=new Node();
    			}
    			cur=cur.next[word.charAt(i)-97];
    		}
    		cur.exist=true;
    	}
    	return root;
    }
}

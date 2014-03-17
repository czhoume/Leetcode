import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class WordLadderII {
	
	public class Node{
		String val;
		ArrayList<Node> adj, prv;
		int lvl;
		boolean visited;
		
		public Node(String v){
			val=v;
			adj=new ArrayList<Node>();
			prv=new ArrayList<Node>();
			lvl=-1;
			visited=false;
		}
		public Node(String v, Node node){
			val=v;
			adj=new ArrayList<Node>();
			prv=new ArrayList<Node>();
			prv.add(node);
			lvl=node.lvl+1;
			visited=false;
		}
	}
	
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
    	ArrayList<ArrayList<String>> res=new ArrayList<ArrayList<String>>();
    	ArrayList<ArrayList<Node>> tmpres=new ArrayList<ArrayList<Node>>();
        HashMap<String, Node> map = new HashMap<String, Node>();
        ArrayList<Node> path, tmpPath;
        Node s = null, e=null, node, last;
        dict.add(start);
        dict.add(end);
        s=new Node(start);
        map.put(start, s);
        s.lvl=0;
        Queue<Node> q=new LinkedList<Node>();
        q.add(s);
        s.visited=true;
        while(!q.isEmpty()){
        	node=q.remove();
    		String word=node.val, newWord;
    		Node tmpNode;
    		char old;
    		char [] chars = word.toCharArray();
    		for(int i=0; i<word.length(); i++){
    			old=chars[i];
    			for(char c='a'; c<='z'; c++){
    				if(c==old)
    					continue;
    				chars[i]=c;
    				newWord=new String(chars);
    				if(dict.contains(newWord)){
    					System.out.println(newWord);
    					if(map.containsKey(newWord)){
    						tmpNode=map.get(newWord);
    						if(tmpNode.lvl==node.lvl+1){
    							tmpNode.prv.add(node);
    							if(!tmpNode.visited){
    								q.add(tmpNode);
    								tmpNode.visited=true;
    							}
    						}
    					}else{
    						tmpNode=new Node(newWord, node);
    						map.put(newWord, tmpNode);
    						q.add(tmpNode);
    						tmpNode.visited=true;
    					}
    				}
    			}
    			chars[i]=old;
    		}
        }
        Stack<ArrayList<Node>> p = new Stack<ArrayList<Node>>();
        e=map.get(end);
        if(e==null)
        	return res;
        for(Node tmp:e.prv){
        	path = new ArrayList<Node>();
        	path.add(e);
        	path.add(tmp);
        	p.add(path);
        }
        while(!p.isEmpty()){
        	path=p.pop();
        	last=path.get(path.size()-1);
        	if(last.lvl==0){
        		tmpres.add(path);
        	}else if(last.prv.size()>1){
        		for(Node tmp:last.prv){
        			tmpPath=(ArrayList<Node>) path.clone();
        			tmpPath.add(tmp);
        			p.push(tmpPath);
        		}
        	}else{
        		while(last.prv.size()==1){
        			path.add(last.prv.get(0));
        			last=last.prv.get(0);
        		}
        		p.push(path);
        	}
        }
        for(ArrayList<Node> tmp:tmpres){
        	ArrayList<String> trans = new ArrayList<String>();
        	for(int i=0; i<tmp.size(); i++){
        		trans.add(tmp.get(tmp.size()-1-i).val);
        	}
        	res.add(trans);
        }
        return res;
    }
	
	public void print(String start, String end, HashSet<String> dict){
		ArrayList<ArrayList<String>> res=findLadders(start, end, dict);
		System.out.println("num of solution: "+res.size());
		for(ArrayList<String> tmpres:res){
			for(String word:tmpres){
				System.out.print(word+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args){
		HashSet<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dog");
		WordLadderII wd=new WordLadderII();
		wd.print("hot", "dog", dict);
	}

}

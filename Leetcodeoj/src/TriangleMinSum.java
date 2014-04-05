public class TriangleMinSum {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int min;
        ArrayList<Integer> s1 = new ArrayList<Integer>();
        ArrayList<Integer> s2 = new ArrayList<Integer>();
        s2.add(triangle.get(0).get(0));
        for(int i=1; i< triangle.size(); i++){
        	ArrayList<Integer> tmp=triangle.get(i);
        	if(i%2==1){
        		s1.clear();
        		for(int j=0; j<tmp.size(); j++){
        			if(j==0){
        				s1.add(tmp.get(j)+s2.get(0));
        			}else if(j==tmp.size()-1){
        				s1.add(tmp.get(j)+s2.get(j-1));
        			}else{
        				int tmpmin=Math.min(s2.get(j), s2.get(j-1));
        				s1.add(tmpmin+tmp.get(j));
        			}
        		}
        	}else{
        		s2.clear();
        		for(int j=0; j<tmp.size(); j++){
        			if(j==0){
        				s2.add(tmp.get(j)+s1.get(0));
        			}else if(j==tmp.size()-1){
        				s2.add(tmp.get(j)+s1.get(j-1));
        			}else{
        				int tmpmin=Math.min(s1.get(j), s1.get(j-1));
        				s2.add(tmpmin+tmp.get(j));
        			}
        		}
        	}
        }
        ArrayList<Integer> bot = (triangle.size()%2==0)?s1:s2;
        min=bot.get(0);
        for(int sum : bot){
        	if(sum<min)
        		min=sum;
        }
        return min;
    }
}
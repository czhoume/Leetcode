public class Solution {
    public boolean canJump(int[] A) {
    	int w=0;
        for(int i=0; i<A.length; i++){
        	if(i>w)
        		return false;
        	else if(i+A[i]>w){
        		w=i+A[i];
        	}
        }
        return true;
    }
}
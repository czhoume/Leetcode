
public class TrappingRainWater {
    public int trap(int[] A) {
        int n = A.length, sum=0;
        int i=1, left=0, right, max=0;
        while(i<n){
        	if(A[i]>=A[max])
        		max=i;
        	if(A[i]>=A[left]){
        		right=i;
        		sum+=getSum(A, left, right);
        		left=right;
        	}
        	i++;
        }
        i=n-2;
        right=n-1;
        while(i>=max){
        	if(A[i]>=A[right]){
        		left=i;
        		sum+=getSum(A, left, right);
        		right=left;
        	}
        	i--;
        }
        return sum;
    }

    public int getSum(int[] A, int left, int right){
    	int h=(A[left]>A[right])?right:left;
    	int sum=0;
    	for(int i=left+1; i<right; i++){
    		if(A[i]<A[h])
    			sum+=A[h]-A[i];
    	}
    	return sum;
    }
}

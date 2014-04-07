
public class TrappingRainWater {
    public int trap(int[] A) {
        int n = A.length;
        if(n==0)
        	return 0;
        int [] h = new int[n];
        h[n-1]=n;
        for(int i=n-2; i>=0; i--){
        	int w;
        	if(A[i]>A[i+1]){
        		w=h[i+1];
        		while(w!=n){
        			if(A[i]>A[w]&&w!=n-1){
        				w=h[w+1];
        			}else{
        				h[i]=w;
        				break;
        			}
        		}
        	}else{
        		h[i]=i+1;
        	}
        }
        int sum=0;
        for(int i=0; i<n; i++){
        	sum = sum + h[i] - i - 1;
        }
        return sum;
    }
}


public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
    	int n=gas.length, sum, total, start;
    	sum=0;
    	start=0;
    	total=0;
    	for(int i=0; i<n; i++){
    		total+=gas[i]-cost[i];
    		sum+=gas[i]-cost[i];
    		if(sum<0){
    			sum=0;
    			start=i+1;
    		}
    	}
    	if(total<0)
    		return -1;
    	else
    		return start;
    }
    
}

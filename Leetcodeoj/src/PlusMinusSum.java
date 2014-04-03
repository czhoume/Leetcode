public class PlusMinusSum{

	public boolean exist(int[] n, int target){
		int[] grouped=group(n);
		ArrayList<Integer> singles, singleSums;
		singles=new ArrayList<Integer>();
		for(int i=10; i<20; i++)
			if(grouped[i]==1)
				singles.add(i-10);
		singleSums=getSum(singles, target);
		for(int sigleSum : singleSums){
			if(checkDiff(singleSum, target, grouped))
				return true;
		}
		return false;
	}

	public int[] group(int[] n){
		int[] numOf=new int[20];
		for(int i; i<20; i++)
			numOf[i]=0;
		for(int i; i<n.length; i++){
			numOf[n[i]]++;
		}
		for(int i; i<10; i++){
			if(numOf[i]%2==1){
				numOf[i]--;
				numOf[i+10]=1;
			}
		}
	}

	public ArrayList<Integer> getSum(ArrayList<Integer> s, int target){
		ArrayList<Integer> res = new ArrayList<Integer>();
		int tmp=s.remove(0);
		for(int tmpsum : getSum(s)){
			if((tmpsum+tmp+target)%2==0)
				res.add(tmpsum+tmp);
			if((tmpsum-tmp+target)%2==0)
				res.add(tmpsum-tmp);			
		}
		return res;
	}

	public boolean checkDiff(int s, int target, int[] n){
		int[] numOfPair = new int[10];
		for(int i=0; i<10; i++)
			numOfPair[i]=n[i]/2;
		
	}

}
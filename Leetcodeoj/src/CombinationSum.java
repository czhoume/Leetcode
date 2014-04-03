public class CombinationSum {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
    	Arrays.sort(candidates);
    	return getList(candidates, target, 0);
    }

    public ArrayList<ArrayList<Integer>> getList(int[] candidates, int target, int index) {
        int i;
        ArrayList<ArrayList<Integer>> tmpres, res;
        res=new ArrayList<ArrayList<Integer>>();
        for(i=index; i<candidates.length; i++){
            if(target<candidates[i])
                continue;
            else if(target==candidates[i]){
                ArrayList<Integer> tmp=new ArrayList<Integer>();
                tmp.add(candidates[i]);
                res.add(tmp);
            }
            else{
                tmpres=getList(candidates, target-candidates[i], i);
                if(!tmpres.isEmpty()){
                    for(ArrayList<Integer> tmp:tmpres){
                        tmp.add(0, candidates[i]);
                        res.add(tmp);
                    }
                }
            }
        }
        return res;
    }
}
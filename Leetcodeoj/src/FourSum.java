import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class FourSum {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
    	if(num.length<4){
    		return null;
    	}
        int max=num[0], min=num[0], n;
        Map<Integer, Integer> arr = new HashMap<Integer, Integer>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<num.length; i++){
            max=(max>=num[i])?max:num[i];
            min=(min<=num[i])?min:num[i];
            if(arr.containsKey(num[i])){
                n=arr.get(num[i]);
                n++;
                arr.put(num[i], n);
            }else{
                arr.put(num[i], 1);
            }
        }
        for(int i=target-2*max; i<=target-2*min; i++){
            ArrayList<ArrayList<Integer>> tmp1, tmp2;
            // ArrayList<ArrayList<Integer>> tmp2 = new ArrayList<ArrayList<Integer>>();
            tmp1=twoSum(num, i);
            if(!tmp1.isEmpty()){
                for(int j=0; j<tmp1.size(); j++){
                    tmp2=twoSum(num, target-i, tmp1.get(j).get(0), tmp1.get(j).get(1) );
                    if(!tmp2.isEmpty()){
                    	for(int k=0; k<tmp2.size(); k++){
                        ArrayList<Integer> pair = new ArrayList<Integer>();
                        pair.add(tmp1.get(j).get(0));
                        pair.add(tmp1.get(j).get(1));
                        pair.add(tmp2.get(k).get(0));
                        pair.add(tmp2.get(k).get(1));
                        ArrayList<Integer> sorted = sortList(pair);
                        res.add(sorted);
                    	}
                    }
                }
            }
        }
        removeDup(res);
        return res;
    }
    
    public ArrayList<ArrayList<Integer>> twoSum(int[] num, int target) {
        int tmp, n;
        Map<Integer, Integer> arr = new HashMap<Integer, Integer>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<num.length; i++){
            if(arr.containsKey(num[i])){
                n=arr.get(num[i]);
                n++;
                arr.put(num[i], n);
            }else{
                arr.put(num[i], 1);
            }
        }
        for(int i=0; i<num.length; i++){
            if(arr.get(num[i])==1){
                arr.remove(num[i]);
            }else{
            	n=arr.get(num[i]);
            	n--;
                arr.put(num[i], n);
            }
            if(arr.containsKey(target-num[i])){
                tmp=target-num[i];
                ArrayList<Integer> pair = new ArrayList<Integer>();
                pair.add(tmp);
                pair.add(num[i]);
                res.add(pair);
            }
        }
        return res;
    }

    public ArrayList<ArrayList<Integer>> twoSum(int[] num, int target, int num1, int num2) {
        int tmp, n;
        boolean  num1used=false, num2used=false;
        Map<Integer, Integer> arr = new HashMap<Integer, Integer>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<num.length; i++){
            if(arr.containsKey(num[i])){
                n=arr.get(num[i]);
                n++;
                arr.put(num[i], n);
            }else{
                arr.put(num[i], 1);
            }
        }
        if(arr.get(num1)==1){
            arr.remove(num1);
        }else{
            	n=arr.get(num1);
            	n--;
                arr.put(num1, n);
        }
        if(arr.get(num2)==1){
            arr.remove(num2);
        }else{
            	n=arr.get(num2);
            	n--;
                arr.put(num2, n);
        }
        for(int i=0; i<num.length; i++){
        	if(!num1used&&num[i]==num1){
        		num1used=true;
        		continue;
        	}
        	if(!num2used&&num[i]==num2){
        		num2used=true;
        		continue;
        	}
            if(arr.get(num[i])==1){
                arr.remove(num[i]);
            }else{
            	n=arr.get(num[i]);
            	n--;
                arr.put(num[i], n);
            }
            if(arr.containsKey(target-num[i])){
                tmp=target-num[i];
                ArrayList<Integer> pair = new ArrayList<Integer>();
                pair.add(tmp);
                pair.add(num[i]);
                res.add(pair);
            }
        }
        return res;
    }

    public ArrayList<Integer> sortList(ArrayList<Integer> list){
        int minI;
        ArrayList<Integer> res=new ArrayList<Integer>();
        while(!list.isEmpty()){
            minI=0;
            for(int i=0; i<list.size(); i++){
                if(list.get(minI)>=list.get(i)){
                    minI=i;
                }
            }
            res.add(list.get(minI));
            list.remove(minI);
        }
        return res;
    }
    
    public void removeDup(ArrayList<ArrayList<Integer>> res){
        for(int i=0; i<res.size(); i++)
            for(int j=i+1; j<res.size(); j++){
                if(res.get(i).equals(res.get(j))){
                    res.remove(j);
                    j--;
                }
            }
    }

    public static void main(String[] args){
    	FourSum inst=new FourSum();
    	int[] num={-499,-483,-463,-461,-431,-417,-390,-381,-366,-365,-342,-339,-321,-290,-285,-272,-265,-258,-228,-211,-188,-182,-146,-144,-123,-120,-112,-97,-92,-60,-58,-53,-53,-41,-36,-28,-15,-12,-7,22,45,57,59,62,77,81,99,103,105,115,119,135,147,154,169,183,187,215,243,258,259,266,272,272,275,309,319,345,370,382,385,389,436,439,442,469,484};
    	//test commit r r
    	ArrayList<ArrayList<Integer>> res = inst.fourSum(num, 7189);
    }
}
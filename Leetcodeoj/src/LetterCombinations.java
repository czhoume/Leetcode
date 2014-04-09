public class LetterCombinations {
    public ArrayList<String> letterCombinations(String digits) {
    	ArrayList<String> res = new ArrayList<String>();
    	if(digits.equals("")){
    	    res.add("");
    		return res;
    	}
        ArrayList<String> tmpres = letterCombinations(digits.substring(1));
        char digit=digits.charAt(0);
        char[] chars = null;
        switch(digit){
        	case '2': chars=new char[3];
        			  chars[0]='a'; 
        			  chars[1]='b'; 
        			  chars[2]='c';
        			  break;
        	case '3': chars=new char[3];
        			  chars[0]='d'; 
        			  chars[1]='e'; 
        			  chars[2]='f';
        			  break;
        	case '4': chars=new char[3];
        			  chars[0]='g'; 
        			  chars[1]='h'; 
        			  chars[2]='i';
        			  break;
        	case '5': chars=new char[3];
        			  chars[0]='j'; 
        			  chars[1]='k'; 
        			  chars[2]='l';
        			  break;
        	case '6': chars=new char[3];
        			  chars[0]='m'; 
        			  chars[1]='n'; 
        			  chars[2]='o';
        			  break;
        	case '7': chars=new char[4];
        			  chars[0]='p'; 
        			  chars[1]='q'; 
        			  chars[2]='r'; 
        			  chars[3]='s';
        			  break;
        	case '8': chars=new char[3];
        			  chars[0]='t'; 
        			  chars[1]='u'; 
        			  chars[2]='v'; 
        			  break;
        	case '9': chars=new char[4];
        			  chars[0]='w'; 
        			  chars[1]='x'; 
        			  chars[2]='y'; 
        			  chars[3]='z';
        			  break;
        }
        for(String base:tmpres){
        	for(char letter:chars){
        		StringBuilder sb = new StringBuilder();
        		sb.append(letter);
        		sb.append(base);
        		res.add(sb.toString());
        	}
        }
        return res;
    }
}
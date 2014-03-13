

public class WordSearch {

	boolean[][] used;
	int m, n, l;
	
    public boolean exist(char[][] board, String word) {
    	int i, j, k;
    	m=board.length;
    	n=board[0].length;
    	l=word.length();
    	used=new boolean[m][n];
    	for(i=0; i<m; i++)
    		for(j=0; j<n; j++)
    			used[i][j]=false;
    	
    	for(i=0; i<m; i++)
    		for(j=0; j<n; j++){
    			if(board[i][j]==word.charAt(0)){
    				used[i][j]=true;
    				if(check(board, i, j, 1, word))
    					return true;
    				used[i][j]=false;
    			}
    		}
    	return false;
    }
    
    public boolean check(char[][] board, int i, int j, int k, String word){
    	if(k>=l)
    		return true;
    	if(i!=0 && !used[i-1][j] && board[i-1][j]==word.charAt(k)){
    		used[i-1][j]=true;
    		if(check(board, i-1, j, k+1, word))
    			return true;
    		used[i-1][j]=false;
    	}
    	if(j!=0 && !used[i][j-1] && board[i][j-1]==word.charAt(k)){
    		used[i][j-1]=true;
    		if(check(board, i, j-1, k+1, word))
    			return true;
    		used[i][j-1]=false;
    	}
    	if(i!=m-1 && !used[i+1][j] && board[i+1][j]==word.charAt(k)){
    		used[i+1][j]=true;
    		if(check(board, i+1, j, k+1, word))
    			return true;
    		used[i+1][j]=false;
    	}
    	if(j!=n-1 && !used[i][j+1] && board[i][j+1]==word.charAt(k)){
    		used[i][j+1]=true;
    		if(check(board, i, j+1, k+1, word))
    			return true;
    		used[i][j+1]=false;
    	}
    	return false;
    }
}


public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] sol=new int[m][n];
        for(int i=0; i<m; i++)
        	sol[i][0]=1;
        for(int i=0; i<n; i++)
        	sol[0][i]=1;
        for(int i=1; i<m; i++)
        	for(int j=1; j<n; j++){
        		sol[i][j]=sol[i-1][j]+sol[i][j-1];
        	}
        return sol[m-1][n-1];
    }
}

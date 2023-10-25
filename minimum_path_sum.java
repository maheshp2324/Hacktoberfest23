//Minimum Path Sum - https://leetcode.com/problems/minimum-path-sum/

class Solution {
    static int bestnext(int[][] arr , int i , int j){
        int row = arr.length;
        int col = arr[0].length;

        if(i==row-1 && j==col-1){
            return 0;
        }
        if(i==row-1){
            return arr[i][j+1];
        }
        if(j==col-1){
            return arr[i+1][j];
        }
        return Math.min(arr[i][j+1],arr[i+1][j]);
    }
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = grid.clone();

        int i = m-1 , j=n-1;
        for(;i>=0 && j>=0;i--,j--){

            for(int r = m-1;r>i;r--){
                dp[r][j] += bestnext(dp,r,j);
            }
            for(int c = n-1;c>j;c--){
                dp[i][c] += bestnext(dp,i,c);
            }
            dp[i][j] += bestnext(dp,i,j);
        }
               if(i<0){
            while(j>=0){
                dp[m-1][j] += dp[m-1][j+1];
                for(int k=m-2;k>=0;k--){
                    dp[k][j] += bestnext(dp,k,j);
                }
                j--;
            }
        }
        if(j<0){
            while(i>=0){
                dp[i][n-1] += dp[i+1][n-1];
                for(int l=n-2;l>=0;l--){
                    dp[i][l] += bestnext(dp,i,l);
                }
                i--;
            }
        }
        return dp[0][0];
    }
}

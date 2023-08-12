class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp[][] = new int[m][n];
        return helper(obstacleGrid,0,0,m,n,dp);
    }
    
    public int helper(int[][] grid,int i,int j,int m,int n,int[][] dp){
        if(i == m || j == n || grid[i][j] == 1)return 0;
        if(dp[i][j]>0) return dp[i][j];
        if(i == m-1 && j == n-1){
            if(grid[i][j] == 1)return 0;
            return 1;            
        }
        return dp[i][j] = helper(grid,i+1,j,m,n,dp) + helper(grid,i,j+1,m,n,dp);
    }
}
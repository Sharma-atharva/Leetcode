class Solution {
    int[] sums;
    int[][] dp;
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        sums = new int[n];
        dp = new int[n][n];
        for (int[] row: dp) Arrays.fill(row,-1);
        sums[n-1] = piles[n-1];
        for (int i=n-2; i>=0; i--){
            sums[i] = sums[i+1] + piles[i]; 
        }
        return helper(piles, 0, 1);
    }
    
    public int helper(int[] piles, int idx, int m){
        if (idx == piles.length) return 0;
        if (2*m >= piles.length-idx) return sums[idx];
        if (dp[idx][m] != -1) return dp[idx][m];
        int min = Integer.MAX_VALUE;
        for (int i=1; i<=m*2; i++){
            min = Math.min(min, helper(piles,idx+i,Math.max(i,m)));
        }
        dp[idx][m] = sums[idx] - min;
        return dp[idx][m];
    }
}
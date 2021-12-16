class UniquePathMemoization {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        
        return uniquePathHelper(0, 0, m, n, dp);
    }
    
    public int uniquePathHelper(int i, int j, int m, int n, int[][] dp){
        if(i >= m || j >= n)
            return 0;
        if(i == m-1 && j == n-1)
            return 1;
        
        if(dp[i][j] != -1)
            return dp[i][j];
        return dp[i][j] = uniquePathHelper(i+1, j, m, n, dp) + uniquePathHelper(i, j+1, m, n, dp);
    }
}

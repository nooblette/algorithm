class Solution {
    public int uniquePaths(int m, int n) {
        // (i, j)까지 도달 가능한 경우의 수
        int[][] dp = new int[m+1][n+1];

        // 초기화
        dp[0][1] = 1;
        dp[1][0] = 0;

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m][n];
    }
}

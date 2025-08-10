class Solution {
    public int uniquePaths(int m, int n) {
        // n까지 도달 가능한 경우의 수
        int[] dp = new int[n];

        // 1로 초기화한다. (우측으로 한 칸씩 이동하는 경우)
        Arrays.fill(dp, 1);

        // 출발지점은 0
        dp[0] = 0;

        for(int i = 1; i < m; i++) {
            for(int j = 1; j <= n; j++) {
                dp[j] += dp[j-1];
            }
        }

        return dp[n];
    }
}

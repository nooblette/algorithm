class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n+1];

        for(int i = 1; i <= n; i++) {
            // dp[i & (i-1)] : i에서 뒤에서 가장 먼저 나온 1비트를 삭제한 결과의 1의 개수
            dp[i] = dp[i & (i-1)] + 1;
        }

        return dp;
    }
}

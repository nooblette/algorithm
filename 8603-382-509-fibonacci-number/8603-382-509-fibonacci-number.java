class Solution {
    public int fib(int n) {
        // 문제 조건 : 0 <= n <= 30
        int[] dp = new int[31];
        
        // 0과 1 값을 미리 지정
        dp[0] = 0;
        dp[1] = 1;
        
        for(int i = 2; i <= n; i++) {
            // 작은 문제들(dp[i-1], dp[i-2])의 결과를 이용해서 큰 문제(dp[i])의 결과를 얻는다.
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        return dp[n];
    }
}
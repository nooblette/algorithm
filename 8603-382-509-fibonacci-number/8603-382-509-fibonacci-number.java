class Solution {
    // 문제 조건 : 0 <= n <= 30
    int[] dp = new int[31];
    
    public int fib(int n) {
        if(n <= 1) {
            return n;
        }
        
        // 미리 계산한 결과가 있다면 재활용
        if(dp[n] != 0) {
            return dp[n];
        }
        
        // 계산 결과를 dp 배열에 추가 (기억해둔다.)
        dp[n] = fib(n-1) + fib(n-2); 
        return dp[n];
    }
}
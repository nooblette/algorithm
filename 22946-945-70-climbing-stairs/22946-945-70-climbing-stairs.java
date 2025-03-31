class Solution {
    int[] dp = new int[46];
    
    public int climbStairs(int n) {
        // 2이하는 지정한 값 반환 (1인 경우 한가지, 2인 경우 2가지만 존재한다.)
        if(n <= 2) {
            return n;
        }
        
        // 미리 계산한 결과가 있다면 해당 값 반환
        if(dp[n] != 0) {
            return dp[n];
        }
        
        dp[n] = climbStairs(n - 2) + climbStairs(n - 1);
        return dp[n];
    }
}
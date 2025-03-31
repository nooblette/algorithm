class Solution {    
    public int climbStairs(int n) {
        if(n <= 2) {
            return n;
        }
        
        int oneStepBefore = 2; // dp[i-1]
        int twoStepsBefore = 1; // dp[i-2]
        int result = 0;
        
        for(int i = 3; i <= n; i++) {
            result = oneStepBefore + twoStepsBefore;
            twoStepsBefore = oneStepBefore;
            oneStepBefore = result;
        }
        
        return result;
    }
}
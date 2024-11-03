class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        
        // `dp[i]`는 0부터 i까지의 부분 수열 중 최장 길이를 저장한다.
        int[] dp = new int[n];
        
        // dp 초기화
        Arrays.fill(dp, 1);
        
        int answer = 1;
        for(int i = 1; i < n; i++) {
            // dp[i]는 이전 loop에서 구한 dp[0] ~ dp[i-1] 값을 이용하여 구한다.
            for(int j = 0; j < i; j++) {
                
                // 0 <= j < i이므로, 증가하는 부분 수열을 찾은 경우
                if(nums[j] < nums[i]) {
                    // 이전에 구한 dp[j]를 이용하여 갱신한다.
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            
            // 결과값 갱신
            answer = Math.max(answer, dp[i]);
        }
        
        return answer;
    }
}
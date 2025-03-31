class Solution {
    public int rob(int[] nums) {
        // 입력값이 1개인 경우 예외 처리
        if(nums.length == 1) {
            return nums[0];
        }
        
        // 이미 계산한 값을 저장
        int[] dp = new int[nums.length];
        
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        // 직전 값와 2칸 이전 값에 현재 값을 더한 값 중 큰 값을 취한다.
        for(int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        
        // 항상 최댓값이 저장되므로 마지막 값을 반환한다.
        return dp[nums.length - 1];
    }
}
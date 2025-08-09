class Solution {
    public int rob(int[] nums) {
        // i번째 집까지 훔쳤을 때 이익을 담는다.
        int[] dp = new int[nums.length + 1];

        // 집이 하나만 있는 경우, 해당 집만 훔친다.
        dp[1] = nums[0];

        // 집이 두개만 있는 경우, 둘 중 더 이익이 큰 집을 훔친다.
        if(nums.length > 1) {
            dp[2] = Math.max(nums[0], nums[1]);
        }

        // 집이 3개만 있는 경우, 첫번째와 세번째 집만 훔치거나 두번째 집만 훔친다.
        if(nums.length > 2) {
            dp[3] = Math.max(nums[0] + nums[2], nums[1]);
        }

        // dp[i] 계산, i번째 집을 훔치는 경우와 포기하는 경우 중 더 큰 값을 취한다.
        for(int i = 3; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i-1], dp[i - 1]);
        }

        return dp[nums.length];
    }
}

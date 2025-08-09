class Solution {
    public int rob(int[] nums) {
        // 집이 하나만 있는 경우, 해당 집만 훔친다.
        if(nums.length == 1) {
            return nums[0];
        }

        // 첫번째 집을 훔치는 경우 최대 이익과 두번째 집을 훔치는 경우 최대 이익 중 큰 값을 취한다.
        return Math.max(bottomUp(0, nums.length - 1, nums), bottomUp(1, nums.length, nums));
    }

    private int bottomUp(int start, int end, int[] nums) {
        // 직전 집을 훔치는 경우와 훔치지 않는 경우 별로 구한 이익 기록
        int prev1 = 0;
        int prev2 = 0;

        // 첫번째 집을 훔치는 경우와 아닌 경우별로 나누어 초기화
        prev1 = start == 0 ? nums[0] : 0;

        // dp[i] 계산, i번째 집을 훔치는 경우와 포기하는 경우 중 더 큰 값을 취한다.
        for(int i = 2; i <= end; i++) {
            int val = Math.max(prev1, prev2 + nums[i - 1]);

            // 이전 값 기록
            prev2 = prev1;
            prev1 = val;
        }

        return prev1;
    }
}

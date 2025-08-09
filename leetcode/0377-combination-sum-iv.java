class Solution {
    public int combinationSum4(int[] nums, int target) {
        // dp 배열 선언, dp[i] = 합이 i가 되는 조합의 개수
        int[] dp = new int[target + 1];

        // 0을 만드는 조합의 개수는 아무것도 선정하지 않는 경우 1가지가 존재
        dp[0] = 1;

        for(int i = 1; i <= target; i++) {
            for(int num : nums) {
                // 마지막에 num를 추가할 때 가능한 경우의 수 합산
                if(i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }

        return dp[target];
    }
}

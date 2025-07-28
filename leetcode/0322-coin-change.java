class Solution {
    public int coinChange(int[] coins, int amount) {
        // 금액 i원을 만드는데 필요한 최소 동전 개수를 갖는 DP 배열 선언
        int[] dp = new int[amount + 1];

        // 최소값을 구하기 위한 dp 배열 초기화
        Arrays.fill(dp, Integer.MAX_VALUE - 1);

        // 초기화, 0원을 만드는데 필요한 동전은 0개 
        dp[0] = 0;

        for(int i = 1; i <= amount; i++) {
            for(int coin : coins) {
                if(i - coin >= 0) {
                    // 모든 동전을 시도하면서 최소값을 갱신
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
    }
}

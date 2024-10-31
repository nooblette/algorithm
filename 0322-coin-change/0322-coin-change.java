class Solution {
    public int coinChange(int[] coins, int amount) {
        // dp[i] : 금액 i를 만들기 위해 필요한 동전의 개수 
        int[] dp = new int[amount + 1];
        
        // 초기화
        Arrays.fill(dp, amount + 1);
        
        // 예외 처리 - 금액이 0인경우 동적을 사용하지 않는다.
        dp[0] = 0;
        
        // 탐색 시작 - 주어진 동전(coins)을 하나씩 사용하여 금액 i를 만드는데 필요한 동전의 개수를 구한다.
        for(int coin : coins) {
            // 총 합인 amount를 구할때까지 반복
            for(int i = coin; i <= amount; i++) {
                // 금액 i - coin을 만드는데 필요한 동전의 개수에서 금액이 coin인 동전 1개를 추가
                // 금액 i를 만드는데 필요한 동전의 최소 개수를 갱신한다.
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
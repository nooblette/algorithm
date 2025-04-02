class Solution {
    public int solution(int[] money) {
        int[][] dp = new int[2][money.length];

        // 첫번째 집을 포함하는 경우, 최댓값을 구할때 포함한다.
        dp[0][0] = 0;

        // 첫번째 집을 훔치는 경우, 두번째 집도 훔칠 수 없으므로 0으로 초기화한다.
        dp[0][1] = 0;

        // 첫번째 집을 훔치지 않는 경우
        dp[1][0] = 0;

        // 첫번째 집을 훔치지 않는 경우, 두번쨰 집부터 타뷸레이션에 포함한다.
        dp[1][1] = money[1];

        // 직전 값와 2칸 이전 값에 현재 값을 더한 값 중 큰 값을 취한다.
        for(int i = 2; i < money.length; i++) {
            dp[0][i] = Math.max(dp[0][i-1], dp[0][i-2] + money[i]);
            dp[1][i] = Math.max(dp[1][i-1], dp[1][i-2] + money[i]);
        }
        
        // 첫번째 값을 포함하는 경우와 포함하지 않는 경우 중 최댓값을 반환한다.
        return Math.max(dp[0][money.length - 2] + money[0], dp[1][money.length - 1]);
    }
}
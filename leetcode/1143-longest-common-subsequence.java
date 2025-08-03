class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // 두 문자열의 인덱스별로 공통 문자열 중 최장 길이를 저장하는 2차원 배열 dp 선언
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        
        for(int i = 1; i <= text1.length(); i++) {
            for(int j = 1; j <= text2.length(); j++) {
                // 공통 문자를 찾은 경우
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    // dp[i][j-1]와 dp[j-1][i] 중 큰 값 + 1을 취한다.
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    // 가장 긴 최장 길이를 구해야하므로 dp[i][j-1]와 dp[j-1][i] 중 큰 값을 취한다. 
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }
}

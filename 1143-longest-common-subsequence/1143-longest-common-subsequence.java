class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // LCS 길이를 담을 dp 선언
        // `dp[i][j]`는 text1의 첫 번째 문자부터 i까지의 문자와 text2의 첫 번째 문자부터 j까지 문자의 공통 부분 수열의 길이를 저장한다.
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        
        // dp 진행
        for(int i = 1; i <= text1.length(); i++) {
            for(int j = 1; j <= text2.length(); j++) {
                
                // 공통 문자를 찾은 경우
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        
        return dp[text1.length()][text2.length()];
    }
}
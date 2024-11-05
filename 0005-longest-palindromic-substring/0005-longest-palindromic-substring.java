class Solution { 
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n <= 1) return s;

        // `dp[i][j]`는 부분 문자열 `s[i..j]`가 팰린드롬인지 여부를 저장한다.
        boolean[][] dp = new boolean[n][n];
        
        int maxLen = 1; // 최소 길이 1의 팰린드롬 고려
        int start = 0;
        
        // 길이 1인 부분 문자열은 모두 팰린드롬
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            start = i;
            maxLen = 1;
        }
        
        // 길이 2인 부분 문자열 초기화
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLen = 2;
            }
        }
        
        // 길이 3 이상인 부분 문자열 탐색
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                // 두 문자가 같고, 내부 문자열이 팰린드롬인 경우
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;

                    // 가장 긴 팰린드롬 갱신
                    if (len > maxLen) {
                        maxLen = len;
                        start = i;
                    }
                }
            }
        }

        return s.substring(start, start + maxLen);
    }
}

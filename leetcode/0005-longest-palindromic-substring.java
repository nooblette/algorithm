class Solution {
    public String longestPalindrome(String s) {
        // 팰린드롬 여부를 갖는 dp 배열을 선언하여 부분해로 최적해를 구한다.
        boolean[][] dp = new boolean[s.length()][s.length()];

        // 길이가 1인 경우는 모두 팰린드롬
        int left = 0;
        int right = 0;
        for(int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        // 길이가 2인 경우
        for(int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                
                // 직전 길이보다 큰 길이를 찾은 경우, 부분 문자열을 구하기 위해 기록하는 두 개의 포인터를 갱신한다.
                if(2 > right - left + 1) {
                    left = i;
                    right = i + 1;
                }  
            }
        }

        // 길이가 3 이상인 경우 (시간 복잡도 O(n^2))
        for(int i = 3; i <= s.length(); i++) {
            for(int j = 0; j < s.length() - i + 1; j++) {
                if(s.charAt(j) == s.charAt(j + i - 1) && dp[j + 1][j + i - 2] == true) {
                    dp[j][j + i - 1] = true;

                    // 직전 길이보다 큰 길이를 찾은 경우, 부분 문자열을 구하기 위해 기록하는 두 개의 포인터를 갱신한다.
                    if(i > right - left + 1) {
                        left = j;
                        right = j + i - 1;
                    } 
                }
            }
        }
        
        return s.substring(left, right + 1);
    }
}

class Solution {
    public int numDecodings(String s) {
        // 예외 처리
        if(s.startsWith("0")) return 0;

        // 문자열 s의 특정 인덱스 i까지 디코딩 가능한 경우의 수
        int[] dp = new int[s.length() + 1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= s.length(); i++) {
            // 문자 하나를 선택했을 때 유효한 경우
            if(s.charAt(i - 1) != '0') {
                dp[i] = dp[i-1];
            }

            // 문자 두개를 선택했을 때 유효한 경우
            int digit = Integer.parseInt(s.substring(i - 2, i));
            if(digit >= 10 && digit <= 26) {
                dp[i] += dp[i-2];
            }
        }

        return dp[s.length()];
    }
}

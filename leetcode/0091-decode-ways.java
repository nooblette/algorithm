class Solution {
    public int numDecodings(String s) {
        // 예외 처리
        if(s.startsWith("0")) return 0;

        // 문자열 s의 특정 인덱스 i-1까지 디코딩 가능한 경우의 수
        int prev1 = 1;

        // 문자열 s의 특정 인덱스 i-2까지 디코딩 가능한 경우의 수
        int prev2 = 1;

        for(int i = 2; i <= s.length(); i++) {
            int current = 0;

            // 문자 하나를 선택했을 때 유효한 경우
            if(s.charAt(i - 1) != '0') {
                current = prev1;
            }

            // 문자 두개를 선택했을 때 유효한 경우
            int digit = Integer.parseInt(s.substring(i - 2, i));
            if(digit >= 10 && digit <= 26) {
                current += prev2;
            }

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}

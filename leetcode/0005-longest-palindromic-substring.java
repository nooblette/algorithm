class Solution {
    public String longestPalindrome(String s) {
        int result = 0;
        int start = 0;
        int end = 0;

        // 중심 확장(Expand Around Center) 알고리즘으로 팰린드롬 여부 판별
        for(int i = 0; i < s.length(); i++) {
            // 팰린드롬인 동안 좌우를 확장
            int left = i;

            // 홀수 길이로 탐색하는 경우
            int right = i;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }

            // 새로운 최장 길이 팰린드롬 부분 문자열을 찾은 경우 갱신
            if(result < right - left + 1) {
                result = right - left + 1;

                // 마지막 반복에서 증감을 복구
                start = left + 1;
                end = right - 1;
            }

            // 짝수 길이로 탐색하는 경우
            left = i;
            right = i + 1;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }

            if(result < right - left + 1) {
                result = right - left + 1;

                // 마지막 반복에서 증감을 복구
                start = left + 1;
                end = right - 1;
            }
        }

        return s.substring(start, end + 1);
    }
}

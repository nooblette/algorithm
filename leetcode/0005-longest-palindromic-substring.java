class Solution {
    public String longestPalindrome(String s) {
        int left = 0;
        int right = 0;

        // 중심 확장(Expand Around Center) 알고리즘으로 팰린드롬 여부 판별
        for(int i = 0; i < s.length(); i++) {
            int odd = expandAroundCenter(s, i, i);
            int even = expandAroundCenter(s, i, i + 1);

            int maxLen = Math.max(odd, even);
            if(maxLen > right - left + 1) {
                left = i - (maxLen - 1) / 2;
                right = i + maxLen / 2;
            }
        }

        return s.substring(left, right + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        // 두 포인터를 좌우로 확장하며 팰린드롬 여부 판별
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        // 마지막 loop에서 증감분 2를 최종 길이에서 제외한다.
        return right - left - 1;
    }
}

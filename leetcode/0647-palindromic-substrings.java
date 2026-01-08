class Solution {
    public int countSubstrings(String s) {
        int result = 0;

        // 중심 확장(Expand Around Center) 알고리즘으로 팰린드롬 여부 판별
        for(int i = 0; i < s.length(); i++) {
            result += countPalindromicSubstrings(s, i, i);
            result += countPalindromicSubstrings(s, i, i + 1);
        }

        return result;
    }

    private int countPalindromicSubstrings(String s, int left, int right) {
        int count = 0;

        // 팰린드롬인 동안 두 범위를 확장
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }

        return count;
    }
}

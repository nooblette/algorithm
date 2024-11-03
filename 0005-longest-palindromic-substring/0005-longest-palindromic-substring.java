class Solution {
    private boolean isPalindrome(int left, int right, String s) {
        while(left < right && s.charAt(left) == s.charAt(right)) {
            left += 1;
            right -= 1;
        }
        
        return left >= right;
    }
    
    public String longestPalindrome(String s) {
        String answer = "";
        int len = 0;
        
        for(int i = 0; i < s.length(); i++) {
            for(int j = i; j < s.length(); j++) {
                // 두 문자가 동일하다면, 둘 사이 문자에 대해 팰린드롬이 맞는지 체크
                if(s.charAt(i) == s.charAt(j) && isPalindrome(i, j, s)) {
                    // 팰린드롬이 맞고 더 길이가 길다면 갱신
                    if(len < j - i + 1) {
                        answer = s.substring(i, j + 1);
                        len = j - i + 1;
                    }
                }
            }
        }
        
        return answer;
    }
}
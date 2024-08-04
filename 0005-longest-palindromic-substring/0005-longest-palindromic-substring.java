class Solution {
    public String longestPalindrome(String s) {    
        int start = 0; // 가장 긴 팰린드롬이 시작하는 인덱스
        int maxLen = 0; // 가장 긴 팰린드롬의 길이
        
        for(int i = 0; i < s.length(); i++) {
            // 길이가 홀수인 팰린드롬의 길이
            int oddLen = expandAroundCenter(s, i, i);
            
            // 길이가 짝수인 팰린드롬의 길이
            int evenLen = expandAroundCenter(s, i, i+1);
            
            int len = oddLen > evenLen ? oddLen : evenLen;
            
            // 새로운 팰린드롬의 길이와 시작 인덱스 계산
            if(len > maxLen) {
                maxLen = len;
                
                // (maxLen-1) / 2 : 전체 팰린드롬 길이에서 중앙에 있는 문자를 제외(= maxLen-1)하고 한쪽에 있는 문자의 개수(= /2)를 계산
                start = i - (maxLen-1) / 2;
            }
        }
        
        return s.substring(start, start + maxLen);
    }
    
    // 팰린드롬의 길이 반환
    private int expandAroundCenter(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        
        
        // 팰린드롬의 길이(한 칸씩 이동하기 전의 left와 right에 대한 길이를 계산) 반환
        return right - left - 1;
    }
}
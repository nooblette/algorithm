class Solution {
    private int expandAroundCenter(String s, int left, int right) {
        // left와 right를 중심으로 확장해가며 최장 길이 팰린드롬 탐색
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left -= 1;
            right += 1;
        }
        
        // 팰린드롬이 아닌 경우 while문을 빠져나오므로 팰린드롬 길이를 구하기 위해서 -1을 해주어야한다.
        // right - 1 - (left + 1) + 1 = right - left - 1
        return right - left - 1;
    }
    
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        
        for(int i = 0; i < s.length(); i++) {
            // i를 중심으로 확장해가며 최장길이 팰린드롬 탐색
            int lenOdd = expandAroundCenter(s, i, i); // 길이가 홀수인 팰린드롬
            int lenEven = expandAroundCenter(s, i, i+1); // 길이가 짝수인 팰린드롬
            
            // i가 중심인 경우 등장하는 팰린드롬 중 최대 길이 반환
            int len = Math.max(lenOdd, lenEven);
            
            // 최장 길이를 갱신하는 경우
            if(len > end - start + 1) {
                // i를 중심으로 (len-1)/2만큼 좌측으로 이동하면 시작 지점
                // 팰린드롬의 길이가 짝수인 경우를 위해 한쪽으로 쏠리므로 -1을 빼준다.
                start = i - (len-1)/2;
                
                // i를 중심으로 len/2만큼 우측으로 이동하면 종료 지점
                end = i + len/2;
            }
            
        }
        
        return s.substring(start, end + 1);
    }
}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> used = new HashMap<>();
        int maxLength = 0;
        int left = 0, right = 0;
        
        // 문자열을 문자 단위로 반복
        for(char c : s.toCharArray()) {
            // 중복 검증
            if(used.containsKey(c) && left <= used.get(c)) {
                // 이미 등장한 문자인 경우
                left = used.get(c) + 1;
            } else {
                // 새로 등장한 문자인 경우
                maxLength = Math.max(maxLength, right - left + 1);
            }

            // 현재 문자와 등장한 인덱스 추가
            used.put(c, right);
            
            // 다음 인덱스 순회
            right++;
        }
        
        return maxLength;
    }
}
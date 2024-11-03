class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 슬라이딩 윈도우를 적용하기 위한 시작 인덱스
        int start = 0;
        
        // key : 특정 문자, value : 해당 문자가 등장한 인덱스
        Map<Character, Integer> map = new HashMap<>();
        
        // 최대 길이
        int answer = 0;
        
        // end : 슬라이딩 윈도우 범위의 종료 인덱스
        for(int end = 0; end < s.length(); end++) {
            Character curChar = s.charAt(end);
            
            // 현재 문자가 이미 등장한 문자이고, 그 위치가 start거나 start 이후라면
            while(map.containsKey(curChar) && map.get(curChar) >= start) {
                // start 위치를 1 증가한다. (중복 제거)
                start += 1;
            }
            
            // map에 등장한 문자와 등장 위치 추가
            map.put(curChar, end);
            
            // 정답 길이 갱신
            answer = Math.max(answer, end - start + 1);
        }
        
        return answer;
    }
}
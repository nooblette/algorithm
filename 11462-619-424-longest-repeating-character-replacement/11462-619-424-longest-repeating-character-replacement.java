class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        // 문자별 등장 횟수 저장
        Map<Character, Integer> counts = new HashMap<>();
        
        // 오른쪽 포인터를 끝까지 이동하면서 순회
        for(int right = 1; right <= s.length(); right++) {
            // 문자별 등장 횟수 갱신
            char c = s.charAt(right - 1);
            counts.put(c, counts.getOrDefault(c, 0) + 1);
            
            // 가장 많이 등장한 문자의 횟수
            final int maxCharCount = Collections.max(counts.values());
            
            // 연속된 문자로 구성된 문자열을 만들기 위해 변경해야할 문자의 개수
            final int needToChange = right - left - maxCharCount;
            if(needToChange > k) {
                // 왼쪽 포인터 이동
                counts.put(s.charAt(left), counts.getOrDefault(s.charAt(left), 0)-1);
                left++;
            }
        }
        
        // 만약 left를 증가한 이후로 최대 길이를 찾지 못했다면 윈도우의 크기는 계속 고정된다.
        // 따라서 문자열을 순회한 뒤 왼쪽 포인터의 위치를 뺀 값을 반환한다.
        return s.length() - left;
    }
}
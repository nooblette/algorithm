class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 문자와 등장한 인덱스 저장
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int result = 0;

        for(int i = 0; i < s.length(); i++) {
            // 현재 윈도우 사이에 등장한 문자라면 left 갱신
            char c = s.charAt(i);
            if(map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1;
            }

            map.put(c, i);
            result = Math.max(result, i - left + 1);
        }

        return result;
    }
}

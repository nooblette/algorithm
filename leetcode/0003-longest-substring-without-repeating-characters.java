class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 현재 등장한 문자와 위치를 기록
        // Queue나 다른 자료구조를 사용하면 등장 여부 판단을 위해 모든 요소를 순회(O(n))해야한다.
        // 따라서 등장 여부를 빠르게 판단할 수 있는 HashMap으로 구현한다. 
        // 이때 value를 등장 위치로 사용하여 최장 길이를 계산(슬라이딩 윈도우)하는데 사용한다.
        Map<Character, Integer> used = new HashMap<>();

        int result = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 등장 여부 판단, containsKey()의 시간 복잡도는 O(log(n/b)) (n = 전체 원소 수, b = 버킷 배열의 크기)
            if(used.containsKey(c) && used.get(c) >= left) {
                // 이미 등장한 문자가 있고 현재 탐색 범위(left ~ i)에 속해있다면 그 다음 위치(left + 1)부터 탐색에 사용
                left = used.get(c) + 1;
            }

            used.put(c, i);
            result = Math.max(result, i - left + 1);
        }

        return result;
    }
}

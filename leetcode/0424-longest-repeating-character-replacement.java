class Solution {
    public int characterReplacement(String s, int k) {
        // s의 최대 길이가 10^5이므로 O(n) 또는 O(logn)으로 풀이해야한다.
        // 이 문제는 투 포인터와 슬라이딩 윈도우를 결합하여 O(n)의 시간복잡도로 풀이할 수 있다.

        // 알파벳별 등장 횟수 저장
        int[] count = new int[26];

        // 왼쪽, 오른쪽 포인터
        int left = 0;

        // 현재 가장 많이 등장한 문자의 개수
        int maxCount = 0;
        int result = 0;
        for(int right = 0; right < s.length(); right++) {
            // 등장 횟수 증가
            count[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);

            // (현재 슬라이딩 윈도우 크기 - 가장 많이 등장한 문자)가 k보다 큰 경우 동일한 문자로 구성된 부분 문자열을 만들 수 없음
            // 따라서 부분 문자열을 찾을 수 있을 때까지 슬라이딩 윈도우 크기를 줄인다.
            while((right - left + 1) - maxCount > k) {
                // 등장 횟수 감소
                count[s.charAt(left) - 'A']--;
                left++;
            }

            result = Math.max(result, (right - left + 1));
        }

        return result;
    }
}

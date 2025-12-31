class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 사용한 문자들을 들어온 순서대로 기록
        // 탐색보다 양쪽 끝 삽입, 삭제가 중요하므로 LinkedList가 아닌 ArrayDeque으로 구현한다.
        Deque<Character> queue = new ArrayDeque<>();

        int result = 0;
        int cur = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 이미 등장한 문자라면
            if(queue.contains(c)) {
                // 현재 길이 기록
                result = Math.max(result, cur);

                // 이미 등장한 문자가 나올때까지 큐에서 제거
                while(!queue.isEmpty() && queue.contains(c)) {
                    queue.poll();
                    cur--;
                }
            }
            
            // 사용한 문자 목록에 추가하고 길이 증가
            queue.offer(c);
            cur++;
        }

        return Math.max(result, cur);
    }
}

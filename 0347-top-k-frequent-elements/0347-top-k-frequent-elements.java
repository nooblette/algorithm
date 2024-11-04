class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 원소별로 등장 횟수를 저장
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        // map을 등장 횟수를 기준으로 내림차순 정렬하는 우선순위 큐 변환
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        
        // map을 우선순위 큐로 변환
        for(int key : map.keySet()) {
            pq.add(new int[]{key, map.get(key)});
        }
        
        // k번까지만 우선순위 큐에서 원소를 추출한다.
        int[] answer = new int[k];
        for(int i = 0; i < k; i++) {
            answer[i] = pq.poll()[0];
        }
        
        return answer;
    }
}
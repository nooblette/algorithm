class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // num별 등장 횟수 기록
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }

        // 등장 횟수를 기준으로 내림차순 정렬하는 우선순위 큐 생성
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> b.get(0) - a.get(0));
        map.forEach((key, frequent) -> pq.offer(List.of(frequent, key)));

        int[] result = new int[k];
        for(int i = k; i > 0; i--) {
            List<Integer> node = pq.poll();
            result[k - i] = node.get(1);
        }

        return result;
    }
}

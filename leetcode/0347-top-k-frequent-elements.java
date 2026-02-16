class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // num별 등장 횟수 기록
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }

        // 등장 횟수를 기준으로 오름차순 정렬하는 우선순위 큐 생성
        // 우선순위 큐의 크기가 k를 넘어가면 가장 앞에 있는 최소 원소를 제거한다.
        // 우선순위 큐의 크기를 k로 유지하여 시간 복잡도를 O(nlogn)에서 O(nlogk)로 개선하는 것이 핵심
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        map.forEach((key, frequent) -> {
            pq.offer(new int[]{frequent, key});
            
            if(pq.size() > k) {
                pq.poll();
            }
        });

        // 우선수위 큐의 크기가 k를 유지하므로 바로 int[]로 변환하여 반환
        return pq.stream()
         .mapToInt(result -> result[1])
         .toArray();
    }
}

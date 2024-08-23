class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 각 엘리먼트 별로 등장 빈도를 저장
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // 빈도순으로 정렬되는 우선순위 큐 선언
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        // 우선순위 큐에 각 엘리먼트와 빈도 수 삽입
        for(int elem : frequencyMap.keySet()) {
            pq.add(new int[]{elem, frequencyMap.get(elem)});
        }
        
        int[] result = new int[k];

        // k번까지만 우선순위 큐에서 원소를 추출한다.
        for(int i = 0; i < k; i++) {
            result[i] = pq.poll()[0];
        }

        return result;
    }
}
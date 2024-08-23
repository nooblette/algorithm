class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 각 엘리먼트 별로 등장 빈도를 저장
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // frequencyMap을 단순히 숫자가 등장한 빈도로 저장
        Map<Integer, List<Integer>> buckets = new HashMap<>();

        // frequencyMap의 키 목록(등장한 숫자 목록) 조회
        for(int element : frequencyMap.keySet()) {
            // freq : 해당 숫자(element)가 등장한 빈도 조회
            int freq = frequencyMap.get(element);

            // elems : 해당 빈도만큼 등장한 숫자(element) 목록
            List<Integer> elems = buckets.getOrDefault(freq, new ArrayList<Integer>());
            elems.add(element);
            buckets.put(freq, elems);
        }
        
        // 빈도가 가장 높은 k개를 추출한다.
        int[] result = new int[k];
        int index = 0;

        // nums가 모두 동일한 숫자로 구성, 즉 빈도와 nums의 길이가 같은 경우부터 -1씩 감소하며 순회
        for(int freq = nums.length; freq >= 0 && index < k; freq--) {
            if(buckets.get(freq) == null) {
                continue;
            }

            for(int ele : buckets.get(freq)) {
                result[index] = ele;

                // 가장 높은 k개만 추출하면 되므로 index < k 조건을 둔다.
                index++;
            }
        }
        
        return result;
    }
}
class Solution {
    public int majorityElement(int[] nums) {
        // 엘리먼트 개수 계산
        Map<Integer, Integer> countsMap = new HashMap<>();
        for(int num : nums) {
            countsMap.put(num, countsMap.getOrDefault(num, 0) + 1);
        }

        // countsMap을 내림차순 정렬하여 Map에 저장한다.
        // 여기서는 첫번째 항목을 구해야하므로 입력 순서가 유지되는 LinkedHashMap으로 구현한다.
        // 참고로 HashMap은 입력 순서를 유지하지 않는다.
        Map<Integer, Integer> reverseSortedMap = new LinkedHashMap<>();

        // countsMap을 내림차순 정렬해 입력 순서를 유지하여 저장
        countsMap.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

        // 첫번째 항목 추출
        Map.Entry<Integer, Integer> entry = reverseSortedMap.entrySet()
            .iterator()
            .next();

        // 과반수를 넘을 경우 정답으로 반환
        return entry.getValue() > nums.length / 2 ? entry.getKey() : -1;
    }
}
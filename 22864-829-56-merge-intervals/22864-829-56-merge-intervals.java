class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> merged = new ArrayList<>();
        
        // 주어진 리스트의 첫번째 값을 기준으로 정렬한다.
        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));
        
        // 정렬된 결과 순회
        for(int[] interval : intervals) {
            // 순회하는 구간의 첫번째 값이 기존 병합 결과 목록의 마지막 구간의 두번째 값보다 작거나 같다면 구간이 겹치므로 구간을 확장한다.
            if(!merged.isEmpty() && merged.get(merged.size() - 1)[1] >= interval[0]) {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            } else {
                // 겹치지 않는 경우 단순 삽입
                merged.add(interval);
            }
        }
        
        // 최종 결과를 반환 타입에 맞춰 변환하여 반환
        return merged.toArray(new int[merged.size()][]);
    }
}
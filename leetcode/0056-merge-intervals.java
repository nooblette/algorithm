class Solution {
    public int[][] merge(int[][] intervals) {
        // 시작 지점을 기준으로 주어진 배열 정렬
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        for(int[] interval : intervals) {
            // 겹치지 않는 경우 (현재 탐색 중인 구간의 시작 지점이 새로운 구간의 마지막 지점보다 이후)
            if(result.isEmpty() || result.get(result.size() - 1)[1] < interval[0]) {
                // 범위 단순 추가
                result.add(interval);
            } else {
                // 겹치는 경우
                // 범위 확장
                result.get(result.size() - 1)[1] = Math.max(interval[1], result.get(result.size() - 1)[1]);
            }
        }

        // 배열로 변환하여 반환
        return result.toArray(new int[result.size()][]);
    }
}

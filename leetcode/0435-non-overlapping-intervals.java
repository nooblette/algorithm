class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // 주어진 배열을 시작 지점을 기준으로 오름차순 정렬
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // 기존 구간 탐색
        List<int[]> newIntervals = new ArrayList<>();
        int result = 0;
        for(int[] interval : intervals) {
            if(newIntervals.isEmpty()) {
                newIntervals.add(interval);
                continue;
            }
            
            int[] lastIntervals = newIntervals.get(newIntervals.size() - 1);

            // 기존 구간과 겹치지 않는 경우
            if(lastIntervals[1] <= interval[0]) {
                // 새로운 구간에 추가
                newIntervals.add(interval);
            } else {
                // 새로운 구간과 겹친다면 제거
                result++;

                // 가능한 구간 범위를 작게
                lastIntervals[1] = Math.min(lastIntervals[1], interval[1]);
            }
        }
        
        return result;
    }
}

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // 끝점을 기준으로 오름차순 정렬
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        // 직전 구간의 끝점 저장
        int lastEnd = Integer.MIN_VALUE;

        int count = 0;
        for(int[] interval : intervals) {
            // 탐색 중인 구간이 직전 구간의 끝점과 겹친다면 현재 구간을 제거
            if(interval[0] < lastEnd) {
                count++;
            } else {
                // 겹치지 않는다면 구간의 끝점 정보 갱신
                lastEnd = interval[1];
            }
        }   

        return count;
    }
}

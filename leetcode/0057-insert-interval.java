class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int []> result = new ArrayList<>();

        int i = 0;
        // 겹치지 않는 앞쪽 구간 처리
        while(i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // 겹치는 구간 병합
        while(i < intervals.length && intervals[i][1] >= newInterval[0] && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        // 남은 구간 그대로 추가
        while(i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }

        // 리스트를 배열로 변환하여 반환
        return result.toArray(new int[result.size()][]);
    }
}
